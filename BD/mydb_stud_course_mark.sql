-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.6.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `stud_course_mark`
--

DROP TABLE IF EXISTS `stud_course_mark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stud_course_mark` (
  `st_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `mark_id` int(11) DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`st_id`,`course_id`),
  KEY `st_id_idx` (`st_id`),
  KEY `course_id_idx` (`course_id`),
  KEY `mark_id_idx` (`mark_id`),
  CONSTRAINT `course_id2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mark_id2` FOREIGN KEY (`mark_id`) REFERENCES `mark` (`mark_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `st_id2` FOREIGN KEY (`st_id`) REFERENCES `student` (`st_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stud_course_mark`
--

LOCK TABLES `stud_course_mark` WRITE;
/*!40000 ALTER TABLE `stud_course_mark` DISABLE KEYS */;
INSERT INTO `stud_course_mark` VALUES (1,1,NULL,NULL),(1,2,NULL,NULL),(1,3,NULL,NULL),(1,5,2,'Do not bad'),(1,7,3,NULL),(1,8,4,'Bad!'),(2,1,NULL,NULL),(2,3,NULL,NULL),(2,8,3,'Try better'),(3,3,NULL,NULL),(3,4,1,'Congratulations!'),(3,6,2,'Good work!'),(3,7,1,'Congratulations!'),(4,1,NULL,NULL),(4,2,NULL,NULL),(4,5,3,NULL),(4,7,NULL,NULL),(4,8,2,'Good student'),(5,2,NULL,NULL),(5,3,1,'Best student!'),(5,4,NULL,NULL),(5,7,5,'Auful!'),(5,8,1,'Exellent'),(6,1,NULL,NULL),(6,4,3,'Not so good!');
/*!40000 ALTER TABLE `stud_course_mark` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-24 23:05:10
