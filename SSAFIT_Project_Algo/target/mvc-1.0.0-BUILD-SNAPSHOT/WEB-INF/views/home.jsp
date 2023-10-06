<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<style>
	body {
	padding : 100px;
	}

	* {
	text-align : center;
	}

	h1 {
	margin : 30px;
		font-size: 100px;
	}
</style>
<body>
<h1>
	B . T . C
</h1>

<form method="POST" action="recommend">
	<div class="input-group mb-3 input-group-lg">
	<input class="form-control" id="level" type="number" required min="1" max="10" name="level" placeholder="난이도 입력" aria-label="난이도 입력" aria-describedby="button-addon2">
	<input id="button-addon2" type="submit" value="추천 받기" class="btn btn-outline-secondary">

</div>
</form>

<div style="margin-top: 50px">
<h4>방탈출 난이도를 입력하면 알맞은 방탈출을 추천해드립니다
</h4>
<h4>

		현재 강남 지역 방탈출 개수 : 159개
</h4>
</div>
</body>
</html>
