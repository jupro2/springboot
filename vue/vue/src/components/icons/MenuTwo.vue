
<!--侧边栏，about界面的左边位置-->
<template>
 <div class="el-res-menu">
   <el-col :span="12">

     <el-menu
         style="width: 200px;min-height: calc(1000vh - 50px)"
         default-active="2"
         class="el-menu-vertical-demo"
     >
<!--       小标题！实现自动更改-->
       <h5 class="mb-2" style="font-size: 18px;padding-top: 2px">{{resName}}</h5>

      
           <el-sub-menu index="1">
         <template #title>
           <el-icon><location /></el-icon>
           <span>一楼</span>
         </template> 
          <el-menu-item v-for="(item,key) in getFloodFood.firstFlood" :key="item.id" :index="item.menuUrl" >{{item.name}}</el-menu-item>

       </el-sub-menu>
           

       <el-sub-menu index="2">
         <template #title>
           <el-icon><location /></el-icon>
           <span>二楼</span>
         </template>
         <el-menu-item v-for="(item,key) in getFloodFood.secondFlood" :key="item.id" :index="item.menuUrl" index="2-1">{{item.name}}</el-menu-item>

       </el-sub-menu>

       <el-sub-menu index="3">
         <template #title>
           <el-icon><location /></el-icon>
           <span>三楼</span>
         </template>
         <el-menu-item v-for="(item,key) in getFloodFood.thirdFlood" :key="item.id" :index="item.menuUrl" index="3-1">{{item.name}}</el-menu-item>
       </el-sub-menu>

 

    

     </el-menu>
   </el-col>
 </div>
</template>

<script>
export default {
  props:{
    resName: String,
    // firstFlood: {
    //         type: Array,
    //         required: true
    //     },
    // secondFlood: {
    //         type: Array,
    //         required: true
    //     } ,   
    //  thirdFlood:{
    //         type:Array,
    //         required:true
    //  },
     getFloodFood:{
            type:Array,
            required:true
     } 
  },


  data(){
    return{
      search :'',
      // 搜索结果
    }
  },
  name: "MenuTwo",
}


</script>

<style>

</style>