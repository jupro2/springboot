<template>
  <div class="Menu">
    <Menu :dataGet="restaurant"/>
  </div>
  <div class="Carousel">
    <Carousel/>
  </div>


</template>

<script>
import Menu from "@/components/icons/Menu.vue";
import Carousel from "@/components/icons/Carousel.vue";
import BodyTwo from "@/components/icons/BodyTwo.vue";
export default {
  name: "Home",
  components:{
    Menu,
    Carousel,
    BodyTwo,
  },
    data(){
      return{
          restaurant :[
              {id:2,name:"雅苑",menuUrl:"/About"},
              {id:1,name:"楠苑",menuUrl: "/About"},
              {id:3,name:"湖苑",menuUrl: "/About"},
          ],
        }
    }

}
</script>

<style>

</style>