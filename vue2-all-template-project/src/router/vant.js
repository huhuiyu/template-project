const routes = [
  {
    path: '/vant',
    name: 'Vant',
    component: () => import('../views/vant/Home.vue'),
  },
  {
    path: '/vant/popup',
    name: 'VantPopup',
    component: () => import('../views/vant/Popup.vue'),
  },
  {
    path: '/vant/cascader',
    name: 'VantCascader',
    component: () => import('../views/vant/Cascader.vue'),
  },
]

export default routes
