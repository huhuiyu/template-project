<template>
  <div>
    <div class="pd10 tc"> {{ title }}</div>
    <div class="pd10">
      <van-button type="info" @click="showToast('提示信息')">Toast提示</van-button>
      <van-button type="info" @click="visiable = true">Popup提示</van-button>
      <van-button type="info" @click="showDialog('确认对话框', '确认')">对话框</van-button>
      <van-button type="info" @click="showDialog('这是一个消息')">对话框组件</van-button>
      <van-button type="info" @click="showCallbackDialog()">异步关闭对话框</van-button>
    </div>
    <!-- 弹出层 -->
    <div>
      <van-popup v-model="visiable" closeable round position="bottom">
        <div class="popup-info">弹出内容 </div>
      </van-popup>
    </div>
    <!-- 对话框 -->
    <div>
      <van-dialog v-model="dialogVisiable" title="自定义对话框">
        <div> 自定义信息：{{ dialogInfo }} </div>
      </van-dialog>
    </div>
  </div>
</template>

<script>
export default {
  name: 'VantPopup',
  data() {
    return {
      title: '弹出层和对话框',
      visiable: false,
      dialogVisiable: false,
      dialogInfo: '',
    }
  },
  methods: {
    showToast(info) {
      this.$toast.success(info)
    },
    showDialog(info, title) {
      if (title) {
        this.$dialog
          .confirm({
            title: title,
            message: info,
          })
          .then(() => {
            this.$dialog.alert({
              message: '点击确认',
            })
          })
          .catch(() => {
            this.$dialog.alert({
              message: '点击取消',
            })
          })
      } else {
        this.dialogInfo = info
        this.dialogVisiable = true
      }
    },
    showCallbackDialog() {
      this.$dialog
        .confirm({
          title: '关闭',
          message: '异步关闭',
          beforeClose(action, done) {
            if (action === 'confirm') {
              setTimeout(done, 2000)
            } else {
              done()
            }
          },
        })
        .then(() => {
          this.$logger.debug('确认')
        })
        .catch(() => {
          this.$logger.debug('取消')
        })
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
