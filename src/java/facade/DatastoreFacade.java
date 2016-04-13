/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Client;
import entity.Service;
import entity.Tower;

/**
 *
 * @author Juan
 */
public class DatastoreFacade {
    
    Client client;
    Tower tower;
    Service service;
    
    public DatastoreFacade(){
        
    }
    
    public DatastoreFacade(Integer idclient, Integer idtower){
        client = new Client();
        tower = new Tower();
        service = new Service();
        client.selectById(idclient);
        tower.selectById(idtower);
    }
    
    public void CreateClient(){
        
    }
    
    public void CreateTower(){
        
    }
    
    public void CreateService(){
        
    }
    
    public void UpdateService(){
        
    }
    
}
