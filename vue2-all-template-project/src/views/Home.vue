<template>
  <div class="links tc">
    <span @click="toPage('/vant')">有赞ui首页</span>
    <span @click="toPage('/test')">测试首页</span>
    <span @click="toPage('/nopage')">路由错误测试</span>
  </div>
</template>

<script>
export default {
  name: 'Template',
  data() {
    return {
      title: '黑暗骑士-Vue模板项目首页',
    }
  },
  methods: {
    toPage(path) {
      this.$router.push(path)
    },
  },
}
</script>
<style lang="less" scoped>
@btn-main-color: #dcdcdc;
.links {
  padding: 1rem;
  span {
    margin: 0.2rem;
    display: inline-block;
    padding: 0.5rem 1rem;
    border: 1px solid @btn-main-color;
    border-radius: 0.5rem;
    cursor: pointer;
    &:hover {
      background-color: @btn-main-color;
    }
  }
}
</style>
