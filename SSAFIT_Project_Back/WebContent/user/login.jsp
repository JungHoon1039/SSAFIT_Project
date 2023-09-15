<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFIT</title>
</head>
<body>
<h2>로그인</h2>
<form action="<%= request.getContextPath() %>/user" method="post">
    <input name="action" type="hidden" value="login">
    <input id="userId" name="userId" type="text" placeholder="아이디" required><br>
    <input id="password" name="password" type="password" placeholder="비밀번호" required><br>
    <input type="submit" value="로그인">
</form>
</body>
</html>