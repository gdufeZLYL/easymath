/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : test_easymath

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-09-18 23:09:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `guid` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `student_set` varchar(255) NOT NULL COMMENT '学生集合',
  `class_name` varchar(40) NOT NULL COMMENT '班级名称',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`guid`),
  KEY `user_class_fk` (`uid`),
  CONSTRAINT `user_class_fk` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='班级数据表';

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES ('1', '1', '', '广东财经大学测试1班', '2017-09-18 17:01:12');
INSERT INTO `class_info` VALUES ('2', '1', '', '广东财经大学测试2班', '2017-09-18 17:01:27');

-- ----------------------------
-- Table structure for score_info
-- ----------------------------
DROP TABLE IF EXISTS `score_info`;
CREATE TABLE `score_info` (
  `testid` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩ID',
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `type` int(11) DEFAULT NULL COMMENT '测试类型',
  `level` int(11) DEFAULT NULL COMMENT '测试等级',
  `que_type` int(11) DEFAULT NULL,
  `score_right` int(11) DEFAULT NULL COMMENT '答对的数量',
  `score_wrong` int(11) DEFAULT NULL COMMENT '答错的数量',
  `finish_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '完成的时间',
  PRIMARY KEY (`testid`),
  KEY `user_test_fk` (`uid`),
  CONSTRAINT `user_test_fk` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成绩数据表';

-- ----------------------------
-- Records of score_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键Id',
  `account` varchar(30) NOT NULL COMMENT '用户账户',
  `password` varchar(30) NOT NULL COMMENT '用户密码',
  `nickname` varchar(30) NOT NULL COMMENT '用户昵称',
  `school` varchar(30) NOT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户创建时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'admin', 'excitedzeng', '曾庆熙', '广东财经大学', '2017-09-18 15:51:15');
INSERT INTO `user_info` VALUES ('2', '14251104201', '123456', '柯小南', '广东财经大学', '2017-09-18 17:03:46');
INSERT INTO `user_info` VALUES ('3', '14251104202', '123456', '柯大楠', '广东财经大学', '2017-09-18 17:04:07');
