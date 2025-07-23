import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    host: true,       // Allow external access (e.g., inside Docker)
    port: 5173,       // Default Vite port
    strictPort: true, // Fail if port is already in use
  }
})
