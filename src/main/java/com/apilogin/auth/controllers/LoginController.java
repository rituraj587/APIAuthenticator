package com.apilogin.auth.controllers;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

import javax.servlet.http.HttpSession;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;



import com.apilogin.auth.utilities.MakingRequestApi;


@Controller
//@RequestMapping("/")
public class LoginController{
	
	 @Autowired
	 ObjectMapper objectMapper;
	
	@PostMapping("/")
	public String loginPage(ModelMap model, 
			@RequestParam("login_id") String login_id, 
			@RequestParam("password") String password , 
			@RequestParam(required = false) String cmd,
			HttpServletResponse response) {
		
	//---------------------------------------------
		JsonNode jsonNode =null;
		String accessToken ="";
		
		
	    ObjectNode jsonObject = objectMapper.createObjectNode();
        jsonObject.put("login_id", login_id);
        jsonObject.put("password", password);
        
        String jsonBodyString=null;
        try {
            // Creating Json object string
            jsonBodyString = objectMapper.writeValueAsString(jsonObject);
            System.out.println("String jsonBodyString"+jsonBodyString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
		
		MakingRequestApi makingRequestApi =new MakingRequestApi();
		
		String authenticationFromApi = makingRequestApi.authenticationFromApi(null, jsonBodyString, cmd);
		System.out.println("authenticationFromApi= "+authenticationFromApi.equals("Login Id or Password is invalid"));
		System.out.println("authenticationFromApi= "+authenticationFromApi.trim().equals("Login Id or Password is invalid"));
    
		
		//---------------------------------------------	Cookie work below
	if (!authenticationFromApi.trim().equals("Login Id or Password is invalid")) {


//		if (jsonBodyString.contains("access_token")) {
			
			try {
				// Parse the JSON string
				jsonNode = objectMapper.readTree(authenticationFromApi);

				// Fetch values using the keys
				accessToken = jsonNode.get("access_token").asText();

				System.out.println("Access Token: " + accessToken);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			StringJoiner s = new StringJoiner(" ");   //StringeJoiner object  
	        s.add("Bearer");    //command 1  
	        s.add(accessToken);
	        String authToken = s.toString();
	        System.out.println("authToken: " + authToken);
	        String encodedValue = URLEncoder.encode(authToken, StandardCharsets.UTF_8);
	        
	        
	        System.out.println("encodedValue: " + encodedValue);
			Cookie cookie = new Cookie("auth_token", encodedValue);
		    cookie.setMaxAge(-1);  // Session-scoped cookie
		    response.addCookie(cookie);
		    System.out.println("encodedValue: " + encodedValue);
		    System.out.println("cookie: " + cookie);
		    return "redirect:/allcustomer?cmd=get_customer_list";
//		}
		
	}
		
	
		model.put("errorMessage","please provide valid userID and Password");
		return "login";
		
	}

	
	
    @GetMapping("/") // it is giving first request of index
    public String showIndexPage() {
    	System.out.println("abc test");
        return "login"; // This maps to the "index.jsp" page inside the "WEB-INF/jsp" folder
    }
    
    @GetMapping("/Logout")
    public String logout( HttpServletResponse response) {
    	
    	 Cookie cookie = new Cookie("auth_token", "");
    	    cookie.setMaxAge(0);
    	    cookie.setPath("/");
    	    response.addCookie(cookie);


		return "login";
    	
    }

	
	

	
    
    

}
