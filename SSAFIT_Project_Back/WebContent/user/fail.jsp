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
<h2>오류 페이지</h2>
<div><% if (request.getParameter("action").equals("login")) {
    out.print("로그인");
} else if (request.getParameter("action").equals("signup")) {
    out.print("회원가입");
}%> 실패 <a href="<%= request.getContextPath() %>/index.jsp">메인으로</a></div>
</body>
</html>