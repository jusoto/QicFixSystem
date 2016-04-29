/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.Client;
import entity.DatastoreFacade;
import entity.Tower;
import java.util.List;

/**
 *
 * @author Juan
 */
public class RegistrationLogic {

    private final Authenticator authenticator;

    public RegistrationLogic() {
        authenticator = Authenticator.getInstance();
    }

    boolean registerTower(String content) {
        DatastoreFacade ds = new DatastoreFacade();
        List<Tower> list;
        Tower tower = null;
        list = Tower.fromJson(content);
        if (list != null && list.size() > 0) {
            tower = list.get(0);
        }
        return ds.createTower(tower);
    }

    boolean registerClient(String content) {
        List<Client> list = Client.fromJson(content);
        Client client = null;
        if(list!=null && list.size()>0){
            client = list.get(0);
        }
        DatastoreFacade ds = new DatastoreFacade();
        return ds.createClient(client);
    }

}
