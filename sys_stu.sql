/*
 Navicat Premium Data Transfer

 Source Server         : 47.102.217.51
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : 47.102.217.51:3306
 Source Schema         : sys_stu

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 03/09/2020 09:19:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for success_killed
-- ----------------------------
DROP TABLE IF EXISTS `success_killed`;
CREATE TABLE `success_killed`  (
  `stu_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `elective_id` int(11) NOT NULL,
  `success_time` timestamp(0) NULL DEFAULT NULL,
  `state` tinyint(255) NULL DEFAULT -1,
  PRIMARY KEY (`stu_num`, `elective_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of success_killed
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perm_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `perm_decription` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, 'changePassword', '修改密码');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'student', '学生');
INSERT INTO `sys_role` VALUES (2, 'teacher', '教师');
INSERT INTO `sys_role` VALUES (3, 'admin', '管理员');

-- ----------------------------
-- Table structure for sys_rp
-- ----------------------------
DROP TABLE IF EXISTS `sys_rp`;
CREATE TABLE `sys_rp`  (
  `role_id` int(11) NULL DEFAULT NULL,
  `perm_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_rp
-- ----------------------------
INSERT INTO `sys_rp` VALUES (1, 2);
INSERT INTO `sys_rp` VALUES (3, 3);

-- ----------------------------
-- Table structure for sys_ur
-- ----------------------------
DROP TABLE IF EXISTS `sys_ur`;
CREATE TABLE `sys_ur`  (
  `user_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_ur
-- ----------------------------
INSERT INTO `sys_ur` VALUES (1, 1);
INSERT INTO `sys_ur` VALUES (1, 3);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_status` int(4) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 196 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '1610701120', 'f7f05b0bf83fd2abe714dcdbfe9ef6dc', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (2, '1610701121', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (131, '1610701101', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (132, '1610701102', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (133, '1610701103', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (134, '1610701104', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (135, '1610701105', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (136, '1610701106', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (137, '1610701107', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (138, '1610701108', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (139, '1610701109', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (140, '1610701110', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (141, '1610701111', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (142, '1610701112', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (143, '1610701113', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (144, '1610701114', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (145, '1610701115', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (146, '1610701116', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (147, '1610701117', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (148, '1610701118', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (149, '1610701119', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (150, '1610701122', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (151, '1610701123', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (152, '1610701124', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (153, '1610701125', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (154, '1610701126', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (155, '1610701127', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (156, '1610701128', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (157, '1610701129', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (158, '1610701130', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (159, '1610701131', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (160, '1610701132', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (194, '1610701134', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (195, '1610701135', 'fc1709d0a95a6be30bc5926fdb7f22f4', NULL, NULL, 1);

-- ----------------------------
-- Table structure for t_appraise
-- ----------------------------
DROP TABLE IF EXISTS `t_appraise`;
CREATE TABLE `t_appraise`  (
  `stu_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tc_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `option1` double(11, 2) NULL DEFAULT NULL,
  `option2` double(11, 2) NULL DEFAULT NULL,
  `avg` double(11, 2) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_appraise
-- ----------------------------
INSERT INTO `t_appraise` VALUES ('1610701120', '1', 3.00, 3.00, 3.00);
INSERT INTO `t_appraise` VALUES ('1610701120', '3', 3.00, 3.00, 3.00);
INSERT INTO `t_appraise` VALUES ('1610701120', '6', 5.00, 3.00, 4.00);

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1003 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES (1001, 'java1班');
INSERT INTO `t_class` VALUES (1002, 'java2班');

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coures_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `course_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tc_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES (1, '121001', 'zzz', 6);
INSERT INTO `t_course` VALUES (2, '121002', 'xxx', 5);
INSERT INTO `t_course` VALUES (3, '121003', 'ccc', 4);
INSERT INTO `t_course` VALUES (4, '121004', 'vvv', 3);
INSERT INTO `t_course` VALUES (5, '121005', 'bbb', 2);
INSERT INTO `t_course` VALUES (6, '121007', 'nnn', 1);

-- ----------------------------
-- Table structure for t_course_class
-- ----------------------------
DROP TABLE IF EXISTS `t_course_class`;
CREATE TABLE `t_course_class`  (
  `class_id` int(11) NULL DEFAULT NULL,
  `course_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_course_class
-- ----------------------------
INSERT INTO `t_course_class` VALUES (1001, 3);
INSERT INTO `t_course_class` VALUES (1002, 2);
INSERT INTO `t_course_class` VALUES (1001, 1);
INSERT INTO `t_course_class` VALUES (1001, 4);
INSERT INTO `t_course_class` VALUES (1001, 5);
INSERT INTO `t_course_class` VALUES (1001, 6);

-- ----------------------------
-- Table structure for t_elective
-- ----------------------------
DROP TABLE IF EXISTS `t_elective`;
CREATE TABLE `t_elective`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `elective_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stock` int(255) NULL DEFAULT NULL,
  `start_time` timestamp(0) NULL DEFAULT NULL,
  `end_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_elective
-- ----------------------------
INSERT INTO `t_elective` VALUES (1, 'tttttt', 10, '2019-08-07 14:16:10', '2019-08-08 14:16:18');
INSERT INTO `t_elective` VALUES (2, 'yyyyyy', 0, '2019-08-05 14:16:21', '2019-08-30 14:16:24');
INSERT INTO `t_elective` VALUES (3, 'oooooo', 3, '2019-08-07 14:16:27', '2019-08-14 14:16:32');
INSERT INTO `t_elective` VALUES (4, 'pppppp', 4, '2019-09-26 20:00:00', '2019-12-28 20:02:00');
INSERT INTO `t_elective` VALUES (6, '外语课', 5, '2019-08-15 15:39:38', '2020-03-27 15:39:44');
INSERT INTO `t_elective` VALUES (7, '日语课', 0, '2019-08-12 19:52:32', '2020-01-30 19:52:35');

-- ----------------------------
-- Table structure for t_score
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score`  (
  `stu_id` int(11) NULL DEFAULT NULL,
  `course_id` int(11) NULL DEFAULT NULL,
  `score` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_score
-- ----------------------------
INSERT INTO `t_score` VALUES (1, 1, 80);
INSERT INTO `t_score` VALUES (1, 2, 80);
INSERT INTO `t_score` VALUES (2, NULL, NULL);

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `stu_num` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_gender` int(11) NULL DEFAULT NULL,
  `stu_age` int(11) NULL DEFAULT NULL,
  `stu_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`stu_num`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1610701101', '安真幸', 2, NULL, '17826260025', '2693491014@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701102', '蔡祺耀', 1, NULL, '17826260737', '937058016@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701103', '陈凯', 1, NULL, '15961099720', '1737990299@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701104', '仇舒豪', 1, NULL, '15358260375', '810863161@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701105', '戴维超', 1, NULL, '18360497748', '721471801@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701106', '樊乘乘', 1, NULL, '17826260016', '309219094@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701107', '冯彬彬', 2, NULL, '17826260836', '308988340@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701108', '高媛媛', 2, NULL, '17715942063', '1592100982@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701109', '龚柄瑞', 1, NULL, '17826260232', '2322538677@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701110', '古赛昆', 1, NULL, '17826261291', '1339982411@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701111', '黄淑君', 1, NULL, '15295308982', '943626862@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701112', '蒋楠楠', 2, NULL, '17826263390', '2416544808@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701113', '李层层', 1, NULL, '17826260327', '2047954711@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701114', '刘斓', 2, NULL, '15161991227', '2495812446@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701115', '刘庆', 1, NULL, '17826263582', '1219302769@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701116', '陆嘉良', 1, NULL, '17826261206', '1098335908@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701117', '倪大洋', 1, NULL, '15051342307', '1782055745@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701118', '倪奇', 1, NULL, '17826263561', '1290346330@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701119', '宋金程', 1, NULL, '15751233148', '1248382652@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701120', '宋金程', 1, 20, '17749598136', '528424355@qq.com', 1001);
INSERT INTO `t_student` VALUES ('1610701121', '王鑫', 1, NULL, '17826261061', '1907298000@qq.com', 1002);
INSERT INTO `t_student` VALUES ('1610701122', '王学臣', 1, NULL, '13862685285', '1581839619@qq.com', 1002);
INSERT INTO `t_student` VALUES ('1610701123', '王震', 1, NULL, '13912363796', '1173375190@qq.com', 1002);
INSERT INTO `t_student` VALUES ('1610701124', '徐诚豪', 1, NULL, '18896564491', '1913899707@qq.com', 1002);
INSERT INTO `t_student` VALUES ('1610701125', '徐梦麟', 1, NULL, '17826265706', '917897434@qq.com', 1002);
INSERT INTO `t_student` VALUES ('1610701126', '徐正媛', 2, NULL, '17826263531', '1650426875@qq.com', 1002);
INSERT INTO `t_student` VALUES ('1610701127', '虞育涛', 1, NULL, '13771453831', '2549326724@qq.com', 1002);
INSERT INTO `t_student` VALUES ('1610701128', '张旭东', 1, NULL, '17826263701', '1130923412@qq.com', 1002);
INSERT INTO `t_student` VALUES ('1610701129', '张逸轩', 1, NULL, '18352889192', '705681912@qq.com', 1002);
INSERT INTO `t_student` VALUES ('1610701130', '赵乾坤', 1, NULL, '17826263609', '373020024@qq.com', 1002);
INSERT INTO `t_student` VALUES ('1610701131', '周乃涛', 1, NULL, '15161771097', '1367278852@qq.com', NULL);
INSERT INTO `t_student` VALUES ('1610701132', '周宇', 1, NULL, '13912852257', '1297799065@qq.com', NULL);
INSERT INTO `t_student` VALUES ('1610701134', '朱江涛', 1, NULL, '13305108109', '741666642@qq.com', NULL);
INSERT INTO `t_student` VALUES ('1610701135', '朱宇清', 1, NULL, '17826260105', '1825791715@qq.com', NULL);

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tc_num` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tc_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `course_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (1, '0610701120', '张老师', 6);
INSERT INTO `t_teacher` VALUES (2, '0610701121', '李老师', 5);
INSERT INTO `t_teacher` VALUES (3, '0610701122', '陈老师', 4);
INSERT INTO `t_teacher` VALUES (4, '0610701123', '田老师', 3);
INSERT INTO `t_teacher` VALUES (5, '0610701124', '王老师', 2);
INSERT INTO `t_teacher` VALUES (6, '0610701125', '刘老师', 1);

SET FOREIGN_KEY_CHECKS = 1;
