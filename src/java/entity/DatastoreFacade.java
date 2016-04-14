/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Client;
import entity.Service;
import entity.Tower;
import java.util.List;

/**
 *
 * @author Juan
 */
public class DatastoreFacade {
    
    public DatastoreFacade(){
    }
    
    public void createClient(Client client){
        client.create();
    }
    
    public void createTower(Tower tower){
        tower.create();
    }
    
    public void createRequest(Service service, List<Tower> listTower){
        service.createService(listTower);
    }
    
    public void acceptRequest(Integer serviceId, Integer towerId){
        HasTower hasTower = new HasTower();
        hasTower.setServiceId(serviceId);
        hasTower.setTowerId(towerId);
        hasTower.acceptRequest();
    }
    
    public void declineRequest(Integer serviceId, Integer towerId){
        HasTower hasTower = new HasTower();
        hasTower.setServiceId(serviceId);
        hasTower.setTowerId(towerId);
        hasTower.cancelRequest();
    }
    
}
