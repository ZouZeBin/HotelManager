/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : db_hotel

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2016-10-29 23:29:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '预订人姓名',
  `phone` varchar(50) DEFAULT NULL COMMENT '预订人电话',
  `checkTime` varchar(50) DEFAULT NULL COMMENT '预订入住时间',
  `creditTime` varchar(50) DEFAULT NULL COMMENT '订单创建时间',
  `state` varchar(50) DEFAULT NULL COMMENT '预订状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', '1', '1', '1', '2016-10-29 16:39:28', '已退订');
INSERT INTO `t_book` VALUES ('2', '1', '1', '1', '2016-10-29 16:43:14', '已退订');
INSERT INTO `t_book` VALUES ('3', '1', '1', '1', '2016-10-29 17:24:14', '已退订');

-- ----------------------------
-- Table structure for t_cashier
-- ----------------------------
DROP TABLE IF EXISTS `t_cashier`;
CREATE TABLE `t_cashier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  `money` varchar(50) DEFAULT NULL COMMENT '金额',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `time` varchar(50) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cashier
-- ----------------------------
INSERT INTO `t_cashier` VALUES ('1', '收入', '100', '用户2入住收入金额100', null);
INSERT INTO `t_cashier` VALUES ('2', '收入', '1', '用户1入住收入金额1', '2016-10-29 17:47:24');
INSERT INTO `t_cashier` VALUES ('3', '收入', '1', '1', '2016-10-29 22:28:17');
INSERT INTO `t_cashier` VALUES ('4', '收入', '1', '1', '2016-10-29 22:28:48');
INSERT INTO `t_cashier` VALUES ('5', '收入', '100', '打牌赢得', '2016-10-29 22:29:06');
INSERT INTO `t_cashier` VALUES ('6', '支出', '11', '11', '2016-10-29 22:31:29');
INSERT INTO `t_cashier` VALUES ('7', '支出', '1', '1', '2016-10-29 23:15:32');

-- ----------------------------
-- Table structure for t_guestroom
-- ----------------------------
DROP TABLE IF EXISTS `t_guestroom`;
CREATE TABLE `t_guestroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `state` int(255) DEFAULT '0',
  `type` varchar(255) DEFAULT NULL COMMENT '客房类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_guestroom
-- ----------------------------
INSERT INTO `t_guestroom` VALUES ('1', '301', '1', '标间');
INSERT INTO `t_guestroom` VALUES ('2', '302', '0', '双刃剑');
INSERT INTO `t_guestroom` VALUES ('3', '303', '0', '标间');
INSERT INTO `t_guestroom` VALUES ('4', '304', '0', '标间');
INSERT INTO `t_guestroom` VALUES ('5', '305', '1', '标间');
INSERT INTO `t_guestroom` VALUES ('6', '306', '0', '标间');
INSERT INTO `t_guestroom` VALUES ('7', '307', '0', '标间');
INSERT INTO `t_guestroom` VALUES ('8', '308', '0', '标间');
INSERT INTO `t_guestroom` VALUES ('9', '309', '0', '标间111');
INSERT INTO `t_guestroom` VALUES ('10', '310', '0', '标间');

-- ----------------------------
-- Table structure for t_household
-- ----------------------------
DROP TABLE IF EXISTS `t_household`;
CREATE TABLE `t_household` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '住户姓名',
  `idNum` varchar(30) DEFAULT NULL COMMENT '身份证号码',
  `checkTime` varchar(50) DEFAULT NULL COMMENT '入住时间',
  `roomNum` int(11) DEFAULT NULL COMMENT '入住房号',
  `money` int(30) DEFAULT NULL COMMENT '收费',
  `state` varchar(30) DEFAULT NULL COMMENT '入住状态',
  `outTime` varchar(50) DEFAULT NULL COMMENT '退房时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_household
-- ----------------------------
INSERT INTO `t_household` VALUES ('10', '蒋攀', '500382199310127630', '2016-10-29 12:10:12', '301', '150', '已退房', '2016-10-29 15:24:07');
INSERT INTO `t_household` VALUES ('11', '1', '1', '2016-10-29 13:08:05', '302', '1', '已退房', '2016-10-29 15:23:40');
INSERT INTO `t_household` VALUES ('12', '1', '1', '2016-10-29 13:11:32', '301', '1', '已退房', '2016-10-29 15:24:07');
INSERT INTO `t_household` VALUES ('13', '1', '1', '2016-10-29 13:11:50', '301', '1', '已退房', '2016-10-29 15:24:07');
INSERT INTO `t_household` VALUES ('14', '1', '1', '2016-10-29 13:36:28', '303', '1', '已退房', '2016-10-29 13:36:41');
INSERT INTO `t_household` VALUES ('15', '1', '1', '2016-10-29 14:15:40', '301', '1', '已退房', '2016-10-29 15:24:07');
INSERT INTO `t_household` VALUES ('16', '蒋攀', '5003821993101327630', '2016-10-29 15:22:52', '302', '50', '已退房', '2016-10-29 15:23:40');
INSERT INTO `t_household` VALUES ('17', '1', '1', '2016-10-29 15:23:54', '301', '1', '已退房', '2016-10-29 15:24:07');
INSERT INTO `t_household` VALUES ('18', '1', '1', '2016-10-29 15:23:59', '302', '1', '已退房', '2016-10-29 15:24:07');
INSERT INTO `t_household` VALUES ('19', '1', '1', '2016-10-29 15:30:36', '301', '1', '已退房', '2016-10-29 15:35:47');
INSERT INTO `t_household` VALUES ('20', '1', '1', '2016-10-29 15:32:25', '305', '1', '已退房', '2016-10-29 15:35:41');
INSERT INTO `t_household` VALUES ('21', '1', '1', '2016-10-29 16:10:52', '301', '1', '已退房', '2016-10-29 16:10:58');
INSERT INTO `t_household` VALUES ('22', '1', '1', '2016-10-29 16:11:08', '301', '4', '已退房', '2016-10-29 16:11:15');
INSERT INTO `t_household` VALUES ('23', '1', '1', '2016-10-29 16:17:26', '305', '1', '已退房', '2016-10-29 16:17:38');
INSERT INTO `t_household` VALUES ('24', '2', '2', '2016-10-29 17:38:09', '305', '100', '入住中', null);
INSERT INTO `t_household` VALUES ('25', '1', '1', '2016-10-29 17:47:23', '301', '1', '已退房', '2016-10-29 22:56:44');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) DEFAULT NULL COMMENT '登录名',
  `password` varchar(30) DEFAULT NULL COMMENT '登陆密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin');
