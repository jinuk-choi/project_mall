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
	(101020, '간팔 티셔츠', 50);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- 테이블 project_mall.orders 구조 내보내기
CREATE TABLE IF NOT EXISTS `orders` (
  `o_id` int(11) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `o_total_price` int(11) DEFAULT NULL,
  `o_state` varchar(50) DEFAULT NULL,
  `o_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.orders:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`o_id`, `user_id`, `o_total_price`, `o_state`, `o_date`) VALUES
	(2, 'cju', 10, '배송중', '2021-07-14'),
	(4, 'a', 33, '배송준비', '2021-07-14'),
	(1, 'cju', 10, '배송중', '2021-07-14'),
	(5, 'a', 33, '배송준비', '2021-07-14'),
	(7, 'a', 33, '배송준비', '2021-07-14'),
	(3, 'a', 33, '배송준비', '2021-07-14'),
	(8, 'a', 33, '배송준비', '2021-07-14'),
	(9, 'a', 33, '배송준비', '2021-07-14'),
	(10, 'a', 33, '배송준비', '2021-07-14'),
	(11, 'a', 33, '배송준비', '2021-07-14'),
	(12, 'a', 33, '배송준비', '2021-07-14'),
	(13, 'a', 33, '배송준비', '2021-07-14'),
	(14, 'a', 33, '배송준비', '2021-07-14'),
	(15, 'a', 33, '배송준비', '2021-07-14'),
	(16, 'a', 33, '배송준비', '2021-07-14'),
	(17, 'a', 33, '배송준비', '2021-07-14'),
	(18, 'a', 33, '배송준비', '2021-07-14'),
	(6, 'a', 33, '배송준비', '2021-07-14');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- 테이블 project_mall.order_detail 구조 내보내기
CREATE TABLE IF NOT EXISTS `order_detail` (
  `od_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `od_price` int(11) DEFAULT NULL,
  `od_count` int(11) DEFAULT NULL,
  `o_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.order_detail:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` (`od_id`, `p_id`, `od_price`, `od_count`, `o_id`) VALUES
	(1, 1, 10000, 2, 1);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;

-- 테이블 project_mall.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `p_id` int(11) NOT NULL,
  `p_name` varchar(50) DEFAULT NULL,
  `p_price` int(11) DEFAULT NULL,
  `p_category` int(11) DEFAULT NULL,
  `p_quantity` int(11) DEFAULT NULL,
  `p_text` text DEFAULT NULL,
  `p_rank` int(11) DEFAULT NULL,
  `p_view` int(11) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.product:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`p_id`, `p_name`, `p_price`, `p_category`, `p_quantity`, `p_text`, `p_rank`, `p_view`) VALUES
	(1, '티셔츠1', 100, 1010, 10, '티셔츠입니다.', NULL, NULL),
	(2, '긴팔티셔츠1', 100, 101020, 50, '긴팔티셔츠입니다.', NULL, NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

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
	('a', '$2a$10$KV7s25dHAc1Jlkuq6cW31O1T19g8r.hla88.zvkW10lpxaR17bUvW', '사용자', '대구', NULL, '010-1234-5678', 'a@naver.com', NULL, 1, 1, 1, 1),
	('cju', '$2a$10$D95.jprxWI183p/Jhgy3G.rMCKaeleQbRCk4MAu6WdNIk6TUo5Ac6', '최진욱', '대구', NULL, '010-1234-5678', 'cju@naver.com', NULL, 1, 1, 1, 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 테이블 project_mall.userauth 구조 내보내기
CREATE TABLE IF NOT EXISTS `userauth` (
  `user_id` varchar(50) DEFAULT NULL,
  `user_auth` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.userauth:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `userauth` DISABLE KEYS */;
INSERT INTO `userauth` (`user_id`, `user_auth`) VALUES
	('cju', 'ROLE_ADMIN'),
	('a', 'ROLE_USER');
/*!40000 ALTER TABLE `userauth` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
