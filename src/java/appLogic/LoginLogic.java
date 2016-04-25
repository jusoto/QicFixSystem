/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;

/**
 *
 * @author Juan
 */
public class LoginLogic {
    
    Authenticator authenticator;

    public LoginLogic() {
        authenticator = Authenticator.getInstance();
    }

    String login(String email, String password) {
        String token = "";

        try {
            token = authenticator.login(email, password);
        } catch (LoginException ex) {
            Logger.getLogger(LoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        }

        return token;
    }
    
}
