<template>
  <div id="flowerPurchase">
    <h1>你要购买的鲜花是{{ floName }}</h1>
    <h1>它的价格是{{ floPrice }}</h1>
    <h1>尊敬的 {{ userName }} 你现在有 {{ userMoney }} 元</h1>
    <button @click="purchasy()">点击购买</button>
  </div>
</template>

<script>
import {reqPurchase} from '@/api/index'
export default {
  name: "flowerPurchase",
  data() {
    return {
      userId:this.$store.state.user.userInfo.userId
    };
  },
  computed: {
    userName() {
      return this.$store.state.user.userInfo.userName;
    },
    userMoney() {
      return this.$store.state.user.userInfo.userMoney;
    },
    floName() {
      return this.$route.query.flowerInfo.floName;
    },
    floPrice() {
      return this.$route.query.flowerInfo.floPrice;
    },
  },
  methods: {
    async purchasy() {
      if(this.userMoney>this.floPrice){
        const userName=this.userName
        const cutMoney= this.floPrice
        const data={userName,cutMoney};
        console.log(data)
        let result= await reqPurchase(data);
        console.log("后端结果是:",result)
        alert("你的钱够，管买")
        this.$router.push('/')
        this.$router.go(0)
      }
      else{
        alert("你的钱有点少，先充值吧")
      }
    },
  },
  created() {
    console.log("路由是:", this.$route.query.flowerInfo);
  },
};
</script>

<style>
</style>