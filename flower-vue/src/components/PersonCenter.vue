<template>
  <div id="PersonCenter">
    <h1>PersonCenter</h1>
    <h1>用户名：{{this.$store.state.user.userInfo.userName}}</h1>
    <h1>用户余额：{{this.$store.state.user.userInfo.userMoney}}</h1>
    <h1>用户电话号：{{this.$store.state.user.userInfo.phoneNumber}}</h1>
    <button @click="logout">点击退出登录</button>
  </div>
</template>

<script>
export default {
  name: "PersonCenter",
  methods: {
    async logout() {
      try {
        await this.$store.dispatch("userLogout"); //回到首页
        this.$router.push("/home");
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style>
</style>