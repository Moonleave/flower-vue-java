<template>
  <div id="FlowerHome">
    <div id="dowebok" class="normal">
      <div class="head_top">
        <!-- 首部 -->
        <div class="head">
          <div>
            <!-- 首部图片 -->
            <img src="@/static/images/logo-w.png" class="logo_white logo_w" />
          </div>
          <!-- 首部导航栏 -->
          <ul id="menu" class="menu menu1">
            <li>
              <a id="brandPage" class="menua" href="javascript:;"
                ><span class="c-menu__inner">首页</span></a
              >
            </li>
            <li>
              <a @click="RouterLanguage" id="explorePage" class="menua" href="javascript:;"
                ><span class="c-menu__inner">探索花海</span></a
              >
            </li>
            <li>
              <a class="menua" href="javascript:;"
                ><span class="c-menu__inner">花的艺术</span></a
              >
            </li>
            <li v-if="!userName">
              <a @click="RouterLogin" class="menua" href="javascript:;"
                ><span class="c-menu__inner">登录</span></a
              >
            </li>
            <li v-if="userName" id="userNameBoder">
              <a @click="RouterPersonCenter" class="menua" href="javascript:;"
                ><span class="c-menu__inner">{{ userName }}</span></a
              >
            </li>
          </ul>
          <div class="showmenu2"></div>
        </div>
      </div>
      <!-- head_top结束 -->
      <div class="section active">
        <video
          id="sec_video"
          class="section_vedio"
          src="@/static/video/video1.mp4"
          poster="@/static/images/1.jpg"
          autoplay="autoplay"
          preload="auto"
          loop="loop"
        ></video>
        <div id="brand0" class="brand brand_w tranY tranX">
          <!-- 用鲜花点亮生活 -->
          <img id="word0" class="w" src="@/static/images/center-text.png" />
          <a class="visite btn button btnw" href="/"
            >点亮世界<span></span><span></span
          ></a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "FlowerHome",
  methods: {
    // 点击登录按钮跳转到登录页面
    RouterLogin() {
      // console.log("RouterLogin正在执行，准备跳转到登录页，跳转路径为：/login");
      this.$router.push("/login");
      console.log("跳转login正常");
    },
    RouterLanguage(){
      // console.log("RouterLanguage正在执行，准备跳转到花海世界，跳转路径为：/home/flowerLanguage")
      this.$router.push("/home/flowerLanguage");
      console.log("跳转正常");

    },
    RouterPersonCenter(){
this.$router.push("/home/personCenter")
    },
    toHome() {
      this.$router.push("/");
    },
  },
  mounted() {
    // 这些已经加到全局守卫路由中了
    // 一挂载就获取用户信息
    // this.$store.dispatch("getUserInfo");
    // console.log("终于获得了数据", this.$store.state.user);
  },
  computed: {
    userName() {
      return this.$store.state.user.userInfo.userName;
    },
  },
};
</script>

<style scode>
#userNameBoder {
  border: 1px white solid;
}
.story_vedio {
  width: 100%;
}
.head,
.small_menu,
.hoverhj {
  font-size: 14px;
  transition: all 0.3s;
  -webkit-transition: all 0.3s;
}
.head {
  width: 100%;
  height: 93px;
  position: fixed;
  z-index: 30;
  background: transparent;
}
@media screen and (max-width: 1400px) {
  .head {
    font-size: 12px;
  }
}
.small_menu {
  background: #fff;
  height: 68px;
}
.hoverhj {
  background: #fff;
}
.menu {
  margin-right: 46px;
  margin-top: 42px;
  float: right;
  list-style-type: none;
  z-index: 70;
}
.menu1 {
  display: flex;
  display: -webkit-flex;
  align-items: center;
  -webkit-align-items: center;
}

