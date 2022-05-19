<template>
  <div id="out">
    <div class="register-box" id="flowerRegister">
      <div class="owl" id="owl">
        <div class="hand"></div>
        <div class="hand hand-r"></div>
        <div class="arms">
          <div class="arm"></div>
          <div class="arm arm-r"></div>
        </div>
      </div>
      <div class="input-box">
        <!-- 注册的用户名 -->
        <input
          type="text"
          placeholder="请输入注册的用户名"
          v-model="RegisterUsername"
        />

        <!-- 注册的密码 -->
        <input
          type="password"
          placeholder="请输入注册的密码"
          class="password"
          v-model="RegisterUserpassword"
        />
        <!-- 确认注册的密码 -->
        <input
          type="password"
          placeholder="确认密码"
          class="password"
          v-model="RegisterUserpassword2"
        />
        <!-- 手机号 -->
        <input
          type="text"
          placeholder="请输入注册的手机号"
          v-model="RegisterUserNumber"
          @keyup.enter="handleRegister"
        />
        <!-- 注册处理按钮 -->
        <button @click="handleRegister">登录</button>
      </div>
    </div>
  </div>
</template>

<script>
import { reqUserRegister } from "@/api";
import $ from "jquery";
$(function () {
  $(".password")
    .focus(function () {
      // 密码框获得焦点，追加样式.password
      $("#owl").addClass("password");
    })
    .blur(function () {
      // 密码框失去焦点，移除样式.password
      $("#owl").removeClass("password");
    });
});
export default {
  name: "flowerRegister",
  data() {
    return {
      RegisterUsername: "",
      RegisterUserpassword: "",
      RegisterUserpassword2: "",
      RegisterUserNumber: "",
    };
  },

  mounted() {
    console.log("Register组件挂载完毕了", this);
  },
  methods: {
    handleRegister() {
      if (this.RegisterUsername === "") {
        alert("输入的用户名为空");
      }
      if (this.RegisterUserpassword === "") {
        alert("输入密码不能为空");
      }
      if (this.RegisterUserNumber === "") {
        alert("输入的手机号为空");
      }
      if (this.RegisterUserpassword != this.RegisterUserpassword2) {
        alert("两次密码输入不一样");
      }
      console.log("验证通过");
      const data = {
        userName: this.RegisterUsername,
        password: this.RegisterUserpassword,
        phonenumber: this.RegisterUserNumber,
      };
      reqUserRegister(data)
        .then((res) => {
          console.log("后端传来", res);
          alert("恭喜你注册成功");
          this.$router.push("/");
        })
        .catch((err) => {
          alert(err);
        });
    },
  },
};
</script>


<style scope>
#out {
  /* 100%窗口高度 */
  height: 100vh;
  /* 弹性布局 居中 */
  display: flex;
  justify-content: center;
  align-items: center;
  /* 渐变背景 */
  background: linear-gradient(200deg, #72afd3, #96fbc4);
}
.register-box {
  /* 相对定位 */
  position: relative;
  width: 320px;
}
.input-box {
  /* 弹性布局 垂直排列 */
  display: flex;
  flex-direction: column;
}
.input-box input {
  height: 40px;
  border-radius: 3px;
  /* 缩进15像素 */
  text-indent: 15px;
  outline: none;
  border: none;
  margin-bottom: 15px;
}
.input-box input:focus {
  outline: 1px solid lightseagreen;
}
.input-box button {
  border: none;
  height: 45px;
  background-color: lightseagreen;
  color: #fff;
  border-radius: 3px;
  cursor: pointer;
}
/* 接下来是猫头鹰的样式 */
.owl {
  width: 211px;
  height: 108px;
  /* 背景图片 */
  background: url("../../static/images/owl-login.png") no-repeat;
  /* 绝对定位 */
  position: absolute;
  top: -100px;
  /* 水平居中 */
  left: 50%;
  transform: translateX(-50%);
}
.owl .hand {
  width: 34px;
  height: 34px;
  border-radius: 40px;
  background-color: #472d20;
  /* 绝对定位 */
  position: absolute;
  left: 12px;
  bottom: -8px;
  /* 沿Y轴缩放0.6倍（压扁） */
  transform: scaleY(0.6);
  /* 动画过渡 */
  transition: 0.3s ease-out;
}
.owl .hand.hand-r {
  left: 170px;
}
.owl.password .hand {
  transform: translateX(42px) translateY(-15px) scale(0.7);
}
.owl.password .hand.hand-r {
  transform: translateX(-42px) translateY(-15px) scale(0.7);
}
.owl .arms {
  position: absolute;
  top: 58px;
  width: 100%;
  height: 41px;
  overflow: hidden;
}
.owl .arms .arm {
  width: 40px;
  height: 65px;
  position: absolute;
  left: 20px;
  top: 40px;
  background: url("../../static/images/owl-login-arm.png") no-repeat;
  transform: rotate(-20deg);
  transition: 0.3s ease-out;
}
.owl .arms .arm.arm-r {
  transform: rotate(20deg) scaleX(-1);
  left: 158px;
}
.owl.password .arms .arm {
  transform: translateY(-40px) translateX(40px);
}
.owl.password .arms .arm.arm-r {
  transform: translateY(-40px) translateX(-40px) scaleX(-1);
}
</style>