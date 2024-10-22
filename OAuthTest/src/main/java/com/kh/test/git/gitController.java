package com.kh.test.git;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	// 
	@RequestMapping("callback")
	public String callback(@RequestParam String code, HttpSession session, HttpServletResponse hsr) throws IOException {
		String token = getToken(code);
		System.out.println(token);
		session.setAttribute("token", token);
		
		
		return "redirect:/";
	}
	
	// 깃허브 로그인 후 유저 깃허브 토큰 가져오는 메소드
	public String getToken(String code){
		String url = "https://github.com/login/oauth/access_token";

		String response = webClient
				.post()
				.uri(url)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.body(BodyInserters.fromFormData("client_id", "Ov23lijlJe6CD8zHVxyU").with("client_secret", "689c260bfc682d5acdf9300cd9e207e6d54ecff5").with("code",code))
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
