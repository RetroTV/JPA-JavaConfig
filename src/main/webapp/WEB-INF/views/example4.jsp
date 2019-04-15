<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>이전 예제가 제대로 동작했을 경우</title>
</head>
<body>
<h1>example4를 실행한 결과 입니다.</h1>
	<c:forEach var="user" items="${users }">
		<p>아이디	: ${user.id } &emsp; 이름 : ${user.name } &emsp; 이메일 : ${user.email }</p>
	</c:forEach>
</body>
</html>