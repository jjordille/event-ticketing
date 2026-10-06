import react from '@vitejs/plugin-react'
import { defineConfig } from 'vite'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    // Forward /api/* to Spring Boot during development, so the browser
    // sees one origin and we avoid CORS configuration.
    proxy: {
      '/api': 'http://localhost:8080',
    },
  },
})
