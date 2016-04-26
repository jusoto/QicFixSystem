/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.DatastoreFacade;
import entity.Service;
import entity.Tower;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    String createService(String content, String token, String email) {
        String message = "false";
        if (authenticator.isAuthTokenValid(token, email)) {
            DatastoreFacade ds = new DatastoreFacade();
            String pickup;
            String destination;
            String[] array = getObjects(content);
            String jsonService = array[0];
            String jsonTower = array[1];

            List<Tower> listTower = Tower.fromJson(jsonTower);
            List<Service> list = Service.fromJson(jsonService);
            Service service = null;

            for (int i = 0; i < list.size(); i++) {
                try {
                    service = list.get(i);
                    pickup = service.getStreetAddressPickup() + ", " + service.getCityPickup() + " " + service.getStatePickup() + ", " + service.getZipcodePickup();
                    destination = service.getStreetAddressDestination() + ", " + service.getCityDestination() + " " + service.getStateDestination() + ", " + service.getZipcodeDestination();
                    Location locationPickup = null;//Utility.getLocationFromAddress(pickup);
                    Location locationDestination = null;//Utility.getLocationFromAddress(destination);
                    if (locationPickup != null) {
                        service.setLatitudePickup(locationPickup.getLatitude());
                        service.setLongitudePickup(locationPickup.getLongitude());
                    }
                    if (locationDestination != null) {
                        service.setLatitudeDestination(locationDestination.getLatitude());
                        service.setLongitudeDestination(locationDestination.getLongitude());
                    }
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

    //Splits objects between [Object1] [Object2] [Object3]
    private String[] getObjects(String content) {
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(content);
        ArrayList<String> stringList = new ArrayList<String>();

        while (matcher.find()) {
            stringList.add(matcher.group(1));
        }

        String[] stringArray = stringList.toArray(new String[stringList.size()]);
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = "[" + stringArray[i] + "]";
        }
        return stringArray;
    }

}
