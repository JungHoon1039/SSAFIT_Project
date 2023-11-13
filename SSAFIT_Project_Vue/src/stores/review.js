import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_REVIEW_API = `http://localhost:8080/ssafit/review`

export const useReviewStore = defineStore('review', () => {
	const reviewList = ref([])
	const getReviewList = function (youtubeId) {
	axios.get(REST_REVIEW_API + "/" + youtubeId)
		.then((response) => {
			reviewList.value = response.data
		})
	}
  
  const createReview = function (review) {
	console.log(review)
	axios({
		url: REST_REVIEW_API,
		method: 'POST',
		params: review
	})
		.then(() => {
			router.push({ name: 'reviewList', params:{videoId:review.youtubeId} })
		})
  }
  
  const review = ref({})

  const updateReview = function () {
	axios({
		url: REST_REVIEW_API,
		method: 'PUT',
		params: {id: review.value.id, title: review.value.title, content: review.value.content}
	})
		.then(() => {
			router.push({ name: 'reviewDetail', params:{videoId:review.youtubeId, reviewId:review.reviewId} })
		})
  }

  const getReview = function (reviewId) {
	axios.get(`${REST_REVIEW_API}/detail/${reviewId}`)
		.then((response) => {
			review.value = response.data
		})
  }

  const deleteReview = function (reviewId) {
	axios.delete(`${REST_REVIEW_API}/${reviewId}`)
		.then(() => {
			router.push({ name: 'reviewList', params:{videoId:review.youtubeId} })
		})
  }

  return { reviewList, getReviewList, createReview, review, updateReview, getReview, deleteReview}
})
