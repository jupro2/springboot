// main.ts
import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import App from './App.vue'
import 'element-plus/dist/index.css'
import router from "@/router";

createApp(App).use(router).use(ElementPlus).mount('#app')
