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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Location;
import util.Utility;

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
        Tower tower1 = new Tower();
        tower1.setId(1);
        Tower tower2 = new Tower();
        tower2.setId(2);
        listTower.add(tower1);
        listTower.add(tower2);

        obj.setId(Integer.parseInt(request.getParameter("email").trim()));
        obj.setStreetAddressPickup(request.getParameter("street_address_pickup").trim());
        obj.setCityPickup(request.getParameter("city_pickup").trim());
        obj.setStatePickup(request.getParameter("state_pickup").trim());
        obj.setZipcodePickup(request.getParameter("zipcode_pickup").trim());
        obj.setStreetAddressDestination(request.getParameter("street_address_destination").trim());
        obj.setCityDestination(request.getParameter("city_destination").trim());
        obj.setStateDestination(request.getParameter("state_destination").trim());
        obj.setZipcodeDestination(request.getParameter("zipcode_destination").trim());

        //Retrieve locations
        try {
            String pickupAddress = obj.getStreetAddressPickup() + ", " + obj.getCityPickup() + " " + obj.getStatePickup() + ", " + obj.getZipcodePickup();
            String destinationAddress = obj.getStreetAddressDestination() + ", " + obj.getCityDestination() + " " + obj.getStateDestination() + ", " + obj.getZipcodeDestination();;
            Location pickupLocation = Utility.getLocationFromAddress(pickupAddress);
            Location destinationLocation = Utility.getLocationFromAddress(destinationAddress);
            obj.setLatitudePickup(pickupLocation.getLatitude());
            obj.setLongitudePickup(pickupLocation.getLatitude());
            obj.setLatitudePickup(destinationLocation.getLatitude());
            obj.setLongitudePickup(destinationLocation.getLatitude());
        } catch (Exception ex) {
            Logger.getLogger(requestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Create Service in System
        if (!obj.create(listTower)) {
            //Display error message if service could not be created
            request.setAttribute("errorMessage", "Service could not be created.");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "errorMessage.jsp");
        } else {
            //request.setAttribute("msgCreateServiceman", "Serviceman was created.");
            response.sendRedirect("index.jsp");
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
