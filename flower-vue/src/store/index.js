import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex);

import user from '@/store/User/index.js'

import detail from '@/store/detail/index.js'

export default new Vuex.Store({
    modules:{
        user,
        detail,
    }
})