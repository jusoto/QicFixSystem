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
public class Payment {

    private Integer idpayment;
    private Integer idservice;
    private Date date;
    private Double amount;
    private String creditCardLast;
    private String paypalAuto;

    public Payment() {
    }

    public Integer getIdpayment() {
        return idpayment;
    }

    public void setIdpayment(Integer idpayment) {
        this.idpayment = idpayment;
    }

    public Integer getIdservice() {
        return idservice;
    }

    public void setIdservice(Integer idservice) {
        this.idservice = idservice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCreditCardLast() {
        return creditCardLast;
    }

    public void setCreditCardLast(String creditCardLast) {
        this.creditCardLast = creditCardLast;
    }

    public String getPaypalAuto() {
        return paypalAuto;
    }

    public void setPaypalAuto(String paypalAuto) {
        this.paypalAuto = paypalAuto;
    }

    public boolean registerPayment() {

        boolean resp = false;
        int parameterIndex = 0;

        String sql = "INSERT INTO payment (idservice, date, amount, credit_card_last, paypal_auto)"
                + " VALUES (?,?,?,?,?)";

        Database db = new Database();
        try {
            db.Connect();
            db.setPreparedStatement(sql);
            db.getPreparedStatement().setInt(++parameterIndex, this.getIdservice());
            db.getPreparedStatement().setDate(++parameterIndex, (java.sql.Date) this.getDate());
            db.getPreparedStatement().setDouble(++parameterIndex, this.getAmount());
            db.getPreparedStatement().setString(++parameterIndex, this.getCreditCardLast());
            db.getPreparedStatement().setString(++parameterIndex, this.getPaypalAuto());
            db.ExecuteNonQuery();
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (db != null) {
                try {
                    db.Close();
                } catch (SQLException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return resp;
    }
  
    public List<Payment> SelectAll() {
        List<Payment> list = new ArrayList<Payment>();
        String sql;
        ResultSet rs = null;

        sql = "SELECT idpayment, idservice, date, amount, credit_card_last, paypal_auto FROM payment";
        
        Database db = new Database();
        try {
            db.Connect();
            db.setStatement();
            
            rs = db.ExecuteQuery(sql);
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setIdpayment(rs.getString("idpayment")!=null?rs.getInt("idpayment"):null);
                payment.setIdservice(rs.getString("idservice")!=null?rs.getInt("idservice"):null);
                payment.setDate(rs.getString("date")!=null?(java.sql.Date)Utility.StringToDate(rs.getString("date")):null);
                payment.setAmount(rs.getString("amount")!=null?rs.getDouble("amount"):null);
                payment.setCreditCardLast(rs.getString("credit_card_last"));
                payment.setPaypalAuto(rs.getString("paypal_auto"));
                list.add(payment);
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