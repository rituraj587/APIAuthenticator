package com.apilogin.auth.utilities;

import com.apilogin.auth.utilities.UrlDataToPojo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateAndUpdate {

	
	ObjectMapper objectMapper = new ObjectMapper();

	public String addAndUpdateCustomer(String body, Map<String, String> auth,String Authorization ,String finalCommand) {

		
		System.out.println("body in addcustomer"+body);
		
		UrlDataToPojo urlDataToPojo = new UrlDataToPojo();

		Customer customer = urlDataToPojo.getPojo(body);

		System.out.println(customer.getFirst_name());
		System.out.println(customer.getLast_name());
		System.out.println(customer.getStreet());

	
		
		String finalBody = null;
		try {
			finalBody = objectMapper.writeValueAsString(customer);
		} catch (Exception e) {

			e.printStackTrace();
		}

		// {"uuid":null,"first_name":"Aryan","last_name":"Shukla","street":null,
		// "address":null,"city":null,"state":null,"email":null,"phone":null}
		// ------------------------------

		// conversion of Map to List
		MapToListOfString headerList = new MapToListOfString();
		List<String> listOfHeaders = headerList.MapToList((HashMap<String, String>) auth);

		// making command ?key=value&key=value
		/*
		 * StringJoiner s = new StringJoiner("&"); //StringeJoiner object
		 * s.add("?cmd="+cmd); //command 1 s.add("uuid="+uuid); String finalCommand =
		 * s.toString();
		 */

		// Api hit of SunBase
		MakingRequestApi makingRequestApi = new MakingRequestApi();
		String dataFromApi = makingRequestApi.postDataFromApi(listOfHeaders, finalBody, "?cmd=create",
				Authorization);

		System.out.println(dataFromApi);
		System.out.println("post mapping");

		System.out.println(body);

		return "Done";

	}

	public String updateCustomer() {
		return null;

	}

}
