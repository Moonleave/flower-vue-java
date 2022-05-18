//存储token
export const setToken = (token) => {
  console.log("我是工具类，我设置了TOKEN")
  localStorage.setItem("TOKEN", token);
};
//获取token
export const getToken = () => {
  return localStorage.getItem("TOKEN");
};

//清除本地存储的token
export const removeToken=()=>{
   localStorage.removeItem("TOKEN");
}
