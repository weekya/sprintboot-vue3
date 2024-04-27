import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  server:{
    proxy:{
      '/user':{
        target:'http:localhost:8081',
        changeOrigin:true,
        rewrite:(path) => path.replace(/^\/user/,'')
      }
    }
  },
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))

    }
  }
})
//
// module.exports = {
//   devServer:{
//     port: 5172,
//     proxy:{
//       '/user':{
//         target:'http://localhost:8081',
//         changeOrigin: true,
//         pathRewrite:{
//           '^/user':''
//         }
//
//
//       }
//     }
//   }
// }
