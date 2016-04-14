/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import appLogic.AppLogicFacade;
import entity.Client;
import entity.Service;
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
@Path("service")
public class ServiceREST {
    
    @Context
    private UriInfo context;

    public ServiceREST() {
    }
    
    /**
     * Retrieves representation of an instance of service.BancoREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Service> findAll() {
        Service obj = new Service();
        return obj.selectAll();
    }

    /**
     * PUT method for updating or creating an instance of ReciboCobroREST
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String putJson(String content) {
        String message;
        AppLogicFacade obj = new AppLogicFacade();
        message = obj.requestService(content);
        return message;
    }
    
    
    
}
