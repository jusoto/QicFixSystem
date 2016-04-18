/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.model.ModelFacade;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Juan
 */
public class LoginController extends HttpServlet {
    
    public LoginController(){
        
    }
    
    public String Login(String email, String password){
        String key;
        ModelFacade ds = new ModelFacade();
        key = ds.login(email, password);
        
        return key;
    }
    
    
}
