/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.Client;
import entity.Service;
import entity.Tower;
import java.util.List;
import entity.Location;
import entity.User;
import util.Utility;

/**
 *
 * @author Juan
 */
public class AppLogicFacade {
    
    Client client;
    Tower tower;
    Service service;
    
    public AppLogicFacade(){
    }
    
    public String requestService(String content){
        String message = "false";
        String pickup;
        String destination;
        List<Service> list = Service.fromJson(content);
        for(int i=0; i<list.size(); i++){
            Service service = list.get(i);
            pickup = service.getStreetAddressPickup() + ", " + service.getCityPickup()+" "+service.getStatePickup()+", "+service.getZipcodePickup();
            destination = service.getStreetAddressDestination() + ", " + service.getCityDestination()+" "+service.getStateDestination()+", "+service.getZipcodeDestination();
            String locationPickup = Utility.getLocationFromAddress(pickup);
            String locationDestination = Utility.getLocationFromAddress(destination);
            service.setLatitudePickup(Double.parseDouble(locationPickup.split(",")[0].trim()));
            service.setLongitudePickup(Double.parseDouble(locationPickup.split(",")[1].trim()));
            service.setLatitudeDestination(Double.parseDouble(locationDestination.split(",")[0].trim()));
            service.setLongitudeDestination(Double.parseDouble(locationDestination.split(",")[1].trim()));
        }
        return message;
    }
    
    public void updatePickup(Integer idservice, String pickup){
        
    }
    
    public void updateDestination(Integer idservice, Location destination){
        
    }
    
    public List<Tower> listTower(String pickup, Integer order){
        List<Tower> list;
        Tower tower = new Tower();
        list = tower.selectAllOrdered(pickup, order);
        return list;
    }
    
    public void selectTowers(List<Tower> list){
        
    }
    
    public void chargeClient(Integer idservice, Double charge){
        
    }
    
    public void makePayment(Integer idservice, Double payment){
        
    }
    
    public void rateTower(Integer serviceId, Integer towerId, Integer rate){
        
    }
    
    public void login(User user){
        
    }
    
    public void logout(User user){
        
    }
    
    public void clientRegistration(Client client){
        
    }
    
    public void towerRegistration(Tower tower){
        
    }
    
    public String getAddressByLocation(Location location){
        String address = "";
        
        
        
        return address;
    }
    
    public Location getLocationByAddress(String address){
        Location location;
        double latitude = 0;
        double longitude = 0;
        
        
        
        location = new Location(latitude, longitude);
        
        return location;
    }
    
    
}
