<template>
    <div class="hot-bar">
        <div class="inner">{{ props.hot }}</div>
    </div>
</template>

<script setup>
import { computed } from 'vue';

let props = defineProps(['hot', 'maxHot'])

let w = computed(() => {
    return (props.hot / props.maxHot) * 100 + '%';
});

</script>

<style scoped>
.hot-bar {
    border-radius: 20px;
    background-color: rgb(236, 229, 230);
    text-indent: .5em;
    /* overflow: hidden; */
}

.inner {
    width: v-bind(w);
    background: linear-gradient(to right, rgb(145, 44, 161) 50%, rgb(37, 167, 196));
    border-radius: 20px;
    white-space: nowrap;
}
</style>