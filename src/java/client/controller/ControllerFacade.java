/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.model.ModelFacade;

/**
 *
 * @author Juan
 */
public class ControllerFacade {
    
    public ControllerFacade(){
    }
    
    public String login(String email, String password){
        String key;
        ModelFacade ds = new ModelFacade();
        key = ds.login(email, password);
        return key;
    }
    
    public void blockAccount(String email){
        ModelFacade ds = new ModelFacade();
        ds.blockAccount(email);
    }
    
}
