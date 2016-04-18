/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tower;
import entity.User;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Juan
 */
@Path("tower")
public class TowerREST {
    
    
    @Context
    private UriInfo context;

    public TowerREST() {
    }
    
    /**
     * Retrieves representation of an instance of service.BancoREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tower> findAll() {
        Tower obj = new Tower();
        return obj.selectAll();
    }

    /**
     * PUT method for updating or creating an instance of BancoREST
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        String message = "false";
        
        return message;
    }
    
    
}
