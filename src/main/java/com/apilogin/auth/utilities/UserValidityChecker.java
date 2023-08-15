package com.apilogin.auth.utilities;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class UserValidityChecker {
	
	
	final String realAuthToken="Bearer dGVzdEBzdW5iYXNlZGF0YS5jb206VGVzdEAxMjM=";		
	private String decodedValue;
	private String Authorization;
	
	public String cookieValidityChecker(HttpServletRequest request) {
	
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
    	System.out.println("cookie l1: ");
        for (Cookie cookie : cookies) {
        	System.out.println("cookie l2: ");
            if ("auth_token".equals(cookie.getName())) {
            	System.out.println("cookie l3: ");
                String authToken = cookie.getValue();
                if (isValidAuthToken(authToken)) {
                	System.out.println("cookie l4: ");
                	Authorization =decodedValue;
                    return "Authorized";
                }
            }
        }
    }
	return "Unauthorized";
	}
	
	 public String getAuthorization() {
		return Authorization;
	}

	private boolean isValidAuthToken(String authToken) {
		 
		 decodedValue = URLDecoder.decode(authToken, StandardCharsets.UTF_8);
		 
		 System.out.println("decodedValue in checker: "+decodedValue);
		 System.out.println("decodedValue.equals(authToken): "+decodedValue.equals(realAuthToken));
		 
		return decodedValue.equals(realAuthToken);

	    }
	
	
}
