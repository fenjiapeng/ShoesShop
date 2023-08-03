/*
 Navicat Premium Data Transfer

 Source Server         : java2305
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : shoesshop

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 04/08/2023 02:35:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `stock` int NULL DEFAULT NULL,
  `type_id` int NULL DEFAULT NULL,
  `size` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type_id`(`type_id` ASC) USING BTREE,
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 'W DUNK HIGH\r\n\"Fossil Stone\"', 'nike1.webp', 1087, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 15, 1, 42);
INSERT INTO `goods` VALUES (2, 'DUNK HIGH WMNS\r\n\"Panda (2021)\"', 'nike2.webp', 914, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 10, 1, 42);
INSERT INTO `goods` VALUES (3, 'AIR FORCE 1 LOW \'07\r\n\"White on White\"', 'nike3.webp', 813, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 50, 1, 42);
INSERT INTO `goods` VALUES (4, 'WMNS DUNK LOW\r\n\"Coconut Milk\"', 'nike4.webp', 1358, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 14, 1, 42);
INSERT INTO `goods` VALUES (5, 'SB DUNK LOW\r\n\"Concepts - Orange Lobster\"', 'nike5.webp', 3042, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 5, 1, 42);
INSERT INTO `goods` VALUES (6, 'YEEZY BOOST 350 V2\r\n\"Bone\"', 'adidas1.webp', 2810, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 55, 2, 42);
INSERT INTO `goods` VALUES (7, 'AIR JORDAN 13 HE GOT GAME AJ13 复刻熊猫 男篮球鞋 414571 104\r\n\"He Got Game\"', 'jordan6.jpg', 3738, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 10, 3, 42);
INSERT INTO `goods` VALUES (8, 'Air Jordan 4 Retro SE Craft\"Photon Dust', 'jordan1.webp', 2980, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 14, 3, 42);
INSERT INTO `goods` VALUES (9, 'Jordan\nAir Jordan 4 Retro WMNS\"Seafoam / Oil Green\"', 'jordan2.webp', 1890, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 4, 3, 42);
INSERT INTO `goods` VALUES (10, 'JordanAir Jordan 11\"Cherry 2022\"', 'jordan3.webp', 1500, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 45, 3, 42);
INSERT INTO `goods` VALUES (11, 'JordanAir Jordan 4\"Midnight Navy\"', 'jordan4.webp', 2589, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 12, 3, 42);
INSERT INTO `goods` VALUES (12, 'JordanAir Jordan 3 Retro\"Wizards\"', 'jordan5.webp', 1475, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 17, 3, 42);
INSERT INTO `goods` VALUES (13, 'NEW BALANCE', 'new-balance1webp.webp', 578, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 500, 4, 42);
INSERT INTO `goods` VALUES (14, 'JordanAir Jordan 4', 'jordan4.webp', 1477, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 10, 3, 42);
INSERT INTO `goods` VALUES (15, 'JordanAir Jordan 5', 'jordan4.webp', 1896, '整双鞋在高帮 Dunk 鞋型基础上采用奶茶色与白色拼接的设计，搭配侧身黑色 Swoosh Logo ，视觉效果可爱百搭。', 14, 3, 42);

-- ----------------------------
-- Table structure for manger
-- ----------------------------
DROP TABLE IF EXISTS `manger`;
CREATE TABLE `manger`  (
  `id` int NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manger
-- ----------------------------
INSERT INTO `manger` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `itemid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `count` int NULL DEFAULT NULL,
  `subtotal` double NULL DEFAULT NULL,
  `gid` int NULL DEFAULT NULL,
  `oid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`itemid`) USING BTREE,
  INDEX `go_id`(`gid` ASC) USING BTREE,
  INDEX `or_id`(`oid` ASC) USING BTREE,
  CONSTRAINT `go_id` FOREIGN KEY (`gid`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `or_id` FOREIGN KEY (`oid`) REFERENCES `orders` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('2364402DB8F340A79C10756982D62B55', 1, 1087, 1, '5DD25F4740BE49808FAEB9759352F404');
INSERT INTO `orderitem` VALUES ('5A403346089B42FDB1788F6EC7CD519D', 1, 1087, 1, '57DF890B4D9341E9B99CB0A5643D15DB');
INSERT INTO `orderitem` VALUES ('8E13B9DF33AC4A408854126C0358A782', 1, 1087, 1, '1CF7203959DC4298955AC2B7DCC43CCD');
INSERT INTO `orderitem` VALUES ('A0842750372C4FA5AC0B2DB3A766B8E6', 1, 1358, 4, 'B8A6576116374D2E9E7C6C49C0EF4216');
INSERT INTO `orderitem` VALUES ('EF949D949B9246018798228DAE5B8DFA', 1, 3042, 5, 'D398C2BF7EF04573AB92D73811A04598');
INSERT INTO `orderitem` VALUES ('F9BFFDC17CFD4909AFE3E5278059933B', 1, 1087, 1, '7E27D35C0C9D4CE49AA7371D34B2C0DF');
INSERT INTO `orderitem` VALUES ('FC982F5F8891484A8BB83772A357F697', 1, 914, 2, '1C939F3B70AA40CC9A5BE870F405F0A7');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ordertime` date NULL DEFAULT NULL,
  `total` double NULL DEFAULT NULL,
  `state` int NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `uid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid` ASC) USING BTREE,
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1C939F3B70AA40CC9A5BE870F405F0A7', '2023-08-03', 914, 1, '甘肃兰州', '老冯', '172555555', 3);
INSERT INTO `orders` VALUES ('1CF7203959DC4298955AC2B7DCC43CCD', '2023-08-03', 1087, 1, '陕西西安', '老余', '180222222', 2);
INSERT INTO `orders` VALUES ('57DF890B4D9341E9B99CB0A5643D15DB', '2023-08-03', 1087, 0, '甘肃兰州', '老冯', '172555555', 3);
INSERT INTO `orders` VALUES ('5DD25F4740BE49808FAEB9759352F404', '2023-08-03', 1087, 0, '甘肃庆阳', '小李', '789456123', 4);
INSERT INTO `orders` VALUES ('7E27D35C0C9D4CE49AA7371D34B2C0DF', '2023-08-03', 1087, 0, '甘肃庆阳', '小李', '789456123', 4);
INSERT INTO `orders` VALUES ('B8A6576116374D2E9E7C6C49C0EF4216', '2023-08-03', 1358, 0, '甘肃庆阳', '小李', '789456123', 4);
INSERT INTO `orders` VALUES ('D398C2BF7EF04573AB92D73811A04598', '2023-08-03', 3042, 1, '甘肃庆阳', '小李', '789456123', 4);

-- ----------------------------
-- Table structure for size
-- ----------------------------
DROP TABLE IF EXISTS `size`;
CREATE TABLE `size`  (
  `id` int NOT NULL,
  `size` double NULL DEFAULT NULL,
  `gid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `gid`(`gid` ASC) USING BTREE,
  CONSTRAINT `gid` FOREIGN KEY (`gid`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of size
-- ----------------------------
INSERT INTO `size` VALUES (1, 42, 1);
INSERT INTO `size` VALUES (2, 43, 1);
INSERT INTO `size` VALUES (3, 36, 1);
INSERT INTO `size` VALUES (4, 41, 1);
INSERT INTO `size` VALUES (5, 40, 1);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int NOT NULL,
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, 'NIKE');
INSERT INTO `type` VALUES (2, 'ADIDAS');
INSERT INTO `type` VALUES (3, 'Air Jordan');
INSERT INTO `type` VALUES (4, 'NEW BALANCE');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isadmin` bit(1) NULL DEFAULT NULL,
  `isvalidate` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'yzj', '77123@qq.com', '456789', '123', '180222222', '陕西西安', NULL, NULL);
INSERT INTO `user` VALUES (3, 'fjp', '123@qq.com', '123456', '老冯', '172555555', '甘肃兰州', NULL, NULL);
INSERT INTO `user` VALUES (4, 'lyt', '777@qq.com', '456789', '小李', '789456123', '甘肃庆阳', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
