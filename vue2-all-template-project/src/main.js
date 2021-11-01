import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// 插件导入
import myplugins from './plugins/myplugins'
Vue.use(myplugins)
// 过滤器导入
import './filters/myfilters'

// 有赞ui
import Vant from 'vant'
import 'vant/lib/index.css'

Vue.use(Vant)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app')
