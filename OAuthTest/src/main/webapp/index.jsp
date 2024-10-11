<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login with GitHub</h1>
    <button id="loginButton">GitHub 로그인</button>
    
    <button onclick="repo()">레파지토리 확인</button>
    
    <div>${ repo }</div>
	
    <script>
        document.getElementById('loginButton').addEventListener('click', function() {
            window.location.href = 'https://github.com/login/oauth/authorize?client_id=Ov23lijlJe6CD8zHVxyU&scope=repo,user';
        });

        function repo(){
            location.href="getRepo?accessToken=${token}"
        }



    </script> 
</body>
</html>