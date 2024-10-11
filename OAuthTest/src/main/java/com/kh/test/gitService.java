package com.kh.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class gitService {
	
	private static final String GITHUB_API_URL = "https://api.github.com/user/repos";

    @Autowired
    private RestTemplate restTemplate;

    public String getRepositories(String accessToken) {
        // HTTP 요청에 필요한 헤더 설정 (Bearer Token)
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        // API 호출
        ResponseEntity<String> response = restTemplate.exchange(
                GITHUB_API_URL,
                HttpMethod.GET,
                new org.springframework.http.HttpEntity<>(headers),
                String.class
        );

        return response.getBody();
    }

}
