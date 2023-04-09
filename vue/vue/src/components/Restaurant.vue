<template>

  <Menu/>
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
  }
}
</script>

<style >
.BodyTwo{
  text-align: center;
}
</style>