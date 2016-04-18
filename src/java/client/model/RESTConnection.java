/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import java.util.HashMap;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author Juan
 */
public class RESTConnection {

    private static final String BASE_URL = "http://www.qicfixit.com:8080/api";
    private static RESTConnection instance = new RESTConnection();

    public RESTConnection() {
    }

    public static RESTConnection getInstance() {
        return instance;
    }
    
    public String getMethod(String path, HashMap<String, String> parameters) {
        Response response;
        String message = null;
        Client obj = ClientBuilder.newClient();
        WebTarget target = obj.target(BASE_URL + path);
        
        for (String key : parameters.keySet()) {
            String value = parameters.get(key);
            target = target.queryParam(key, value);

        }
        
        response = target.request(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN).get();
        
        //Test HTTP Response
        System.out.println("HTTP Response Status: " + response.getStatus());
        
        message = target.request(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN).get(String.class);
        
        return message;
    }

}
