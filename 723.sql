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

-- 테이블 project_mall.comment 구조 내보내기
CREATE TABLE IF NOT EXISTS `comment` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `c_rating` int(11) DEFAULT NULL,
  `c_content` varchar(50) DEFAULT NULL,
  `c_date` date DEFAULT current_timestamp(),
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 project_mall.comment:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
