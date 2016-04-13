/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
public class Tower extends User {

    private Integer idtower;
    private Double positionX;
    private Double positionY;

    public Tower() {
    }

    public Integer getIdtower() {
        return idtower;
    }

    public void setIdtower(Integer idtower) {
        this.idtower = idtower;
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

    public List<Tower> selectAllTower() {
        List<Tower> list = new ArrayList<Tower>();
        String sql;
        ResultSet rs = null;

        sql = "SELECT u.name, s.idserviceman, s.email, s.position_x, s.position_y FROM user u, serviceman s"
                + " WHERE s.email=u.email";

        Database db = new Database();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            while (rs.next()) {
                Tower obj = new Tower();
                obj.setName(rs.getString("name"));
                obj.setIdtower(rs.getString("idserviceman") != null ? rs.getInt("idserviceman") : null);
                obj.setEmail(rs.getString("email"));
                obj.setPositionX(rs.getString("position_x") != null ? rs.getDouble("position_x") : null);
                obj.setPositionY(rs.getString("position_y") != null ? rs.getDouble("position_y") : null);
                list.add(obj);
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

    public boolean createTower() {

        boolean resp = false;
        int parameterIndex = 0;
        int id;

        String sql = "INSERT INTO serviceman (email, position_x, position_y)"
                + " VALUES (?,?,?)";
        
        createUser();

        Database db = new Database();
        try {
            db.Connect();
            db.setPreparedStatement(sql);
            db.getPreparedStatement().setString(++parameterIndex, this.getEmail());
            db.getPreparedStatement().setDouble(++parameterIndex, this.getPositionX());
            db.getPreparedStatement().setDouble(++parameterIndex, this.getPositionY());
            id = db.ExecuteNonQuery();
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(Tower.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (db != null) {
                try {
                    db.Close();
                } catch (SQLException ex) {
                    Logger.getLogger(Tower.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return resp;
    }

    public void selectById(Integer idtower) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

