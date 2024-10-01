package com.kh.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class gitController {
	
	WebClient webClient = WebClient.create();
	
	@RequestMapping("callback")
	public String callback(@RequestParam String code) throws IOException {
		String url = "https://github.com/login/oauth/access_token?client_id=Ov23liXFCmu7DAbTXCnZ&client_secret=6e05409f7a9e5dbddebd3a0a33132be0c201b26f&code=" + code;
		
		URL requestUrl = new URL(url);
		
		String tok = getToken(code);
		
		System.out.println(tok);
		
		return "redirect:/";
	}
	
	public String getToken(String code){
		String url = "https://github.com/login/oauth/access_token";

		String response = webClient
				.post()
				.uri(url)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.body(BodyInserters.fromFormData("client_id", "Ov23liXFCmu7DAbTXCnZ").with("client_secret", "6e05409f7a9e5dbddebd3a0a33132be0c201b26f").with("code",code))
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode jsonNode;
	    
	    String token="";
	    
	    try {
			jsonNode = objectMapper.readTree(response);
			token = jsonNode.get("access_token").asText();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	    return token;
	}

}
