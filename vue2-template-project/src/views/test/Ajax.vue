<template>
  <div>
    <div class="tc">{{ title }}</div>
    <div>
      <!-- 表单的部分 -->
      <div>
        <input type="text" v-model="tbUserMessage.title" placeholder="标题模糊查询" />
        <input type="text" v-model="tbUserMessage.info" placeholder="内容模糊查询" />
        <button @click="query">查询</button>
      </div>
      <!-- 数据显示部分 -->
      <table>
        <thead>
          <tr>
            <th>标题</th>
            <th>内容</th>
            <th>留言用户</th>
            <th>留言时间</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="d in list" :key="d.umid">
            <td>{{ d.title }}</td>
            <td>{{ d.info }}</td>
            <td>{{ d.user.username }}</td>
            <td>{{ d.lastupdate | formatDate }}</td>
          </tr>
        </tbody>
      </table>
      <!-- 分页部分 -->
      <page :page="page" @change-page="query"></page>
    </div>
  </div>
</template>

<script>
import Page from '../../components/Page.vue'
export default {
  components: { Page },
  name: 'TestAjax',
  data() {
    return {
      title: '黑暗骑士-Vue模板项目，ajax测试，包括组件和过滤器演示',
      list: [],
      page: {
        pageNumber: 1,
        pageSize: 5,
      },
      tbUserMessage: {
        title: '',
        info: '',
      },
    }
  },
  methods: {
    query() {
      this.$ajax(
        '/userMessage/queryAll',
        {
          page: this.page,
          tbUserMessage: this.tbUserMessage,
        },
        function (data) {
          if (data.success) {
            this.list = data.resultData.list
            this.page = data.resultData.page
          } else {
            alert(data.message)
          }
        }
      )
    },
  },
  created() {
    this.query()
  },
}
</script>
<style lang="less" scoped>
table {
  width: 100%;
  border-collapse: collapse;
}
table,
tr,
th,
td {
  border: 1px solid #dcdcdc;
}
td,
th {
  padding: 0.2rem;
}
th {
  background-color: #acacac;
}
tr {
  &:nth-child(2n) {
    background-color: #acac00;
  }
  &:nth-child(2n + 1) {
    background-color: #ac00ac;
  }
}
</style>
