/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.Tower;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Utility;

/**
 *
 * @author Juan
 */
public class createTower extends HttpServlet {

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
        Tower obj = new Tower();
        Double positionX = 0.;
        Double positionY = 0.;
        String location = request.getAttribute("location").toString();
        positionX = Double.parseDouble(location.split(",")[0]);
        positionY = Double.parseDouble(location.split(",")[1]);
        
        obj.setName(request.getAttribute("name").toString());
        obj.setEmail(request.getAttribute("email").toString());
        obj.setPassword(request.getAttribute("password").toString());
        obj.setAddress(request.getAttribute("address").toString());
        obj.setDob(Utility.StringToDate(request.getAttribute("dob").toString()));
        obj.setPositionX(positionX);
        obj.setPositionY(positionY);
        obj.createTower();
        request.setAttribute("msgCreateServiceman", "Serviceman was created.");
        response.sendRedirect("registerServiceman.jsp");
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
