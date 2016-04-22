/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import appLogic.AppLogicFacade;
import entity.Client;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import static util.Utility.getNoCacheResponseBuilder;

/**
 *
 * @author Juan
 */
@Path("client")
public class ClientREST {

    @Context
    private UriInfo context;

    public ClientREST() {
    }

    /**
     * Retrieves representation of an instance of service.ClientREST
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> findAll() {
        Client obj = new Client();
        return obj.selectAll();
    }
    
    /**
     * Retrieves representation of an instance of service.ClientREST
     *
     * @return an instance of java.lang.String
     */
    @Path("email")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> findUserByEmail(@QueryParam("email") String email, @QueryParam("token") String token) {
        List<Client> list;
        AppLogicFacade obj = new AppLogicFacade();
        list = obj.selectClientByEmail(email, token);
        return list;
    }

    /**
     * PUT method for updating or creating an instance of service.ClientREST
     *
     * @param content representation for the resource
     * @param email
     * @param token
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response putJson(String content,
            @QueryParam("email") String email,
            @QueryParam("token") String token) {
        AppLogicFacade appLogic = new AppLogicFacade();
        String message = "false";
        if (appLogic.createClient(content, token, email)) {
            return getNoCacheResponseBuilder(Response.Status.OK).entity(message).build();
        } else {
            return getNoCacheResponseBuilder(Response.Status.UNAUTHORIZED).entity(message).build();
        }
    }

    /**
     * POST method for updating or creating an instance of service.ClientREST
     *
     * @param content representation for the resource
     * @param email
     * @param token
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postJson(String content,
            @QueryParam("email") String email,
            @QueryParam("token") String token) {
        AppLogicFacade appLogic = new AppLogicFacade();
        String message = "false";
        List<Client> list = Client.fromJson(content);
        if (list.size() > 0) {
            if (appLogic.registrationClient(list.get(0), email, token)) {
                return getNoCacheResponseBuilder(Response.Status.OK).entity(message).build();
            } else {
                return getNoCacheResponseBuilder(Response.Status.UNAUTHORIZED).entity(message).build();
            }
        } else {
            return getNoCacheResponseBuilder(Response.Status.NO_CONTENT).entity(message).build();
        }

    }

}
