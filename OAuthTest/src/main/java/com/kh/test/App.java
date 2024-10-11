package com.kh.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;


@Controller
public class App {
	
	@RequestMapping("getRepo")
	public String getRepo(String accessToken, HttpSession session) throws IOException {
		
		GitHub github = GitHub.connectUsingOAuth(accessToken);
		
		GHCreateRepositoryBuilder builder = github.createRepository("gitCreateTest");
        builder.description("This is a new repository응애")
                .private_(true)
                .autoInit(true)
                .create();
		
		return "redirect:/";
	}
	
	 
	 
}
