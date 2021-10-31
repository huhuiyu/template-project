const routes = [
  {
    path: '/error/404',
    name: 'Error404',
    component: () => import('../views/error/404.vue'),
  },
]

export default routes
