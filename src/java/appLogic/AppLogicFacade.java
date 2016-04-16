/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.Client;
import entity.DatastoreFacade;
import entity.Service;
import entity.Tower;
import java.util.List;
import util.Location;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;
import util.Utility;

/**
 *
 * @author Juan
 */
public class AppLogicFacade {

    Authenticator authenticator;

    public AppLogicFacade() {
        authenticator = Authenticator.getInstance();
    }

    public String requestService(String content, String authToken, String email, Location location) {
        String message = "false";
        if (authenticator.isAuthTokenValid(authToken)) {
            DatastoreFacade ds = new DatastoreFacade();
            if(ds.requestService(content, email, location)){
                message = "true";
            }
        }
        return message;
    }

    public List<Tower> listTower(String authToken, String pickup, Integer order) {
        if (authenticator.isAuthTokenValid(authToken)) {
            DatastoreFacade ds = new DatastoreFacade();
            Location location = null;
            try {
                location = Utility.getLocationFromAddress(pickup);
            } catch (Exception ex) {
                Logger.getLogger(AppLogicFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
            return ds.selectAllTower(location, order);
        }
        return null;
    }

    public String login(String email, String password) throws LoginException {
        String token;

        token = authenticator.login(email, password);

        return token;
    }

    public void logout(String authToken) {
        if (authenticator.isAuthTokenValid(authToken)) {
            try {
                authenticator.logout(authToken);
            } catch (GeneralSecurityException ex) {
                Logger.getLogger(AppLogicFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Location getLocationByAddress(String address) {
        Location location = null;
        try {
            location = Utility.getLocationFromAddress(address);
        } catch (Exception ex) {
            Logger.getLogger(AppLogicFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return location;
    }

    public List<Service> selectAllService(String authToken) {
        if (authenticator.isAuthTokenValid(authToken)) {
            DatastoreFacade ds = new DatastoreFacade();
            return ds.selectAllService();
        }
        return null;
    }

    public String acceptService(String content, String authToken, String email, Integer serviceId) {
        String message = "false";
        if (authenticator.isAuthTokenValid(authToken)) {
            DatastoreFacade ds = new DatastoreFacade();
            if (ds.acceptService(email, serviceId)) {
                message = "true";
            }
        }
        return message;
    }

    public String declineService(String content, String authToken, String email, Integer serviceId) {
        String message = "false";
        if (authenticator.isAuthTokenValid(authToken)) {
            DatastoreFacade ds = new DatastoreFacade();
            if (ds.declineService(email, serviceId)) {
                message = "true";
            }
        }
        return message;
    }

    public String chargeService(String content, String authToken, String email, Integer serviceId) {
        String message = "false";
        if (authenticator.isAuthTokenValid(authToken)) {
            DatastoreFacade ds = new DatastoreFacade();
            if (ds.chargeService(email, serviceId)) {
                message = "true";
            }
        }
        return message;
    }

    public List<Service> selectServiceByTowerEmail(String authToken, String towerEmail) {
        List<Service> list = null;
        if (authenticator.isAuthTokenValid(authToken)) {
            DatastoreFacade ds = new DatastoreFacade();
            list = ds.selectServiceByTowerEmail(towerEmail);
        }
        return list;
    }

    public void clientRegistration(Client client) {

    }

    public void towerRegistration(Tower tower) {

    }

    public String getAddressByLocation(Location location) {
        String address = "";

        return address;
    }
    
    public void updatePickup(Integer idservice, String pickup) {

    }

    public void updateDestination(Integer idservice, String destination) {

    }

    public void selectTowers(List<Tower> list) {

    }

    public void chargeClient(Integer idservice, Double charge) {

    }

    public void makePayment(Integer idservice, Double payment) {

    }

    public void rateTower(Integer serviceId, Integer towerId, Integer rate) {

    }

}
