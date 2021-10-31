module.exports = {
  // 配置build时不需要map文件
  productionSourceMap: !process.env.NODE_ENV === 'production',
  // 项目输出路径（修改项目build的输出路径）
  outputDir: 'D:\\output\\vue2-template-project',
  // 如果不是放置再服务器顶级目录时配置的虚拟路径
  publicPath: process.env.NODE_ENV === 'production' ? '/vue2-template-project/' : '/',
  // 注释build时打包文件大小，以及外置基础js引用文件，可以有效减少构建的js文件大小
  // configureWebpack: (config) => {
  //   if (process.env.NODE_ENV === 'production') {
  //     // 为生产环境修改配置...
  //     config.mode = 'production';
  //     config['performance'] = {
  //       //打包文件大小配置
  //       maxEntrypointSize: 1000000,
  //       maxAssetSize: 2000000,
  //     };
  //   }
  // config.externals = {
  //   vue: 'Vue',
  //   'vue-router': 'VueRouter',
  //   vuex: 'Vuex',
  //   'spark-md5': 'SparkMD5',
  //   'qs': 'qs',
  //   'axios': 'axios',
  // };
  // },
}
