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
	< <h1>Login with GitHub</h1>
    <button id="loginButton">GitHub 로그인</button>

    <button onclick="token()">토큰 가져오기</button>


    
    <script>
        document.getElementById('loginButton').addEventListener('click', function() {
            window.location.href = 'https://github.com/login/oauth/authorize?client_id=Ov23liXFCmu7DAbTXCnZ&scope=repo,user';
        });
        const urlParams = new URLSearchParams(window.location.search);
        const authCode = urlParams.get("code");
        console.log(authCode);
        
    </script> 
</body>
</html>