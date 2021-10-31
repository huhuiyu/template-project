import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count: 1,
  },
  mutations: {
    changeCount(state, amount) {
      state.count = state.count + amount
    },
  },
  actions: {
    changeCount(context, amount) {
      let promise = new Promise(function (resolve, reject) {
        try {
          setTimeout(function () {
            context.commit('changeCount', amount)
            resolve()
          }, 2000)
        } catch (ex) {
          reject(ex)
        }
      })
      return promise
    },
  },
  modules: {},
})
