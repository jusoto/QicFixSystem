/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.Client;
import entity.DatastoreFacade;
import entity.Tower;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class EditProfileLogic {
    
    private final Authenticator authenticator;

    public EditProfileLogic() {
        authenticator = Authenticator.getInstance();
    }
    
    public boolean updateTower(String content, String email, String token, Integer id) {
        boolean resp = false;
        List<Tower> list;
        Tower tower;
        if (authenticator.isAuthTokenValid(token, email)) {
            list = Tower.fromJson(content);
            if (list != null && list.size() > 0) {
                tower = list.get(0);
                tower.setId(id);
                tower.updateTower();
            }
        }
        return resp;
    }

    public List<Tower> getTowerById(String email, String token, Integer id) {
        List<Tower> list = new ArrayList<Tower>();
        Tower tower = new Tower();
        if (authenticator.isAuthTokenValid(token, email)) {
            list.add(tower.selectById(id));
        }
        return list;
    }

    public List<Client> getClientById(String email, String token, Integer id) {
        List<Client> list = new ArrayList<Client>();
        Client client = new Client();
        if (authenticator.isAuthTokenValid(token, email)) {
            list.add(client.selectById(id));
        }
        return list;
    }
    
    public boolean updateClient(String content, String email, String token) {
        /*boolean resp = false;
        List<Client> list;
        Client client;
        if (authenticator.isAuthTokenValid(token, email)) {
            list = Client.fromJson(content);
            if (list != null && list.size() > 0) {
                client = list.get(0);
                client.updateClient();
            }
        }
        return resp;*/
        
        boolean resp = false;
        if (authenticator.isAuthTokenValid(token, email)) {
            DatastoreFacade ds = new DatastoreFacade();
            Client client = new Client();
            List<Client> list = client.fromJson(content);
            if (list.size() > 0) {
                ds.updateClient(list.get(0));
                resp = true;
            }
        }
        return resp;
    }

    List<Client> selectClientByEmail(String email, String token) {
        List<Client> list = null;
        if (authenticator.isAuthTokenValid(token, email)) {
            DatastoreFacade ds = new DatastoreFacade();
            list = ds.selectClientByEmail(email);
        }
        return list;
    }
    
}
