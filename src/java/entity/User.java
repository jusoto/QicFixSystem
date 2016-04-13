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
import javax.websocket.Session;

/**
 *
 * @author Juan
 */
public class User {
    
    private String email;
    private String password;
    private String name;
    private String address;
    private Date dob;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public boolean validateUser(String email, String pass){
        boolean respuesta = false;
        String sql;
        ResultSet rs = null;

        sql = "SELECT email, name, address, dob FROM user WHERE email='" + email + "' AND password='" + pass + "'";

        Database db = new Database();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            if (rs!=null && rs.next()) {
                respuesta = true;
                this.setName(rs.getString("name"));
                this.setAddress(rs.getString("address"));
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
            if(db!=null){
                try {
                    db.Close();
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
            }
        }
        
        return respuesta;
    }
    
    public boolean createUser() {

        boolean resp = false;
        int parameterIndex = 0;

        String sql = "INSERT INTO user (name, address, email, password, dob)"
                + " VALUES (?,?,?,?,?)";

        Database db = new Database();
        try {
            db.Connect();
            db.setPreparedStatement(sql);
            db.getPreparedStatement().setString(++parameterIndex, this.getName());
            db.getPreparedStatement().setString(++parameterIndex, this.getAddress());
            db.getPreparedStatement().setString(++parameterIndex, this.getEmail());
            db.getPreparedStatement().setString(++parameterIndex, this.getPassword());
            db.getPreparedStatement().setDate(++parameterIndex, (java.sql.Date) this.getDob());
            db.ExecuteNonQuery();
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (db != null) {
                try {
                    db.Close();
                } catch (SQLException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return resp;
    }

    public List<User> SelectAll() {
        List<User> list = new ArrayList<User>();
        String sql;
        ResultSet rs = null;

        sql = "SELECT name, email, address, dob FROM user";

        Database db = new Database();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setDob(rs.getString("dob") != null ? rs.getDate("dob") : null);
                list.add(user);
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
