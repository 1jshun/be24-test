# 1. 빌드 단계
FROM node:24.12.0-slim AS builder
WORKDIR /app

ARG VITE_BACKEND_URL
ENV VITE_BACKEND_URL=${VITE_BACKEND_URL}

COPY package*.json ./

RUN npm install

COPY ./ ./
RUN npm run build

# 2. 실행 단계
FROM nginx:alpine

COPY --from=builder /app/dist /usr/share/nginx/html
COPY default.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]