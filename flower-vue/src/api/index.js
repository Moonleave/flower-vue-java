import requests from "@/api/ajax";

// axios发送请求返回结果Promise对象
// export const testGetDataHello =()=>{
//     return requests({url:'/userservice/hello',method:'get'})
// }

// 登录  URL:http://localhost:8081/api/user/login
export const reqUserLogin = (data) => requests({ url: 'http://localhost:8081/api/user/login', data, method: 'post' })


//退出登录
//URL:http://localhost:8081/api/user/logout  get
export const reqLogout = ()=> requests({url:'http://localhost:8081/api/user/logout',method:'get'});


//根据token获取到用户的信息
export const reqUserInfo = () => requests({ url: 'http://localhost:8081/api/user/auth/getUserInfo', method: 'get'})
