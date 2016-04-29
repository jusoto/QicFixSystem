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
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Location;
import util.Utility;

/**
 *
 * @author Juan
 */
public class ListTowerLogic {
    
    private final Authenticator authenticator;

    public ListTowerLogic() {
        authenticator = Authenticator.getInstance();
    }

    public List<Tower> getTowerList(String token, String email, String address, Integer order) {
        List<Tower> list = null;
        try {
            
            Double latitude, longitude;
            Location location = Utility.getLocationFromAddress(address);
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        String city = address.split(",")[1].split(" ")[0];
        String state = address.split(",")[1].split(" ")[1];
            if (authenticator.isAuthTokenValid(token, email)) {
                DatastoreFacade ds = new DatastoreFacade();
                switch(order){
                    case 1: list = ds.selectTowerByAddress(location, city, state); break;
                    case 2: list = ds.selectTowerByRating(city, state); break;
                    case 3: list = ds.selectTowerByPrice(city, state); break;
                }
            }   return list;
        } catch (Exception ex) {
            Logger.getLogger(ListTowerLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
