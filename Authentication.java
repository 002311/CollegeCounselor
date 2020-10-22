/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollegeCounselor;

import java.net.MalformedURLException;
import java.util.*;
import java.util.function.Consumer;

import com.microsoft.aad.msal4j.DeviceCode;
import com.microsoft.aad.msal4j.DeviceCodeFlowParameters;
import com.microsoft.aad.msal4j.IAuthenticationResult;
import com.microsoft.aad.msal4j.PublicClientApplication;
/**
 *
 * @author aryangulati
 */
public class Authentication {
    
      private static String applicationId;
    // Set authority to allow only organizational accounts
    // Device code flow only supports organizational accounts
    private final static String authority = "https://login.microsoftonline.com/common/";

    public static void initialize(String applicationId) {
        Authentication.applicationId = applicationId;
    }
    

    public static String getUserAccessToken(String[] scopes) {
        if (applicationId == null) {
            System.out.println("You must initialize Authentication before calling getUserAccessToken");
            return null;
        }

        Set<String> scopeSet = new HashSet<>();
        
        for (String s : scopes){
            
            scopeSet.add(s);
        }
        
        
        PublicClientApplication app;
        try {
            // Build the MSAL application object with
            // app ID and authority
            app = PublicClientApplication.builder(applicationId)
                .authority(authority)
                .build();
        } catch (MalformedURLException e) {
            return null;
        }

        // Create consumer to receive the DeviceCode object
        // This method gets executed during the flow and provides
        // the URL the user logs into and the device code to enter
        Consumer<DeviceCode> deviceCodeConsumer = (DeviceCode deviceCode) -> {
            // Print the login information to the console
            
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AuthenticationUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuthenticationUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuthenticationUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthenticationUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
             /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuthenticationUI(deviceCode.message()).setVisible(true);
            }
        });
        
        };

        // Request a token, passing the requested permission scopes
        IAuthenticationResult result = app.acquireToken(
            DeviceCodeFlowParameters
                .builder(scopeSet, deviceCodeConsumer)
                .build()
        ).exceptionally(ex -> {
            System.out.println("Unable to authenticate - " + ex.getMessage());
            return null;
        }).join();

        if (result != null) {
            AuthenticationUI.jLabel1.setText("Authenticated. Searching...");
            return result.accessToken();
        }

        return null;
    }
    
}
