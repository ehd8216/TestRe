package com.kh.test;

import java.io.IOException;
import java.util.List;

import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHPermissionType;
import org.kohsuke.github.GHRateLimit;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class App2 {
	
	private final static String GITHUB_API_URL = "https://api.github.com";
	
	public static void main(String[] args) throws IOException {
		
        // GitHub OAuth Token을 사용하여 인증
		GitHub github = new GitHubBuilder().withOAuthToken("").build();
		String owner = "ehd8216";
		String repository = "test";
        
        String repositoryName = "ehd8216/DevHelper";
        
        // 레포지토리 가져오기
        GHRepository repo = github.getRepository(repositoryName);
		    	
        for (GHCommit commit : repo.listCommits()) {
            System.out.println("Commit SHA: " + commit.getSHA1());
            System.out.println("Commit Author: " + commit.getCommitShortInfo().getAuthor().getName());
            System.out.println("Commit Message: " + commit.getCommitShortInfo().getMessage());
            System.out.println("Commit Date: " + commit.getCommitDate());
            System.out.println(commit.getAuthor());
            
            System.out.println("----------------------------------------");
        }
        
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
