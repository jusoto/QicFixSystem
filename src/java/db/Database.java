/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Database {
    
    private String jdbcDriver;
    private String dbUrl;
    private String user;
    private String pass;
    private Connection conn;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet generatedKeys;

    public Database() {
        this.preparedStatement = null;
        this.statement = null;
        this.generatedKeys = null;
        this.jdbcDriver = "com.mysql.jdbc.Driver";
        this.dbUrl = "jdbc:mysql://localhost:3306/qicfixdb";
        this.user = "root";
        this.pass = "";
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(String sql) throws SQLException {
        if (this.conn != null) {
            this.preparedStatement = conn.prepareStatement(sql);
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement() throws SQLException {
        if (this.conn != null) {
            this.statement = conn.createStatement();
        }
    }

    public ResultSet getGeneratedKeys() {
        return generatedKeys;
    }

    public void setGeneratedKeys(ResultSet generatedKeys) {
        this.generatedKeys = generatedKeys;
    }

    public boolean Connect() {
        boolean respuesta = false;
        try {
            Class.forName(jdbcDriver);
            conn = (Connection) DriverManager.getConnection(dbUrl, user, pass);
            System.out.println("Connected database successfully...");
            respuesta = true;
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return respuesta;
    }
    
    public void Close() throws SQLException {
        if(this.preparedStatement != null){
            this.preparedStatement.close();
        }
        if(this.statement != null){
            this.statement.close();
        }
        if(this.conn != null){
            this.conn.close();
        }
    }

    public Integer ExecuteNonQuery() {
        Integer resp = -1;
        try {
            this.preparedStatement.executeUpdate();
            this.conn.commit();
            this.generatedKeys = this.preparedStatement.getGeneratedKeys();
            if(this.generatedKeys.next()){
                resp = this.generatedKeys.getInt(0);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return resp;
    }

    public ResultSet ExecuteQuery(String sql) {
        
        ResultSet rs = null;
        
        if(sql!=null){
            try {
                rs = this.statement.executeQuery(sql);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return rs;
    }
    
    public Integer ExecuteQueryLastId(String sql) {
        Integer resp = -1;
        ResultSet rs;
        try {
            rs = this.statement.executeQuery(sql);
            if(rs.next()){
                resp = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return resp;
    }
    
}
