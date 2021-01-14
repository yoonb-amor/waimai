# coupon

#### 介绍
外卖优惠券仓库

#### 软件架构
软件架构说明


#### 安装教程

1.  coupon为前端项目，具体参考https://ext.dcloud.net.cn/plugin?id=3569
2.  my-coupon为后端项目，先执行sql，修改数据库地址
3.  nginx配置
    location /coupon/{
         proxy_pass   http://localhost:8848/coupon/;
         proxy_redirect off;
         proxy_set_header X-Real-IP $remote_addr;
         proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
      }





