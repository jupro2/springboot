// createWebHashHistory 是hash模式就是访问链接带有#
// createWebHistory  是history模式
import { createRouter, createWebHashHistory } from 'vue-router'
import Home from "@/components/Home.vue";
import Restaurant from "@/components/Restaurant.vue";


// 引入文件，动态路由
const routes = [
    {
        path: "/About",
        name: "About",
        component:Restaurant,
    },
    {
        path: "/",
        name: "Home",
        component:Home,
    },

];

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router