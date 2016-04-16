/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import appLogic.AppLogicFacade;
import entity.Client;
import util.Location;
import entity.Service;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
     * Retrieves representation of an instance of ServiceREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Service> findAll(@QueryParam("token") String authToken) {
        AppLogicFacade obj = new AppLogicFacade();
        return obj.selectAllService(authToken);
    }

    /**
     * PUT method for updating or creating an instance of ServiceREST
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String putJson(String content, @QueryParam("token") String authToken, @QueryParam("email") String email, @QueryParam("location") String locationString) {
        String message = "";
        Location location = null;
        if(authToken!=null && email !=null){
            if(locationString.split(",").length > 0){
                Double latitude = Double.parseDouble(locationString.split(",")[0].trim());
                Double longitude = Double.parseDouble(locationString.split(",")[1].trim());
                location = new Location(latitude, longitude);
            }
        AppLogicFacade obj = new AppLogicFacade();
        message = obj.requestService(content, authToken, email, location);
        }
        return message;
    }
    
    @Path("charge")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String charge(String content, @QueryParam("token") String authToken, @QueryParam("email") String email, @QueryParam("serviceId") Integer serviceId) {
        String message = "";
        Location location = null;
        if (authToken != null && email != null) {
            AppLogicFacade obj = new AppLogicFacade();
            message = obj.chargeService(content, authToken, email, serviceId);
        }
        return message;
    }
    
    @Path("active")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Service> findByTowerId(@QueryParam("token") String authToken, @QueryParam("email") String email) {
        AppLogicFacade obj = new AppLogicFacade();
        return obj.selectServiceByTowerEmail(authToken, email);
    }
    
    
    
}
