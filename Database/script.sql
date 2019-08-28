/*
SQLyog Ultimate v12.09 (32 bit)
MySQL - 8.0.11 : Database - realestate_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`realestate_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `realestate_db`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `accountid` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) NOT NULL,
  `password` varchar(128) NOT NULL,
  `username` varchar(36) NOT NULL,
  `customer_customer_id` int(11) DEFAULT NULL,
  `employee_employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`accountid`),
  UNIQUE KEY `Account_UK` (`username`),
  KEY `FK8p188ud3c73tq5mcu32muewjt` (`customer_customer_id`),
  KEY `FK7dm2i6k5n35g07d6ocyt574yg` (`employee_employee_id`),
  CONSTRAINT `FK7dm2i6k5n35g07d6ocyt574yg` FOREIGN KEY (`employee_employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FK8p188ud3c73tq5mcu32muewjt` FOREIGN KEY (`customer_customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `account` */

insert  into `account`(`accountid`,`enabled`,`password`,`username`,`customer_customer_id`,`employee_employee_id`) values (1,'','$2a$10$7tbtkvKak7roCZcM3S2q0u10hk4M.EXSBN9BuJHp9LLjPDEIznyKi','thuydx',NULL,1),(2,'','$2a$10$V70.FQlsCDDqKndc6ubJTefqGNiEWKC7UuqxlVp7bsvVt0yS7kssO','hoanv',NULL,2),(3,'','$2a$10$RykGMUvH.XuO52l/ULC1i.PYhCXSka7CFUU/KOaTZ0ce/ucGRmnya','minhhoa',NULL,3),(4,'','$2a$10$wAMOzi0EV/Rlpu73thi..el3HsgTjv3LLCthTLZqwrfF40UDtjGo.','annc',1,NULL),(5,'','$2a$10$oqBZwEGY9nmUNJM2EVWtA.GqxQY34eVZ5DPi65jAvYBjzSXbbtNUW','tuantv',2,NULL),(6,'','$2a$10$DBnPEzDHz/iVn4W0GnL.T.I2VKW4slpkv7PHInSLPoBGTSrE/9t.q','thiennu',3,NULL),(7,'','$2a$10$7Mf9MxS4A8.wMTiMhmQiBOIdhhiZ2Jo7Yf5lI1sHl3g9jj3It0HT.','minhnc',4,NULL),(8,'','$2a$10$RykGMUvH.XuO52l/ULC1i.PYhCXSka7CFUU/KOaTZ0ce/ucGRmnya','user1',9,NULL),(9,'','$2a$10$RykGMUvH.XuO52l/ULC1i.PYhCXSka7CFUU/KOaTZ0ce/ucGRmnya','user2',10,NULL),(10,'','$2a$10$RykGMUvH.XuO52l/ULC1i.PYhCXSka7CFUU/KOaTZ0ce/ucGRmnya','user3',11,NULL),(11,'','$2a$10$RykGMUvH.XuO52l/ULC1i.PYhCXSka7CFUU/KOaTZ0ce/ucGRmnya','user4',12,NULL),(12,'','$2a$10$RykGMUvH.XuO52l/ULC1i.PYhCXSka7CFUU/KOaTZ0ce/ucGRmnya','user5',13,NULL),(13,'','$2a$10$RykGMUvH.XuO52l/ULC1i.PYhCXSka7CFUU/KOaTZ0ce/ucGRmnya','emp1',NULL,4),(14,'','$2a$10$RykGMUvH.XuO52l/ULC1i.PYhCXSka7CFUU/KOaTZ0ce/ucGRmnya','emp2',NULL,5),(15,'','$2a$10$RykGMUvH.XuO52l/ULC1i.PYhCXSka7CFUU/KOaTZ0ce/ucGRmnya','emp3',NULL,6),(16,'','$2a$10$RykGMUvH.XuO52l/ULC1i.PYhCXSka7CFUU/KOaTZ0ce/ucGRmnya','emp4',NULL,7),(17,'','$2a$10$RykGMUvH.XuO52l/ULC1i.PYhCXSka7CFUU/KOaTZ0ce/ucGRmnya','emp5',NULL,8),(18,'\0','$2a$10$dBxXVdMZdxzByLcvV7MLteZo3uLXF/zOcuvGdcRwL9Wdr3nslcXRy','huyhoangLT',14,NULL),(19,'\0','$2a$10$qrMfVTXS1mHwxti.AOop0ON0ud6BuZXrG1pjW8ZaancWnXwFWPAgu','minhdao1',15,NULL),(20,'\0','$2a$10$4Ct5O6CeeVVyy/Cd.AhBVePDTNuMmyymdRHDEme54WxVmUOz51k0e','minhdao2',16,NULL),(21,'\0','$2a$10$T.pX/7dQY4hIu9Hd9QpXzugAKjTF4FK0yNA/UqOFk2443nu5ouIFq','minhdao3',17,NULL),(22,'\0','$2a$10$CIPMMi5vJlioGHYZpTDoROMK8v3zAgg/qZn5Lv3bVBjoB6T.rq0Ae','minhdao4',18,NULL),(23,'\0','$2a$10$hfaSPjVQxl4CBt2qwIV95u5RrJy7AhR4qAuxCGxEleuHcT5wg2QRO','minhdao5',19,NULL),(24,'\0','$2a$10$GjRS.mIdpKalzCgg4YlAUudwzc7N4JFeTtV2BUiv5tDah6jpDNN16','minhdao6',20,NULL),(25,'\0','$2a$10$3Bmhde9eQUn81JIJjOiZ/eKn0/mx0yG8F3qSYgjLyIEJ2uYtyWoQu','minhdao7',21,NULL),(26,'\0','$2a$10$2awyMFn5aH97.2XgBaoBU.KI6PvL2K0.5bcuLPddu2OMJb7lQqesS','minhdao8',22,NULL),(27,'\0','$2a$10$xyS1i7uPF.BNlH3.xXLgmu1SP7hiyPASR6wrY0sQ82EJl4KrO9l.2','minhdao89',23,NULL);

