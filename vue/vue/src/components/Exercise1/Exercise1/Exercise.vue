<template>
    <Tap>
        <template #0>
            <TapList :items="players" :maxHot="maxHot"></TapList>
        </template>
        <template #1>
            <TapList :items="teams" :maxHot="maxHot"></TapList>
        </template>
    </Tap>
</template>

<script setup>
import { reactive, ref } from 'vue';
import Tap from './Exercise-tap.vue';
import TapList from './Exercise-tap-list.vue';


// 父组件通常使用 props 将数据传递给子组件
let isShow = ref(true);

let maxHot = ref(700000);

let players = ref([
    {
        name: 'desk',
        src: '/images/desk.jpg',
        rank: 1,
        hot: 433769,
    },
    {
        name: 'desk',
        src: '/images/Capture001.png',
        rank: 2,
        hot: 400009,
    },
    {
        name: 'desk',
        src: '/images/dotnet.png',
        rank: 3,
        hot: 533769,
    },
]);

let teams = ref([
    {
        name: 'dotnet',
        src: '/images/dotnet.png',
        rank: 1,
        hot: 500000,
    },
    {
        name: 'dotnet',
        src: '/images/Capture001.png',
        rank: 2,
        hot: 300000,
    },
    {
        name: 'dotnet',
        src: '/images/desk.jpg',
        rank: 3,
        hot: 400000,
    },
]);
</script>

<style scoped></style>