/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import entity.Application;
import entity.Client;
import entity.DatastoreFacade;
import entity.Service;
import entity.Tower;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import util.Location;

/**
 *
 * @author Juan
 */
public class MockDataStoreFacade extends DatastoreFacade {

    @Override
    public List<Service> selectUserByClientEmail(String email) {
        return super.selectUserByClientEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Application> selectApplication(Integer userTypeId) {
        return super.selectApplication(userTypeId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateClient(Client client) {
        super.updateClient(client); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tower> selectTowerByPrice(String city, String state) {
        return super.selectTowerByPrice(city, state); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tower> selectTowerByRating(String city, String state) {
        return super.selectTowerByRating(city, state); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tower> selectTowerByAddress(Location location, String city, String state) {
        return super.selectTowerByAddress(location, city, state); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tower> selectTowerByAddress(String address) {
        return super.selectTowerByAddress(address); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Client> selectClientByEmail(String email) {
        return super.selectClientByEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> selectUserByEmail(String email) {
        return super.selectUserByEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tower> selectAllTower(Location location, Integer order) {
        return super.selectAllTower(location, order); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Service> selectAllService() {
        return super.selectAllService(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean acceptService(String towerEmail, Integer serviceId) {
        return super.acceptService(towerEmail, serviceId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean declineService(String towerEmail, Integer serviceId) {
        return super.declineService(towerEmail, serviceId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean chargeService(String email, Integer serviceId) {
        return super.chargeService(email, serviceId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Service> selectServiceByTowerEmail(String towerEmail) {
        return super.selectServiceByTowerEmail(towerEmail); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validateUser(String email, String password) {
        return super.validateUser(email, password); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void declineRequest(Integer serviceId, Integer towerId) {
        super.declineRequest(serviceId, towerId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void acceptRequest(Integer serviceId, Integer towerId) {
        super.acceptRequest(serviceId, towerId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createRequest(Service service, List<Tower> listTower) {
        return super.createRequest(service, listTower); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createTower(Tower tower) {
        return super.createTower(tower); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createClient(Client client) {
        List<Client> list = new ArrayList<Client>();
        //TODO Populate list
        Client client2 = new Client();
        client.setEmail("user1");
        list.add(client2);
        for (int i=0; i<list.size(); i++){
            if(client.getEmail().equals(list.get(i).getEmail())){
               return false; 
            }
        }
        return true;
    }
    
    
    
    
    
    public Client getClient1(){
        Client c = new Client();
        c.setEmail("user1@email.com");
        c.setPassword("abc123");
        return c;
    }
    
    public boolean doesExist(Client client){
        Client c1 = getClient1();
        return client.getEmail() == c1.getEmail(); 
    }
    
}
