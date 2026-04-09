<template>
  <div v-if="post">
    <h2>{{ post.title }}</h2>
    <p style="color: gray;"><small>작성일: {{ post.date }}</small></p>
    <hr />
    <p style="white-space: pre-wrap;">{{ post.content }}</p>
    <hr />
    
    <button @click="router.push('/')">목록으로</button>
  </div>
  <div v-else-if="loading">
    <p>데이터를 불러오는 중입니다...</p>
  </div>
  <div v-else>
    <p>존재하지 않거나 삭제된 게시글입니다.</p>
    <button @click="router.push('/')">목록으로</button>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { fetchPostById } from '../api/board'

const route = useRoute()
const router = useRouter()

const postId = parseInt(route.params.id)
const post = ref(null)
const loading = ref(true)
onMounted(async () => {
  try {
    post.value = await fetchPostById(postId)
  } catch (error) {
    console.error('게시글 불러오기 실패:', error)
  } finally {
    loading.value = false
  }
})
</script>