/*
 Navicat Premium Data Transfer

 Source Server         : 47.100.30.250
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 47.100.30.250:3306
 Source Schema         : coupon

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 14/01/2021 09:43:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `tab_id` int NOT NULL AUTO_INCREMENT,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分类名称',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图标链接',
  `deleted` int NULL DEFAULT 1,
  PRIMARY KEY (`tab_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (0, '全部', 'http://img.yoonb.cn/category/all.png', 1);
INSERT INTO `t_category` VALUES (1, '饿了么', 'http://img.yoonb.cn/category/ele.png', 1);
INSERT INTO `t_category` VALUES (2, '美团', 'http://img.yoonb.cn/category/meituan.png', 1);
INSERT INTO `t_category` VALUES (3, '京东', 'http://img.yoonb.cn/category/jd.png', 1);
INSERT INTO `t_category` VALUES (4, '滴滴出行', 'http://img.yoonb.cn/category/didi.jpg', 1);
INSERT INTO `t_category` VALUES (5, '橙心优选', 'http://img.yoonb.cn/category/cxyx.png', 1);
INSERT INTO `t_category` VALUES (6, '花小猪', 'http://img.yoonb.cn/category/hxz.png', 1);
INSERT INTO `t_category` VALUES (7, '瑞幸咖啡', 'http://img.yoonb.cn/category/rxkf.png', 1);

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `cate_id` int NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `app_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `path` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sort` int NULL DEFAULT NULL,
  `deleted` int NULL DEFAULT 1,
  `is_me` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_project
-- ----------------------------
INSERT INTO `t_project` VALUES (1, 2, '美团外卖', 'http://img.yoonb.cn/projects/meituan.png', 'http://img.yoonb.cn/projects/meituan_banner.jpg', 'wxde8ac0a21135c07d', '/index/pages/h5/h5?noshare=1&f_userId=0&f_openId=0&f_token=0&weburl=https%3A%2F%2Fact.meituan.com%2Fclover%2Fpage%2Fadunioncps%2Fshare_coupon_new%3FutmSource%3D2055%26timestamp%3D1610111866%26utmMedium%3Dd0dfb29e673b618f1910dc7108290774%26version%3D1.0%26showKa%3D1%26requestId%3Db072bd1453e3cc0d5f034e070d0a1118%26activity%3DjRIy9mv9rA', 'https://c.mktdatatech.com/track.php?site_id=409595&aid=4882&euid=&t=http%3A%2F%2Ffxno-act.meituan.com&dm_fid=16079', 6, 1, '多麦，赚钱');
INSERT INTO `t_project` VALUES (2, 1, '饿了么外卖', 'http://img.yoonb.cn/projects/ele.png', 'http://img.yoonb.cn/projects/eleme_hongbao.jpg', 'wxece3a9a4c82f58c9', 'pages/sharePid/web/index?scene=https://s.click.ele.me/FS6Lysu', 'https://tb.g2h3.com/54YzW', 5, 1, '多麦，赚钱');
INSERT INTO `t_project` VALUES (3, 1, '饿了么天天领红包', 'http://img.yoonb.cn/projects/ele.png', 'http://img.yoonb.cn/projects/ele_banner.jpg', 'wxece3a9a4c82f58c9', 'ele-recommend-price/pages/guest/index?inviterId=ae53222', 'https://h5.ele.me/ant/qrcode?open_type=miniapp&url_id=35&inviterId=ae53222', 5, 0, '0');
INSERT INTO `t_project` VALUES (4, 2, '美团生鲜', 'http://img.yoonb.cn/projects/meituan.png', 'http://img.yoonb.cn/projects/meituan-shangchao.jpg', 'wxde8ac0a21135c07d', '/index/pages/h5/h5?lch=cps:waimai:5:293bc949ae9df6d082eda2311f51c6b2:meituan&weburl=https%3A%2F%2Frunion.meituan.com%2Furl%3Fkey%3D293bc949ae9df6d082eda2311f51c6b2%26url%3Dhttps%253A%252F%252Fi.meituan.com%252Fawp%252Fhfe%252Fblock%252Fc9ff59b58f6f5bf385b6%252F94455%252Findex.html%253Fappkey%253D293bc949ae9df6d082eda2311f51c6b2%253Ameituan%26sid%3Dmeituan&f_userId=1&f_token=1', 'https://runion.meituan.com/url?key=7c2a1b12b058bb28b2ceaf6b22e4b89b&url=https%3A%2F%2Fi.meituan.com%2Fawp%2Fhfe%2Fblock%2F652c4b9d8a2425a98ca5%2F92207%2Findex.html%3Fappkey%3D7c2a1b12b058bb28b2ceaf6b22e4b89b%3Aonline20201108&sid=online20201108', 4, 1, '0');
INSERT INTO `t_project` VALUES (5, 1, '饿了么大额满减券', 'http://img.yoonb.cn/projects/ele.png', 'http://img.yoonb.cn/projects/ele_guosu.jpg', 'wxece3a9a4c82f58c9', 'pages/sharePid/web/index?scene=https://s.click.ele.me%2F6mtdltu', 'https://s.click.ele.me/6mtdltu', 3, 0, '0');
INSERT INTO `t_project` VALUES (6, 1, '饿了么果蔬', 'http://img.yoonb.cn/projects/ele.png', 'http://img.yoonb.cn/projects/eleme-cai.jpg', 'wxece3a9a4c82f58c9', 'pages/sharePid/web/index?scene=https://s.click.ele.me%2FCjMxotu', 'https://s.click.ele.me/CjMxotu', 2, 1, '0');
INSERT INTO `t_project` VALUES (7, 5, '橙心优选', 'http://img.yoonb.cn/projects/cxyx.png', 'http://img.yoonb.cn/projects/chengxinyouxuan.png', 'wxd7fa7df243b05aed', 'cx-cpc/views/index/index?trace_id=0a561c215fe165706336e9580be2a802&share_source_id=60052&biz_channel_id=666005&origin=&root_xpsid=8c172d61bd824e0b87785a9161e5baf4&xpsid=8c172d61bd824e0b87785a9161e5baf4&f_xpsid=8c172d61bd824e0b87785a9161e5baf4&page=invitee&share_code=bvclkn647oitk17hhdog00&dchn=nLAEd3', NULL, 1, 1, '自己');
INSERT INTO `t_project` VALUES (8, 4, '滴滴出行', 'http://img.yoonb.cn/projects/didi.jpg', 'http://img.yoonb.cn/projects/didichuxing.jpg', 'wxaf35009675aa0b2a', 'passenger-recommend/views/coupon/index?template=1&sharecode=bv7qiligrvv9hse02210&root_dchn=RpQlOo&channel_id=1100000090&scene=14', NULL, 1, 1, '自用');
INSERT INTO `t_project` VALUES (9, 6, '花小猪', 'http://img.yoonb.cn/projects/hxz.png', 'http://img.yoonb.cn/projects/huaxiaozhu.jpg', 'wxd98a20e429ce834b', 'kfpub/pages/gift?jump_home=1&f_dpsid=e314d9a6c0844b7384088b4a4979da61&latitude=31.780445149739585&g_channel=2f9e032794de100a0b8eb5a203bd2a37&entrance_channel=&channel=2001001001&xpsid=e7147830f4214fe490834521329d57f8&share_code=bvgmfu4duek0bvifb1u0&dchn=zxOgqk&channel_id=2001001001&longitude=117.3364697265625&city_id=15', NULL, 1, 1, '自用');
INSERT INTO `t_project` VALUES (10, 3, '京东自购省分享赚', 'http://img.yoonb.cn/projects/jd.png', 'http://img.yoonb.cn/projects/dongxiaodian.jpg', 'wx9f8396eb61de4188', 'pages/memberhome/memberhome?scene=bsysot', NULL, 1, 0, '0');
INSERT INTO `t_project` VALUES (11, 7, '瑞幸咖啡', 'http://img.yoonb.cn/projects/rxkf.png', 'http://img.yoonb.cn/projects/ruixingkafei.png', 'wx21c7506e98a2fe75', 'pages/share/inviter/inviter?locationType=1&activityNo=NR201810220001&shareType=3&channelInviteCode=undefined&target=p5FBbNzh4dnLKeYYJvMLmg%3D%3D', NULL, 1, 1, '自用');
INSERT INTO `t_project` VALUES (12, 2, '美团酒店', 'http://img.yoonb.cn/projects/meituan.png', 'http://img.yoonb.cn/projects/mtjd.png', 'wxde8ac0a21135c07d', '/index/pages/h5/h5?noshare=1&f_userId=0&f_openId=0&f_token=0&weburl=https%3A%2F%2Fact.meituan.com%2Fclover%2Fpage%2Fadunioncps%2Fsecond_cashback%3FutmSource%3D2055%26timestamp%3D1608600415%26access_token%3Dca9ddb984c2a0a8ea9b094524b9d8217%26utmMedium%3D6bd99e32473445410cc486421a14c9cc%26version%3D1.0%26showKa%3D1%26requestId%3Df02f3afd5858a16d7474f1bed2591a86%26activity%3DyknUrA9Rrx', 'https://c.mktdatatech.com/track.php?site_id=409595&aid=8729&euid=xcx&t=http%3A%2F%2Fhotel-fx-act.meituan.com&dm_fid=16079', 3, 1, '多麦，不赚钱');

SET FOREIGN_KEY_CHECKS = 1;
