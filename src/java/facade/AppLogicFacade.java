/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Client;
import entity.Service;
import entity.Tower;
import java.util.List;
import entity.Location;

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
    
    public AppLogicFacade(Integer idclient, Integer idtower){
        client = new Client();
        tower = new Tower();
        service = new Service();
        client.selectById(idclient);
        tower.selectById(idtower);
    }
    
    public void requestService(Location pickup, Location destination){
        
    }
    
    public void updatePickup(Integer idservice, Location pickup){
        
    }
    
    public void updateDestination(Integer idservice, Location destination){
        
    }
    
    public List<Tower> listTower(Location pickup, Integer order){
        return null;
    }
    
    public void selectTowers(List<Tower> list){
        
    }
    
    public void chargeClient(Integer idservice, Double charge){
        
    }
    
    public void makePayment(Integer idservice, Double payment){
        
    }
}
