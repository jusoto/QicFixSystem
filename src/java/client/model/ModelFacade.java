/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ws.rs.core.MultivaluedMap;
import util.Utility;

/**
 *
 * @author Juan
 */
public class ModelFacade {

    public ModelFacade() {
    }

    public String login(String email, String password) {
        String key;
        RESTConnection conn = RESTConnection.getInstance();
        String path = Utility.LOGIN_PATH;

        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("email", email);
        parameters.put("password", password);

        key = conn.getMethod(path, parameters);

        return key;
    }

    public void createClient(String token, Client client) {
        client.create(token);
    }

    public void createTower(String token, Tower tower) {
        tower.create(token);
    }

    public void createRequest(String token, Service service, List<Tower> listTower) {
        service.create(token, listTower);
    }

    public void acceptRequest(String token, Integer serviceId, Integer towerId) {
        HasTower hasTower = new HasTower();
        hasTower.setServiceId(serviceId);
        hasTower.setTowerId(towerId);
        //hasTower.acceptRequest(token);
    }

    public void declineRequest(Integer serviceId, Integer towerId) {
        HasTower hasTower = new HasTower();
        hasTower.setServiceId(serviceId);
        hasTower.setTowerId(towerId);
        //hasTower.cancelRequest();
    }

    public User getUserByEmail(String token, String email) {
        User user = new User();
        RESTConnection conn = RESTConnection.getInstance();
        String path = Utility.USER_PATH;

        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("token", token);
        parameters.put("email", email);

        String json = conn.getMethod(path, parameters);

        List<User> list = user.fromJsonUser(json);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public void blockAccount(String email) {
        User user = new User();
        user.block(email);
    }

}
