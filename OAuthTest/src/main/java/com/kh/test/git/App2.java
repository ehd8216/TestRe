package com.kh.test.git;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHContentUpdateResponse;
import org.kohsuke.github.GHInvitation;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHPermissionType;
import org.kohsuke.github.GHRateLimit;
import org.kohsuke.github.GHRef;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitCommit;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class App2 {
	
	private final static String GITHUB_API_URL = "https://api.github.com";
	
	public static void main(String[] args) throws IOException {
		
		int[] arr = new int[4];

		int a = 4;
		System.out.println(test());
		
		
		
	}
	
	public static double test() {
		int a = 5;
		return 5 / 3;
	}
	
	 public static String checkTokenScopes(String token) {
	        WebClient webClient = WebClient.create();

	        String response = webClient.get()
	                .uri("https://api.github.com/user")
	                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
	                .header(HttpHeaders.ACCEPT, "application/vnd.github.v3+json")
	                .retrieve()
	                .bodyToMono(String.class)
	                .block();

	        return response;
	    }
}
