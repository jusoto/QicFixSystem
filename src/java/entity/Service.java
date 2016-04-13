/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utility;

/**
 *
 * @author Juan
 */
public class Service {

    private Integer id;
    private Integer clientId;
    private Date creationDate;
    private Date startDate;
    private Date endDate;
    private Date cancelDate;
    private Double cost;
    private Double latitudePickup;
    private Double longitudePickup;
    private Double latitudeDestination;
    private Double longitudeDestination;
    private String streetAddressPickup;
    private String statePickup;
    private String zipcodePickup;
    private String streetAddressDestination;
    private String stateDestination;
    private String zipcodeDestination;
    private String clientDescription;
    private String towerDescription;

    public Service() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getLatitudePickup() {
        return latitudePickup;
    }

    public void setLatitudePickup(Double latitudePickup) {
        this.latitudePickup = latitudePickup;
    }

    public Double getLongitudePickup() {
        return longitudePickup;
    }

    public void setLongitudePickup(Double longitudePickup) {
        this.longitudePickup = longitudePickup;
    }

    public Double getLatitudeDestination() {
        return latitudeDestination;
    }

    public void setLatitudeDestination(Double latitudeDestination) {
        this.latitudeDestination = latitudeDestination;
    }

    public Double getLongitudeDestination() {
        return longitudeDestination;
    }

    public void setLongitudeDestination(Double longitudeDestination) {
        this.longitudeDestination = longitudeDestination;
    }

    public String getStreetAddressPickup() {
        return streetAddressPickup;
    }

    public void setStreetAddressPickup(String streetAddressPickup) {
        this.streetAddressPickup = streetAddressPickup;
    }

    public String getStatePickup() {
        return statePickup;
    }

    public void setStatePickup(String statePickup) {
        this.statePickup = statePickup;
    }

    public String getZipcodePickup() {
        return zipcodePickup;
    }

    public void setZipcodePickup(String zipcodePickup) {
        this.zipcodePickup = zipcodePickup;
    }

    public String getStreetAddressDestination() {
        return streetAddressDestination;
    }

    public void setStreetAddressDestination(String streetAddressDestination) {
        this.streetAddressDestination = streetAddressDestination;
    }

    public String getStateDestination() {
        return stateDestination;
    }

    public void setStateDestination(String stateDestination) {
        this.stateDestination = stateDestination;
    }

    public String getZipcodeDestination() {
        return zipcodeDestination;
    }

    public void setZipcodeDestination(String zipcodeDestination) {
        this.zipcodeDestination = zipcodeDestination;
    }

    public String getClientDescription() {
        return clientDescription;
    }

    public void setClientDescription(String clientDescription) {
        this.clientDescription = clientDescription;
    }

    public String getTowerDescription() {
        return towerDescription;
    }

    public void setTowerDescription(String towerDescription) {
        this.towerDescription = towerDescription;
    }

