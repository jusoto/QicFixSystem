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
import entity.User;
import java.util.List;
import util.Location;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;
import util.Utility;

/**
 *
 * @author Juan
 */
public class AppLogicFacade {

    private Authenticator authenticator;
    
    public AppLogicFacade() {
        authenticator = Authenticator.getInstance();
    }

    public String requestService(String content, String token, String email) {
        ServiceLogic obj = new ServiceLogic();
        return obj.createService(content, token, email);
    }

    public List<Tower> listTower(String authToken, String email, String pickup, Integer order) {
        if (authenticator.isAuthTokenValid(authToken, email)) {
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
        LoginLogic logic = new LoginLogic();
        return logic.login(email, password);
    }

    public void logout(String token, String email) {
        /*if (authenticator.isAuthTokenValid(authToken, email)) {
            try {
                authenticator.logout(authToken);
            } catch (GeneralSecurityException ex) {
                Logger.getLogger(AppLogicFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        LogoutLogic logic = new LogoutLogic();
        logic.logout(token, email);
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

    public List<Service> selectAllService(String authToken, String email) {
        if (authenticator.isAuthTokenValid(authToken, email)) {
            DatastoreFacade ds = new DatastoreFacade();
            return ds.selectAllService();
        }
        return null;
    }

    public String acceptService(String content, String authToken, String email, Integer serviceId) {
        String message = "false";
        if (authenticator.isAuthTokenValid(authToken, email)) {
            DatastoreFacade ds = new DatastoreFacade();
            if (ds.acceptService(email, serviceId)) {
                message = "true";
            }
        }
        return message;
    }

    public String declineService(String content, String authToken, String email, Integer serviceId) {
        String message = "false";
        if (authenticator.isAuthTokenValid(authToken, email)) {
            DatastoreFacade ds = new DatastoreFacade();
            if (ds.declineService(email, serviceId)) {
                message = "true";
            }
        }
        return message;
    }

    public String chargeService(String content, String authToken, String email, Integer serviceId) {
        String message = "false";
        if (authenticator.isAuthTokenValid(authToken, email)) {
            DatastoreFacade ds = new DatastoreFacade();
            if (ds.chargeService(email, serviceId)) {
                message = "true";
            }
        }
        return message;
    }

    public List<Service> selectServiceByTowerEmail(String authToken, String towerEmail) {
        List<Service> list = null;
        if (authenticator.isAuthTokenValid(authToken, towerEmail)) {
            DatastoreFacade ds = new DatastoreFacade();
            list = ds.selectServiceByTowerEmail(towerEmail);
        }
        return list;
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

    public void blockUser(String email) {
        User user = new User();
        List<User> list = user.selectByEmail(email);
        if (list.size() > 0) {
            user = list.get(0);
        }
        user.setBlocked(UUID.randomUUID().toString());
        user.block();
    }

    public boolean registerClient(String content) {
        RegistrationLogic logic = new RegistrationLogic();
        return logic.registerClient(content);
    }

    public List<User> selectUserByEmail(String email, String token) {
        List<User> list = null;
        if (authenticator.isAuthTokenValid(token, email)) {
            DatastoreFacade ds = new DatastoreFacade();
            list = ds.selectUserByEmail(email);
        }
        return list;
    }

    public List<Client> selectClientByEmail(String email, String token) {
        List<Client> list = null;
        if (authenticator.isAuthTokenValid(token, email)) {
            DatastoreFacade ds = new DatastoreFacade();
            list = ds.selectClientByEmail(email);
        }
        return list;
    }

    public List<Tower> getTowerList(String token, String email, String address, Integer order) {
        ListTowerLogic logic = new ListTowerLogic();
        return logic.getTowerList(token, email, address, order);
    }

    public boolean updateTower(String content, String email, String token) {
        EditProfileLogic editProfile = new EditProfileLogic();
        return editProfile.updateTower(content, email, token);
    }

    public boolean registerTower(String content) {
        RegistrationLogic registration = new RegistrationLogic();
        return registration.registerTower(content);
    }

    public List<Tower> getTowerById(String token, String email, Integer id) {
        EditProfileLogic editProfile = new EditProfileLogic();
        return editProfile.getTowerById(email, token, id);
    }

    public boolean updateClient(String content, String token, String email) {
        EditProfileLogic editProfile = new EditProfileLogic();
        return editProfile.updateClient(content, email, token);
    }

    public List<Client> getClientById(String token, String email, Integer id) {
        EditProfileLogic editProfile = new EditProfileLogic();
        return editProfile.getClientById(email, token, id);
    }

}
