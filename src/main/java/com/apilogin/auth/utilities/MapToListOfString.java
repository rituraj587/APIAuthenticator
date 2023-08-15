package com.apilogin.auth.utilities;


import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MapToListOfString {
	

	
	List<String> listOfHeaders = new ArrayList<>();

	public List<String> MapToList(HashMap<String, String> headers) {
		
	    for (Entry<String, String> entry : headers.entrySet()) {
	    	
	    	listOfHeaders.add(entry.getKey());
	    	listOfHeaders.add(entry.getValue());
	    	
	    	
//	        System.out.println(entry.getKey() + ":" + entry.getValue());
	    }
	    System.out.println(listOfHeaders);
		return listOfHeaders;
	}

	
	
	
	/*
	 * public void iterateUsingEntrySet(Map<String, Integer> map) { for
	 * (Map.Entry<String, Integer> entry : map.entrySet()) {
	 * System.out.println(entry.getKey() + ":" + entry.getValue()); } }
	 */
}
