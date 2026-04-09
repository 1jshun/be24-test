import { createRouter, createWebHistory } from 'vue-router'
import BoardList from '../views/BoardList.vue'
import BoardDetail from '../views/BoardDetail.vue'
import BoardCreate from '../views/BoardCreate.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', name: 'list', component: BoardList },
    { path: '/create', name: 'create', component: BoardCreate },
    { path: '/post/:id', name: 'detail', component: BoardDetail }
  ]
})

export default router