const BASE_URL = '/api/board'

export const fetchPosts = async () => {
  const response = await fetch(BASE_URL)
  if (!response.ok) throw new Error('게시글 목록을 불러오는데 실패했습니다.')
  
  const data = await response.json()

  return data.map(post => ({
    ...post,
    date: post.createAt
  }))
}

export const fetchPostById = async (id) => {
  const response = await fetch(`${BASE_URL}/${id}`)
  if (!response.ok) throw new Error('게시글 상세 정보를 불러오는데 실패했습니다.')
  
  const post = await response.json()

  return {
    ...post,
    date: post.createAt
  }
}

export const createPost = async (data) => {
  const response = await fetch(BASE_URL, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    // BoardDto.Reg의 구조(title, content)에 맞게 JSON 직렬화하여 전송
    body: JSON.stringify({
      title: data.title,
      content: data.content
    })
  })
  
  if (!response.ok) throw new Error('게시글 등록에 실패했습니다.')
}