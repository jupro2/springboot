<template>
    <div class="photo">
        <img :src="item.src" :alt="item.name">
        <span>{{ item.rank }}</span>
    </div>
</template>

<script setup>
import { computed } from 'vue';
let props = defineProps([
    'item',
]);
let item = props.item;

let color = computed(() => {
    if (item.rank === 1) {
        return "rgb(254, 45, 70)";
    } else if (item.rank === 2) {
        return "rgb(245, 102, 1)";
    } else {
        return "rgb(247, 169, 1)";
    }
})
</script>

<style scoped>
.photo {
    width: 150px;
    background-color: #fff;
    border-radius: 20px;
    overflow: hidden;
    position: relative;
}

.photo img {
    width: 100%;
    vertical-align: top;
    /* display:block; */
}

.photo span {
    position: absolute;
    width: 50px;
    height: 50px;
    background-color: v-bind(color);
    font-size: 20px;
    font-weight: bold;
    color: #fff;
    display: flex;
    justify-content: center;
    align-items: center;
    top: 0;
    left: 0;
    border-bottom-right-radius: 20px;
}
</style>