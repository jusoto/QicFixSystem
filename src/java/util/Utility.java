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
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

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

    //Translates from "222 SW 82ND ST, Miami FL, 33143" to "83.11115,-83.14545"
    public static Location getLocationFromAddress(String address) throws Exception {
        Location location = null;
        //TODO: Test
        String[] locationPickup = getLatLongPositions(address);
        Double latitude = Double.parseDouble(locationPickup[0]);
        Double longitude = Double.parseDouble(locationPickup[1]);
        location = new Location(latitude, longitude);
        System.out.println("Address: "+address+" - location: "+latitude+","+longitude);
        return location;
    }

    public static String[] getLatLongPositions(String address) throws Exception {
        int responseCode = 0;
        String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true&key="+GOOGLE_MAPS_API_KEY;
        //System.out.println("URL : " + api);
        URL url = new URL(api);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.connect();
        responseCode = httpConnection.getResponseCode();
        if (responseCode == 200) {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
            Document document = (Document) builder.parse(httpConnection.getInputStream());
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("/GeocodeResponse/status");
            String status = (String) expr.evaluate(document, XPathConstants.STRING);
            if (status.equals("OK")) {
                expr = xpath.compile("//geometry/location/lat");
                String latitude = (String) expr.evaluate(document, XPathConstants.STRING);
                expr = xpath.compile("//geometry/location/lng");
                String longitude = (String) expr.evaluate(document, XPathConstants.STRING);
                return new String[]{latitude, longitude};
            } else {
                throw new Exception("Error from the API - response status: " + status);
            }
        }
        return null;
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
