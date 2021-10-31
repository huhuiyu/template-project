//服务器相关信息
let serverInfo = {}
// 本地存储token的key
serverInfo.serverTokenKey = 'teach-server.info.token'
// 后端服务基础地址
serverInfo.serverUrl = 'https://huhuiyu.top/teach-service'

// 本地token信息
serverInfo.saveToken = function (resp) {
  if (resp.data && resp.data.token) {
    localStorage.setItem(serverInfo.serverTokenKey, resp.data.token)
  }
}
serverInfo.loadToken = function () {
  let token = localStorage.getItem(serverInfo.serverTokenKey)
  return token ? token : ''
}

export default serverInfo
