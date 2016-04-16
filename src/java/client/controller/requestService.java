/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import entity.Service;
import entity.Tower;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan
 */
public class requestService extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Service obj = new Service();
        List<Tower> listTower = new ArrayList<Tower>();
        Double latitude = 0.;
        Double longitude = 0.;
        String location = request.getAttribute("location").toString();
        latitude = Double.parseDouble(location.split(",")[0]);
        longitude = Double.parseDouble(location.split(",")[1]);
        
        obj.setId(Integer.parseInt(request.getAttribute("idclient").toString()));
        obj.setStreetAddressPickup(request.getAttribute("address").toString());
        obj.setLatitudePickup(latitude);
        obj.setLongitudePickup(longitude);
         //Create Service in System
        if (!obj.create(listTower)) {
            //Display error message if service could not be created
            request.setAttribute("errorMessage", "Service could not be created.");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "errorMessage.jsp");
        } else {
            request.setAttribute("msgCreateServiceman", "Serviceman was created.");
            response.sendRedirect("registerServiceman.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
