/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import appLogic.AppLogicFacade;
import appLogic.Authenticator;
import com.google.gson.Gson;
import java.security.GeneralSecurityException;
import javax.security.auth.login.LoginException;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Juan
 */
@Path("login")
public class LoginREST {

    //private static final long serialVersionUID = 1L;
    
    @Context
    private UriInfo context;

    public LoginREST() {
    }
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@Context HttpHeaders httpHeaders,
            @QueryParam("email") String email,
            @QueryParam("password") String password) {
        //System.out.println("RESTResource: "+email+password);
        AppLogicFacade appLogic = new AppLogicFacade();

        try {
            String authToken = appLogic.login(email, password);

            //Gson gson = new Gson();
            //gson.toJson(authToken);
            return getNoCacheResponseBuilder(Response.Status.OK).entity(authToken).build();

        } catch (final LoginException ex) {
            //Gson gson = new Gson();
            String message = "Authentication error";
            //gson.toJson(message);

            return getNoCacheResponseBuilder(Response.Status.UNAUTHORIZED).entity(message).build();
        }
    }

    private Response.ResponseBuilder getNoCacheResponseBuilder(Response.Status status) {
        CacheControl cc = new CacheControl();
        cc.setNoCache(true);
        cc.setMaxAge(-1);
        cc.setMustRevalidate(true);

        return Response.status(status).cacheControl(cc);
    }

}
