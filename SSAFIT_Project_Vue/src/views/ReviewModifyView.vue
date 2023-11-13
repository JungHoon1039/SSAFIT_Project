<template>
<div class="container">
        <div class=" shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 80%;">
            <form class="reviewform" style="width: 80%; margin: auto;">
                
                <div class="text-center">
                    <span class="material-symbols-outlined">dialogs</span>
                    <h2 class="d-inline mb-3 fs-4 fw-semibold">운동영상 리뷰 수정</h2>
                    <span class="material-symbols-outlined">dialogs</span>
                </div>
                <hr class="mb-3">
    
                <div class="mb-3">
                    <label for="inputTitle" class="col-form-label">제목</label>
                    <input type="text" class="form-control" id="inputEmail3" v-model="title">
                </div>
    
                <div class="mb-4">
                    <label for="inputContent" class="col-form-label">수정할 내용</label>
                    <textarea class="form-control" type="text" rows="3" v-model="content"></textarea>
                </div>
    
                <button type="button" class="w-20 me-2 btn btn-outline-primary" @click="reviewModify">수정</button>
				<RouterLink :to="`/review/${route.params.videoId}/${route.params.reviewId}`">
                <button type="button" class="w-20 btn btn-outline-danger">취소</button>
				</RouterLink>
            
            </form>
        </div>
    </div>
</template>

<script setup>
import { useRoute } from 'vue-router'
import { useReviewStore } from '@/stores/review.js';
import { ref, onMounted } from 'vue';
const store = useReviewStore();
const route = useRoute();
const title = ref(store.review.title);
const content = ref(store.review.content);
onMounted(() => {
	store.getReview(route.params.reviewId);
})
const reviewModify = function() {
	store.review.title = title.value;
	store.review.content = content.value;
	store.updateReview();
}
</script>

<style scoped>

</style>