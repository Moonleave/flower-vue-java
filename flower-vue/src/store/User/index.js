import { reqUserLogin, reqUserInfo  ,reqLogout} from "@/api/index";
import { setToken, removeToken } from '@/utils/token';
// user小仓库
const user = {
    // state:仓库存储数据的地方
    state: {
        // token: '',
        token: localStorage.getItem('TOKEN') ? localStorage.getItem('TOKEN') : '',
        userInfo: {}
    },
    // mutations:修改state的唯一手段
    mutations: {
        USERLOGIN(state, token) {
            state.token = token;
            // console.log("我准备设置token了")
            // localStorage.setItem('TOKEN',token)
        },
        GETUSERINFO(state, userInfo) {
            state.userInfo = userInfo;
        },
        CLEAR(state) {
            state.token = '';
            state.userInfo = {};
            //本地存储数据清空
            removeToken();

        }
    },
    // action:处理action，可以书写自己的业务逻辑，也可以处理异步
    actions: {
        // 登录
        async userLogin({ commit }, data) {
            // console.log("前端登录请求发送出去了")
            let result = await reqUserLogin(data);
            // console.log("后端传来的结果是：", result)
            if (result.code == 200) {
                // console.log("响应码为200")
                // console.log("result.data=",result.data)
                // console.log("result.data.token=", result.data.token)
                commit("USERLOGIN", result.data.token);
                // console.log("user-token已经设置完毕了")
                // console.log("准备向localstorage设置token")
                setToken(result.data.token)
            }
            else {
                // console.log("出错了!", result.data.code, "错误，原因:", result.data.data.message)
                return Promise.reject(new Error("faile"))
            }
        },
        // 退出登录
        async userLogout({ commit }) {
            //只是向服务器发起一次请求，通知服务器清除token
            let result = await reqLogout();
            //action里面不能操作state，提交mutation修改state
            if (result.code == 200) {
                commit("CLEAR");
                return 'ok';
            } else {
                return Promise.reject(new Error('faile'));
            }

        },
        //获取用户信息
        async getUserInfo({ commit }) {
            let result = await reqUserInfo();
            // console.log("我是js,我得到的用户信息result=", result)
            // console.log("result.code=", result.code)
            if (result.code == 200) {
                const userInfo = { ...result.data.userInfo }
                // console.log("我是js,我得到的数据result.userInfo=", userInfo)
                // console.log("我准备提交给仓库userInfo")
                commit("GETUSERINFO", userInfo);
                return userInfo;
            }
            else {
                return Promise.reject(new Error('faile'));
            }
        }

    },
    // getters:理解为计算属性，用于简化仓库数据，让组件获取仓库的数据更加方便
    getters: {},
}

export default user;