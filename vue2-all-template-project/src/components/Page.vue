<template>
  <div v-if="page.pageCount > 1" class="tc links">
    <span @click="changePage(page.pageNumber - 1)">上一页</span>
    <span>当前页/总页数/记录数：{{ page.pageNumber }}/{{ page.pageCount }}/{{ page.total }}</span>
    <span @click="changePage(page.pageNumber + 1)">下一页</span>
  </div>
</template>
<script>
export default {
  data() {
    return {}
  },
  props: {
    page: {
      default() {
        return {}
      },
    },
  },
  methods: {
    changePage(pn) {
      this.page.pageNumber = pn
      this.$emit('change-page', this.page)
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
