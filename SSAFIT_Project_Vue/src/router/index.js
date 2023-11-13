import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ReviewListView from '../views/ReviewListView.vue'
import ReviewDetailView from '../views/ReviewDetailView.vue'
import ReviewCreateView from '../views/ReviewCreateView.vue'
import ReviewModifyView from '../views/ReviewModifyView.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/review/:videoId',
      name: 'reviewList',
      component: ReviewListView
    },
    {
      path: '/review/:videoId/:reviewId',
      name: 'reviewDetail',
      component: ReviewDetailView
    },    
    {
      path: '/review/:videoId/create',
      name: 'reviewCreate',
      component: ReviewCreateView
    },    
    {
      path: '/review/:videoId/:reviewId/modify',
      name: 'reviewModify',
      component: ReviewModifyView
    }
  ]
})

export default router
