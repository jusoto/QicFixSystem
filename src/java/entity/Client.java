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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Client extends User {

    private Integer idclient;

    public Client() {
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public boolean createCustomer() {

        boolean resp = false;
        int parameterIndex = 1;

        String sql = "INSERT INTO client (email) VALUES (?)";

        if (createUser()) {

            Database db = new Database();
            try {
                db.Connect();
                db.setPreparedStatement(sql);
                db.getPreparedStatement().setString(++parameterIndex, this.getEmail());
                db.ExecuteNonQuery();
                resp = true;
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (db != null) {
                    try {
                        db.Close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return resp;
    }

    public List<Client> selectAllCustomer() {
        List<Client> list = new ArrayList<Client>();
        String sql;
        ResultSet rs = null;

        sql = "SELECT c.idclient, u.name, c.email FROM user u, client c"
                + " WHERE c.email=u.email";

        Database db = new Database();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            while (rs.next()) {
                Client client = new Client();
                client.setName(rs.getString("name"));
                client.setIdclient(rs.getString("idclient") != null ? rs.getInt("idclient") : null);
                client.setEmail(rs.getString("email"));
                list.add(client);
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

    public void selectIdByEmail() {
        String sql;
        ResultSet rs = null;

        sql = "SELECT idclient FROM client WHERE email='" + this.getEmail() + "'";

        Database db = new Database();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            if (rs.next()) {
                this.setIdclient(rs.getString("idclient") != null ? rs.getInt("idclient") : null);
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

    }

}
