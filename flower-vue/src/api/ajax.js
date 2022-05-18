import axios from "axios";
import nprogress from 'nprogress'
import "nprogress/nprogress.css";

import store from '@/store'
let requests = axios.create({
  //基础路径
  // baseURL: "/api",
  //请求不能超过5S
  timeout: 5000,
});

//请求拦截器----在项目中发请求（请求没有发出去）可以做一些事情
requests.interceptors.request.use((config) => {
  // 这个和detail有关
  // 如果detail的仓库里有临时身份
  if (store.state.detail.uuid_token) {
    // 给请求头添加一个字段(给后端传递一个信息，userTempId商量好)
    config.headers.userTempId = store.state.detail.uuid_token;
  }
  // 这个与user有关
  if (store.state.user.token) {
    // 给请求头添加token
    config.headers.token = store.state.user.token;
  }
  if (localStorage.getItem('TOKEN')) {
    console.log("我拦截器准备设置token头了")
    config.headers.token = localStorage.getItem('TOKEN')
  }


  nprogress.start();
  return config;
})

//响应拦截器----当服务器手动请求之后，做出响应（相应成功）会执行的
requests.interceptors.response.use((res) => {


  nprogress.done();
  return res.data;
}, (err) => {
  // 响应失败回调函数
  return Promise.reject(new Error('faile'))
})


export default requests;