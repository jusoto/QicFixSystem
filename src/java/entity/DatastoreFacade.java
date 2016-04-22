/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import util.Location;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utility;

/**
 *
 * @author Juan
 */
public class DatastoreFacade {

    public DatastoreFacade() {
    }

    public void createClient(Client client) {
        client.create();
    }

    public void createTower(Tower tower) {
        tower.create();
    }

    public void createRequest(Service service, List<Tower> listTower) {
        service.create(listTower);
    }

    public void acceptRequest(Integer serviceId, Integer towerId) {
        HasTower hasTower = new HasTower();
        hasTower.setServiceId(serviceId);
        hasTower.setTowerId(towerId);
        hasTower.acceptRequest();
    }

    public void declineRequest(Integer serviceId, Integer towerId) {
        HasTower hasTower = new HasTower();
        hasTower.setServiceId(serviceId);
        hasTower.setTowerId(towerId);
        hasTower.cancelRequest();
    }

    public boolean validateUser(String email, String password) {
        User user = new User();
        return user.validateUser(email, password);
    }

    public List<Service> selectServiceByTowerEmail(String towerEmail) {
        List<Service> list = null;
        Service service = new Service();
        Tower tower = new Tower();
        tower.setEmail(towerEmail);
        List<Tower> listTower = tower.selectTowerByEmail(towerEmail);
        if(listTower!=null && listTower.size()>0){
            list = service.selectServiceByTowerId(listTower.get(0).getId());
        }
        return list;
    }

    public boolean chargeService(String email, Integer serviceId) {
        Payment payment = new Payment();
        payment.setAmount(80.0);
        Service service = new Service();
        service.setId(serviceId);
        service.setCost(80.0);
        service.setEndDate(new Date());
        service.endService();
        return payment.charge();
    }

    public boolean declineService(String towerEmail, Integer serviceId) {
        HasTower hasTower = new HasTower();
        Tower tower = new Tower();
        tower.setEmail(towerEmail);
        List<Tower> listTower = tower.selectTowerByEmail(towerEmail);
        if(listTower!=null && listTower.size()>0){
            hasTower.setTowerId(listTower.get(0).getId());
        }
        hasTower.setServiceId(serviceId);
        hasTower.setTowerDeclineDate(new Date());
        return hasTower.cancelRequest();
    }

    public boolean acceptService(String towerEmail, Integer serviceId) {
        HasTower hasTower = new HasTower();
        Tower tower = new Tower();
        tower.setEmail(towerEmail);
        List<Tower> listTower = tower.selectTowerByEmail(towerEmail);
        if(listTower!=null && listTower.size()>0){
            hasTower.setTowerId(listTower.get(0).getId());
        }
        hasTower.setServiceId(serviceId);
        hasTower.setTowerAcceptDate(new Date());
        return hasTower.acceptRequest();
    }

    public List<Service> selectAllService() {
        Service obj = new Service();
        return obj.selectAll();
    }

    public List<Tower> selectAllTower(Location location, Integer order) {
        List<Tower> list;
        Tower tower = new Tower();
        list = tower.selectAllOrdered(location, order);
        return list;
    }

    public boolean requestService(String content, String email, Location location) {
        String pickup;
        String destination;
        List<Tower> listTower = null;
        List<Service> list = Service.fromJson(content);
        for (int i = 0; i < list.size(); i++) {
            try {
                Service service = list.get(i);
                pickup = service.getStreetAddressPickup() + ", " + service.getCityPickup() + " " + service.getStatePickup() + ", " + service.getZipcodePickup();
                destination = service.getStreetAddressDestination() + ", " + service.getCityDestination() + " " + service.getStateDestination() + ", " + service.getZipcodeDestination();
                Location locationPickup = Utility.getLocationFromAddress(pickup);
                Location locationDestination = Utility.getLocationFromAddress(destination);
                service.setLatitudePickup(locationPickup.getLatitude());
                service.setLongitudePickup(locationPickup.getLongitude());
                service.setLatitudeDestination(locationDestination.getLatitude());
                service.setLongitudeDestination(locationDestination.getLongitude());
                return service.create(listTower);
            } catch (Exception ex) {
                Logger.getLogger(DatastoreFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<User> selectUserByEmail(String email) {
        List<User> list;
        User user = new User();
        list = user.selectByEmail(email);
        return list;
    }

    public List<Client> selectClientByEmail(String email) {
        List<Client> list;
        Client client = new Client();
        list = client.selectClientByEmail(email);
        return list;
    }

}
