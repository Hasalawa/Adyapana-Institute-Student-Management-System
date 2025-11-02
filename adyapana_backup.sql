-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.31 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for adyapana
CREATE DATABASE IF NOT EXISTS `adyapana` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `adyapana`;

-- Dumping structure for table adyapana.address
CREATE TABLE IF NOT EXISTS `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `line1` varchar(45) NOT NULL,
  `line2` varchar(45) NOT NULL,
  `city_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_address_city1_idx` (`city_id`),
  CONSTRAINT `fk_address_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.address: ~2 rows (approximately)
DELETE FROM `address`;
INSERT INTO `address` (`id`, `line1`, `line2`, `city_id`) VALUES
	(1, '"Udara Vasana', 'Youn saviyagama', 1),
	(5, 'Yatiyana road', 'kekanadura', 1);

-- Dumping structure for table adyapana.attendance
CREATE TABLE IF NOT EXISTS `attendance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `attend_date` date NOT NULL,
  `student_has_class_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_attendance_student_has_class1_idx` (`student_has_class_id`),
  CONSTRAINT `fk_attendance_student_has_class1` FOREIGN KEY (`student_has_class_id`) REFERENCES `student_has_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.attendance: ~6 rows (approximately)
DELETE FROM `attendance`;
INSERT INTO `attendance` (`id`, `attend_date`, `student_has_class_id`) VALUES
	(1, '2025-01-19', 1),
	(2, '2025-01-19', 3),
	(3, '2025-01-20', 2),
	(4, '2025-01-20', 3),
	(5, '2025-01-20', 1),
	(6, '2025-01-21', 2);

