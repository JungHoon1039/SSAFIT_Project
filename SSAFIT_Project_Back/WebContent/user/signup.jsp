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
<h2>회원가입</h2>
<form action="<%= request.getContextPath() %>/user" method="post">
    <input name="action" type="hidden" value="signup">
    <input id="userId" name="userId" type="text" placeholder="아이디" required><br>
    <input id="password" name="password" type="password" placeholder="비밀번호" required><br>
    <input id="passwordConfirm" name="passwordConfirm" type="password" placeholder="비밀번호 확인" required><br>
    <input id="userName" name="userName" type="text" placeholder="이름" required><br>
    <input id="nickName" name="nickName" type="text" placeholder="닉네임" required><br>
    <input id="email" name="email" type="email" placeholder="이메일" required><br>
    <input type="submit" value="계정 만들기">
</form>
<script type="text/javascript">
let password = document.getElementById("password")
let passwordConfirm = document.getElementById("passwordConfirm");
function validatePassword(){
    if(password.value != passwordConfirm.value) {
        passwordConfirm.setCustomValidity("비밀 번호가 일치 하지 않습니다");
    } else {
        passwordConfirm.setCustomValidity(''); 
    }
}
password.onchange = validatePassword;
passwordConfirm.onkeyup = validatePassword;
</script>
</body>
</html>
