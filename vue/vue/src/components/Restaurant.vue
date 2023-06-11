<template>
  <Menu :dataGet="dataGet" @getresname="handetresName" />
  <div class="common-layout">
    <el-container>
        <el-aside >
          <MenuTwo :res-name="getresname" 
         :getFloodFood="getFloodFood"/>
        </el-aside>
        <el-main><BodyTwo/></el-main>
    </el-container>
  </div>


</template>

<script>
import MenuTwo from "@/components/icons/MenuTwo.vue";
import Menu from "@/components/icons/Menu.vue";
import BodyTwo from "@/components/icons/BodyTwo.vue";
import { method } from "lodash";


export default {
  name: "Restaurant",
  components:{
    MenuTwo,
    Menu,
    BodyTwo,
  },


  data(){
      return{
          getresname:'',
          dataGet :[
              {id:2,name:"雅苑",menuUrl:"/About"},
              {id:1,name:"楠苑",menuUrl: "/About"},
              {id:3,name:"湖苑",menuUrl: "/About"},
          ],
          
    getFloodFood: {
      firstFlood: [
        { id: 1, name: "茶泡饭",menuUrl:"/About/test" },
        { id: 2, name: "鸡排饭",menuUrl:"/About" },
        { id: 3, name: "掉渣饼",menuUrl:"/About" }
      ],
      secondFlood: [
        { id: 4, name: "茶泡饭2",menuUrl:"/About"},
        { id: 5, name: "鸡排饭2",menuUrl:"/About"},
        { id: 6, name: "掉渣饼2",menuUrl:"/About" }
      ],
      thirdFlood: [
        { id: 7, name: "茶泡饭3",menuUrl:"/About" },
        { id: 8, name: "鸡排饭3",menuUrl:"/About" },
        { id: 9, name: "掉渣饼3",menuUrl:"/About"}
      ]
      
    }
  }
},
  methods:{
        handetresName(value){
            this.getresname=value
            console.log(value)
        }
      }





}
      
</script>

<style >
.BodyTwo{
  text-align: center;
}
</style>