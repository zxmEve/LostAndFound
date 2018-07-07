SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'laowang', '123456', '13117293216', '123456@qq.com');
INSERT INTO `user` VALUES ('2', 'laochen', '123456', '13687173777', '123963@qq.com');
INSERT INTO `user` VALUES ('3', 'laozhou', '123456', '13687173778', '123852@qq.com');
INSERT INTO `user` VALUES ('4', 'laohu', '123456', '13687173777', '123741@qq.com');

-- ----------------------------
-- Table structure for lost
-- ----------------------------
DROP TABLE IF EXISTS `lost`;
CREATE TABLE lost(
   lostID int NOT NULL AUTO_INCREMENT,
   userID int NOT NULL,
   lostName varchar(45) NOT NULL,
   lostType varchar(45) DEFAULT NULL,
   lostDate datetime DEFAULT NULL,
   lostPlace varchar(45) DEFAULT NULL,
   lostPhone varchar(12) DEFAULT NULL,
   reportDate datetime DEFAULT NULL,
   lostInfo text DEFAULT NULL,
   lostCity varchar(45) DEFAULT NULL,
   state int DEFAULT NULL,
   image  varchar(500) DEFAULT NULL,
   PRIMARY KEY (lostID),
   FOREIGN KEY (userID) references user(userID)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for found
-- ----------------------------
DROP TABLE IF EXISTS `found`;
CREATE TABLE found(
   pickID int NOT NULL AUTO_INCREMENT,
   userID int NOT NULL,
   pickName varchar(45) NOT NULL,
   pickType varchar(45) DEFAULT NULL,
   pickDate datetime DEFAULT NULL,
   pickPlace varchar(45) DEFAULT NULL,
   pickPhone varchar(12) DEFAULT NULL,
   reportDate datetime DEFAULT NULL,
   storePlace varchar(45) DEFAULT NULL,
   pickInfo text DEFAULT NULL,
   pickCity varchar(45) DEFAULT NULL,
   state int DEFAULT NULL,
   image  varchar(500) DEFAULT NULL,
   PRIMARY KEY (pickID),
   FOREIGN KEY (userID) references user(userID)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;