.fadeRight {
  right: 0;
  transition: right 0.3s cubic-bezier(0.42, 0, 1, 1);
}
.menu > li {
  padding: 0 39px;
  letter-spacing: 4px;
  height: 50px;
  line-height: 50px;
}
.small_menu .menu {
  margin-top: 17px;
}
.menua {
  text-decoration: none;
  color: #fff;
  transition: all 0.2s ease-in-out;
  display: block;
}
.small_menu .menua,
.hoverhj .menua {
  color: #666;
}
.small_menu .menua:hover,
.hoverhj .menua:hover {
  color: #000;
}
.small_menu .logo_white {
  top: 17px;
  width: 123px;
}
.c-menu__inner {
  position: relative;
}
.hoverhj .c-menu__inner::before {
  background: rgba(0, 0, 0, 1);
}
.c-menu__inner::before {
  content: "";
  position: absolute;
  bottom: -17px;
  left: 0;
  width: 100%;
  height: 2px;
  background: rgba(255, 255, 255, 1);
  -o-transform: scale(0, 1);
  -webkit-transform: scale(0, 1);
  transform: scale(0, 1);
  -webkit-transition: -webkit-transform 0.3s ease;
  -o-transition: transform 0.3s ease;
  transition: transform 0.3s ease, -webkit-transform 0.3s ease;
  -webkit-transform-origin: right center;
  -o-transform-origin: right center;
  transform-origin: right center;
}
.menua:hover .c-menu__inner::before {
  -webkit-transform-origin: left center;
  -o-transform-origin: left center;
  transform-origin: left center;
  -webkit-transform: scale(1, 1);
  -o-transform: scale(1, 1);
  transform: scale(1, 1);
}
.menu .current .c-menu__inner::before {
  -webkit-transform-origin: left center;
  -o-transform-origin: left center;
  transform-origin: left center;
  -webkit-transform: scale(1, 1);
  -o-transform: scale(1, 1);
  transform: scale(1, 1);
}
.small_menu .c-menu__inner::before {
  background: rgba(0, 0, 0, 1);
}
.logo_white {
  position: absolute;
  top: 43px;
  left: 62px;
  list-style-type: none;
  width: 178px;
  z-index: 70;
  transition: all 0.3s;
  -webkit-transition: all 0.3s;
}
.logo_w {
  opacity: 1;
}
.small_menu .logo_w,
.hoverhj .logo_w {
  opacity: 0;
}
.logo_b {
  opacity: 0;
}
.small_menu .logo_b,
.hoverhj .logo_b {
  opacity: 1;
}
.under_menu {
  width: 100%;
  min-width: 900px;
  position: absolute;
  top: 93px;
  left: 0;
  background: #fff;
  height: 0px;
  box-sizing: border-box;
  overflow: hidden;
  letter-spacing: 3px;
  opacity: 1;
  transition: all 0.3s cubic-bezier(0.39, 0.315, 0.6, 0.2);
}
.under_img {
  width: 320px;
  height: 200px;
  float: right;
  margin-top: 90px;
  margin-right: 250px;
}

.under_ul {
  color: #666;
  letter-spacing: 3px;
  float: right;
  margin-top: 90px;
  padding-left: 40px;
  border-left: #666 solid 1px;
  margin-right: 12%;
}
.under_ul li {
  margin-bottom: 32.5px;
  line-height: 1;
}
.under_ul li a {
  color: #666;
}
.under_ul li:hover a {
  color: #000;
}
.under_ul li:first-child {
  color: #000;
}
.under_ul li:last-child {
  margin-bottom: 0;
}
.small_menu .under_menu {
  top: 68px;
}
.small_menu .under_menu {
  color: #000000;
  background: #fff;
}
/*.small_menu .under_menu li a{
    color: #000;
}*/
.under_menu_show {
  opacity: 1;
  height: 375px;
  transition: all 0.3s cubic-bezier(0.39, 0.315, 0.6, 0.2);
  visibility: visible;
}
@media screen and (max-width: 1400px) {
  .under_img {
    width: 304px;
    height: 190px;
    margin-right: 50px;
  }
  .under_ul {
    margin-right: 5%;
  }
}
@media screen and (max-width: 1400px) {
  .head {
    font-size: 12px;
  }
  .menu > li {
    padding: 0 20px;
  }
}
@media screen and (max-width: 900px) {
  .menu > li {
    padding: 0 10px;
  }
  .menu1 {
    display: none;
  }
}
.bar {
  position: fixed;
  top: 65%;
  right: 20px;
  z-index: 99;
}

