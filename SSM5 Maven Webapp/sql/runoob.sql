/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : runoob

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 23/08/2018 08:49:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `way` int(10) NOT NULL DEFAULT 0,
  `number` decimal(50, 2) UNSIGNED NOT NULL,
  `state` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '贷款', 1, 100000.00, 1);
INSERT INTO `account` VALUES (2, '借款', 1, 20000.00, -1);
INSERT INTO `account` VALUES (3, '购入设备', 0, 10000.00, 1);
INSERT INTO `account` VALUES (4, '存款利息', 1, 2000.00, 0);

-- ----------------------------
-- Table structure for sdumap
-- ----------------------------
DROP TABLE IF EXISTS `sdumap`;
CREATE TABLE `sdumap`  (
  `id` int(11) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `x` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `y` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sdumap
-- ----------------------------
INSERT INTO `sdumap` VALUES (1, '中心校区', '117.066997', '36.681139');
INSERT INTO `sdumap` VALUES (2, '软件园校区', '117.14587', '36.673743');
INSERT INTO `sdumap` VALUES (3, '洪家楼校区', '117.075068', '36.693073');
INSERT INTO `sdumap` VALUES (4, '千佛山校区', '117.034922', '36.6566');
INSERT INTO `sdumap` VALUES (5, '趵突泉校区', '117.024524', '36.658814');
INSERT INTO `sdumap` VALUES (6, '兴隆山校区', '117.05625', '36.60914');
INSERT INTO `sdumap` VALUES (7, '威海校区', '122.06735', '37.535699');
INSERT INTO `sdumap` VALUES (8, '青岛校区', '120.693321', '36.371635');

-- ----------------------------
-- Table structure for user_t
-- ----------------------------
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Redundant;

-- ----------------------------
-- Records of user_t
-- ----------------------------
INSERT INTO `user_t` VALUES (1, '张三', '123', 23);
INSERT INTO `user_t` VALUES (2, '李四', '123', 32);
INSERT INTO `user_t` VALUES (3, 'Bob', '', 33);
INSERT INTO `user_t` VALUES (4, 'John', '321', 12);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'abc', '');
INSERT INTO `users` VALUES (2, '张三', '123');
INSERT INTO `users` VALUES (3, 'cba', '123');
INSERT INTO `users` VALUES (4, '李四', '321');
INSERT INTO `users` VALUES (5, 'aaa', '123');

-- ----------------------------
-- Table structure for websites
-- ----------------------------
DROP TABLE IF EXISTS `websites`;
CREATE TABLE `websites`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '站点名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `alexa` int(11) NOT NULL DEFAULT 0 COMMENT 'Alexa 排名',
  `country` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '国家',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of websites
-- ----------------------------
INSERT INTO `websites` VALUES (1, 'Google', 'https://www.google.cm/', 1, 'USA');
INSERT INTO `websites` VALUES (2, '淘宝', 'https://www.taobao.com/', 13, 'CN');
INSERT INTO `websites` VALUES (3, '菜鸟教程', 'http://www.runoob.com', 5892, '');
INSERT INTO `websites` VALUES (4, '微博', 'http://weibo.com/', 20, 'CN');
INSERT INTO `websites` VALUES (5, 'Facebook', 'https://www.facebook.com/', 3, 'USA');

SET FOREIGN_KEY_CHECKS = 1;
