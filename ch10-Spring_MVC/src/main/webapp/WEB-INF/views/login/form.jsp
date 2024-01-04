<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form:form action="login.do" modelAttribute="loginVO">
		<%-- 기본적으로 span태그에 에러 메시지를 명시하는데 element 속성에 
		 	 div를 명시하면 div태그에 에러 메시지를 표시함 --%>
		<form:errors element="div"/>
		아이디 : <form:input path="userId"/>
		<form:errors path="userId"/>
		<br>
		비밀번호 : <form:password path="password"/>
		<form:errors path="password"/>
		<br>
		<form:button>전송</form:button>
	</form:form>
</body>
</html>