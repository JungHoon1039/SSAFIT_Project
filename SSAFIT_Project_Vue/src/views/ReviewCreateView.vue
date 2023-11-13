<template>
<div class="container">
    <div class=" shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 80%;">
        <form class="reviewform" style="width: 80%; margin: auto;">

            <div class="text-center">
                <span class="material-symbols-outlined">dialogs</span>
                <h2 class="d-inline mb-3 fs-4 fw-semibold">운동영상 리뷰 등록</h2>
                <span class="material-symbols-outlined">dialogs</span>
            </div>

            <hr class="mb-3">

            <div class="mb-3">
                <label for="inputTitle" class="col-form-label">제목</label>
                <input type="text" class="form-control" id="inputEmail3" placeholder="제목을 입력하세요" v-model="title">
            </div>

            <div class="mb-4">
                <label for="inputContent" class="col-form-label">내용</label>
                <textarea class="form-control" rows="3" placeholder="내용을 입력하세요" v-model="content"></textarea>
            </div>

            <button type="button" class="w-20 me-2 btn btn-outline-primary" @click="reviewCreate">등록</button>
			<RouterLink :to="`/review/${route.params.videoId}`">
            <button type="button" class="w-20 btn btn-outline-danger">취소</button>
			</RouterLink>
        
        </form>
    </div>
</div>
</template>

<script setup>
import { useRoute } from 'vue-router'
import { useReviewStore } from '@/stores/review.js';
import { ref } from 'vue';
const store = useReviewStore();
const route = useRoute();
const title = ref('');
const content = ref('');
const reviewCreate = function() {
	let review = {};
	review.title = title.value;
	review.content = content.value;
	review.youtubeId = route.params.videoId;
	review.writer = "ssafy";
	store.createReview(review);
}

</script>

<style scoped>

</style>