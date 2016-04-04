/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import db.Database;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utility;

/**
 *
 * @author Juan
 */
public class HasTower {

    private Integer idservice;
    private Integer idtower;
    private Date requestDate;
    private Date acceptDate;
    private Date cancelDate;

    public HasTower() {
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

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public boolean createRequest(Integer idservice, List<Integer> listTower) {
        boolean resp = true;

        for (int i = 0; i < listTower.size(); i++) {
            int parameterIndex = 0;

            String sql = "INSERT INTO has_tower (idservice, idtower, request_date)"
                    + " VALUES (?,?,?)";

            Database db = new Database();
            try {
                db.Connect();
                db.setPreparedStatement(sql);
                db.getPreparedStatement().setInt(++parameterIndex, this.getIdservice());
                db.getPreparedStatement().setInt(++parameterIndex, listTower.get(i));
                db.getPreparedStatement().setDate(++parameterIndex, (java.sql.Date) this.getRequestDate());
                db.ExecuteNonQuery();
                resp = false;
            } catch (SQLException ex) {
                Logger.getLogger(HasTower.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (db != null) {
                    try {
                        db.Close();
                    } catch (SQLException ex) {
                        Logger.getLogger(HasTower.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        return !resp;
    }

    public boolean acceptRequest() {
        boolean resp = false;
        int parameterIndex = 0;
        this.setAcceptDate(new Date());

        String sql = "UPDATE has_tower SET accept_date=? WHERE idservice=? AND idtower=?";

        Database db = new Database();
        try {
            db.Connect();
            db.setPreparedStatement(sql);
            db.getPreparedStatement().setDate(++parameterIndex, (java.sql.Date) this.getAcceptDate());
            db.getPreparedStatement().setInt(++parameterIndex, this.getIdservice());
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

    public boolean cancelService() {
        boolean resp = false;
        int parameterIndex = 0;
        this.setCancelDate(new Date());

        String sql = "UPDATE has_tower SET cancel_date=? WHERE idservice=? AND idtower=?";

        Database db = new Database();
        try {
            db.Connect();
            db.setPreparedStatement(sql);
            db.getPreparedStatement().setDate(++parameterIndex, (java.sql.Date) this.getCancelDate());
            db.getPreparedStatement().setInt(++parameterIndex, this.getIdservice());
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

}
