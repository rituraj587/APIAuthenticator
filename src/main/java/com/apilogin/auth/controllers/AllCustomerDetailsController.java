package com.apilogin.auth.controllers;

import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.apilogin.auth.utilities.Customer;
import com.apilogin.auth.utilities.MakingRequestApi;
import com.apilogin.auth.utilities.UserValidityChecker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AllCustomerDetailsController {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	
	
    @GetMapping("/allcustomer")
    public String redirection(@RequestParam(required = false) String cmd,
    		Model model,
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

    	
    	
    	
    	
    	
    	String dataFromApi;
    	System.out.println("temprary"+ cmd);
   
    	String finalCommand = "?cmd=".concat(cmd != null ? cmd : "");
    	System.out.println("finalCommand="+finalCommand);
    	
		// Api hit of SunBase		
		  MakingRequestApi makingRequestApi = new MakingRequestApi();
		  dataFromApi = makingRequestApi.getDataFromApi(Authorization , finalCommand );

		  
		  
		  
		  // for Deserialization json sting to List<customer>
		  
		  List<Customer> customersList;
		  
		try {
			customersList = this.objectMapper.readValue(dataFromApi, new TypeReference<List<Customer>>(){});
			
			
			if(customersList==null) {
				System.out.println("empty");
			}
			 
			model.addAttribute("customers", customersList);
			
		  System.out.println("List<customer> are "+customersList);
		  System.out.println("---------------------------------------");
		  for (Customer customer : customersList) {
			    String uuid = customer.getUuid();
			    String firstName = customer.getFirst_name();
			    String lastName = customer.getLast_name();
			    String street = customer.getStreet();
			    String address = customer.getAddress();
			    String city = customer.getCity();
			    String state = customer.getState();
			    String email = customer.getEmail();
			    String phone = customer.getPhone();

			    System.out.println("Customer UUID: " + uuid);
			    System.out.println("First Name: " + firstName);
			    System.out.println("Last Name: " + lastName);
			    System.out.println("Street: " + street);
			    System.out.println("Address: " + address);
			    System.out.println("City: " + city);
			    System.out.println("State: " + state);
			    System.out.println("Email: " + email);
			    System.out.println("Phone: " + phone);
			    System.out.println("-----------------------");
			}
		  
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  
    	System.out.println("abc test");
        return "customerList"; 
    }
    
    @GetMapping("/customerList")
    public String redirectionFromDeleteIcon( @RequestParam(required = false) String cmd) {
    	System.out.println("abc test from delete Icon");
    	System.out.println("cmd="+cmd);
       	if("get_customer_list".equals(cmd)) {
       		System.out.println("abc test from delete Icon1");
    		return "redirect:/allcustomer?cmd=get_customer_list";
    	}
        return "customerList"; 
    }
    
    @PostMapping("/customerList")
    public String update(Model model, @RequestParam(required = false) String cmd,
    		HttpServletRequest request) {
    	
    	
		UserValidityChecker authFetcher = new UserValidityChecker();
		
		String Authorization = authFetcher.cookieValidityChecker(request);
		System.out.println("Authorization= "+Authorization);
		if(Authorization.equals("Unauthorized")) {
			return "redirect:/";
		}
		Authorization = authFetcher.getAuthorization();

    	
    	
    	
    	System.out.println("update test-----PostMethod-----customerList");
    	
    	if(cmd=="get_customer_list") {
    		return "redirect:/allcustomer?cmd=get_customer_list";
    	}
    	
    	
    	model.addAttribute("userId", "abcTest");
    	
    	
        return "customerList";  
    }
    
    @GetMapping("/customerList/delete")
    public String delete(@RequestParam String cmd,
    		@RequestParam(required = false) String uuid,
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
    	
    	
    	
    	
		// making command  ?key=value&key=value
		StringJoiner s = new StringJoiner("&");   //StringeJoiner object  
        s.add("?cmd="+cmd);    //command 1  
        s.add("uuid="+uuid);
        String finalCommand = s.toString();
    	
    	    	
    	System.out.println("finalCommand="+finalCommand);
    	
    	
    	// Api hit of SunBase 
    	MakingRequestApi makingRequestApi = new MakingRequestApi();
		String dataFromApi = makingRequestApi.postDataFromApi(null, uuid, finalCommand, Authorization);
    	
    	
    	
    	System.out.println(" user deleted");
		return "redirect:/customerList?cmd=get_customer_list";
		
    }
    

}
