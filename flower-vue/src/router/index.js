import Vue from 'vue'
import Router from 'vue-router'

import store from '@/store/index'
import FlowerHome from '@/components/pages/FlowerHome'
import FlowerLogin from '@/components/pages/FlowerLogin'
import FlowerLanguage from '@/components/FlowerLanguage'
import personCenter from '@/components/PersonCenter'
import flowerPurchase from '@/components/FlowerPurchase'
import flowerRegister from '@/components/pages/flowerRegister'
Vue.use(Router)

let router = new Router({
  routes: [
    {
      path: '/',
      component: FlowerHome
    },
    {
      path: '/home',
      component: FlowerHome,
    },
    {
      path: '/login',
      component: FlowerLogin
    },
    {
      path: '/home/flowerLanguage',
      component: FlowerLanguage
    },
    {
      path: '/home/personCenter',
      component: personCenter
    },
    {
      name:'flowerPurchase',
      path:'/home/purchase',
      component:flowerPurchase
    },
    {
      path:'/home/flowerRegister',
      component:flowerRegister
    }
  ]
})

// 全局守卫
router.beforeEach(async (to, from, next) => {
  let token = store.state.user.token;
  let name = store.state.user.userInfo.userName;
  next();
  // 如果有token表示已经登录了，
  if (token) {
    if (to.path == '/login' || to.path == '/register') {
      next('/')
    }
    // 如果登录了并且访问路径不是登录与注册
    // 登录了，并且有用户信息的就放行
    else {
      if (name) {
        next();
      }
      else {
        // 表示登录了，去的不是登录和注册，并且没有用户信息
        try {
          await store.dispatch('getUserInfo');
          next();
        }
        catch (error) {
          // token失效，重新登录
          await store.dispatch('userLout')
          next('/login')
        }

      }

    }
  }
  else {
    // 未登录,不能去交易相关，个人中心，支付相关等
    let toPath = to.path;
  }
})
export default router;