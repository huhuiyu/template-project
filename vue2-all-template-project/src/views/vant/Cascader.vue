<template>
  <div>
    <div class="pd10 tc">{{ title }}</div>
    <div>
      <van-field v-model="showInfo" is-link readonly label="地区" placeholder="请选择所在地区" @click="show = true" />
      <van-popup v-model="show" round position="bottom">
        <van-cascader v-model="areaId" title="请选择所在地区" :options="plist" @close="show = false" @change="onChange" @finish="onFinish" />
      </van-popup>
    </div>
    <div>{{ areaId }}</div>
  </div>
</template>

<script>
export default {
  name: 'VantCascader',
  data() {
    return {
      title: '有赞ui-级联',
      show: false,
      showInfo: '',
      areaId: '',
      pindex: '',
      plist: [],
      clist: [],
    }
  },
  methods: {
    findProvice(value) {
      for (let i = 0; i < this.plist.length; i++) {
        let data = this.plist[i]
        if (data.value == value) {
          return i
        }
      }
      return 0
    },
    dataMapping(list, mappgin, children) {
      for (let i = 0; i < list.length; i++) {
        let data = list[i]
        for (let key in mappgin) {
          data[mappgin[key]] = data[key]
          delete data[key]
        }
        if (children) {
          data.children = []
        }
      }
    },
    onChange({ value, selectedOptions, tabIndex }) {
      this.$logger.debug('选中的信息：', value, selectedOptions, tabIndex)
      this.queryCity()
    },
    onFinish(info) {
      this.$logger.debug('onFinish选中的信息：', info)
      this.show = false
      this.showInfo = info.selectedOptions.map((option) => option.text).join('/')
    },
    queryProvince() {
      this.$ajax('/linkinfo/queryAllProvince', {}, function (data) {
        this.plist = data.resultData.list
        this.dataMapping(this.plist, { pid: 'value', province: 'text' }, true)
        this.$logger.debug(this.plist)
      })
    },
    queryCity() {
      this.$ajax('/linkinfo/queryCityByProvince', { 'tbCity.pid': this.areaId }, function (data) {
        this.clist = data.resultData.list
        this.dataMapping(this.clist, { cid: 'value', city: 'text' })
        let index = this.findProvice(this.areaId)
        let option = this.plist[index]
        option.children = this.clist
        this.$logger.debug('选项变化', option)
        this.$set(this.plist[index], option)
      })
    },
  },
  created() {
    this.queryProvince()
  },
}
</script>
