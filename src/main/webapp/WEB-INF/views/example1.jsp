<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Java Annotation</title>
</head>
<body>
<h1>Java 어노테이션으로 유저 정보를 불러오는 예제입니다</h1>
	<p>아이디	: ${user.id } &emsp; 이름 : ${user.name } &emsp; 이메일 : ${user.email }</p>
<div>
	<input type="button" value="xml매퍼를 이용한 데이터 불러오기" onclick="location.href='http://localhost/example2'"/>
</div>
</body>
</html>