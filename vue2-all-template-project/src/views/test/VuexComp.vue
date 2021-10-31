<template>
  <div>
    <div>{{ title }}</div>
    <div>vuex变量：{{ count }}</div>
  </div>
</template>

<script>
export default {
  name: 'Template',
  data() {
    return {
      title: '黑暗骑士-Vue模板-Vuex演示组件',
    }
  },
  computed: {
    count() {
      return this.$store.state.count
    },
  },
}
</script>