-- Dumping structure for table adyapana.city
CREATE TABLE IF NOT EXISTS `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `district_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_city_district1_idx` (`district_id`),
  CONSTRAINT `fk_city_district1` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.city: ~1 rows (approximately)
DELETE FROM `city`;
INSERT INTO `city` (`id`, `name`, `district_id`) VALUES
	(1, 'Kekanadura', 2);

-- Dumping structure for table adyapana.class
CREATE TABLE IF NOT EXISTS `class` (
  `class_no` int NOT NULL AUTO_INCREMENT,
  `subject_id` int NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `class_fee` double NOT NULL,
  `day_id` int NOT NULL,
  `teacher_nic` varchar(12) NOT NULL,
  PRIMARY KEY (`class_no`),
  KEY `fk_class_day1_idx` (`day_id`),
  KEY `fk_class_teacher1_idx` (`teacher_nic`),
  KEY `fk_class_subject1_idx` (`subject_id`),
  CONSTRAINT `fk_class_day1` FOREIGN KEY (`day_id`) REFERENCES `day` (`id`),
  CONSTRAINT `fk_class_subject1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `fk_class_teacher1` FOREIGN KEY (`teacher_nic`) REFERENCES `teacher` (`nic`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.class: ~3 rows (approximately)
DELETE FROM `class`;
INSERT INTO `class` (`class_no`, `subject_id`, `start_time`, `end_time`, `class_fee`, `day_id`, `teacher_nic`) VALUES
	(1, 3, '10:00:00', '15:00:00', 2500, 1, '200213800593'),
	(7, 2, '11:00:00', '15:00:00', 2500, 3, '200213800594'),
	(11, 1, '02:41:00', '04:41:00', 2800, 6, '200213800593');

-- Dumping structure for table adyapana.day
CREATE TABLE IF NOT EXISTS `day` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.day: ~7 rows (approximately)
DELETE FROM `day`;
INSERT INTO `day` (`id`, `name`) VALUES
	(1, 'Monday'),
	(2, 'Tuesday'),
	(3, 'Wednesday'),
	(4, 'Thursday'),
	(5, 'Friday'),
	(6, 'Saturady'),
	(7, 'Sunday');

-- Dumping structure for table adyapana.district
CREATE TABLE IF NOT EXISTS `district` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `province_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_district_province1_idx` (`province_id`),
  CONSTRAINT `fk_district_province1` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.district: ~3 rows (approximately)
DELETE FROM `district`;
INSERT INTO `district` (`id`, `name`, `province_id`) VALUES
	(1, 'Colombo', 2),
	(2, 'Matara', 1),
	(3, 'Galle', 1);

-- Dumping structure for table adyapana.gender
CREATE TABLE IF NOT EXISTS `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.gender: ~2 rows (approximately)
DELETE FROM `gender`;
INSERT INTO `gender` (`id`, `name`) VALUES
	(1, 'Male'),
	(2, 'Female');

-- Dumping structure for table adyapana.invoice
CREATE TABLE IF NOT EXISTS `invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `student_has_class_id` int NOT NULL,
  `student_sNo` varchar(3) NOT NULL,
  `month_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_student_has_class1_idx` (`student_has_class_id`),
  KEY `fk_invoice_student1_idx` (`student_sNo`),
  KEY `fk_invoice_month1_idx` (`month_id`),
  CONSTRAINT `fk_invoice_month1` FOREIGN KEY (`month_id`) REFERENCES `month` (`id`),
  CONSTRAINT `fk_invoice_student1` FOREIGN KEY (`student_sNo`) REFERENCES `student` (`sNo`),
  CONSTRAINT `fk_invoice_student_has_class1` FOREIGN KEY (`student_has_class_id`) REFERENCES `student_has_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.invoice: ~10 rows (approximately)
DELETE FROM `invoice`;
INSERT INTO `invoice` (`id`, `date`, `student_has_class_id`, `student_sNo`, `month_id`) VALUES
	(1, '2025-01-20', 1, '1', 1),
	(2, '2025-01-21', 3, '2', 2),
	(3, '2025-01-21', 2, '1', 3),
	(4, '2025-01-21', 2, '1', 4),
	(5, '2025-01-21', 3, '2', 5),
	(6, '2025-01-21', 1, '1', 2),
	(7, '2025-01-21', 3, '2', 1),
	(8, '2025-01-21', 2, '1', 1),
	(9, '2025-01-21', 4, '003', 1),
	(10, '2025-01-22', 3, '2', 4);

-- Dumping structure for table adyapana.month
CREATE TABLE IF NOT EXISTS `month` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.month: ~12 rows (approximately)
DELETE FROM `month`;
INSERT INTO `month` (`id`, `name`) VALUES
	(1, 'January'),
	(2, 'February'),
	(3, 'March'),
	(4, 'April'),
	(5, 'May'),
	(6, 'June'),
	(7, 'July'),
	(8, 'August'),
	(9, 'September'),
	(10, 'October'),
	(11, 'November'),
	(12, 'December');

-- Dumping structure for table adyapana.province
CREATE TABLE IF NOT EXISTS `province` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.province: ~2 rows (approximately)
DELETE FROM `province`;
INSERT INTO `province` (`id`, `name`) VALUES
	(1, 'Southern Province'),
	(2, 'Western Province');

-- Dumping structure for table adyapana.student
CREATE TABLE IF NOT EXISTS `student` (
  `sNo` varchar(3) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `reg_date` date NOT NULL,
  `gender_id` int NOT NULL,
  `address_id` int NOT NULL,
  PRIMARY KEY (`sNo`),
  KEY `fk_student_gender1_idx` (`gender_id`),
  KEY `fk_student_address1_idx` (`address_id`),
  CONSTRAINT `fk_student_address1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `fk_student_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.student: ~3 rows (approximately)
DELETE FROM `student`;
INSERT INTO `student` (`sNo`, `fname`, `lname`, `mobile`, `dob`, `reg_date`, `gender_id`, `address_id`) VALUES
	('003', 'Sahan', 'Dilshan', '0756146489', '2003-01-08', '2025-01-21', 1, 5),
	('1', 'Kehan', 'Hasalawa', '0740729268', '2025-01-16', '2025-01-16', 1, 1),
	('2', 'Thushara', 'Jayanga', '0718680458', '2002-04-01', '2025-01-17', 1, 1);

-- Dumping structure for table adyapana.student_has_class
CREATE TABLE IF NOT EXISTS `student_has_class` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_sNo` varchar(3) NOT NULL,
  `class_class_no` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student_has_class_class1_idx` (`class_class_no`),
  KEY `fk_student_has_class_student1_idx` (`student_sNo`),
  CONSTRAINT `fk_student_has_class_class1` FOREIGN KEY (`class_class_no`) REFERENCES `class` (`class_no`),
  CONSTRAINT `fk_student_has_class_student1` FOREIGN KEY (`student_sNo`) REFERENCES `student` (`sNo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.student_has_class: ~3 rows (approximately)
DELETE FROM `student_has_class`;
INSERT INTO `student_has_class` (`id`, `student_sNo`, `class_class_no`) VALUES
	(1, '1', 1),
	(2, '1', 7),
	(3, '2', 7),
	(4, '003', 11);

-- Dumping structure for table adyapana.subject
CREATE TABLE IF NOT EXISTS `subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.subject: ~4 rows (approximately)
DELETE FROM `subject`;
INSERT INTO `subject` (`id`, `name`) VALUES
	(1, 'Biology'),
	(2, 'Physics'),
	(3, 'Chemestry');

-- Dumping structure for table adyapana.teacher
CREATE TABLE IF NOT EXISTS `teacher` (
  `nic` varchar(12) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `email` varchar(80) NOT NULL,
  `address_id` int NOT NULL,
  `gender_id` int NOT NULL,
  `reg_date` date NOT NULL,
  PRIMARY KEY (`nic`),
  KEY `fk_teacher_address1_idx` (`address_id`),
  KEY `fk_teacher_gender1_idx` (`gender_id`),
  CONSTRAINT `fk_teacher_address1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `fk_teacher_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.teacher: ~2 rows (approximately)
DELETE FROM `teacher`;
INSERT INTO `teacher` (`nic`, `fname`, `lname`, `mobile`, `email`, `address_id`, `gender_id`, `reg_date`) VALUES
	('200213800593', 'kehan', 'hasalawa', '0740729268', 'hasa@gmail.com', 1, 1, '2025-01-15'),
	('200213800594', 'Kishan ', 'Chirantha', '0756146485', 'kishan@gmail.com', 1, 1, '2025-01-16');

-- Dumping structure for table adyapana.user
CREATE TABLE IF NOT EXISTS `user` (
  `nic` varchar(12) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `email` varchar(80) NOT NULL,
  `password` varchar(45) NOT NULL,
  `reg_date` date NOT NULL,
  `birthday` date NOT NULL,
  `gender_id` int NOT NULL,
  `address_id` int NOT NULL,
  PRIMARY KEY (`nic`),
  KEY `fk_user_gender_idx` (`gender_id`),
  KEY `fk_user_address1_idx` (`address_id`),
  CONSTRAINT `fk_user_address1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `fk_user_gender` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table adyapana.user: ~1 rows (approximately)
DELETE FROM `user`;
INSERT INTO `user` (`nic`, `fname`, `lname`, `mobile`, `email`, `password`, `reg_date`, `birthday`, `gender_id`, `address_id`) VALUES
	('200213800593', 'Kehan', 'Hasalawa', '0756146485', 'hasa@gmail.com', '123456', '2025-01-14', '2025-01-14', 1, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
