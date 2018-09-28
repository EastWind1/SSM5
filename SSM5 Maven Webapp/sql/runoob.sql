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

 Date: 27/09/2018 10:44:16
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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '贷款', 1, 100000.00, 1);
INSERT INTO `account` VALUES (2, '借款', 1, 20000.00, -1);
INSERT INTO `account` VALUES (3, '购入设备', 0, 10000.00, 1);
INSERT INTO `account` VALUES (4, '存款利息', 1, 2000.00, 1);
INSERT INTO `account` VALUES (5, '随便', 1, 20000.00, 1);
INSERT INTO `account` VALUES (6, '2222', 0, 42424.00, 0);

-- ----------------------------
-- Table structure for baccount
-- ----------------------------
DROP TABLE IF EXISTS `baccount`;
CREATE TABLE `baccount`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `odate` date NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `currency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `agroup` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `applicant` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adate` date NULL DEFAULT NULL COMMENT '申请时间',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `audit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `audate` date NULL DEFAULT NULL COMMENT '审核时间',
  `ismain` tinyint(1) NULL DEFAULT NULL,
  `istemp` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of baccount
-- ----------------------------
INSERT INTO `baccount` VALUES ('1', '中行账户', '132412353521', '2018-09-11', NULL, '人民币', '中国银行', NULL, '研发', '张三', '2018-08-31', NULL, '李四', '2018-09-09', 1, 0);
INSERT INTO `baccount` VALUES ('2', '建行账户', '19523729857120', '2018-09-12', NULL, '人民币', '建设银行', NULL, '技术', '张四', '2018-09-12', NULL, '张三', '2018-09-27', 0, 1);

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank`  (
  `b_id` int(10) NOT NULL AUTO_INCREMENT,
  `b_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`b_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO `bank` VALUES (1, '中国银行');
INSERT INTO `bank` VALUES (2, '中国农业银行');
INSERT INTO `bank` VALUES (3, '中国工商银行');
INSERT INTO `bank` VALUES (4, '中国建设银行');
INSERT INTO `bank` VALUES (5, '中国招商银行');

-- ----------------------------
-- Table structure for bank_interest
-- ----------------------------
DROP TABLE IF EXISTS `bank_interest`;
CREATE TABLE `bank_interest`  (
  `b_id` int(10) NULL DEFAULT NULL,
  `i_id` int(10) NULL DEFAULT NULL,
  INDEX `b_id`(`b_id`) USING BTREE,
  INDEX `i_id`(`i_id`) USING BTREE,
  CONSTRAINT `bank_interest_ibfk_1` FOREIGN KEY (`b_id`) REFERENCES `bank` (`b_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bank_interest_ibfk_2` FOREIGN KEY (`i_id`) REFERENCES `interest` (`i_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bank_interest
-- ----------------------------
INSERT INTO `bank_interest` VALUES (1, 1);
INSERT INTO `bank_interest` VALUES (1, 2);
INSERT INTO `bank_interest` VALUES (2, 3);
INSERT INTO `bank_interest` VALUES (3, 4);
INSERT INTO `bank_interest` VALUES (5, 5);
INSERT INTO `bank_interest` VALUES (4, 10);

-- ----------------------------
-- Table structure for caccount
-- ----------------------------
DROP TABLE IF EXISTS `caccount`;
CREATE TABLE `caccount`  (
  `cid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ccurrency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cnumber` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  CONSTRAINT `caccount_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `baccount` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of caccount
-- ----------------------------
INSERT INTO `caccount` VALUES ('1', '1', '中行存款子账户', '人民币', 300.00);
INSERT INTO `caccount` VALUES ('207', '2', '测试子账户', '人民币', 20000.00);

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery`  (
  `jhnm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jhbh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shdz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wlzz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jhjhrq` date NULL DEFAULT NULL,
  PRIMARY KEY (`jhnm`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of delivery
-- ----------------------------
INSERT INTO `delivery` VALUES ('1', '1', '张三', '上海', '中通', '2018-08-27');

-- ----------------------------
-- Table structure for fund
-- ----------------------------
DROP TABLE IF EXISTS `fund`;
CREATE TABLE `fund`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `currency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  CONSTRAINT `fund_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `fund` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fund
-- ----------------------------
INSERT INTO `fund` VALUES ('1', '总部资金中心', '总部合并公司', '人民币', '已启用', NULL);
INSERT INTO `fund` VALUES ('10', '测试银行', NULL, NULL, NULL, '6');
INSERT INTO `fund` VALUES ('2', '集团资金中心', '集团总部', NULL, NULL, NULL);
INSERT INTO `fund` VALUES ('3', '测试资金中心', NULL, NULL, NULL, NULL);
INSERT INTO `fund` VALUES ('4', '山东资金中心', '山东分公司', '人民币', '已启用', '1');
INSERT INTO `fund` VALUES ('5', '河南资金中心', '河南分公司', '人民币', '建设中', '1');
INSERT INTO `fund` VALUES ('6', '测试机构', NULL, NULL, NULL, '2');
INSERT INTO `fund` VALUES ('7', '测试分中心', NULL, NULL, NULL, '3');
INSERT INTO `fund` VALUES ('8', '济南资金中心', '济南分公司', '人民币', '已启用', '4');
INSERT INTO `fund` VALUES ('9', '青岛资金中心', NULL, NULL, NULL, '4');

-- ----------------------------
-- Table structure for interest
-- ----------------------------
DROP TABLE IF EXISTS `interest`;
CREATE TABLE `interest`  (
  `i_id` int(10) NOT NULL AUTO_INCREMENT,
  `i_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `i_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方式',
  `i_rate` decimal(10, 4) NULL DEFAULT NULL COMMENT '利率百分比小数部分',
  `i_tunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间单位，年/月',
  `i_stime` int(10) NULL DEFAULT 0 COMMENT '存款期限',
  `i_btime` date NULL DEFAULT NULL COMMENT '利率开始时间',
  `i_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`i_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of interest
-- ----------------------------
INSERT INTO `interest` VALUES (1, '一年存款', '存款', 2.0000, '年', 1, '2018-02-07', '生效');
INSERT INTO `interest` VALUES (2, '一年贷款', '贷款', 2.0000, '年', 5, '2018-06-05', '生效');
INSERT INTO `interest` VALUES (3, '一年存款', '存款', 0.2000, '年', 1, '2018-09-01', '生效');
INSERT INTO `interest` VALUES (4, '半年存款', '存款', 0.0100, '月', 6, '2018-05-10', '生效');
INSERT INTO `interest` VALUES (5, '二十年存款', '存款', 1.0000, '年', 20, '2018-06-13', '生效');
INSERT INTO `interest` VALUES (10, '测', '', NULL, '', 0, '2018-09-13', '');

-- ----------------------------
-- Table structure for linterest
-- ----------------------------
DROP TABLE IF EXISTS `linterest`;
CREATE TABLE `linterest`  (
  `l_id` int(10) NOT NULL AUTO_INCREMENT,
  `l_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `l_mitime` int(10) NULL DEFAULT 0,
  `l_matime` int(10) NULL DEFAULT 0,
  `l_tunit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `l_rate` decimal(10, 4) NULL DEFAULT NULL,
  `l_stime` date NULL DEFAULT NULL,
  `l_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`l_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of linterest
-- ----------------------------
INSERT INTO `linterest` VALUES (1, '一年贷款', 0, 1, '年', 10.0000, '2018-04-02', '生效');
INSERT INTO `linterest` VALUES (2, '半年贷款', 0, 6, '月', 20.0000, '2018-07-13', '生效');
INSERT INTO `linterest` VALUES (3, '十年贷款', 1, 10, '年', 15.0000, '2018-09-10', '生效');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `wlnm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `wlbh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wlmc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zsl` decimal(65, 2) NULL DEFAULT NULL,
  `zdw` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zdj` decimal(65, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`wlnm`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('1', '1', '中性笔', 1000.00, '箱', 20.00);
INSERT INTO `material` VALUES ('2', '2', 'A4纸', 1000.00, '箱', 50.00);

-- ----------------------------
-- Table structure for order_delivery
-- ----------------------------
DROP TABLE IF EXISTS `order_delivery`;
CREATE TABLE `order_delivery`  (
  `sid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `did` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `sid`(`sid`) USING BTREE,
  INDEX `did`(`did`) USING BTREE,
  CONSTRAINT `order_delivery_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `sale_order` (`ddnm`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_delivery_ibfk_2` FOREIGN KEY (`did`) REFERENCES `delivery` (`jhnm`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_delivery
-- ----------------------------
INSERT INTO `order_delivery` VALUES ('1', '1');

-- ----------------------------
-- Table structure for order_material
-- ----------------------------
DROP TABLE IF EXISTS `order_material`;
CREATE TABLE `order_material`  (
  `sid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `sid`(`sid`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  CONSTRAINT `order_material_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `sale_order` (`ddnm`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_material_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `material` (`wlnm`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_material
-- ----------------------------
INSERT INTO `order_material` VALUES ('1', '1');
INSERT INTO `order_material` VALUES ('1', '2');

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `depart` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `etime` date NULL DEFAULT NULL,
  `eway` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `currency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` decimal(10, 2) NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `applicant` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `atime` date NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay
-- ----------------------------
INSERT INTO `pay` VALUES ('1', '顺丰', '财务', '2018-09-18', '现金', '人民币', 2000.00, NULL, '张三', '2018-09-06', '通过');
INSERT INTO `pay` VALUES ('2', '中通', '推广', '2018-09-05', '转账', '人民币', 1000.00, NULL, '李四', '2018-09-11', '通过');

-- ----------------------------
-- Table structure for pay_detail
-- ----------------------------
DROP TABLE IF EXISTS `pay_detail`;
CREATE TABLE `pay_detail`  (
  `pid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `did` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `pid`(`pid`) USING BTREE,
  INDEX `did`(`did`) USING BTREE,
  CONSTRAINT `pay_detail_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `pay` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pay_detail_ibfk_2` FOREIGN KEY (`did`) REFERENCES `paydetail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_detail
-- ----------------------------
INSERT INTO `pay_detail` VALUES ('2', '2');
INSERT INTO `pay_detail` VALUES ('1', '1');
INSERT INTO `pay_detail` VALUES ('1', '6970');

-- ----------------------------
-- Table structure for paydetail
-- ----------------------------
DROP TABLE IF EXISTS `paydetail`;
CREATE TABLE `paydetail`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `runit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `anumber` decimal(10, 2) NULL DEFAULT NULL,
  `pnumber` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paydetail
-- ----------------------------
INSERT INTO `paydetail` VALUES ('1', '丰巢1', '支付宝', '中行账户', 2000.00, 2000.00);
INSERT INTO `paydetail` VALUES ('2', '天猫', '线上支付', '支付宝', 1000.00, 1000.00);
INSERT INTO `paydetail` VALUES ('6970', '测试', '1', '45', 0.00, 0.00);

-- ----------------------------
-- Table structure for sale_order
-- ----------------------------
DROP TABLE IF EXISTS `sale_order`;
CREATE TABLE `sale_order`  (
  `ddbh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ddnm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ywrq` date NULL DEFAULT NULL,
  `khmc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zje` decimal(50, 2) NULL DEFAULT NULL,
  `khdh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ddnm`) USING BTREE,
  INDEX `ddnm`(`ddnm`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_order
-- ----------------------------
INSERT INTO `sale_order` VALUES ('1', '1', '2018-08-15', '张三', 70000.00, '110');
INSERT INTO `sale_order` VALUES ('2', '2', '2018-08-22', '李四', 1000.00, '120');
INSERT INTO `sale_order` VALUES ('3', '3', '2018-08-07', '张三', 2897.50, '119');
INSERT INTO `sale_order` VALUES ('4', '4', '2018-08-24', '李四', 30000.00, '10086');

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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Redundant;

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
