package com.apilogin.auth.utilities;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UrlDataToPojo {

	public Customer getPojo(String body) {

		// String to Array of String
		String[] keyValuePairs = body.split("&");

		System.out.println(Arrays.asList(keyValuePairs));

		System.out.println(keyValuePairs.length);

		Map<String, String> map = new HashMap<>();

		// putting value in map
		for (int i = 0; i < keyValuePairs.length; i++) {

			String[] parts = keyValuePairs[i].split("=");
			if (parts.length == 2) {
				map.put(parts[0], parts[1]);
			}

		}

		Customer customer = new Customer();
		customer.setFirst_name(map.get("first_name"));
		customer.setLast_name(map.get("last_name"));
		customer.setStreet(map.get("street"));
		customer.setAddress(map.get("address"));
		customer.setCity(map.get("city"));
		customer.setState(map.get("state"));
		customer.setEmail(map.get("email"));
		customer.setPhone(map.get("phone"));

		if (customer.getUuid() == null) {
			customer.setUuid("");
		}
		if (customer.getAddress() == null) {
			customer.setAddress("");
		}
		if (customer.getCity() == null) {
			customer.setCity("");
		}
		if (customer.getState() == null) {
			customer.setState("");
		}
		if (customer.getEmail() == null) {
			customer.setEmail("");
		}
		if (customer.getStreet() == null) {
			customer.setStreet("");
		}
		if (customer.getPhone() == null) {
			customer.setPhone("");
		}
		if (customer.getFirst_name() == null) {
			customer.setFirst_name("");
		}
		if (customer.getLast_name() == null) {
			customer.setLast_name("");
		}

		if (customer.getEmail() != null) {
			// for the decoding of test%40gmail.com to test@gmail.com
			String encodedEmail = customer.getEmail();
			try {
				String decodedEmail = URLDecoder.decode(encodedEmail, "UTF-8");
				customer.setEmail(decodedEmail); // Output: test@gmail.com

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

		}

		return customer;

	}

}
