<template>
	<div class="video-box">
		<div>
			<p class="fw-bold text-left fs-4">최근 가장 많이 본 영상</p>
		</div>
		<div class="video-card shadow pe-3 ps-3 pt-4 pb-4 d-flex video-list w-100 justify-content-around">
			<div v-for="video in store.recentVideoList" :key="video.id" style="cursor: pointer; width: 30%;">
				<RouterLink :to="`/review/${video.youtubeId}`">
					<div class="text-wrap fw-bold">
						<div>
							<img :src="`https://img.youtube.com/vi/${video.youtubeId}/0.jpg`" alt="썸네일">
						</div>
						<div>
							<div class="mt-1 mb-1 d-flex text-wrap">{{ video.title }}</div>
							<div class="justify-content-between d-flex">
								<span class="p-1 rounded-pill fw-bold bg-primary w-auto text-white">{{ video.part }}</span>
								<span class="fw-normal text-body-secondary">{{ video.channelName }}</span>
							</div>
						</div>
					</div>
				</RouterLink>
			</div>
		</div>
	</div>
</template>

<script setup>
import { useVideoStore } from '@/stores/video.js';
import { onMounted } from 'vue';
const store = useVideoStore();

onMounted(() => {
	store.getRecentVideoList();
})

</script>

<style scoped></style>