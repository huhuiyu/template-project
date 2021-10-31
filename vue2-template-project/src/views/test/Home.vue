<template>
  <div>
    <div class="tc">
      {{ title }}
    </div>
    <div class="links tc">
      <span @click="toPage('/test/ajax')">ajax测试</span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Test',
  data() {
    return {
      title: '黑暗骑士-Vue模板项目测试页',
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
