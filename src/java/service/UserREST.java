/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import appLogic.AppLogicFacade;
import javax.security.auth.login.LoginException;
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
@Path("user")
public class UserREST {

    @Context
    private UriInfo context;

    public UserREST() {
    }

    /**
     * Retrieves representation of an instance of service.BancoREST
     *
     * @param _email
     * @param _password
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String login(@QueryParam("email") String _email, @QueryParam("password") String _password) {
        String token;
        AppLogicFacade obj = new AppLogicFacade();
        try {
            token = obj.login(_email, _password);
        } catch (LoginException ex) {
            token = "";
        }
        System.out.println("Email: " + _email + ", Pass: " + _password);
        return token;
    }

    /**
     * PUT method for updating or creating an instance of BancoREST
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    /**
     * POST method for updating or creating an instance of BancoREST
     *
     * @param _email
     */
    @Path("block")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void block(@QueryParam("email") String _email) {
        AppLogicFacade obj = new AppLogicFacade();
        obj.blockUser(_email);
    }

}
