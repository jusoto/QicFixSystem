/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import util.Utility;

/**
 *
 * @author Juan
 */
public class Client extends User {

    private Integer id;

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean create(String token) {
        //Response response;
        String message;
        RESTConnection conn = RESTConnection.getInstance();
        String path = Utility.USER_BLOCK_PATH;
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("email", getEmail());
        parameters.put("token", token);
        message = conn.getMethod(path, parameters);
        return message!=null;
    }

    public Integer selectIdByEmail(String token){
        Integer id = -1;
        String message;
        RESTConnection conn = RESTConnection.getInstance();
        String path = Utility.USER_BLOCK_PATH;
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("email", getEmail());
        parameters.put("token", token);
        message = conn.getMethod(path, parameters);
        try{
            if(message!=null){
                id = Integer.parseInt(message);
            }
        }catch(Exception e){
            //TODO: Handle error NaN
        }
        return id;
    }
 
    public Client selectByEmailClient(String token){
        List<Client> list = null;
        String message;
        RESTConnection conn = RESTConnection.getInstance();
        String path = Utility.USER_BLOCK_PATH;
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("email", getEmail());
        parameters.put("token", token);
        try{
            message = conn.getMethod(path, parameters);
            if(message!=null){
                list = fromJson(message);
            }
        }catch(Exception e){
            //TODO: Handle error NaN
        }
        return list.get(0);
    }
    
    public static String toJson(List<Client> list) {
        Gson gson = new GsonBuilder().setDateFormat(Utility.DATE_FORMAT_STRING_SHORT).create();
        String gsonString = gson.toJson(list, new TypeToken<List<Client>>() {
        }.getType());
        return gsonString;
    }
    
    public static List<Client> fromJson(String json) throws JsonSyntaxException {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new Utility.JsonDateDeserializer()).create();
        List<Client> list = gson.fromJson(json, new TypeToken<List<Client>>() {
        }.getType());
        return list;
    }
}
