/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import db.Database;
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

    private Integer idservice;
    private Integer idtower;
    private Integer idclient;
    private String towerDescription;
    private Date startDate;
    private Date endDate;
    private Date cancelDate;
    private Double cost;
    private Double positionX;
    private Double positionY;
    private String address;
    private String clientDescription;

    public Service() {
    }

    public Integer getIdservice() {
        return idservice;
    }

    public void setIdservice(Integer idservice) {
        this.idservice = idservice;
    }

    public Integer getIdtower() {
        return idtower;
    }

    public void setIdtower(Integer idtower) {
        this.idtower = idtower;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public String getTowerDescription() {
        return towerDescription;
    }

    public void setTowerDescription(String towerDescription) {
        this.towerDescription = towerDescription;
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

    public Double getPositionX() {
        return positionX;
    }

    public void setPositionX(Double positionX) {
        this.positionX = positionX;
    }

    public Double getPositionY() {
        return positionY;
    }

    public void setPositionY(Double positionY) {
        this.positionY = positionY;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClientDescription() {
        return clientDescription;
    }

    public void setClientDescription(String clientDescription) {
        this.clientDescription = clientDescription;
    }

    public boolean createService(List<Integer> listServiceman) {

        boolean resp = false;
        int parameterIndex = 0;
        int idservice;
        HasTower rel = new HasTower();

        String sql = "INSERT INTO service (idcustomer, position_x, position_y, start_date, address, customer_description)"
                + " VALUES (?,?,?,?,?,?,?)";

        Database db = new Database();
        try {
            db.Connect();
            db.setPreparedStatement(sql);
            db.getPreparedStatement().setInt(++parameterIndex, this.getIdclient());
            db.getPreparedStatement().setDouble(++parameterIndex, this.getPositionX());
            db.getPreparedStatement().setDouble(++parameterIndex, this.getPositionY());
            db.getPreparedStatement().setDate(++parameterIndex, (java.sql.Date) this.getStartDate());
            db.getPreparedStatement().setString(++parameterIndex, this.getAddress());
            db.getPreparedStatement().setString(++parameterIndex, this.getClientDescription());
            idservice = db.ExecuteNonQuery();
            this.setIdservice(idservice);
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

        String sql = "UPDATE service SET tower_description=?, end_date=?, cost=? WHERE idservice=?";

        Database db = new Database();
        try {
            db.Connect();
            db.setPreparedStatement(sql);
            db.getPreparedStatement().setString(++parameterIndex, this.getTowerDescription());
            db.getPreparedStatement().setDate(++parameterIndex, (java.sql.Date) this.getEndDate());
            db.getPreparedStatement().setDouble(++parameterIndex, this.getCost());
            db.getPreparedStatement().setInt(++parameterIndex, this.getIdservice());
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

        sql = "SELECT idservice, idtower, idservice_type, idclient, tower_description, date_start, date_end, cost, position_x, position_y, address, client_description FROM service";

        Database db = new Database();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            while (rs.next()) {
                Service service = new Service();
                service.setIdclient(rs.getString("idclient") != null ? rs.getInt("idclient") : null);
                service.setStartDate(rs.getString("start_date") != null ? (java.sql.Date) Utility.StringToDate(rs.getString("start_date")) : null);
                service.setPositionX(rs.getString("position_x") != null ? rs.getDouble("position_x") : null);
                service.setPositionY(rs.getString("position_y") != null ? rs.getDouble("position_y") : null);
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

}
