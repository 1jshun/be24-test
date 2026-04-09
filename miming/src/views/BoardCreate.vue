<template>
  <div>
    <h2>게시글 등록</h2>
    <form @submit.prevent="submitPost">
      <div style="margin-bottom: 10px;">
        <label>제목: </label>
        <input v-model="title" type="text" required style="width: 80%;" />
      </div>
      <div style="margin-bottom: 10px;">
        <label>내용: </label>
        <textarea v-model="content" required rows="5" style="width: 80%;"></textarea>
      </div>
      <button type="submit">등록</button>
      <button type="button" @click="router.push('/')">취소</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { createPost } from '../api/board'

const title = ref('')
const content = ref('')
const router = useRouter()

const submitPost = async () => {
  try {
    // 백엔드에 등록 요청
    await createPost({ title: title.value, content: content.value })
    alert('등록되었습니다.')
    router.push('/') // 완료 후 목록 페이지로 이동
  } catch (error) {
    console.error('등록 실패:', error)
    alert('등록에 실패했습니다.')
  }
}
</script>