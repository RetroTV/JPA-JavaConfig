<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>이름에 Dummy라는 문자열이 포함된 모든 유저들을 조회</title>
</head>
<body>
<h1>update에 대한 예제 입니다.</h1>
	이 예제를 실행하면 "I'm Dummy User"라는 새로운 패스워드로 갱신됩니다.
	<p>아이디	: ${user.id } &emsp; 비밀번호 : ${user.password }</p>
</body>
</html>