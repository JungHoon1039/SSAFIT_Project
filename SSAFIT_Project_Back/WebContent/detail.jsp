<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List"
	import="com.ssafy.board.model.dto.Video"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=1000px, initial-scale=1.0 minimum-scale=1.0 maximun-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
@media all and (min-width : 1000px) {
}
</style>
<title>SSAFIT</title>
</head>
<body>


<%--
String youtubeID = request.getParameter("youtubeID");
			List<Video> videoList = (List<Video>) request.getAttribute("interestList");
			Video selectedVideo = null;
			for (Video video : videoList) {
				if (video.getYoutubeId().equals(youtubeID)) {
					selectedVideo = video;
					break;
				}
			}
 --%>

	<header class="d-flex justify-content-between">
		<img src="ssafit_logo.PNG" alt="ssafit_logo">
		<div class="input-group m-auto container justify-content-center">
			<div class="row">
				<div class="col-2 col-md-8">
					<input type="text" class="form-control col-sm"
						placeholder="운동 제목 검색" aria-label="Example text with button addon"
						aria-describedby="button-addon1">
				</div>
				<div class="col-2 col-md-4">
					<button class="btn btn-outline-secondary" type="button"
						id="button-addon1">검색</button>
				</div>
			</div>
		</div>
		<div class="d-flex">
			<div class="d-flex flex-column justify-content-evenly"></div>
			<i style="font-size: 50px;"
				class="bi bi-person-circle d-flex align-items-center m-3"></i>
		</div>
	</header>

	<main style="width:1200px; margin: 0 auto;">
	<div class="d-flex justify-content-evenly">
		<!-- 영상 -->
		<div>
			<iframe width="400" height="225"
				src="https://www.youtube.com/embed/gMaB-fG4u4g"
				title="YouTube video player" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
				allowfullscreen></iframe>
		</div>
	</div>
	<div class="container-fluid">
		<h2 class="m-3">영상정보</h2>
		<table class="table table-striped table-hover">
			<tr>
				<th>제목:${selectedVideo.title}</th>
				<th>| 채널명:${selectedVideo.title}</th>
				<th>| 부위:${selectedVideo.channelName}</th>
				<th>| 조회수:${selectedVideo.viewCnt}</th>
			</tr>
		</table>
	</div>

	<hr>

	<!-- 리뷰 -->
	<div class="container-fluid">
		<h2 class="m-3">리뷰</h2>
		<table class="table table-striped table-hover">
			<tr>
				<th>N0.</th>
				<th>닉네임</th>
				<th>리뷰 내용</th>
				<th>등록 시간</th>
			</tr>
			<tr>
				<td>(예)1</td>
				<td>(예)동구</td>
				<td>(예)좋아용</td>
				<td>(예)23-09-17</td>
			</tr>
			<c:forEach var="review" items="${reviewList}">
					<tr>
						<td>${review.reviewId}</td>
						<td>${review.nickName}</td>
						<td>${review.content}</td>
						<td>${review.regDate}</td>
					</tr>

			</c:forEach>
		</table>
		<div
			style="display: flex; justify-content: center; flex-direction: column; align-items: center; height: 10vh;">
			<br>
			<button type="button" class="btn btn-outline-primary new-review"
				onclick="redirectToReviewPage('${youtubeId}')">리뷰 작성하기</button>
		</div>
	</div>
	<script>
		function redirectToReviewPage(youtubeId) {
			var url = 'insert.jsp?youtubeId=' + youtubeId;

			window.location.href = url;
		}
	</script> </main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha384-KyZXEAg3QhqLMpG8r+6rque5gkAUs1Ok9fFpK+w5t9zskr+mo4e5DU8j5p5F5F0N1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>

</body>
</html>