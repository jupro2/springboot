<template>
    <div class="submit_input">
        <el-input
            v-model="test.content"
            :rows="3"
            type="textarea"
            placeholder="Please input"
        />
    </div>
    <div class="submit_value" style="padding-left: 30px">
        <el-rate v-model="value" clearable />
    </div>
    <div class="submit_button" style="padding-left: 750px;">
        <el-button @click="insertComment"  type="primary" style="width: 90px">
            提交
        </el-button>
    </div>

</template>

<script>
import request from "@/utlis/request";

export default {
    name: "Submit",

    data(){
        return{
            // 评论框
            test:{
                "content": "",
                "postId": "1",
                "createdTime": (new Date()).toISOString(),
            }
        }
    },

    methods:{
        insertComment(){
            this.updateTime();
             request.post("/comment/insert", this.test)
            .then(response => {
              console.log(response); // 在控制台中打印响应数据
              this.test.content="";
            })
            .catch(error => {
              console.error(error); // 在控制台中打印错误信息
            });
        },

        updateTime() {
            const currentDate = new Date();
            this.test.createdTime = currentDate.toISOString(); // 使用ISO 8601格式保存当前时间
            }

       
       
    },
    created() {
    this.updateTime(); // 初始化时间
    setInterval(this.updateTime, 1000); // 每秒更新时间
  },
  beforeDestroy() {
    clearInterval(this.timer); // 清除定时器
  }

}
</script>

<style>
.submit_input{
    width: 800px;
    padding-left: 30px;
    padding-top: 200px ;
}
</style>