.bar_box li {
  width: 66px;
  height: 75px;
  position: relative;
}

.bar_box li:hover .code {
  display: block;
}

/* 后面是common */
img {
  width: 100%;
  vertical-align: middle;
}
a {
  cursor: pointer;
  text-decoration: none;
}
li {
  list-style: none;
}
::-webkit-scrollbar {
  display: none;
}
body {
  font-family: "PingFang SC";
}
.tranY {
  transform: translateY(-50%);
  -webkit-transform: translateY(-50%);
  -moz-transform: translateY(-50%);
  -o-transform: translateY(-50%);
}
.tranX {
  transform: translateX(-50%);
  -webkit-transform: translateX(-50%);
  -moz-transform: translateX(-50%);
  -o-transform: translateX(-50%);
}
.f12 {
  font-size: 12px;
}
.f14 {
  font-size: 14px;
}
.f16 {
  font-size: 16px;
}
.f18 {
  font-size: 18px;
}
.f24 {
  font-size: 24px;
}
.f32 {
  font-size: 32px;
}
.f36 {
  font-size: 36px;
}
@media screen and (max-width: 1400px) {
  .f14 {
    font-size: 12px;
  }
  .f16 {
    font-size: 14px;
  }
  .f18 {
    font-size: 16px;
  }
  .f24 {
    font-size: 18px;
  }
  .f32 {
    font-size: 26px;
  }
  .f36 {
    font-size: 30px;
  }
}
@media screen and (max-width: 900px) {
  .f14 {
    font-size: 10px;
  }
  .f16 {
    font-size: 12px;
  }
  .f18 {
    font-size: 14px;
  }
  .f24 {
    font-size: 16px;
  }
  .f32 {
    font-size: 24px;
  }
  .f36 {
    font-size: 20px;
  }
}
@media screen and (max-width: 1600px) {
  .f24 {
    font-size: 18px;
  }
}

/* 底部 */
.foot {
  height: 70vh;
  position: relative;
  min-width: 1100px;
  min-height: 400px;
}
.foot_top {
  border-top: #666 solid 1px;
  border-bottom: #666 solid 1px;
  padding: 0 10%;
  height: 12vh;
  background: #fff;
}
.foot_top ul {
  width: 100%;
  height: 100%;
  display: flex;
  display: -webkit-flex;
  display: -moz-flex;
  justify-content: flex-start;
  -webkit-justify-content: flex-start;
  -moz-justify-content: flex-start;
  flex-direction: row;
  -webkit-flex-direction: row;
  -moz-flex-direction: row;
  align-items: center;
  -webkit-align-items: center;
  -moz-align-items: center;
}
.foot_top ul li {
  width: 25%;
  display: flex;
  display: -webkit-flex;
  display: -moz-flex;
  height: 60px;
}
@media screen and (max-width: 1400px) {
  .fimg {
    background-size: auto 90%;
  }
}
.foot_top ul li div:last-child {
  color: #000000;
  float: left;
  letter-spacing: 3px;
  line-height: 28px;
  text-align: center;
  padding-top: 5px;
  padding-left: 15px;
  white-space: nowrap;
}
.foot_body {
  height: 41vh;
  min-height: 260px;
  background: #fff;
  overflow: hidden;
  border-bottom: #666 solid 0.5px;
  display: flex;
  display: -webkit-flex;
  display: -o-flex;
  align-items: center;
  -webkit-align-items: center;
  -o-align-items: center;
}
.forflex {
  display: flex;
  display: -webkit-flex;
  display: -o-flex;
  align-items: flex-start;
  -webkit-align-items: flex-start;
  -o-align-items: flex-start;
  width: 100%;
}
.totop {
  position: absolute;
  top: 57%;
  right: 0%;
  width: 10%;
  text-align: center;
  cursor: pointer;
  color: #000;
  letter-spacing: 4px;
}
.totopAnimate {
  animation: fadeInUp 1s 0.2s ease both;
  -webkit-animation: fadeInUp 1s 0.2s ease both;
  -moz-animation: fadeInUp 1s 0.2s ease both;
}
.totop img {
  width: 25px;
  height: 25px;
  margin-bottom: 13px;
  transform: translateY(0%);
  -webkit-transform: translateY(0%);
  -moz-transform: translateY(0%);
  transition: all 800ms ease;
  -moz-transition: all 800ms ease;
  -webkit-transition: all 800ms ease;
}
.totop:hover img {
  transform: translateY(-30%);
  -webkit-transform: translateY(-30%);
  -moz-transform: translateY(-30%);
}
@keyframes fadeInUp {
  0% {
    opacity: 0;
    transform: translateY(20px);
  }
  100% {
    opacity: 1;
    transform: translateY(0);
  }
}

