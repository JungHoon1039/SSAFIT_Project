import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

const REST_VIDEO_API = `http://localhost:8080/ssafit`

export const useVideoStore = defineStore('video', () => {
  const recentVideoList = ref([]);
  const getRecentVideoList = function () {
	axios.get(REST_VIDEO_API + '/video', {
		params: {
			orderBy: "viewCnt",
			orderByDir: "desc"
		}
	})
		.then((response) => {
			recentVideoList.value = response.data
		})
  }
  const partVideoList = ref([])
  const getPartVideoList = function (part) {
	axios.get(REST_VIDEO_API + '/video', {
		params: {
			key: "part",
			word: part
		}
	})
		.then((response) => {
			partVideoList.value = response.data
		})
  }
  return { recentVideoList, getRecentVideoList, partVideoList, getPartVideoList }
})
