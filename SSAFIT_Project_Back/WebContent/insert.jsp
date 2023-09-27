<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 등록</title>
</head>
<body>
	<h2>리뷰 등록</h2>
	<hr>
	<form action="review" method="get">
		<input type="hidden" name="action" value="insert"> 영상 번호 : <input
			type="text" name="youtubeId" readonly value="${reviewId}"> <br>
		글쓴이 : <input type="text" name="nickName"> <br> 내용 :
		<textarea rows="10" cols="10" name="content"></textarea>
		<br>
		<button type="submit">등록</button>
	</form>

</body>
</html>