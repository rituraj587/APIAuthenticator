package com.apilogin.auth.controllers;

import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.apilogin.auth.utilities.MakingRequestApi;
import com.apilogin.auth.utilities.MapToListOfString;
import com.apilogin.auth.utilities.UrlDataToPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

import com.apilogin.auth.utilities.Customer;
import com.apilogin.auth.utilities.CreateAndUpdate;
import com.apilogin.auth.utilities.UserValidityChecker;

@Controller
public class AddOrUpdateCustomerController {
	
	@Autowired
	ObjectMapper objectMapper;
	

	private String temporaryUuid = null;		  		//temporaryCommand is being used by Update Icon

	@PostMapping("/customer")
	public String addAndUpdateCustomer(@RequestBody String body,
			@RequestHeader Map<String ,String> auth, 
			@RequestParam( required = false) String cmd,
			@RequestParam( required = false) String uuid,
			HttpServletRequest request) {

		//----------------------------
		
		UserValidityChecker authFetcher = new UserValidityChecker();
		
		String Authorization = authFetcher.cookieValidityChecker(request);
		System.out.println("Authorization= "+Authorization);
		if(Authorization.equals("Unauthorized")) {
			return "redirect:/";
		}
		Authorization = authFetcher.getAuthorization();
		
		//----------------------------
		
		System.out.println(cmd);
		System.out.println(uuid);
		CreateAndUpdate createAndUpdate = new CreateAndUpdate();
		
		if(cmd.equals("create")) // for adding the Customer
		{
			
		
			
		String addingStatus = createAndUpdate.addAndUpdateCustomer(body, auth, Authorization, "create");
			
	
		
				
		System.out.println("addingStatus= "+addingStatus);
		
				
		return "redirect:/allcustomer?cmd=get_customer_list";
		}
		else if(cmd.equals("update")) {
			
			
			// making command  ?key=value&key=value
				StringJoiner s = new StringJoiner("&");   //StringeJoiner object  
		        s.add("?cmd="+cmd);    //command 1  
		        s.add("uuid="+uuid);
		        String finalCommand = s.toString();
		        
		        System.out.println(cmd);
				System.out.println("Body"+body);
			String addingStatus = createAndUpdate.addAndUpdateCustomer(body, auth, Authorization, finalCommand);
			
				
		System.out.println("addingStatus= "+addingStatus);
		
				
			
		}
		
		
		return "redirect:/allcustomer?cmd=get_customer_list";
	}

	
	
	@GetMapping("/customer")
	public String Customer(Model model,
			@RequestParam(required =false) String cmd,
			HttpServletRequest request) {
		
		
		System.out.println("Customer Form");
		System.out.println("cmd= "+cmd);
		//----------------------------------Checking cookie
		
		UserValidityChecker authFetcher = new UserValidityChecker();
		
		String Authorization = authFetcher.cookieValidityChecker(request);
		System.out.println("Authorization= "+Authorization);
		if(Authorization.equals("Unauthorized")) {
			return "redirect:/";
		}
		
		//----------------------------------
		if (cmd != null) {

			if (cmd.equals("update")) {
				
				model.addAttribute("cmd",cmd);
				model.addAttribute("uuid", temporaryUuid );
				System.out.println("Set uuid="+temporaryUuid);
				model.addAttribute("Task", "Update");
				
			}
		} 
		else {
			model.addAttribute("cmd", "create");
			model.addAttribute("uuid", "NA");
			model.addAttribute("Task", "Add");

		}	
				
		
		return "customer";
		
	}
	
	@GetMapping("/customerList/update" )
	public String redirectionfromUpdateIcon(@RequestParam String cmd,
			@RequestParam String uuid,
			@RequestHeader(value = "Authorization", required = false) String Authorization) {
		
		
		System.out.println("UpdateIcon cmd="+cmd);
		System.out.println("UpdateIcon uuid="+uuid);
		
		temporaryUuid =uuid;

		
		System.out.println("update redirectin");
		return "redirect:/customer?cmd=update&uuid=onGlobalVariable";
		
	}
	
}
