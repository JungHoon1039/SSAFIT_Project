<template>
	<div class="container">
    <div class="shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 80%;">
      <form class="reviewform" style="width: 80%; margin: auto;">

        <div class="text-center">
          <span class="material-symbols-outlined">dialogs</span>
          <h2 class="d-inline mb-3 fs-4 fw-semibold">운동영상 리뷰 목록</h2>
          <span class="material-symbols-outlined">dialogs</span>
        </div>

        <hr class="mb-3">

        <div class="text-center">
          <iframe width="560" height="315" :src="`https://www.youtube.com/embed/${route.params.videoId}`" title="YouTube video player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
            allowfullscreen></iframe>
        </div>

        <hr class="mb-3">

        <div class="d-flex justify-content-between">
          <RouterLink :to="`/review/${route.params.videoId}/create`">
          <button type="button" class="w-20 me-2 btn btn-outline-primary">글
            작성</button>
          </RouterLink>
          <div style="border-bottom: solid gray 1px;" class="d-flex align-items-center">
            <span class="material-symbols-outlined align-items-center">search</span>

            <input style="border: none; background-color: transparent;" placeholder="제목,내용으로 검색">

          </div>
        </div>

        <hr class="mb-3">

        <div class="d-flex justify-content-center">
          <table style="width: 95%;">
            <tr>
              <th class="border-bottom p-3">번호</th>
              <th class="border-bottom p-3">제목</th>
              <th class="border-bottom p-3">작성자</th>
              <th class="border-bottom p-3">조회수</th>
              <th class="border-bottom p-3">작성시간</th>
            </tr>
            <tr v-for="review in store.reviewList" :key="review.id" style="cursor: pointer; text-decoration: underline;"
              class="link-dark link-offset-2 link-underline-opacity-0 link-underline-opacity-100-hover">
              <RouterLink :to="`/review/${route.params.videoId}/${review.id}`">
                <td class="p-3">{{ review.id }}</td>
                <td class="p-3">{{ review.title }}</td>
                <td class="p-3">{{ review.writer }}</td>
                <td class="p-3">{{ review.viewCnt }}</td>
                <td class="p-3">{{ review.regDate }}</td>
              </RouterLink>
            </tr>
          </table>

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
  store.getReviewList(route.params.videoId);
})

</script>

<style scoped>

</style>