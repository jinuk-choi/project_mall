-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.4-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- project_mall 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `project_mall` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `project_mall`;

-- 테이블 project_mall.category 구조 내보내기
CREATE TABLE IF NOT EXISTS `category` (
  `cg_id` int(11) DEFAULT NULL,
  `cg_name` varchar(50) DEFAULT NULL,
  `cg_product_count` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.category:~10 rows (대략적) 내보내기
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`cg_id`, `cg_name`, `cg_product_count`) VALUES
	(0, '전체', 999),
	(10, '상의', 100),
	(20, '하의', 40),
	(1010, '티셔츠', 50),
	(1020, '와이셔츠', 50),
	(2020, '반바지', 20),
	(2010, '청바지', 20),
	(1011, '니트', 0),
	(101010, '반팔 티셔츠', 50),
	(101020, '간팔 티셔츠', 50),
	(101021, '간팔 셔츠', 50),
	(2011, '면바지', 20);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- 테이블 project_mall.orders 구조 내보내기
CREATE TABLE IF NOT EXISTS `orders` (
  `o_id` int(11) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `o_total_price` int(11) DEFAULT NULL,
  `o_state` varchar(50) DEFAULT NULL,
  `o_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.orders:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`o_id`, `user_id`, `o_total_price`, `o_state`, `o_date`) VALUES
	(2, 'cju', 10, '배송중', '2021-07-14'),
	(1, 'cju', 10, '배송중', '2021-07-14'),
	(3, 'c', 10, '배송완료', '2021-07-16'),
	(4, 'b', 10, '배송완료', '2021-07-15');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- 테이블 project_mall.order_detail 구조 내보내기
CREATE TABLE IF NOT EXISTS `order_detail` (
  `od_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `od_price` int(11) DEFAULT NULL,
  `od_count` int(11) DEFAULT NULL,
  `o_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.order_detail:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` (`od_id`, `p_id`, `od_price`, `od_count`, `o_id`) VALUES
	(2, 3, 10000, 2, 2),
	(3, 5, 20000, 3, 3),
	(4, 6, 30000, 5, 4);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;

-- 테이블 project_mall.point 구조 내보내기
CREATE TABLE IF NOT EXISTS `point` (
  `po_id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `po_content` varchar(50) DEFAULT NULL,
  `po_point` int(255) DEFAULT NULL,
  `po_total_point` int(255) DEFAULT NULL,
  `po_date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`po_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.point:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `point` DISABLE KEYS */;
INSERT INTO `point` (`po_id`, `user_id`, `user_name`, `po_content`, `po_point`, `po_total_point`, `po_date`) VALUES
	(1, 'c', '테스트3', '회원가입 축하', 1000, 1000, '20210716_092528'),
	(2, 'cju', '최진욱', '회원가입 축하', 1000, 1000, '20210716_092528'),
	(3, 'cju', '최진욱', '선물', 1000, 2000, '20210716_103027');
/*!40000 ALTER TABLE `point` ENABLE KEYS */;

-- 테이블 project_mall.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `p_id` int(11) NOT NULL,
  `p_name` varchar(50) DEFAULT NULL,
  `p_price` int(11) DEFAULT NULL,
  `p_category` int(11) DEFAULT NULL,
  `p_quantity` int(11) DEFAULT NULL,
  `p_text` text DEFAULT NULL,
  `p_rank` int(11) DEFAULT NULL,
  `p_views` int(11) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.product:~6 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`p_id`, `p_name`, `p_price`, `p_category`, `p_quantity`, `p_text`, `p_rank`, `p_views`) VALUES
	(1, '긴팔티셔츠2', 100, 1010, 10, '티셔츠입니다.', NULL, 4),
	(2, '긴팔티셔츠1', 100, 101020, 50, '긴팔티셔츠입니다.', NULL, 3),
	(3, '반팔티셔츠1', 100, 101010, 10, '반팔티셔츠입니다.', NULL, 1),
	(4, '흰색긴팔티셔츠', 10000, 101020, 15, '흰색긴팔티셔츠입니다.', NULL, 0),
	(5, '흰색 셔츠', 15000, 101021, 8, '흰색 긴팔 셔츠입니다.', NULL, 0),
	(6, '회색 셔츠', 25000, 101021, 30, '회색 긴팔셔츠입니다.', NULL, 0),
	(7, '흰청바지', 50000, 2010, 13, '흰청바지입니다.', NULL, 0),
	(8, '검정 슬랙스', 30000, 2011, 16, '검정색 슬랙스입니다.', NULL, 0),
	(9, '갈색 슬랙스', 45000, 2011, 21, '갈색 슬랙스입니다.', NULL, 0),
	(10, '반바지', 5000, 2020, 12, '반바지', NULL, 0),
	(11, '반바지2', 6000, 2020, 10, '반바지2입니다.', NULL, 0),
	(12, '청바지', 10000, 2010, 30, '청바지입니다.', NULL, 0),
	(13, '국방색 면바지', 45000, 2011, 13, '국방색의 면바지입니다.', NULL, 0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- 테이블 project_mall.product_img 구조 내보내기
CREATE TABLE IF NOT EXISTS `product_img` (
  `pi_id` int(11) DEFAULT NULL,
  `pi_image` varchar(255) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `pi_unique` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.product_img:~5 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product_img` DISABLE KEYS */;
INSERT INTO `product_img` (`pi_id`, `pi_image`, `p_id`, `pi_unique`) VALUES
	(1, '반팔', 2, '3'),
	(2, '긴팔', 3, '2'),
	(10, '9.jpg', 10, '20210715_1047214'),
	(11, '10.jpg', 11, '20210715_1049258'),
	(12, '7.jpg', 12, '20210715_1053209'),
	(4, '4.jpg', 4, '20210716_1034622'),
	(5, '5.jpg', 5, '20210716_1038392'),
	(6, '6.jpg', 6, '20210716_1038513'),
	(7, '8.jpg', 7, '20210716_103900'),
	(8, '11.jpg', 8, '20210716_1041215'),
	(9, '12.jpg', 9, '20210716_1042423'),
	(13, '13.jpg', 13, '20210716_1042256');
/*!40000 ALTER TABLE `product_img` ENABLE KEYS */;

-- 테이블 project_mall.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(50) NOT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_point` int(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_datetime` date DEFAULT NULL,
  `user_isAccountNonExpired` tinyint(4) DEFAULT NULL,
  `user_isAccountNonLocked` tinyint(4) DEFAULT NULL,
  `user_isCredentialNonExpired` tinyint(4) DEFAULT NULL,
  `user_isEnabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.user:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `user_password`, `user_name`, `user_address`, `user_point`, `user_phone`, `user_email`, `user_datetime`, `user_isAccountNonExpired`, `user_isAccountNonLocked`, `user_isCredentialNonExpired`, `user_isEnabled`) VALUES
	('b', '$2a$10$tCbnBkJoc01zlecHg/0OI.EfTeZ78rbWDh1WmgH.6SzGjYy0KpUkO', '테스트2', '서울', NULL, '010-1111-1111', 'bb@naver.com', NULL, 1, 1, 1, 1),
	('c', '$2a$10$MFyFLUG1O7TunwTboC0JqOQR.jeam9T1SIaPN8R0oSP3o9GjSPAuW', '테스트3', '청주', NULL, '010-1111-5555', 'c@naver.com', NULL, 1, 1, 1, 1),
	('cju', '$2a$10$D95.jprxWI183p/Jhgy3G.rMCKaeleQbRCk4MAu6WdNIk6TUo5Ac6', '최진욱', '대구', NULL, '010-1234-5678', 'cju@naver.com', NULL, 1, 1, 1, 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 테이블 project_mall.userauth 구조 내보내기
CREATE TABLE IF NOT EXISTS `userauth` (
  `user_id` varchar(50) DEFAULT NULL,
  `user_auth` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.userauth:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `userauth` DISABLE KEYS */;
INSERT INTO `userauth` (`user_id`, `user_auth`) VALUES
	('cju', 'ROLE_ADMIN'),
	('a', 'ROLE_USER'),
	('b', 'ROLE_USER'),
	('c', 'ROLE_USER');
/*!40000 ALTER TABLE `userauth` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
