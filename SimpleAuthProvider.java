/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollegeCounselor;

import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.http.IHttpRequest;


/**
 *
 * @author aryangulati
 */
public class SimpleAuthProvider implements IAuthenticationProvider {
    
    private String accessToken = null;

    public SimpleAuthProvider(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public void authenticateRequest(IHttpRequest request) {
        // Add the access token in the Authorization header
        request.addHeader("Authorization", "Bearer " + accessToken);
    }
    
    
}
