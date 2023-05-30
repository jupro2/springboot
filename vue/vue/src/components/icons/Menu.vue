<template>
  <!--  菜单-->
  <div class="menu">
    <el-menu
        class="el-menu-demo"
        mode="horizontal"
        :ellipsis="false"
        background-color="white"
        text-color="#222"
        active-text-color="black"
        style="min-width: 1300px;"
        router
    >

      <!--        图片，无法点击-->
      <div>
        <img src="src/assets/school.jpg" style="height: 50px; width: 50px; color: white;padding-left: 10px;padding-right: 10px" alt="">
      </div>


      <div class="flex-grow" />
      <router-link to="/" style="color: black;text-decoration: none">
        <el-menu-item index="1">排行榜</el-menu-item>
      </router-link>


      <el-sub-menu index="2">
<!--        缺少#title会丢失（餐厅）-->
        <template #title>餐厅</template>

        <el-menu-item v-for="item in dataGet" :key="item.id" :index="item.menuUrl"  @click="getresName(item.name)">
           {{item.name}}
        </el-menu-item>

      </el-sub-menu>

<!--     搜索框-->
      <div style="padding-left: 900px;padding-top: 10px">
          <el-input v-modle="search" placeholder="请输入..." style="width: 200px;height: 40px;"></el-input>
        <el-button type="primary" @click="save" >搜索</el-button>
      </div>

    </el-menu>
  </div>


</template>

<script>
import request from "@/utlis/request";

export default {

    props: {
        dataGet: {
            type: Array,
            required: true
        }
    },



  data(){
    return{
      search :{
          //test
          user_id:10,
          user_name:"ad",
          user_ip:"123"
      },
      test:{
        "id": "",
        "content": "日本",
        "userIp": "",
        "postId": "1",
        "createdTime": ""
      }
      // 搜索结果
    }
  },
  methods:{
      save(){
        request.post("/comment/insert", this.test)
            .then(response => {
              console.log(response); // 在控制台中打印响应数据
            })
            .catch(error => {
              console.error(error); // 在控制台中打印错误信息
            });
      },
    //用于向父组件传递值
      getresName(value){
        this.$emit('getresname',value)
      }
  }
}



</script>

<style>

/*解决el-sub-menu的min-width:200px的问题*/
.el-menu--collapse .el-menu .el-submenu, .el-menu--popup{
  min-width: 120px!important;
}
</style>