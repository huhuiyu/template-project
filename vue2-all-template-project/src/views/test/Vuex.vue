<template>
  <div>
    <div> {{ title }}</div>
    <hr />
    <div>
      {{ count }}
      <button @click="changeCount">修改变量</button>
      <button @click="changeCountAction">延时修改变量</button>
      <span>{{ info }}</span>
    </div>
    <hr />
    <vuex-comp></vuex-comp>
  </div>
</template>

<script>
import VuexComp from './VuexComp.vue'
export default {
  components: { VuexComp },
  name: 'TestVuex',
  data() {
    return {
      title: '黑暗骑士-Vue模板Vuex功能演示',
      info: '',
    }
  },
  methods: {
    changeCount() {
      this.info = ''
      this.$store.commit('changeCount', 2)
    },
    changeCountAction() {
      let app = this
      this.$store
        .dispatch('changeCount', 3)
        .then(function () {
          app.info = '延时修改完成'
        })
        .catch(function () {
          app.info = '延时修改失败'
        })
    },
  },
  computed: {
    count() {
      return this.$store.state.count
    },
  },
}
</script>
