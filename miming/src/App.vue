<template>
  <div id="app">
    <header>
      <h1>게시판</h1>
      <nav>
        <router-link to="/">홈으로</router-link>
      </nav>
    </header>

    <main>
      <router-view />
    </main>
  </div>
</template>

<style>
/* 간단한 스타일링 */
#app {
  font-family: Arial, sans-serif;
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  color: #2c3e50;
}

header {
  border-bottom: 2px solid #42b983;
  margin-bottom: 20px;
  padding-bottom: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

nav a {
  text-decoration: none;
  color: #42b983;
  font-weight: bold;
}

button {
  cursor: pointer;
  padding: 8px 16px;
  border-radius: 4px;
  border: 1px solid #ccc;
  background-color: #f9f9f9;
  transition: 0.3s;
}

button:hover {
  background-color: #e2e2e2;
}

input, textarea {
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
  box-sizing: border-box; /* 패딩이 너비에 포함되도록 설정 */
}
</style>