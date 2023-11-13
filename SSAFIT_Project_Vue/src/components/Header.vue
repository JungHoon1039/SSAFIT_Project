<template>
		<header>
			<nav class="navbar shadow navbar-expand-lg bg-body-tertiary">
				<div class="container-fluid">
					<a class="navbar-brand" id="page-name" href="/main/main.html">SSAFIT</a>
					<div class="justify-end d-flex" id="navbarScroll">
						<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
							<li class="nav-item">
								<a class="nav-link active" aria-current="page" href="/main/main.html">HOME</a>
							</li>

							<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
									aria-expanded="false">
									사용자
								</a>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item">찜</a></li>
									<li><a class="dropdown-item">팔로우</a></li>
								</ul>
							</li>
							<li class="nav-item">
								<a class="nav-link">로그아웃</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
			<div class="main-image-container">
				<img class="main-image object-fit-cover"
					src="https://watermark.lovepik.com/photo/20211126/large/lovepik-gym-picture_501088658.jpg"
					alt="main image">
			</div>
		</header>
</template>

<script setup>

</script>

<style scoped>

</style>