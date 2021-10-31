let routes = []
// build的时候忽略test相关路由
if (process.env.NODE_ENV !== 'production') {
  routes.push({
    path: '/test',
    name: 'Test',
    component: () => import('../views/test/Home.vue'),
  })
  routes.push({
    path: '/test/ajax',
    name: 'TestAjax',
    component: () => import('../views/test/Ajax.vue'),
  })
  routes.push({
    path: '/test/vuex',
    name: 'TestVuex',
    component: () => import('../views/test/Vuex.vue'),
  })
}

export default routes
