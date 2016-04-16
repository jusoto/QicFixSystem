/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import util.Location;
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

    private Integer id;
    private String companyName;
    private String permitNumber;
    private Double latitude;
    private Double longitude;

    public Tower() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<Tower> selectAll() {
        List<Tower> list = new ArrayList<Tower>();
        String sql;
        ResultSet rs = null;

        sql = "SELECT t.id, t.email, t.company_name, t.permit_number, t.latitude, t.longitude, u.phone, u.user_type_id, u.fname, u.lname, u.street_address, u.city, u.state, u.zipcode, u.dob, u.block_end FROM user u, tower t"
                + " WHERE t.email=u.email";

        Database db = new Database();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            while (rs.next()) {
                Tower obj = readResult(rs);
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

    public boolean create() {

        boolean resp = false;
        int parameterIndex = 0;
        int id;

        String sql = "INSERT INTO tower (email, comany_name, permit_number, latitude, longitude)"
                + " VALUES (?,?,?,?,?)";

        if (createUser()) {

            Database db = Database.getInstance();
            try {
                db.Connect();
                db.setPreparedStatement(sql);
                db.getPreparedStatement().setString(++parameterIndex, this.getEmail());
                db.getPreparedStatement().setString(++parameterIndex, this.getCompanyName());
                db.getPreparedStatement().setString(++parameterIndex, this.getPermitNumber());
                db.getPreparedStatement().setDouble(++parameterIndex, this.getLatitude());
                db.getPreparedStatement().setDouble(++parameterIndex, this.getLongitude());
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
        }

        return resp;
    }

    public Tower selectById(Integer towerId) {
        String sql;
        ResultSet rs = null;
        Tower obj = null;

        sql = "SELECT t.id, t.email, t.company_name, t.permit_number, u.phone, u.user_type_id, u.fname, u.lname, u.street_address, u.city, u.state, u.zipcode, u.dob, u.block_end FROM user u, tower t"
                + " WHERE t.email=u.email AND where t.id=" + towerId;

        //Database db = new Database();
        Database db = Database.getInstance();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            if (rs.next()) {
                obj = readResult(rs);
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

        return obj;
    }

    private Tower readResult(ResultSet rs) throws SQLException {
        Tower obj = new Tower();
        obj.setId(rs.getString("id") != null ? rs.getInt("id") : null);
        obj.setEmail(rs.getString("email"));
        obj.setCompanyName(rs.getString("company_name"));
        obj.setPermitNumber(rs.getString("permit_number"));
        obj.setLatitude(rs.getString("latitude")!=null?rs.getDouble("latitude"):null);
        obj.setLongitude(rs.getString("longitude")!=null?rs.getDouble("longitude"):null);
        obj.setFname(rs.getString("fname"));
        obj.setLname(rs.getString("lname"));
        obj.setPhone(rs.getString("phone"));
        obj.setStreetAddress(rs.getString("street_address"));
        obj.setCity(rs.getString("city"));
        obj.setState(rs.getString("state"));
        obj.setZipcode(rs.getString("zipcode"));
        obj.setDob(rs.getString("dob")!=null?rs.getDate("dob"):null);
        obj.setBlockEnd(rs.getString("block_end")!=null?rs.getDate("block_end"):null);
        return obj;
    }
    
    //order 1: orders by Nearest Tower related to the user
    //order 2: orders by Best Rated Tower
    public List<Tower> selectAllOrdered(Location location, Integer order) {
        List<Tower> list = new ArrayList<Tower>();
        String sql;
        ResultSet rs = null;

        sql = "SELECT t.id, t.email, t.company_name, t.permit_number, t.latitude, t.longitude, u.phone, u.user_type_id, u.fname, u.lname, u.street_address, u.city, u.state, u.zipcode, u.dob, u.block_end FROM user u, tower t"
                + " WHERE t.email=u.email";
        

        Database db = Database.getInstance();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            while (rs.next()) {
                Tower obj = readResult(rs);
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

    public Integer getIdByEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
