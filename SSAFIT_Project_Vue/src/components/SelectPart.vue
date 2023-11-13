<template>
	<div class="mt-5 video-box">
		<div>
			<p class="fw-bold text-left fs-4">운동 부위 선택</p>
		</div>
		<div class="d-flex" style="margin-bottom: 20px;">
			<div style="cursor: pointer;" class="fw-normal ps-3 pe-3 pt-2 pb-2 me-2 rounded-pill bg-light shadow-sm w-auto" @click="partValue">
				전신
			</div>
			<div style="cursor: pointer;" class="fw-normal ps-3 pe-3 pt-2 pb-2 me-2 rounded-pill bg-light shadow-sm w-auto" @click="partValue">
				상체
			</div>
			<div style="cursor: pointer;" class="fw-normal ps-3 pe-3 pt-2 pb-2 me-2 rounded-pill bg-light shadow-sm w-auto" @click="partValue">
				하체
			</div>
			<div style="cursor: pointer;" class="fw-normal ps-3 pe-3 pt-2 pb-2 me-2 rounded-pill bg-light shadow-sm w-auto" @click="partValue">
				복부
			</div>
		</div>
		<div class="video-card shadow mt-8  pe-3 ps-3 pt-4 pb-4 d-flex video-list w-100 justify-content-around">
			<div v-for="video in store.partVideoList" :key="video.id" onclick="location.href='/review/reviewList.html'" style="cursor: pointer; width: 30%;">
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
			</div>
		</div>
	</div>
</template>

<script setup>
import { useVideoStore } from '@/stores/video.js';
import { ref, onMounted } from 'vue';
const store = useVideoStore();

const bodyValue = ref('');
const partValue = function() {
	bodyValue.value = event.target.innerText;
	store.getPartVideoList(bodyValue.value);
}

onMounted(() => {
	store.getPartVideoList(bodyValue.value);
})
</script>

<style scoped></style>