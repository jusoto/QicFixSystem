/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import entity.User;
import java.lang.reflect.Type;
import java.text.DateFormat;
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
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String DATE_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_FORMAT_STRING_SHORT = "yyyy-MM-dd";
    public static final String GOOGLE_MAPS_API_KEY = "AIzaSyAhOv2MNrliIM1BrBBOdgzD2Fip1rzUkHQ";

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
        String token = "123";
        
        
        
        return token;
    }

    public static String getLocationFromAddress(String pickup) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static class JsonDateDeserializer implements JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            final DateFormat df = new SimpleDateFormat("MMM dd, yyyy"); 
            try {  
                return df.parse(json.getAsString());  
            } catch (final java.text.ParseException e) {  
                e.printStackTrace();
                return null;
            }  
        }        
    }

}
