import Vue from 'vue'
import VueRouter from 'vue-router'
import test_router from '../router/test'
import error_router from '../router/error'

Vue.use(VueRouter)

// 错误的路由一定要在最后
const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/Home.vue'),
  },
]
  .concat(test_router)
  .concat(error_router)
  .concat({
    path: '*',
    redirect: '/error/404',
  })

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
})

export default router
