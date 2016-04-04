/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import java.security.GeneralSecurityException;
import javax.security.auth.login.LoginException;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 *
 * @author Juan
 */
public class RESTResource implements RESTProxy {

    private static final long serialVersionUID = 1L;

    @Override
    public Response login(
        @Context HttpHeaders httpHeaders,
        @FormParam( "username" ) String username,
        @FormParam( "password" ) String password ) {

        Authenticator authenticator = Authenticator.getInstance();
        String serviceKey = httpHeaders.getHeaderString("service_key");

        try {
            String authToken = authenticator.login(serviceKey, username, password);
            
            Gson gson = new Gson();
            gson.toJson(authToken);
            return getNoCacheResponseBuilder(Response.Status.OK).entity(gson.toString()).build();

        } catch (final LoginException ex) {
            Gson gson = new Gson();
            String message = "Problem matching service key, username and password";
            gson.toJson(message);

            return getNoCacheResponseBuilder(Response.Status.UNAUTHORIZED).entity(gson.toString()).build();
        }
    }

    @Override
    public Response getMethod() {
        Gson gson = new Gson();
            String message = "Executed getMethod";
            gson.toJson(message);

        return getNoCacheResponseBuilder(Response.Status.OK).entity(gson.toString()).build();
    }

    @Override
    public Response postMethod() {
        Gson gson = new Gson();
            String message = "Executed postMethod";
            gson.toJson(message);
        

        return getNoCacheResponseBuilder(Response.Status.ACCEPTED).entity(gson.toString()).build();
    }

    @Override
    public Response logout(
        @Context HttpHeaders httpHeaders ) {
        try {
            Authenticator authenticator = Authenticator.getInstance();
            String serviceKey = httpHeaders.getHeaderString("service_key");
            String authToken = httpHeaders.getHeaderString("auth_token");

            authenticator.logout( serviceKey, authToken );

            return getNoCacheResponseBuilder(Response.Status.NO_CONTENT).build();
        } catch (final GeneralSecurityException ex) {
            return getNoCacheResponseBuilder(Response.Status.INTERNAL_SERVER_ERROR).build();
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