/*Table structure for table `account_role` */

DROP TABLE IF EXISTS `account_role`;

CREATE TABLE `account_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_accountid` int(11) NOT NULL,
  `role_roleid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfruk1k8w4nkj6p38y8h4yybdb` (`account_accountid`),
  KEY `FK38a9ieeidaon0vs708er3y463` (`role_roleid`),
  CONSTRAINT `FK38a9ieeidaon0vs708er3y463` FOREIGN KEY (`role_roleid`) REFERENCES `role` (`roleid`),
  CONSTRAINT `FKfruk1k8w4nkj6p38y8h4yybdb` FOREIGN KEY (`account_accountid`) REFERENCES `account` (`accountid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `account_role` */

insert  into `account_role`(`id`,`account_accountid`,`role_roleid`) values (1,1,1),(2,1,2),(3,2,2),(4,3,2),(5,4,3),(6,5,3),(8,6,3),(9,7,3),(10,8,3),(11,9,3),(12,10,3),(13,11,3),(14,12,3),(16,13,2),(17,14,2),(18,15,2),(19,16,2),(20,17,2);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(200) NOT NULL,
  `create_date` datetime NOT NULL,
  `email` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer` */

insert  into `customer`(`customer_id`,`address`,`create_date`,`email`,`fullname`) values (1,'100 Cộng Hòa, Tân Bình, Hồ Chí Minh','2018-12-17 15:16:15','AnNC@gmail.com','Ngô Công An'),(2,'8/8 Tân Lập, Đông Hòa, Dĩ An, Bình Dương','2018-12-15 15:17:53','TuanTV@gmail.com','Trần Văn Tuấn'),(3,'123 Tân Thượng, Di Linh, Lâm Đồng','2018-12-04 15:18:47','ThienNU@gmail.com','Nguyễn Út Thiện'),(4,'56 Hòa Bình, Phường 6, Quận 2, Hồ Chí Minh','2018-11-07 15:19:44','MinhNC@gmail.com','Ngô Công Minh'),(9,'101, Lê Đại Hành, Phường 9, Quận 5, Hồ CHí Minh','2018-12-24 15:19:44','HuongLT@gmail.com','Lê Thị Thùy'),(10,'54, Nguyễn Công Trứ, Quận 2, Hồ Chí Minh','2018-12-24 12:19:44','Minh@gmail.com','Ngô Công'),(11,'Quận 7, Hồ Chí Minh','2018-12-24 20:19:44','hoaNT@gmail.com','Nguyễn Tiến'),(12,'Quận 9, Hồ Chí Minh','2018-12-24 02:19:44','lieunu@gmail.com','nguyễn út liễu'),(13,'11, Lê Lợi, Phường 8, Quận 7, Hồ Chí Minh','2018-12-24 22:19:44','AnDT@gmail.com','Đinh thị an'),(14,'Quận 1, Hồ Chí Minh','2015-12-12 00:00:00','huy@gmail.com','Huy Hoàng'),(15,'Quận 1, Hồ Chí Minh','2015-12-12 00:00:00','dao113@gmail.com','Nguyễn Minh Đạo 1'),(16,'Quận 1, Hồ Chí Minh','2016-12-12 00:00:00','dao114@gmail.com','Nguyễn Minh Đạo 2'),(17,'Quận 1, Hồ Chí Minh','2012-12-12 00:00:00','dao3@gmail.com','Nguyễn Minh Đạo 3'),(18,'Quận 1, Hồ Chí Minh','2013-12-12 00:00:00','dao4@gmail.com','Nguyễn Minh Đạo 4'),(19,'Quận 1, Hồ Chí Minh','2013-12-12 00:00:00','dao5@gmail.com','Nguyễn Minh Đạo 5'),(20,'Quận 1, Hồ Chí Minh','2013-12-12 00:00:00','dao6@gmail.com','Nguyễn Minh Đạo 6'),(21,'Quận 1, Hồ Chí Minh','2014-12-12 00:00:00','dao7@gmail.com','Nguyễn Minh Đạo 7'),(22,'Quận 1, Hồ Chí Minh','2015-12-12 00:00:00','dao8@gmail.com','Nguyễn Minh Đạo 8'),(23,'Quận 1, Hồ Chí Minh','2016-12-12 00:00:00','dao9@gmail.com','Nguyễn Minh Đạo 9');

/*Table structure for table `direction` */

DROP TABLE IF EXISTS `direction`;

CREATE TABLE `direction` (
  `direction_id` int(11) NOT NULL AUTO_INCREMENT,
  `direction_title` varchar(50) NOT NULL,
  PRIMARY KEY (`direction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `direction` */

insert  into `direction`(`direction_id`,`direction_title`) values (1,'Đông'),(2,'Tây'),(3,'Nam'),(4,'Bắc'),(5,'Đông Bắc'),(6,'Đông Nam'),(7,'Tây Bắc'),(8,'Tây Nam');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(200) NOT NULL,
  `email` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `id_number` int(11) DEFAULT NULL,
  `phone_number` int(11) DEFAULT NULL,
  `manager_employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FKdk9t4nuvpqrslkqqbbgepn9eq` (`manager_employee_id`),
  CONSTRAINT `FKdk9t4nuvpqrslkqqbbgepn9eq` FOREIGN KEY (`manager_employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `employee` */

insert  into `employee`(`employee_id`,`address`,`email`,`fullname`,`id_number`,`phone_number`,`manager_employee_id`) values (1,'22 Hoàng Hoa Thám, Phường 9, Quận 9, Hồ Chí Minh','thuydx.9598@gmail.com','Đào Xuân Thủy',251125147,979319598,NULL),(2,'12 Trường Chinh, Tân Bình, Hồ Chí Minh','HoaNV@gmail.com','Nguyễn Văn Hòa',282839292,91293293,1),(3,'101 Thôn 9, Hòa Ninh, Di Linh, Lâm Đồng','nam@gmail.com','Lê Hòa Nam',251125147,123233,1),(4,'98, Tân Thượng, Di Linh, Lâm Đồng','nguyenthien98@gmail.com','Nguyễn Út Thiện',2147483647,982773733,1),(5,'121, Nguyễn Công Trứ, phường 2, Hóc Môn, Hồ Chí Minh','namPT@gmail.com','Phan Thanh Nam',282928272,182727272,1),(6,'nguyễn chí thanh, ba đình, hà  nội','luong@gmail.com','lá thị liễu',12312321,986754234,1),(7,'bùi viện thành phố hồ chí minh','bangchucaibang@gmail.com','lầu văn lùn',123123,845342323,1),(8,'bùi thị xuân tp đà lạt','checkker@gmail.com','liều văn tháo',123123134,1241243254,1);

/*Table structure for table `post_details` */

DROP TABLE IF EXISTS `post_details`;

CREATE TABLE `post_details` (
  `details_id` int(11) NOT NULL AUTO_INCREMENT,
  `alley` bit(1) DEFAULT NULL,
  `bathroom` int(11) DEFAULT NULL,
  `bedroom` int(11) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `direction_direction_id` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`details_id`),
  KEY `FKbr8ld383x87njw20b2ijw6gm2` (`direction_direction_id`),
  KEY `FK4f2ime4w6jqxd6jocu54ve13r` (`post_id`),
  CONSTRAINT `FK4f2ime4w6jqxd6jocu54ve13r` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`),
  CONSTRAINT `FKbr8ld383x87njw20b2ijw6gm2` FOREIGN KEY (`direction_direction_id`) REFERENCES `direction` (`direction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `post_details` */

insert  into `post_details`(`details_id`,`alley`,`bathroom`,`bedroom`,`floor`,`direction_direction_id`,`post_id`) values (1,'',3,4,2,1,4);

/*Table structure for table `post_images` */

DROP TABLE IF EXISTS `post_images`;

CREATE TABLE `post_images` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(100) NOT NULL,
  `post_post_id` int(11) NOT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FKbv6pg9et8fbuxpygm8ufkfd3t` (`post_post_id`),
  CONSTRAINT `FKbv6pg9et8fbuxpygm8ufkfd3t` FOREIGN KEY (`post_post_id`) REFERENCES `posts` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `post_images` */

insert  into `post_images`(`image_id`,`url`,`post_post_id`) values (1,'1.1.jpg',4),(2,'1.2.jpg',4),(3,'1.3.jpg',4),(5,'2.1.jpg',5),(6,'2.2.jpg',5),(7,'3.1.jpg',6),(8,'3.2.jpg',6);

/*Table structure for table `post_status` */

DROP TABLE IF EXISTS `post_status`;

CREATE TABLE `post_status` (
  `status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_title` varchar(100) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `post_status` */

insert  into `post_status`(`status_id`,`status_title`) values (1,'Waiting'),(2,'Approved'),(3,'Blocked');

/*Table structure for table `post_type` */

DROP TABLE IF EXISTS `post_type`;

CREATE TABLE `post_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_tittle` varchar(30) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `post_type` */

insert  into `post_type`(`type_id`,`type_tittle`) values (1,'Cần mua'),(2,'Cần bán'),(3,'Cần thuê'),(4,'Cần cho thuê');

/*Table structure for table `posts` */

DROP TABLE IF EXISTS `posts`;

CREATE TABLE `posts` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `area` double NOT NULL,
  `description` longtext NOT NULL,
  `location` varchar(255) NOT NULL,
  `post_time` datetime DEFAULT NULL,
  `price` double NOT NULL,
  `project` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `author_customer_id` int(11) NOT NULL,
  `post_type_type_id` int(11) NOT NULL,
  `real_estale_type_realestate_id` int(11) NOT NULL,
  `status_status_id` int(11) NOT NULL,
  PRIMARY KEY (`post_id`),
  KEY `FKbw37bjtotbd1sc1xasbhew9ky` (`author_customer_id`),
  KEY `FKbj1390j3e0qgujctiiqxm96nj` (`post_type_type_id`),
  KEY `FKl7md3xug5eq5avaa8qjx1cg1p` (`real_estale_type_realestate_id`),
  KEY `FKkjnjnjlck3j548juki16oakip` (`status_status_id`),
  CONSTRAINT `FKbj1390j3e0qgujctiiqxm96nj` FOREIGN KEY (`post_type_type_id`) REFERENCES `post_type` (`type_id`),
  CONSTRAINT `FKbw37bjtotbd1sc1xasbhew9ky` FOREIGN KEY (`author_customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `FKkjnjnjlck3j548juki16oakip` FOREIGN KEY (`status_status_id`) REFERENCES `post_status` (`status_id`),
  CONSTRAINT `FKl7md3xug5eq5avaa8qjx1cg1p` FOREIGN KEY (`real_estale_type_realestate_id`) REFERENCES `realestate_type` (`realestate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `posts` */

insert  into `posts`(`post_id`,`area`,`description`,`location`,`post_time`,`price`,`project`,`title`,`author_customer_id`,`post_type_type_id`,`real_estale_type_realestate_id`,`status_status_id`) values (4,100,'Cần bán  nhà của tôi','102, Lê Văn Việt, Quận 9, Hồ Chí Minh','2018-12-24 16:54:55',1300000000,NULL,'Cần bán nhà của tôi',1,1,1,2),(5,50,'Cần bán đất của hàng xóm','44, Hoàng Hoa Thám, Quận 12, Hồ Chí Minh','2018-12-24 01:55:48',900000000,NULL,'Bán đất',2,2,2,2),(6,800,'Cần cho thuê căn hộ chung cư','34, Nguyễn Hữu Cảnh, Quận 2, Hồ Chi Minh','2018-12-23 20:57:16',2100000000,NULL,'Cho thuê căn hộ',3,3,3,2),(7,360,'description example 1',' xã Thuận Giao, huyện Thuận An, tỉnh Bình Dương','2018-12-24 15:46:23',620000000,NULL,'Cần tiền cưới vợ bán đất',1,4,4,2),(8,60,'description example 2','Quận 12 Phường Thạnh Lộc, Quận 12, TP.Hồ Chí Minh','2018-12-24 11:46:23',10000000,NULL,'Sổ Hồng! Nhà 2 Lầu Đường Xe Hơi Hà Huy Giáp\r\n',2,4,4,3),(9,56,'description example 3','193/18 khu phố 8 f bhhb bình tân Phường Bình Hưng Hoà B, Quận Bình Tân, TP.Hồ Chí Minh','2018-12-24 21:46:23',3100000000,NULL,'Nhà 53/181/10/2C, đường số 4, f bhhb, bình tân, 1m x 14m đúc 1 tấm, shr.',3,2,2,3),(10,100,'Cần bán  nhà của tôi','102, Lê Văn Việt, Quận 9, Hồ Chí Minh','2018-12-21 16:54:55',1300000000,NULL,'Cần bán nhà của tôi',1,1,1,2),(11,50,'Cần bán đất của hàng xóm','44, Hoàng Hoa Thám, Quận 12, Hồ Chí Minh','2018-12-24 01:55:48',900000000,NULL,'Bán đất',2,2,2,3),(12,800,'Cần cho thuê căn hộ chung cư','34, Nguyễn Hữu Cảnh, Quận 2, Hồ Chi Minh','2018-12-23 20:57:16',2100000000,NULL,'Cho thuê căn hộ',3,3,3,1),(13,100,'description 4','515 hương lộ 2 P.Bình Trị Đông, Quận Bình Tân, TP.Hồ Chí Minh','2018-12-24 22:46:23',350000000,NULL,'Đất SHR, Xây tự do 100m2',2,1,1,1),(14,250,'description example 5','Xã Phạn Văn Hai, Huyện Bình Chánh, TP.Hồ Chí Minh','2018-12-25 02:46:23',2100000000,NULL,'Bán 2 Dãy Trọ 16 Phòng',3,3,3,1),(15,150,'description example 6','25A Phường Hiệp Bình Phước, Quận Thủ Đức, TP.Hồ Chí Minh','2018-12-24 13:46:23',310000000,NULL,'Thanh Lý Đất Khu Đô Thị - Kcn',1,2,4,1),(16,123,'decription 1','Quận 1, Hồ Chí Minh','2012-12-01 00:00:00',123000000,NULL,'Title 1',14,2,3,2),(17,111,'đécription 2','Quận 1, Hồ Chí Minh','2012-02-23 00:00:00',12211212,NULL,'Title 2',15,1,4,2),(18,50,'description 3','District 1, Ho Chi Minh City','2013-01-01 00:00:00',19191919,NULL,'Title 3',16,4,6,2),(19,70,'description 4','District 3, Ho Chi Minh City','2014-01-02 00:00:00',1200000000,NULL,'Title 4',17,2,2,2),(20,32,'description 4','District 2, Ho Chi Minh City','2015-03-02 00:00:00',100000000,NULL,'Title 5',18,1,3,2),(21,90,'description 5','District 7, Ho Chi Minh City','2015-03-02 00:00:00',2100000000,NULL,'Title 6',12,3,2,2),(22,21,'descriotin 6','District 9, Ho Chi Minh City','2016-02-08 00:00:00',210000000,NULL,'Title 7',13,2,4,2),(23,210,'description\r\n','Thu Duc District, Ho Chi Minh City','2017-04-05 00:00:00',320000000,NULL,'Title 8',19,1,2,2);

/*Table structure for table `realestate_type` */

DROP TABLE IF EXISTS `realestate_type`;

CREATE TABLE `realestate_type` (
  `realestate_id` int(11) NOT NULL AUTO_INCREMENT,
  `realestate_title` varchar(30) NOT NULL,
  PRIMARY KEY (`realestate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `realestate_type` */

insert  into `realestate_type`(`realestate_id`,`realestate_title`) values (1,'Nhà'),(2,'Đất'),(3,'Căn hộ'),(4,'Mặt bằng'),(5,'Kho xưởng'),(6,'Khác');

/*Table structure for table `reported_post` */

DROP TABLE IF EXISTS `reported_post`;

CREATE TABLE `reported_post` (
  `report_id` int(11) NOT NULL AUTO_INCREMENT,
  `reason` varchar(200) NOT NULL,
  `reported_time` datetime NOT NULL,
  `status` bit(1) NOT NULL,
  `censor_employee_id` int(11) DEFAULT NULL,
  `post_post_id` int(11) NOT NULL,
  `reporter_customer_id` int(11) NOT NULL,
  PRIMARY KEY (`report_id`),
  KEY `FK32aq5qn0kdmnmhdnble3afpbs` (`censor_employee_id`),
  KEY `FKdcyjf6bl9ohxyli9j8sv1mwko` (`post_post_id`),
  KEY `FKqrgwywqg78ydg7qse22fbvsw2` (`reporter_customer_id`),
  CONSTRAINT `FK32aq5qn0kdmnmhdnble3afpbs` FOREIGN KEY (`censor_employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FKdcyjf6bl9ohxyli9j8sv1mwko` FOREIGN KEY (`post_post_id`) REFERENCES `posts` (`post_id`),
  CONSTRAINT `FKqrgwywqg78ydg7qse22fbvsw2` FOREIGN KEY (`reporter_customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `reported_post` */

insert  into `reported_post`(`report_id`,`reason`,`reported_time`,`status`,`censor_employee_id`,`post_post_id`,`reporter_customer_id`) values (5,'Tôi không thích thằng đó','2018-12-22 20:59:01','\0',NULL,4,2),(9,'tôi rất ghét bài viết này','2018-12-25 21:59:01','\0',NULL,5,1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleid` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) NOT NULL,
  PRIMARY KEY (`roleid`),
  UNIQUE KEY `ROLE_UK` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `role` */

insert  into `role`(`roleid`,`role_name`) values (1,'ROLE_ADMIN'),(2,'ROLE_CENSOR'),(3,'ROLE_CUSTOMER');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
