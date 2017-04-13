/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2017-04-13 12:53:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'a', '2');
INSERT INTO `user` VALUES ('2', 'b', '3');
INSERT INTO `user` VALUES ('3', 'asdf', '12');
INSERT INTO `user` VALUES ('4', 'ddd', '34345');
INSERT INTO `user` VALUES ('5', '飞哥', '24');
INSERT INTO `user` VALUES ('8', '不', '434');
