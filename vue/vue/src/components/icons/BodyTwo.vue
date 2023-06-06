
<template>
<!--  中部的大图，用来展示-->
<div class="body_img">
  <img src="src/assets/eye2.jpg" alt="src/assets/eye1.jpg">
</div>
    <div class="submit-rank" >
        <el-col :span="6">
            <el-statistic title="点赞数" :value="click" />
        </el-col>
        <el-col :span="6">
            <el-statistic title="排行" :value="rank" />
        </el-col>
    </div>

    <div class="get-info">
        <div class="reply" v-for="(item,index) in comments" :key="index">
            <div class="user"><span class="time">一小时前</span> A{{item.id}}</div>
            <br/>
            <div class="content">{{item.content}}</div>
            <hr/>
        </div>
    </div>




<div class="body_submit">
    <Submit/>
</div>
</template>

<script>
import Submit from "@/components/icons/Submit.vue";
import request from "@/utlis/request";

export default {
  name: "BodyTwo",
    components:{
      Submit,
    },
    //生命周期函数钩子
    created() {
    this.getComment();
  },
    data(){
        return{
            click :'2000',
            rank :'1',
            comments: [
            ]
        }
    },
  //TODO 解决数组问题
    methods:{
    getComment(){
        request.get("/comment/getComment")
            .then(response => {
              console.log(response); // 在控制台中打印响应数据
              this.comments=response;
            })
            .catch(error => {
            console.log("错误，未知");
              console.error(error); // 在控制台中打印错误信息
            });
      },

    }
   

}
</script>

<style>

img{
  width: 900px;
  height: 300px;
}
.submit-rank{
    padding-left: 800px;
}
</style>