@-webkit-keyframes fadeInUp {
  0% {
    opacity: 0;
    -webkit-transform: translateY(20px);
  }
  100% {
    opacity: 1;
    -webkit-transform: translateY(0);
  }
}
.foot_bottom {
  height: 17vh;
  background: #fff;
}
.foot_bottom a {
  color: #000;
  padding: 0 6px;
}
.foot_bottom a:hover {
  text-decoration: underline;
}
.foot_left {
  width: 25%;
  float: left;
  padding-left: 6%;
  box-sizing: border-box;
}
.foot_logo {
  width: 55%;
  display: block;
  margin-bottom: 55px;
}
.contact {
  width: 24%;
  float: left;
  color: #000;
  padding-left: 3%;
  box-sizing: border-box;
  letter-spacing: 2px;
  display: flex;
  display: -webkit-flex;
  display: -moz-flex;
  display: -o-flex;
}
.gzhewm {
  width: 35%;
  min-width: 115px;
  text-align: center;
  margin-right: 9%;
  line-height: 20px;
}
.contactus {
  min-width: 150px;
}
.foot_middle {
  float: left;
  width: 35%;
  padding: 0 7.5%;
  display: flex;
  display: -webkit-flex;
  border-right: #666 solid 1px;
  border-left: #666 solid 1px;
  justify-content: space-around;
}
.conimg {
  width: 40px;
  opacity: 0.6;
  margin-right: 6.26%;
  display: inline-block;
  transition: all 800ms ease;
  -moz-transition: all 800ms ease;
  -webkit-transition: all 800ms ease;
}
.conimg:hover {
  opacity: 1;
}
.conimg:last-child {
  margin-right: 0;
}
.contact p:nth-child(2) {
  margin-top: 11px;
  margin-bottom: 5px;
}
.contact p:nth-child(3) {
  margin-bottom: 55px;
  font-weight: bold;
}
.foot_body ul {
  color: #666;
  line-height: 30px;
  letter-spacing: 3px;
  width: 100px;
}
.foot_body ul li a {
  color: #666;
}
.foot_body ul li:hover a {
  color: #000;
}
.foot_body ul li:first-child {
  padding-bottom: 18px;
  border-bottom: 1px solid #000;
  margin-bottom: 18px;
  font-weight: bold;
  color: #000;
  display: inline-block;
}
.foot_bottom {
  color: #000;
  letter-spacing: 3px;
  text-align: center;
  line-height: 28px;
  display: -webkit-box;
  display: -moz-flexbox;
  display: flex;
  justify-content: center;
  -webkit-justify-content: center;
  -moz-justify-content: center;
  -webkit-align-items: center;
  -moz-align-items: center;
  align-items: center;
  -webkit-align-items: center;
  -moz-align-items: center;
}

.popup {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 11;
  display: none;
}
.popcontent {
  position: absolute;
  top: 15%;
  left: 50%;
  width: 20%;
  min-width: 240px;
  transform: translateX(-50%);
}
.mask {
  background: rgba(0, 0, 0, 0.7);
  width: 100%;
  height: 100%;
}
.popshow {
  -webkit-animation: showBoxAnimate 0.35s ease;
  animation: showBoxAnimate 0.35s ease;
  display: block !important;
}
@-webkit-keyframes showBoxAnimate {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}
@keyframes showBoxAnimate {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}
</style>