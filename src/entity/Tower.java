/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import util.Location;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
public class Tower extends User {

    private Integer id;
    private String companyName;
    private String permitNumber;
    private Double latitude;
    private Double longitude;
    private Double priceMile;

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

    public Double getPriceMile() {
        return priceMile;
    }

    public void setPriceMile(Double priceMile) {
        this.priceMile = priceMile;
    }

    public List<Tower> selectAll() {
        List<Tower> list = new ArrayList<Tower>();
        String sql;
        ResultSet rs = null;

        sql = "SELECT t.id, t.email, t.company_name, t.permit_number, t.latitude, t.longitude, t.price_mile, u.phone, u.user_type_id, u.fname, u.lname, u.street_address, u.city, u.state, u.zipcode, u.dob, u.blocked"
                + " FROM user u, tower t"
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

        String sql = "INSERT INTO tower (email, company_name, permit_number, latitude, longitude, price_mile)"
                + " VALUES (?,?,?,?,?,?)";
        
        this.setUserTypeId(2);
        
        if (createUser()) {

            Database db = Database.getInstance();
            try {
                db.Connect();
                db.setPreparedStatement(sql);
                db.getPreparedStatement().setString(++parameterIndex, this.getEmail().trim());
                db.getPreparedStatement().setString(++parameterIndex, this.getCompanyName());
                db.getPreparedStatement().setString(++parameterIndex, this.getPermitNumber());
                db.getPreparedStatement().setDouble(++parameterIndex, this.getLatitude() != null ? this.getLatitude() : Types.DOUBLE);
                db.getPreparedStatement().setDouble(++parameterIndex, this.getLongitude() != null ? this.getLongitude() : Types.DOUBLE);
                db.getPreparedStatement().setDouble(++parameterIndex, this.getPriceMile() != null ? this.getPriceMile() : Types.DOUBLE);
                id = db.ExecuteNonQuery();
                if (id > 0) {
                    resp = true;
                }
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

        sql = "SELECT t.id, t.email, t.company_name, t.permit_number, t.latitude, t.longitude, t.price_mile, u.phone, u.user_type_id, u.fname, u.lname, u.street_address, u.city, u.state, u.zipcode, u.dob, u.blocked"
                + " FROM user u, tower t"
                + " WHERE t.email=u.email AND t.id=" + towerId;

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
        obj.setLatitude(rs.getString("latitude") != null ? rs.getDouble("latitude") : Types.DOUBLE);
        obj.setLongitude(rs.getString("longitude") != null ? rs.getDouble("longitude") : Types.DOUBLE);
        obj.setPriceMile(rs.getString("price_mile") != null ? rs.getDouble("price_mile") : Types.DOUBLE);
        obj.setFname(rs.getString("fname"));
        obj.setLname(rs.getString("lname"));
        obj.setPhone(rs.getString("phone"));
        obj.setStreetAddress(rs.getString("street_address"));
        obj.setCity(rs.getString("city"));
        obj.setState(rs.getString("state"));
        obj.setZipcode(rs.getString("zipcode"));
        obj.setDob(rs.getString("dob") != null ? rs.getDate("dob") : null);
        obj.setBlocked(rs.getString("blocked"));
        return obj;
    }

    //order 1: orders by Nearest Tower related to the user
    //order 2: orders by Best Rated Tower
    public List<Tower> selectAllOrdered(Location location, Integer order) {
        List<Tower> list = new ArrayList<Tower>();
        String sql;
        ResultSet rs = null;

        sql = "SELECT t.id, t.email, t.company_name, t.permit_number, t.latitude, t.longitude, t.price_mile, u.phone, u.user_type_id, u.fname, u.lname, u.street_address, u.city, u.state, u.zipcode, u.dob, u.blocked FROM user u, tower t"
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

    public Integer getIdByEmail(String email) {
        String sql;
        ResultSet rs = null;
        Tower obj = null;

        sql = "SELECT t.id, t.email, t.company_name, t.permit_number, t.price_mile, u.phone, u.user_type_id, u.fname, u.lname, u.street_address, u.city, u.state, u.zipcode, u.dob, u.blocked FROM user u, tower t"
                + " WHERE t.email=u.email AND u.email='" + email + "'";

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

        return obj.id;
    }

    public List<Tower> selectTowerByEmail(String email) {
        List<Tower> list = new ArrayList<Tower>();
        String sql;
        ResultSet rs = null;
        Tower obj = null;

        sql = "SELECT t.id, t.email, t.company_name, t.permit_number, t.price_mile, u.user_type_id, u.fname, u.lname, u.street_address, u.city, u.state, u.zipcode, u.dob, u.blocked"
                + " FROM user u, tower t"
                + " WHERE t.email=u.email AND u.email='" + email + "'";

        //Database db = new Database();
        Database db = Database.getInstance();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            while (rs.next()) {
                obj = readResult(rs);
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

    public static String toJson(List<Tower> list) {
        Gson gson = new GsonBuilder().setDateFormat(Utility.DATE_FORMAT_STRING_SHORT).create();
        String gsonString = gson.toJson(list, new TypeToken<List<Tower>>() {
        }.getType());
        return gsonString;
    }

    public static List<Tower> fromJson(String json) throws JsonSyntaxException {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new Utility.JsonDateDeserializer()).create();
        List<Tower> list = gson.fromJson(json, new TypeToken<List<Tower>>() {
        }.getType());
        return list;
    }

    public List<Tower> SelectByStateCity(Location location) {
        List<Tower> list = new ArrayList<Tower>();
        String sql;
        ResultSet rs = null;
        Tower obj;

        sql = "SELECT t.id, t.email, t.company_name, t.permit_number, t.price_mile, u.user_type_id, u.fname, u.lname, u.street_address, u.city, u.state, u.zipcode, u.dob, u.blocked"
                + " FROM user u, tower t"
                + " WHERE t.email=u.email AND u.state='" + getState() + "' AND u.city='" + getCity() + "'";

        //Database db = new Database();
        Database db = Database.getInstance();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            while (rs.next()) {
                obj = readResult(rs);
                list.add(obj);
            }
            List<Tower> orderedList = orderList(list);
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

    List<Tower> SelectByRating() {
        List<Tower> list = new ArrayList<Tower>();
        String sql;
        ResultSet rs = null;
        Tower obj;

        sql = "SELECT t.id, t.email, t.company_name, t.permit_number, t.price_mile, AVG(ht.tower_rating) as tower_rating,"
                + " u.user_type_id, u.fname, u.lname, u.street_address, u.city, u.state, u.zipcode, u.dob, u.blocked"
                + " FROM user u, tower t, has_tower ht"
                + " WHERE t.email=u.email AND ht.tower_id=t.id AND u.state='" + getState() + "'"
                + " AND u.city='" + getCity() + "'"
                + " ORDER BY tower_rating";

        //Database db = new Database();
        Database db = Database.getInstance();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            while (rs.next()) {
                obj = readResult(rs);
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

    List<Tower> SelectByPrice() {
        List<Tower> list = new ArrayList<Tower>();
        String sql;
        ResultSet rs = null;
        Tower obj;

        sql = "SELECT t.id, t.email, t.company_name, t.permit_number, t.price_mile, u.user_type_id, u.fname, u.lname, u.street_address, u.city, u.state, u.zipcode, u.dob, u.blocked"
                + " FROM user u, tower t"
                + " WHERE t.email=u.email AND u.state='" + getState() + "' AND u.city='" + getCity() + "'"
                + " ORDER BY t.price_mile DESC";

        //Database db = new Database();
        Database db = Database.getInstance();
        try {
            db.Connect();
            db.setStatement();
            rs = db.ExecuteQuery(sql);
            while (rs.next()) {
                obj = readResult(rs);
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

    private List<Tower> orderList(List<Tower> list) {
        List<Tower> orderedList = null;
        for (int i = 0; i < list.size(); i++) {

        }

        return orderedList;
    }

    public boolean updateTower() {

        boolean resp = false;
        int parameterIndex = 0;

        String sql = "UPDATE tower SET comany_name=?, permit_number=?, latitude=?, longitude=?, price_mile=?"
                + " WHERE id=" + getId();

        if (update()) {

            Database db = Database.getInstance();
            try {
                db.Connect();
                db.setPreparedStatement(sql);
                db.getPreparedStatement().setString(++parameterIndex, this.getCompanyName());
                db.getPreparedStatement().setString(++parameterIndex, this.getPermitNumber());
                db.getPreparedStatement().setDouble(++parameterIndex, this.getLatitude() != null ? this.getLatitude() : Types.DOUBLE);
                db.getPreparedStatement().setDouble(++parameterIndex, this.getLongitude() != null ? this.getLongitude() : Types.DOUBLE);
                db.getPreparedStatement().setDouble(++parameterIndex, this.getPriceMile() != null ? this.getPriceMile() : Types.DOUBLE);
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
}
