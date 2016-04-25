/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.DatastoreFacade;
import entity.Service;
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
public class ServiceLogic {

    Authenticator authenticator;

    public ServiceLogic() {
        authenticator = Authenticator.getInstance();
    }

    String createService(String content, String token, String email, Location location) {
        String message = "false";
        if (authenticator.isAuthTokenValid(token, email)) {
            DatastoreFacade ds = new DatastoreFacade();
            String pickup;
            String destination;
            List<Tower> listTower = null;
            List<Service> list = Service.fromJson(content);
            Service service = null;
                    
            for (int i = 0; i < list.size(); i++) {
                try {
                    service = list.get(i);
                    pickup = service.getStreetAddressPickup() + ", " + service.getCityPickup() + " " + service.getStatePickup() + ", " + service.getZipcodePickup();
                    destination = service.getStreetAddressDestination() + ", " + service.getCityDestination() + " " + service.getStateDestination() + ", " + service.getZipcodeDestination();
                    Location locationPickup = Utility.getLocationFromAddress(pickup);
                    Location locationDestination = Utility.getLocationFromAddress(destination);
                    service.setLatitudePickup(locationPickup.getLatitude());
                    service.setLongitudePickup(locationPickup.getLongitude());
                    service.setLatitudeDestination(locationDestination.getLatitude());
                    service.setLongitudeDestination(locationDestination.getLongitude());
                    //return service.create(listTower);
                } catch (Exception ex) {
                    Logger.getLogger(DatastoreFacade.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //return false;
            if (ds.createRequest(service, listTower)) {
                message = "true";
            }
        }
        return message;
    }
    
    

}
