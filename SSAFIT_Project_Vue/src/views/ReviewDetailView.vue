<template>
	<div class="container">
		<div class="shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 80%;">
			<form class="reviewform" style="width: 80%; margin: auto;">

				<div class="text-center">
					<span class="material-symbols-outlined">dialogs</span>
					<h2 class="d-inline mb-3 fs-4 fw-semibold">운동영상 리뷰 상세</h2>
					<span class="material-symbols-outlined">dialogs</span>
				</div>

				<hr class="mb-3">

				<div class="d-flex justify-content-between">
					<RouterLink :to="`/review/${route.params.videoId}`">
					<button type="button" class="w-20 me-2 btn btn-outline-primary">목록</button>
					</RouterLink>
					<div class="d-flex">
						<RouterLink :to="`/review/${route.params.videoId}/${route.params.reviewId}/modify`">
						<button type="button" class="float-end w-20 me-2 btn btn-outline-primary">글 수정</button>
						</RouterLink>
						<button type="button" class="float-end w-20 btn btn-outline-danger" @click="reviewDelete">글 삭제</button>
					</div>
				</div>

				<div class="shadow-sm mb-3 text-center border p-4 mt-3">
					<div class="p-2">
						<h3 class="fs-5 fw-medium">{{ store.review.title}}</h3>
						<div>작성자: {{ store.review.writer}}</div>
						<div>작성일: {{ store.review.regDate}}</div>
						<div>조회수: {{ store.review.viewCnt}}</div>
					</div>
					<hr>
					<div class="p-2">
						<div>{{ store.review.content}}</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</template>

<script setup>
import { useRoute } from 'vue-router'
import { useReviewStore } from '@/stores/review.js';
import { onMounted } from 'vue';
const store = useReviewStore();
const route = useRoute();

onMounted(() => {
	store.getReview(route.params.reviewId);
})
const reviewDelete = function() {
	store.deleteReview(route.params.reviewId)
}

</script>

<style scoped></style>