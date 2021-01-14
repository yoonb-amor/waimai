import Vue from 'vue'
import App from './App'

import { http } from '@/common/service.js' // 全局挂载引入，配置相关在该index.js文件里修改
	
Vue.prototype.$http = http

Vue.config.productionTip = false
// let  baseRequestUrl = 'https://shine.wehalk.com'  //后端网站域名
let  baseRequestUrl = 'https://yoonb.cn/coupon/index'
Vue.prototype.baseRequestUrl = baseRequestUrl
Vue.prototype.requestUrl = baseRequestUrl
Vue.prototype.raiseImage = 'http://img.yoonb.cn/zsm.jpg' //赞赏作者栏目赞赏码
Vue.prototype.contactImage = "http://img.yoonb.cn/lxw.jpg" //联系作者的二维码
Vue.prototype.shareImage = 'http://img.yoonb.cn/chihe-share.jpg'  //转发朋友的分享图片
App.mpType = 'app'

const app = new Vue({
	...App
})
app.$mount()
