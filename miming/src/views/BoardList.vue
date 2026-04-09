<template>
  <div>
    <h2>게시판 목록</h2>
    <router-link to="/create">
      <button style="margin-bottom: 10px;">새 글 작성</button>
    </router-link>
    
    <ul style="list-style: none; padding: 0;">
      <li v-for="post in posts" :key="post.id" style="border-bottom: 1px solid #eee; padding: 10px 0;">
        <router-link :to="`/post/${post.id}`" style="text-decoration: none; color: black;">
          <strong>{{ post.id }}. {{ post.title }}</strong>
        </router-link>
        <span style="font-size: 0.8em; color: gray; margin-left: 10px;">{{ post.date }}</span>
      </li>
    </ul>
    <p v-if="posts.length === 0">등록된 게시글이 없습니다.</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { fetchPosts } from '../api/board'

const posts = ref([])

// 페이지가 마운트될 때 API를 호출하여 데이터를 가져옴
onMounted(async () => {
  try {
    posts.value = await fetchPosts() // 추후 백엔드 API 호출로 대체
  } catch (error) {
    console.error('목록을 불러오는 중 오류 발생:', error)
  }
})
</script>