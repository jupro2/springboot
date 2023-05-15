<template>
    <div class="tap-wrapper">
        <header class="tap-head">
            <div @click="isShow = true" class="tap-button" :class="{ active: isShow }">热门餐厅</div>
            <div @click="isShow = !isShow" class="tap-button" :class="{ active: !isShow }">热门窗口</div>
        </header>
        <div class="main">
            <!-- 
                v-show，用来设置一个内容是否显示
                通过display设置
             -->
            <!-- 球员 -->
            <div v-show="isShow">
                <!-- <TapList :items="players" :maxHot="maxHot"></TapList> -->
                <slot name="0"></slot>
            </div>
            <!-- 球队 -->
            <div v-show="!isShow">
                <!-- <TapList :items="teams" :maxHot="maxHot"></TapList> -->
                <slot name="1"></slot>
            </div>

            <!-- if-else -->
            <!-- <div v-if="isShow">
                <div class="tap-list">
                    <TapItem :item="player"></TapItem>
                </div>
            </div>
            <div v-else>
                <div class="tap-list">
                    <TapItem :item="team"></TapItem>
                </div>
            </div> -->

            <!-- 
                v-show通过css来切换组件的显示与否，切换时不会重新渲染组件
                但初始化时，要对所有塑件进行初始化（即使组件不显示）

                v-if通过删除添加元素来实现切换元素，反复渲染组件，性能较差
                只会初始化需要用到的组件
             -->
        </div>
    </div>
</template>

<script setup>
import { reactive, ref } from 'vue';
import TapList from './Exercise-tap-list.vue';

let isShow = ref(true);
</script>

<style scoped>
.tap-wrapper {
    border-radius: 10px;
    box-sizing: border-box;
    width: 800px;
    padding: 20px;
    background-color: rgb(45, 83, 211);
}

.tap-head {
    display: flex;
    border-radius: 10px;
    overflow: hidden;
}

.tap-button {
    background-color: #fff;
    font-size: 30px;
    /* flex弹性系数，auto自动伸缩 */
    flex: auto;
    padding: 10px 0;
    text-align: center;
    cursor: pointer;
    /* 切换所需时长 */
    transition: 0.5s;
}

.tap-button:not(.active):hover {
    color: rgb(187, 3, 52);
}

.active {
    background-color: rgb(187, 3, 52);
    color: #fff;
}
</style>