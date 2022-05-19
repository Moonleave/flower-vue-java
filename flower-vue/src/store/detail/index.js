import { getUUID } from "@/utils/uuid_token";
import { reqFlowerInfo } from "@/api/index";
const detail = {
    state: {
        // 货物信息
        goodInfo: {
            flowerInfo: {}
        },
        // 有课临时身份
        uuid_token: getUUID()

    },
    mutations: {
        GETFLOWERINFO(state, flowerInfo) {
            state.goodInfo.flowerInfo = flowerInfo;
        }

    },
    actions: {
        async getFlowerInfo({ commit }) {
            let result = await reqFlowerInfo();
            if (result.code == 200) {
                const flowerInfo = { ...result.data.flowerList }
                commit("GETFLOWERINFO", flowerInfo)
            } else {
                console.log("@@响应码为", result.code)
            }
        }

    },
    getters: {

    }
}
export default detail;