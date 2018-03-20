/*
MySQL Data Transfer
Source Host: localhost
Source Database: market
Target Host: localhost
Target Database: market
Date: 2018/1/27 13:44:05
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminid` varchar(255) NOT NULL,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `realname` varchar(255) default NULL,
  `contact` varchar(255) default NULL,
  PRIMARY KEY  (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleid` varchar(255) NOT NULL,
  `title` varchar(255) default NULL,
  `image` varchar(255) default NULL,
  `contents` varchar(255) default NULL,
  `addtime` varchar(255) default NULL,
  `hits` varchar(255) default NULL,
  PRIMARY KEY  (`articleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bcate
-- ----------------------------
DROP TABLE IF EXISTS `bcate`;
CREATE TABLE `bcate` (
  `bcateid` varchar(255) NOT NULL,
  `bcatename` varchar(255) default NULL,
  PRIMARY KEY  (`bcateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cartid` varchar(255) NOT NULL,
  `usersid` varchar(255) default NULL,
  `goodsid` varchar(255) default NULL,
  `num` varchar(255) default NULL,
  `price` varchar(255) default NULL,
  `addtime` varchar(255) default NULL,
  PRIMARY KEY  (`cartid`),
  KEY `FK2E7B202F06CBA9` (`goodsid`),
  KEY `FK2E7B201AB1D48D` (`usersid`),
  CONSTRAINT `FK2E7B201AB1D48D` FOREIGN KEY (`usersid`) REFERENCES `users` (`usersid`),
  CONSTRAINT `FK2E7B202F06CBA9` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`goodsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for details
-- ----------------------------
DROP TABLE IF EXISTS `details`;
CREATE TABLE `details` (
  `detailsid` varchar(255) NOT NULL,
  `ordercode` varchar(255) default NULL,
  `goodsid` varchar(255) default NULL,
  `num` varchar(255) default NULL,
  `price` varchar(255) default NULL,
  PRIMARY KEY  (`detailsid`),
  KEY `FK5CD8F2422F06CBA9` (`goodsid`),
  CONSTRAINT `FK5CD8F2422F06CBA9` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`goodsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsid` varchar(255) NOT NULL,
  `goodsname` varchar(255) default NULL,
  `image` varchar(255) default NULL,
  `bcateid` varchar(255) default NULL,
  `scateid` varchar(255) default NULL,
  `marketprice` varchar(255) default NULL,
  `price` varchar(255) default NULL,
  `recommend` varchar(255) default NULL,
  `special` varchar(255) default NULL,
  `storage` varchar(255) default NULL,
  `addtime` varchar(255) default NULL,
  `sellnum` varchar(255) default NULL,
  `hits` varchar(255) default NULL,
  `contents` varchar(255) default NULL,
  PRIMARY KEY  (`goodsid`),
  KEY `FK5DF97561103279F` (`bcateid`),
  KEY `FK5DF9756953CA681` (`scateid`),
  CONSTRAINT `FK5DF9756953CA681` FOREIGN KEY (`scateid`) REFERENCES `scate` (`scateid`),
  CONSTRAINT `FK5DF97561103279F` FOREIGN KEY (`bcateid`) REFERENCES `bcate` (`bcateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ordersid` varchar(255) NOT NULL,
  `ordercode` varchar(255) default NULL,
  `usersid` varchar(255) default NULL,
  `total` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `addtime` varchar(255) default NULL,
  `receiver` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `contact` varchar(255) default NULL,
  PRIMARY KEY  (`ordersid`),
  KEY `FKC3DF62E51AB1D48D` (`usersid`),
  CONSTRAINT `FKC3DF62E51AB1D48D` FOREIGN KEY (`usersid`) REFERENCES `users` (`usersid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for scate
-- ----------------------------
DROP TABLE IF EXISTS `scate`;
CREATE TABLE `scate` (
  `scateid` varchar(255) NOT NULL,
  `bcateid` varchar(255) default NULL,
  `scatename` varchar(255) default NULL,
  PRIMARY KEY  (`scateid`),
  KEY `FK6830A421103279F` (`bcateid`),
  CONSTRAINT `FK6830A421103279F` FOREIGN KEY (`bcateid`) REFERENCES `bcate` (`bcateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `topicid` varchar(255) NOT NULL,
  `usersid` varchar(255) default NULL,
  `goodsid` varchar(255) default NULL,
  `num` varchar(255) default NULL,
  `contents` varchar(255) default NULL,
  `addtime` varchar(255) default NULL,
  PRIMARY KEY  (`topicid`),
  KEY `FK696CD2F2F06CBA9` (`goodsid`),
  KEY `FK696CD2F1AB1D48D` (`usersid`),
  CONSTRAINT `FK696CD2F1AB1D48D` FOREIGN KEY (`usersid`) REFERENCES `users` (`usersid`),
  CONSTRAINT `FK696CD2F2F06CBA9` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`goodsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `usersid` varchar(255) NOT NULL,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `realname` varchar(255) default NULL,
  `sex` varchar(255) default NULL,
  `birthday` varchar(255) default NULL,
  `contact` varchar(255) default NULL,
  `regdate` varchar(255) default NULL,
  PRIMARY KEY  (`usersid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', 'admin', 'admin');
INSERT INTO `article` VALUES ('40289f12611eb5f301611eb723540002', '测试测试', 'upfiles/20180123003250.jpg', '<p>在此添加内容123123</p>\r\n', '2018-01-23', '1');
INSERT INTO `bcate` VALUES ('40289f12611af92a01611afc5ebe0001', '家用电器');
INSERT INTO `bcate` VALUES ('40289f12611af92a01611afc6ae20002', '服装');
INSERT INTO `bcate` VALUES ('40289f12611af92a01611afc7e6b0003', '食品');
INSERT INTO `bcate` VALUES ('40289f12611eb5f301611eb781a20003', '电子产品');
INSERT INTO `cart` VALUES ('40289f126135332d01613541bd8a0002', '40289f126135332d01613541214d0001', '40289f12611b07e001611b0cd1f60001', '3', '4999', '2018-01-27');
INSERT INTO `cart` VALUES ('40289f126135332d01613541c9680003', '40289f126135332d01613541214d0001', '40289f12611b07e001611b14a64f0003', '1', '5699', '2018-01-27');
INSERT INTO `cart` VALUES ('40289f126135de3e016135f45fc60003', '40289f126135de3e016135f431810002', '40289f12611b07e001611b1553a20005', '2', '5699', '2018-01-27');
INSERT INTO `cart` VALUES ('40289f126135de3e016135f46ce30004', '40289f126135de3e016135f431810002', '40289f12611b07e001611b19df250008', '3', '59', '2018-01-27');
INSERT INTO `cart` VALUES ('40289f126135de3e016135f47b4b0005', '40289f126135de3e016135f431810002', '40289f12611b07e001611b218fc2000c', '5', '26.9', '2018-01-27');
INSERT INTO `cart` VALUES ('40289f126135de3e016135f798e50007', '40289f126135de3e016135f431810002', '40289f12611b07e001611b19747d0007', '3', '499', '2018-01-27');
INSERT INTO `details` VALUES ('40289f12611e0ea001611e37b4e40005', 'CO20180122221342', '40289f12611b07e001611b0cd1f60001', '1', '4999');
INSERT INTO `details` VALUES ('40289f12611e0ea001611e37b4f00006', 'CO20180122221342', '40289f12611b07e001611b19747d0007', '1', '499');
INSERT INTO `details` VALUES ('40289f12611e0ea001611e37b4f80007', 'CO20180122221342', '40289f12611b07e001611b218fc2000c', '5', '26.9');
INSERT INTO `details` VALUES ('40289f12611e408101611e41fec20002', 'CO20180122222457', '40289f12611b07e001611b14a64f0003', '1', '5699');
INSERT INTO `details` VALUES ('40289f12611eb97e01611ebba8570007', 'CO20180123003750', '40289f12611b07e001611b0cd1f60001', '1', '4999');
INSERT INTO `details` VALUES ('40289f12611eb97e01611ebba85f0008', 'CO20180123003750', '40289f12611b07e001611b22867a000e', '1', '29');
INSERT INTO `details` VALUES ('40289f12611eb97e01611ebba8660009', 'CO20180123003750', '40289f12611b07e001611b231a560010', '1', '29');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b0cd1f60001', '夏普 (SHARP) LCD-40SF466A-BK', 'upfiles/20180122072735.jpg', '40289f12611af92a01611afc5ebe0001', '40289f12611af92a01611afc95670004', '5699', '4999', '是', '是', '1000', '2018-01-22', '4', '64', '<p>夏普 (SHARP) LCD-40SF466A-BK 40英寸全高清wifi智能网络液晶平板</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b0e210c0002', '夏普 (SHARP) LCD-45SF460A', 'upfiles/20180122072909.jpg', '40289f12611af92a01611afc5ebe0001', '40289f12611af92a01611afc95670004', '5999', '5299', '否', '是', '1000', '2018-01-22', '0', '2', '<p>夏普 (SHARP) LCD-45SF460A 45英寸全高清wifi智能网络液晶平板电视</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b14a64f0003', '夏普 (SHARP) LCD-50SU460A', 'upfiles/20180122073618.jpg', '40289f12611af92a01611afc5ebe0001', '40289f12611af92a01611afc95670004', '5999', '5699', '是', '否', '1000', '2018-01-22', '1', '8', '<p>夏普 (SHARP) LCD-50SU460A 50英寸4K超高清wifi智能网络液晶</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b1502060004', '夏普 (SHARP) LCD-60DS7008A', 'upfiles/20180122073640.jpg', '40289f12611af92a01611afc5ebe0001', '40289f12611af92a01611afc95670004', '5999', '5699', '是', '是', '1000', '2018-01-22', '0', '0', '<p>夏普 (SHARP) LCD-60DS7008A 60英寸4K超高清 人工智能语音液晶平板电视机</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b1553a20005', '夏普 (SHARP) LCD-60SU465A', 'upfiles/20180122073703.jpg', '40289f12611af92a01611afc5ebe0001', '40289f12611af92a01611afc95670004', '5999', '5699', '是', '否', '1000', '2018-01-22', '0', '1', '<p>夏普 (SHARP) LCD-60SU465A 60英寸4K超高清wifi智能网络液晶平板</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b15a34d0006', '夏普 (SHARP) LCD-70SU665A', 'upfiles/20180122073725.jpg', '40289f12611af92a01611afc5ebe0001', '40289f12611af92a01611afc95670004', '5999', '5699', '否', '是', '1000', '2018-01-22', '0', '0', '<p>夏普 (SHARP) LCD-70SU665A 70英寸4K超高清wifi智能网络液晶平板</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b19747d0007', 'Logoman春秋季连帽夹克', 'upfiles/20180122074104.jpg', '40289f12611af92a01611afc6ae20002', '40289f12611af92a01611afd324e0007', '699', '499', '是', '否', '1000', '2018-01-22', '2', '8', '<p>NBA 2017秋季新款 Logoman春秋季连帽夹克运动休闲外套</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b19df250008', 'name系列骑士詹姆斯卫衣连帽', 'upfiles/20180122074155.jpg', '40289f12611af92a01611afc6ae20002', '40289f12611af92a01611afd324e0007', '699', '59', '是', '是', '1000', '2018-01-22', '0', '1', '<p>NBA 2017秋季新款nick name系列骑士詹姆斯卫衣连帽</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b1a71c80009', '运动休闲套头卫衣', 'upfiles/20180122074221.jpg', '40289f12611af92a01611afc6ae20002', '40289f12611af92a01611afd324e0007', '699', '599', '否', '是', '1000', '2018-01-22', '0', '0', '<p>NBA 2017秋季新款春秋季运动休闲套头卫衣</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b1adbb4000a', '科比 金色银色亮光印花', 'upfiles/20180122074301.jpg', '40289f12611af92a01611afc6ae20002', '40289f12611af92a01611afd324e0007', '799', '599', '是', '否', '1000', '2018-01-22', '0', '0', '<p>NBA KB20 湖人 科比 金色银色亮光印花 短袖纪念T恤</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b1b4f8d000b', '马刺队莱昂纳德', 'upfiles/20180122074326.png', '40289f12611af92a01611afc6ae20002', '40289f12611af92a01611afd324e0007', '599', '399', '是', '是', '1000', '2018-01-22', '0', '0', '<p>NBA NIKE 马刺队莱昂纳德 球迷版篮球球衣</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b218fc2000c', '埃及进口橙', 'upfiles/20180122075017.jpg', '40289f12611af92a01611afc7e6b0003', '40289f12611af92a01611afd8efc0008', '35.9', '26.9', '否', '是', '1000', '2018-01-22', '10', '2', '<p>埃及进口橙</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b21f3df000d', '妃子笑荔枝', 'upfiles/20180122075047.jpg', '40289f12611af92a01611afc7e6b0003', '40289f12611af92a01611afd8efc0008', '35.9', '29', '是', '否', '1000', '2018-01-22', '0', '0', '<p>妃子笑荔枝</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b22867a000e', '红心木瓜10斤包邮', 'upfiles/20180122075128.jpg', '40289f12611af92a01611afc7e6b0003', '40289f12611af92a01611afd8efc0008', '35.9', '29', '是', '是', '1000', '2018-01-22', '2', '4', '<p>红心木瓜10斤包邮现摘木瓜牛奶夏威夷青皮木瓜6到8个新鲜水果</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b22d25d000f', '进口红提', 'upfiles/20180122075150.JPG', '40289f12611af92a01611afc7e6b0003', '40289f12611af92a01611afd8efc0008', '35.9', '29', '否', '是', '1000', '2018-01-22', '0', '0', '<p>进口红提</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b231a560010', '进口火龙果', 'upfiles/20180122075209.jpg', '40289f12611af92a01611afc7e6b0003', '40289f12611af92a01611afd8efc0008', '35.9', '29', '是', '否', '1000', '2018-01-22', '2', '1', '<p>进口火龙果</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b235c6e0011', '绿宝瓜', 'upfiles/20180122075227.jpg', '40289f12611af92a01611afc7e6b0003', '40289f12611af92a01611afd8efc0008', '35.9', '29', '否', '是', '1000', '2018-01-22', '0', '0', '<p>绿宝瓜</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611b07e001611b239f940012', '美国西北黄车厘子', 'upfiles/20180122075244.jpg', '40289f12611af92a01611afc7e6b0003', '40289f12611af92a01611afd8efc0008', '35.9', '29', '是', '是', '1000', '2018-01-22', '0', '0', '<p>美国西北黄车厘子</p>\r\n');
INSERT INTO `goods` VALUES ('40289f12611eb97e01611eba08890001', '2017新款Core i5 处理器 8GB内存', 'upfiles/20180123003541.jpg', '40289f12611eb5f301611eb781a20003', '40289f12611eb5f301611eb7ac960004', '7599', '7299', '否', '否', '1000', '2018-01-23', '0', '2', '<p>Apple MacBook Air 13.3英寸笔记本电脑 银色(2017新款Core i5 处理器 8GB内存</p>\r\n');
INSERT INTO `orders` VALUES ('40289f12611e0ea001611e37b5000008', 'CO20180122221342', '40289f12611e0ea001611e35ae400001', '5632.5', '完成', '2018-01-22 22:13:42', '123123', '123123', '123123');
INSERT INTO `orders` VALUES ('40289f12611e408101611e41ff280003', 'CO20180122222457', '40289f12611e0ea001611e35ae400001', '5699.0', '未付款', '2018-01-22 22:24:57', '234234', '234234', '234234');
INSERT INTO `orders` VALUES ('40289f12611eb97e01611ebba86e000a', 'CO20180123003750', '40289f12611eb97e01611eba92b80002', '5057.0', '完成', '2018-01-23 00:37:50', '444', '444', '444');
INSERT INTO `scate` VALUES ('40289f12611af92a01611afc95670004', '40289f12611af92a01611afc5ebe0001', '电视');
INSERT INTO `scate` VALUES ('40289f12611af92a01611afc9fcd0005', '40289f12611af92a01611afc5ebe0001', '冰箱');
INSERT INTO `scate` VALUES ('40289f12611af92a01611afcab9a0006', '40289f12611af92a01611afc5ebe0001', '洗衣机');
INSERT INTO `scate` VALUES ('40289f12611af92a01611afd324e0007', '40289f12611af92a01611afc6ae20002', '运动装');
INSERT INTO `scate` VALUES ('40289f12611af92a01611afd8efc0008', '40289f12611af92a01611afc7e6b0003', '水果');
INSERT INTO `scate` VALUES ('40289f12611af92a01611afd9cca0009', '40289f12611af92a01611afc7e6b0003', '生鲜');
INSERT INTO `scate` VALUES ('40289f12611eb5f301611eb7ac960004', '40289f12611eb5f301611eb781a20003', '电脑');
INSERT INTO `scate` VALUES ('40289f12611eb5f301611eb7bfd30005', '40289f12611eb5f301611eb781a20003', '手机');
INSERT INTO `topic` VALUES ('40289f12611eaa5901611eab17b70001', '40289f12611e0ea001611e35ae400001', '40289f12611b07e001611b19747d0007', '5', '123123', '2018-01-23');
INSERT INTO `topic` VALUES ('40289f12611eaa5901611eab25380002', '40289f12611e0ea001611e35ae400001', '40289f12611b07e001611b19747d0007', '5', 'vzxcvxcv', '2018-01-23');
INSERT INTO `topic` VALUES ('40289f12611eb97e01611ebc736c000b', '40289f12611eb97e01611eba92b80002', '40289f12611b07e001611b22867a000e', '5', 'xzcvzxcvxcv', '2018-01-23');
INSERT INTO `topic` VALUES ('40289f12611eb97e01611ebc8634000c', '40289f12611eb97e01611eba92b80002', '40289f12611b07e001611b22867a000e', '4', 'xzcvzxcvzxcv', '2018-01-23');
INSERT INTO `users` VALUES ('40289f12611e0ea001611e35ae400001', '123123', '123123', '123123', '男', '2018-01-22', '123123', '2018-01-22');
INSERT INTO `users` VALUES ('40289f12611eb97e01611eba92b80002', '222', '222', '222', '女', '2018-01-23', '222', '2018-01-23');
INSERT INTO `users` VALUES ('40289f126135332d01613541214d0001', '234234', '234234', '234234', '男', '2018-01-27', '234234', '2018-01-27');
INSERT INTO `users` VALUES ('40289f126135de3e016135f431810002', '444', '444', '444', '男', '2018-01-27', '444', '2018-01-27');
