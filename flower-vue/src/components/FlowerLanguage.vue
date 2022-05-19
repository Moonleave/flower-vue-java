<template>
  <div class="flowerLanguage">
    <!-- {{ flowerInfoList }} -->
    <el-table :data="flowerInfoList" style="width: 100%">
      <el-table-column prop="floName" label="鲜花名称" width="150">
      </el-table-column>
      <el-table-column prop="floLanguage" label="鲜花花语" width="500">
      </el-table-column>
      <el-table-column prop="floPrice" label="鲜花价格" width="180">
      </el-table-column>
      <el-table-column prop="floShape" label="鲜花形状" width="150">
      </el-table-column>
      <el-table-column prop="floSeries" label="鲜花系列" width="150">
      </el-table-column>
       <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="danger"
          @click="handlePurchase(scope.$index, scope.row)">购买</el-button>
      </template>
    </el-table-column>
    </el-table>
  </div>
</template>


<script>
import { reqFlowerInfo } from "@/api/index/";
export default {
  name: "FlowerLanguage",
  data() {
    return {
      flowerInfoList: null,
    };
  },
  methods: {
    // async init() {
    //   await this.$store.dispatch("getFlowerInfo");
    //   const result = this.$store.state.detail.goodInfo.flowerInfo;
    //   this.flowerInfo=result
    // },

    getList() {
      reqFlowerInfo()
        .then((response) => {
          // console.log(response.data);
          this.flowerInfoList = response.data.flowerList;
          // console.log(this.flowerInfoList);
        })
        .catch((err) => {});
    },

    handlePurchase(index,row){
      const flowerInfo={...row}
      console.log(flowerInfo)
      this.$router.push({
        name:'flowerPurchase',
        query:{
          flowerInfo:row
        }
      })
    }
  },
  computed: {},
  created() {
    // this.init();
    this.getList();
  },
};
</script>

<style>
body{
}
</style>