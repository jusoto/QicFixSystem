/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.model.Client;
import client.model.ModelFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Utility;

/**
 *
 * @author Juan
 */
public class updateClient extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ModelFacade model = new ModelFacade();
        Client obj = new Client();
        String token = "";
        if(request.getAttribute("token")!=null){
            token = request.getAttribute("token").toString();
        }
        
        obj.setFname(request.getParameter("fname").trim());
        obj.setLname(request.getParameter("lname").trim());
        obj.setEmail(request.getParameter("email").trim());
        obj.setPassword(request.getParameter("password").trim());
        obj.setStreetAddress(request.getParameter("street_address").trim());
        obj.setCity(request.getParameter("city").trim());
        obj.setState(request.getParameter("state").trim());
        obj.setZipcode(request.getParameter("zipcode").trim());
        obj.setDob(Utility.StringToDate(request.getParameter("dob")));
        if (model.updateClient(obj, token)) {
            session.setAttribute("email", obj.getEmail());
            session.setAttribute("name", obj.getFname() + " " + obj.getLname());
            session.setAttribute("userTypeId", obj.getUserTypeId());
            
            session.setAttribute("indexMessage", "Profile Updated");
            response.sendRedirect("index.jsp");
        }else{
            session.setAttribute("errorMessage", "There was an error. Action couldn't be performed.");
            response.sendRedirect("errorMessage.jsp");
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
