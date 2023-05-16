<template>
    <div class="bigbox">
        <Tap>
        <template #0>
            <TapList :items="players" :maxHot="maxHot"></TapList>
        </template>
        <template #1>
            <TapList :items="teams" :maxHot="maxHot"></TapList>
        </template>
    </Tap>
    </div>
    
</template>

<script setup>
import { reactive, ref } from 'vue';
import Tap from './Exercise-tap.vue';
import TapList from './Exercise-tap-list.vue';


// 父组件通常使用 props 将数据传递给子组件
let isShow = ref(true);

let maxHot = ref(70);

let players = ref([
    {
        name: 'desk',
        src: '/images/desk.jpg',
        rank: 1,
        hot: 43,
    },
    {
        name: 'desk',
        src: '/images/Capture001.png',
        rank: 2,
        hot: 40,
    },
    {
        name: 'desk',
        src: '/images/dotnet.png',
        rank: 3,
        hot: 53,
    },
]);

let teams = ref([
    {
        name: 'dotnet',
        src: '/images/dotnet.png',
        rank: 1,
        hot: 50,
    },
    {
        name: 'dotnet',
        src: '/images/Capture001.png',
        rank: 2,
        hot: 30,
    },
    {
        name: 'dotnet',
        src: '/images/desk.jpg',
        rank: 3,
        hot: 40,
    },
]);
</script>
<style scoped>
</style>