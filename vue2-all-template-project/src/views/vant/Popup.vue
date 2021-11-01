<template>
  <div>
    <div class="pd10 tc"> {{ title }}</div>
    <div class="pd10">
      <van-button type="info" @click="showToast('提示信息')">Toast提示</van-button>

      <van-button type="info" @click="visiable = true">Popup提示</van-button>
    </div>
    <!-- 弹出层 -->
    <div>
      <van-popup v-model="visiable" closeable round position="bottom">
        <div class="popup-info">弹出内容 </div>
      </van-popup>
    </div>
  </div>
</template>

<script>
export default {
  name: 'VantPopup',
  data() {
    return {
      title: '弹出层',
      visiable: false,
    }
  },
  methods: {
    showToast(info) {
      this.$toast.success(info)
    },
  },
}
</script>
<style lang="less" scoped>
.popup-info {
  height: 80vh;
  width: 100vw;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
