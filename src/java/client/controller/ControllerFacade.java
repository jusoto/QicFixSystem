/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import client.model.Application;
import client.model.Client;
import client.model.ModelFacade;
import client.model.Tower;
import client.model.User;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Juan
 */
public class ControllerFacade {

    public ControllerFacade() {
    }

    /*public String login(String email, String password) {
        String key;
        ModelFacade ds = new ModelFacade();
        key = ds.login(email, password);
        return key;
    }*/

    public void blockAccount(String email) {
        ModelFacade ds = new ModelFacade();
        ds.blockAccount(email);
    }

    public User selectUserByEmail(String token, String email) {
        User user = new User();
        user.setEmail(email);
        return user.selectByEmail(token, email);
    }

    public Client selectClientByEmail(String token, String email) {
        Client client = new Client();
        client.setEmail(email);
        client = client.selectByEmailClient(token, email);
        return client;
    }
    
    public Tower selectTowerByEmail(String token, String email) {
        Tower obj = new Tower();
        obj.setEmail(email);
        obj = obj.selectByEmailTower(token, email);
        return obj;
    }
    
    public boolean registerClient(Client client){
        return true;
    }

    public String getMenu(Integer userTypeId) {
        ModelFacade model = new ModelFacade();
        return model.getMenu(userTypeId);
    }

}