    public boolean createService(List<Integer> listServiceman) {

        boolean resp = false;
        int parameterIndex = 0;
        int idservice;
        HasTower rel = new HasTower();

        String sql = "INSERT INTO service (client_id, creation_date, start_date, end_date, cancel_date, cost,"
                + " latitude_pickup, longitude_pickup, latitude_destination, longitude_destination,"
                + " street_address_pickup, state_pickup, zipcode_pickup,"
                + " street_address_destination, state_destination, zipcode_destination,"
                + " client_description, tower_description)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Database db = new Database();
        try {
            db.Connect();
            db.setPreparedStatement(sql);
            db = prepareStatement(db);
            idservice = db.ExecuteNonQuery();
            this.setId(idservice);
            rel.createRequest(idservice, listServiceman);
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (db != null) {
                try {
                    db.Close();
                } catch (SQLException ex) {
                    Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return resp;
    }

    public boolean endService() {
        boolean resp = false;
        int parameterIndex = 0;

        String sql = "UPDATE service SET tower_description=?, end_date=?, cost=? WHERE id=?";

        Database db = new Database();
        try {
            db.Connect();
            db.setPreparedStatement(sql);
            db.getPreparedStatement().setString(++parameterIndex, this.getTowerDescription());
            db.getPreparedStatement().setDate(++parameterIndex, (java.sql.Date) this.getEndDate());
            db.getPreparedStatement().setDouble(++parameterIndex, this.getCost());
            db.getPreparedStatement().setInt(++parameterIndex, this.getId());
            db.ExecuteNonQuery();
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (db != null) {
                try {
                    db.Close();
                } catch (SQLException ex) {
                    Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return resp;
    }

    public List<Service> SelectAll() {
        List<Service> list = new ArrayList<Service>();
        String sql;
        ResultSet rs = null;

        sql = "SELECT id, client_id, creation_date, start_date, end_date, cancel_date, cost,"
                + " latitude_pickup, longitude_pickup, latitude_destination, longitude_destination,"
                + " street_address_pickup, state_pickup, zipcode_pickup,"
                + " street_address_destination, state_destination, zipcode_destination,"
                + " client_description, tower_description"
                + " FROM service";

        Database db = new Database();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            while (rs.next()) {
                Service service = readResulset(rs);
                list.add(service);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
            }
            try {
                db.Close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }

        return list;
    }

    private Service readResulset(ResultSet rs) throws SQLException {
        Service service = new Service();
        service.setId(rs.getString("id") != null ? rs.getInt("id") : null);
        service.setClientId(rs.getString("client_id") != null ? rs.getInt("client_id") : null);
        service.setStartDate(rs.getString("creation_date") != null ? (java.sql.Date) Utility.StringToDate(rs.getString("creation_date")) : null);
        service.setStartDate(rs.getString("start_date") != null ? (java.sql.Date) Utility.StringToDate(rs.getString("start_date")) : null);
        service.setStartDate(rs.getString("end_date") != null ? (java.sql.Date) Utility.StringToDate(rs.getString("end_date")) : null);
        service.setStartDate(rs.getString("cancel_date") != null ? (java.sql.Date) Utility.StringToDate(rs.getString("cancel_date")) : null);
        service.setLatitudePickup(rs.getString("latitude_pickup") != null ? rs.getDouble("latitude_pickup") : null);
        service.setLongitudePickup(rs.getString("longitude_pickup") != null ? rs.getDouble("longitude_pickup") : null);
        service.setLatitudePickup(rs.getString("latitude_destination") != null ? rs.getDouble("latitude_destination") : null);
        service.setLongitudePickup(rs.getString("longitude_destination") != null ? rs.getDouble("longitude_destination") : null);
        service.setStreetAddressPickup(rs.getString("street_address_pickup"));
        service.setStatePickup(rs.getString("state_pickup"));
        service.setZipcodePickup(rs.getString("zipcode_pickup"));
        service.setStreetAddressDestination(rs.getString("street_address_destination"));
        service.setStateDestination(rs.getString("state_destination"));
        service.setZipcodeDestination(rs.getString("zipcode_destination"));
        return service;
    }

    private Database prepareStatement(Database db) throws SQLException {
        Integer parameterIndex = 0;
        db.getPreparedStatement().setInt(++parameterIndex, this.getClientId());
        db.getPreparedStatement().setDate(++parameterIndex, (java.sql.Date) this.getCreationDate());
        db.getPreparedStatement().setDate(++parameterIndex, (java.sql.Date) this.getStartDate());
        db.getPreparedStatement().setDate(++parameterIndex, (java.sql.Date) this.getEndDate());
        db.getPreparedStatement().setDate(++parameterIndex, (java.sql.Date) this.getCancelDate());
        db.getPreparedStatement().setDouble(++parameterIndex, this.getLatitudePickup());
        db.getPreparedStatement().setDouble(++parameterIndex, this.getLongitudePickup());
        db.getPreparedStatement().setDouble(++parameterIndex, this.getLatitudeDestination());
        db.getPreparedStatement().setDouble(++parameterIndex, this.getLongitudeDestination());
        db.getPreparedStatement().setString(++parameterIndex, this.getStreetAddressPickup());
        db.getPreparedStatement().setString(++parameterIndex, this.getStatePickup());
        db.getPreparedStatement().setString(++parameterIndex, this.getZipcodePickup());
        db.getPreparedStatement().setString(++parameterIndex, this.getStreetAddressDestination());
        db.getPreparedStatement().setString(++parameterIndex, this.getStateDestination());
        db.getPreparedStatement().setString(++parameterIndex, this.getZipcodeDestination());
        db.getPreparedStatement().setString(++parameterIndex, this.getTowerDescription());
        db.getPreparedStatement().setString(++parameterIndex, this.getClientDescription());
        return db;
    }

}
