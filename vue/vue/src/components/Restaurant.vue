<template>
  <Menu :dataGet="dataGet"/>
  <div class="common-layout">
    <el-container>
        <el-aside ><MenuTwo/></el-aside>
        <el-main><BodyTwo/></el-main>
    </el-container>
  </div>


</template>

<script>
import MenuTwo from "@/components/icons/MenuTwo.vue";
import Menu from "@/components/icons/Menu.vue";
import BodyTwo from "@/components/icons/BodyTwo.vue";


export default {
  name: "Restaurant",
  components:{
    MenuTwo,
    Menu,
    BodyTwo,
  },

  data(){
      return{
          resName:'',
          dataGet :[
              {id:2,name:"雅苑",menuUrl:"/About"},
              {id:1,name:"楠苑",menuUrl: "/About"},
              {id:3,name:"湖苑",menuUrl: "/About"},
          ],
      }
  }
}
</script>

<style >
.BodyTwo{
  text-align: center;
}
</style>