<template>
  <!--    图片高度200px-->
  <div class="index">
    <el-carousel :interval="3000"  autoplay="true"  type="card" height="200px" style=" padding: 20px">
      <el-carousel-item v-for="item in imgList" :key="item.id">
        <img :src="item.idView" class="image" alt="mistake" style="height: 400px">
      </el-carousel-item>
    </el-carousel>
  </div>
<!--走马灯样式-->
</template>

<style>
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>

<script>
export default {
  name: "Carousel",

  components:{
    name :'index',
  },

  data(){
    return{
      imgList: [
        {id:1,idView:'./src/assets/eye1.jpg'},
        {id:2,idView:'./src/assets/eye2.jpg'},
        {id:3,idView:'./src/assets/eye3.jpg'},
      ]
    }
  }
}

</script>