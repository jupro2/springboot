<template>
    <div class="tap-item">
        <!-- 图片组件 -->
        <Photo :item="photoItem"></Photo>
        <div class="desc">
            <span class="name">{{ item.name }}</span>
            <HotBar :hot="item.hot" :max-hot="props.maxHot"></HotBar>
        </div>
    </div>
</template>

<!-- 
    子组件中的数据通常不会在子组件中直接定义
    数据通常在创建组件实例时确定

    现在子组件中设置defineProps()
    defineProps 不是方法，是一个宏
 -->
<script setup>
import { reactive } from 'vue';
import Photo from './Exercise-photo.vue';
import HotBar from './Exercise-hotbar.vue'

// 数组只能定义参数名，常用的简单配置
let props = defineProps(['item', 'maxHot']);
// 对象可以对参数进行限制，不常用的严谨配置
// let props = defineProps({
//     item: {
//         type: Object, // 指定参数类型
//         required: true, // 设置参数为必填
//         default: {
//             name: 'desk',
//             imgurl: '/images/desk.jpg',
//             rank: 1,
//             hot: 433769,
//         },
//         validator(value) {
//             console.log('value :>> ', value.name);
//             return value.name == 'desk'; // 等于 true 说明合法
//         },
//     }
// });
let item = props.item;

let photoItem = reactive({
    src: item.src,
    name: item.name,
    rank: item.rank,
});
</script>

<style scoped>
.tap-item {
    display: flex;
    margin-bottom: 40px;
}

.desc {
    display: flex;
    flex-flow: column;
    flex: auto;
    justify-content: space-evenly;
    font-size: 30px;
    color: #fff;
    margin-left: 30px;
}
</style>