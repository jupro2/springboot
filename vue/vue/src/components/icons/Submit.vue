<template>
    <div class="submit_input">
        <el-input
            v-model="textarea"
            :rows="3"
            type="textarea"
            placeholder="Please input"
        />
    </div>
    <div class="submit_value" style="padding-left: 30px">
        <el-rate v-model="value" clearable />
    </div>
    <div class="submit_button" style="padding-left: 750px;">
        <el-button type="primary" style="width: 90px">
            提交
        </el-button>
    </div>

</template>

<script>

export default {
    name: "Submit",

    data(){
        return{
            // 评论框的数据
            textarea :'',
            value :'',
            click :'2000',
            rank :'1',
        }
    },
}
</script>

<style>
.submit_input{
    width: 800px;
    padding-left: 30px;
    padding-top: 200px ;
}
</style>