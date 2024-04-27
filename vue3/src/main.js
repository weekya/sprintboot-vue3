import './assets/main.css'
import { createApp } from 'vue'
import App from './App.vue'
import router from "./router";
import './style/headtop.css'
import 'element-plus/dist/index.css'
import ElementPlus from 'element-plus'
import urls from './api/api.js'
import request from './api/request.js'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const app = createApp(App)
app.use(ElementPlus)
app.use(router)
app.config.globalProperties.$urls = urls
app.config.globalProperties.$request = request

app.mount('#app')
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
