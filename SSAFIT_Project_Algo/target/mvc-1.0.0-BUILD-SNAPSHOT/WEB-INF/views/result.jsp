<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>

<style>
	* {
		text-align: center;
		margin: 20px;
	}
	h1 {
		margin: 40px 0;
	}
	body {
		padding: 30px 10%;
	}
	.data {
		display: none;
	}


</style>

<body>

<h1> 159개 중 난이도 ${level}인  ${list.size()}개가 선택되었습니다</h1>
<hr>
<h1>추천 방탈출</h1>



<c:forEach items="${list}" var="btc" varStatus="idx">
	<div id="${idx.index}" class="data">

	<div>
		<h4>
			매장 : ${btc.shop}
		</h4>
	</div>
	<div>
		<h4>테마 : ${btc.name}
		</h4>
	</div>
	<div>
		<h4>평점 : ${btc.grade} </h4>
	</div>
	<div>
		<h4>리뷰 수 : ${btc.rvCnt} </h4>
	</div>

	</div>
</c:forEach>


<div class="btn-group" role="group" aria-label="Basic outlined example">
	<button id="prev" type="button" class="btn btn-outline-primary"> 이전 </button>
	<button id="next" type="button" class="btn btn-outline-primary"> 다음 </button>
</div>
<br>
<a href="home"> 이전으로 돌아가기 </a>

</body>

<script>
	let idx = 0;
	let active = document.getElementById(idx);
	active.style.display = "block";
	const next = document.getElementById("next");
	next.addEventListener('click',e=>{
		if (idx < ${list.size()}-1) {
		active.style.display = "none";
		active = document.getElementById(++idx);
		active.style.display = "block";
		} else {
			alert("마지막 방탈출입니다");
		}
	});
	const prev = document.getElementById("prev");
	prev.addEventListener('click',e=>{
		if (idx > 0) {
			active.style.display = "none";
			active = document.getElementById(--idx);
			active.style.display = "block";
		} else {
			alert("첫번째 방탈출입니다");
		}
	})

</script>
</html>
