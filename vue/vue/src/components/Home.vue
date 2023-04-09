<template>
  <div class="Menu">
    <Menu/>
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
  }
}
</script>

<style>

</style>