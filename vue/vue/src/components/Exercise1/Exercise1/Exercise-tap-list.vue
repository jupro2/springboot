<template>
    <div class="tap-list">
        <TapItem v-for="player in items" :item="player" :maxHot="maxHot"></TapItem>
    </div>
</template>

<script setup>
import TapItem from './Exercise-tap-item.vue';

let props = defineProps(['items', 'maxHot']);

let items = props.items
</script>

<style scoped>
.tap-list {
    margin: 20px;
}
</style>