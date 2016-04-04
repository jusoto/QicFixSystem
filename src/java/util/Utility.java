/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Juan
 */
public class Utility {

    private static Pattern pattern;
    private static Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String DATE_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String DATE_FORMAT_STRING_SHORT = "yyyy-MM-dd";

    public static boolean checkSession(String sessionKey) {
        boolean resp = false;

        if (sessionKey != "") {
            resp = true;
        }

        return resp;
    }

    public static Date StringToDate(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_STRING);
        Date date = null;

        try {
            date = format.parse(strDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date;
    }

    public static String ConvertirDateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_STRING);
        String strDate = null;

        try {
            strDate = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return strDate;
    }

    /*public static boolean validateUserFormat(String user) {
        boolean resp = true;

        if ((user.length() < 4 || user.contains(" "))) {
            resp = false;
        }

        return resp;
    }*/

    public static boolean validatePassFormat(String pass) {
        boolean resp = true;

        if ((pass.length() < 4 || pass.contains(" "))) {
            resp = false;
        }

        return resp;
    }

    public static boolean validateEmailFormat(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String generateToken() {
        String token = "";
        
        
        
        return token;
    }

}
