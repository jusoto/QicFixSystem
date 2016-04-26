/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appLogic;

import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class LogoutLogic {
    
    private Authenticator authenticator;

    public LogoutLogic() {
        authenticator = Authenticator.getInstance();
    }
    
    public void logout(String token, String email){
         try {
             authenticator.logout(token, email);
         } catch (GeneralSecurityException ex) {
             Logger.getLogger(LogoutLogic.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
