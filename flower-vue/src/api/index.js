import requests from "@/api/ajax";

// axios发送请求返回结果Promise对象
// export const testGetDataHello =()=>{
//     return requests({url:'/userservice/hello',method:'get'})
// }

// 登录  URL:http://localhost:8081/api/user/login
export const reqUserLogin = (data) => requests({ url: 'http://localhost:8081/api/user/login', data, method: 'post' })


//注册   URL:http://localhost:8081/api/user/register
export const reqUserRegister = (data) => requests({ url: 'http://localhost:8081/api/user/register', data, method: 'post' })


//退出登录
//URL:http://localhost:8081/api/user/logout  get
export const reqLogout = () => requests({ url: 'http://localhost:8081/api/user/logout', method: 'get' });


//根据token获取到用户的信息
export const reqUserInfo = () => requests({ url: 'http://localhost:8081/api/user/auth/getUserInfo', method: 'get' })

//获取鲜花信息
export const reqFlowerInfo = () => requests({ url: 'http://localhost:8082/api/flower/getAllFlowerInfo', method: 'get' })

//购买业务
export const reqPurchase = (data) => requests({ url: 'http://localhost:8081/api/user/auth/PurchaseByUserNameAndCutMoney', params:data, method: 'get' })