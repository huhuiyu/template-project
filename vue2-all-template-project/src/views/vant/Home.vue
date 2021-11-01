<template>
  <div>
    <div class="pd10 tc">{{ title }}</div>
    <div class="pd10">
      <van-button type="primary" @click="toPage('/vant/popup')">弹出层</van-button>
      <van-button type="primary" @click="toPage('/vant/cascader')">级联</van-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Vant',
  data() {
    return {
      title: '有赞ui-vue2，请在手机模式下查看',
    }
  },
  methods: {
    toPage(url) {
      this.$router.push(url)
    },
  },
}
</script>
