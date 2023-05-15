<template>
  <div class="Menu">
    <Menu :dataGet="restaurant"/>
  </div>
  <div class="Carousel">
    <Carousel/>
  </div>
  <div class="Ranking">
      <Exercise/>
  </div>


</template>

<script>
import Menu from "@/components/icons/Menu.vue";
import Carousel from "@/components/icons/Carousel.vue";
import BodyTwo from "@/components/icons/BodyTwo.vue";
import Exercise from "@/components/Exercise1/Exercise1/Exercise.vue";
export default {
  name: "Home",
  components:{
    Menu,
    Carousel,
    BodyTwo,
      Exercise,
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
.Ranking{
    padding-left: 400px;
}

</style>