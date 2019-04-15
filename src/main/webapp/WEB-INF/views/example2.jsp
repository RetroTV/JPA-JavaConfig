<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>XML Mapper</title>
</head>
<body>
<h1>XML 매퍼로 유저 정보를 불러오는 예제입니다</h1>

<p>아이디	: ${userXml.id }</p>
<p>이름	: ${userXml.name }</p>
<p>이메일	: ${userXml.email }</p>
<div>
	<input type="button" value="트랜젝션 예제" onclick="location.href='http://localhost/exampl3'"/>
</div>
</body>
</html>
