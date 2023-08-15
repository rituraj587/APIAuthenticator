package com.apilogin.auth.utilities;

import java.net.URI;

import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MakingRequestApi {

	
	private ObjectMapper objectMapper = new ObjectMapper();

	String Auth;

	final String apiEndpoint = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp";
	final String authApiEndPoint ="https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";
	

	
	public String postDataFromApi(List<String> listOfHeaders, String body, String finalCommand ,String Authorization) {

		// it converts string to object
//    Customer readValue = this.objectMapper.readValue("{\"name\": \"John Doe\", \"age\": 30}", Customer.class);
		
		System.out.println(listOfHeaders);
		System.out.println("final body in api section="+body);
		
		System.out.println("finalCommand in api section="+finalCommand);
		// final api End point with command
		String finalApiEndPoint = apiEndpoint.concat(finalCommand);
		
		if(listOfHeaders !=null) {
		// it will converts List to array
		String[] stringArray = listOfHeaders.toArray(new String[0]);
		}
		
		
		
		HttpRequest postRequest;
		
		// making/building the request using static newbuilder
		try {
			postRequest = (HttpRequest) HttpRequest.newBuilder().uri(new URI(finalApiEndPoint))
					.POST(BodyPublishers.ofString(body))
					.header("Content-Type", "application/json")
					.header("Accept", "application/json")
					.header("Authorization" ,Authorization).build();

			System.out.println("after req creation in api section");
			
			// making actual client who will take a request to the server
			HttpClient client = HttpClient.newHttpClient();
			
			System.out.println("after HttpClient creation in api section");
			
			// telling client to send the request and storing it in HttpResponse
			HttpResponse<String> response = (HttpResponse<String>)client.send(postRequest, BodyHandlers.ofString());

			System.out.println("Content-Type: " + response.headers().firstValue("Content-Type"));
			System.out.println("after response creation in api section");
			
		//	System.out.println(response.body());
			
			System.out.println("after response.body creation in api section");
			System.out.println("header+ "+response.headers());
			System.out.println("after header creation in api section");
			// return request.toString();
			
			
			
			String contentType = response.headers().firstValue("Content-Type").orElse("");
			if (contentType.contains("application/json")) {
			    
				return response.body();
				
			} else if (contentType.contains("text/html")) {

			    // Handle HTML response
			    System.out.println("Received text/html response:");
			    String strippedText = response.body().replaceAll("\\<.*?\\>", " ");
			    
			    System.out.println("strippedText"+strippedText);
			    String plainText= Jsoup.parse(response.body()).ownText();
			    System.out.println(plainText);

			} else {
				
			}

			
		
			return response.body();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return body;
	}
	
	//-------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------
	
	
	// method for get call 
	public String getDataFromApi(String Authorization , String finalCommand ) {
		
	
		
		
		// final api End point with command
		String finalApiEndPoint = apiEndpoint.concat(finalCommand);
		
		
		// it will converts List to array
//		String[] stringArray = listOfHeaders.toArray(new String[0]);
		
		
		
		
		HttpRequest postRequest;
		
		// making/building the request using static newbuilder
		try {
			postRequest = (HttpRequest) HttpRequest.newBuilder().uri(new URI(finalApiEndPoint))
					.GET()
					.header("Authorization", Authorization)
					.header("Content-Type", "application/json").build();
					
					
			
			
			// making actual client who will take a request to the server
			HttpClient client = HttpClient.newHttpClient();
			
			// telling client to send the request and storing it in HttpResponse
			HttpResponse<String> response = client.send(postRequest, BodyHandlers.ofString());

			
			
			
			System.out.println(response.body());
			System.out.println("header+ "+response.headers());
			
			//-------------------------------------trial
			
			
			//----------------------------------------trial
			  
			  
			// return request.toString();
			return response.body();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return response.body();

	
		return finalCommand;
		
	}
	
	
	
	public String authenticationFromApi(List<String> listOfHeaders, String body, String finalCommand) {

		// it converts string to object
//    Customer readValue = this.objectMapper.readValue("{\"name\": \"John Doe\", \"age\": 30}", Customer.class);
		
		System.out.println(listOfHeaders);
		System.out.println("final body in api section="+body);
	
		
		if(listOfHeaders !=null) {
		// it will converts List to array
		String[] stringArray = listOfHeaders.toArray(new String[0]);
		}
		
		
		
		HttpRequest postRequest;
		
		// making/building the request using static newbuilder
		try {
			postRequest = (HttpRequest) HttpRequest.newBuilder().uri(new URI(authApiEndPoint))
					.POST(BodyPublishers.ofString(body))
					.header("Content-Type", "application/json")
					.header("Accept", "application/json")
					.build();

			System.out.println("after req creation in api section");
			
			// making actual client who will take a request to the server
			HttpClient client = HttpClient.newHttpClient();
			
			System.out.println("after HttpClient creation in api section");
			
			// telling client to send the request and storing it in HttpResponse
			HttpResponse<String> response = (HttpResponse<String>)client.send(postRequest, BodyHandlers.ofString());

			System.out.println("Content-Type: " + response.headers().firstValue("Content-Type"));
			System.out.println("after response creation in api section");
			
			System.out.println(response.body());
			
			System.out.println("after response.body creation in api section");
			System.out.println("header+ "+response.headers());
			System.out.println("after header creation in api section");
			// return request.toString();
			
			
			
			String contentType = response.headers().firstValue("Content-Type").orElse("");
			if (contentType.contains("application/json")) {
			    
				return response.body();
				
			} else if (contentType.contains("text/html")) {

			    // Handle HTML response
			    System.out.println("Received text/html response:");
			    String strippedText = response.body().replaceAll("\\<.*?\\>", " ");
			    
			    System.out.println("strippedText"+strippedText);
			    String plainText= Jsoup.parse(response.body()).ownText();
			    System.out.println("plainText"+plainText);
			    return strippedText;

			} else {
				
			}

			
		
			return response.body();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return body;
	}
	
	
}
