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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `st_id` int(11) NOT NULL AUTO_INCREMENT,
  `st_first_name` varchar(45) NOT NULL,
  `st_last_name` varchar(45) NOT NULL,
  `st_login` varchar(20) NOT NULL,
  `st_password` varchar(12) NOT NULL,
  `st_email` varchar(20) NOT NULL,
  PRIMARY KEY (`st_id`),
  UNIQUE KEY `st_login_UNIQUE` (`st_login`),
  UNIQUE KEY `st_email_UNIQUE` (`st_email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Ivan','Ivaniv','ivashka','1111','ivashka@gmail.com'),(2,'Sidor','Sidorov','sidorushka','2222','sidor@ukr.net'),(3,'Petr','Petrenko','petrusha','3333','petr@gmail.com'),(4,'Maria','Mirabella','marisha','4444','marisha@mail.ru'),(5,'Albina','Kurochka','albinushka','5555','alba@ukr.net'),(6,'Semen','Semenyuk','semenushka','6666','sema@gmail.com'),(7,'Anna','Arkhipchuk','arha','123','arhanechka@gmail.com'),(8,'Anna','Khmara','khmarochka','7777','khmar@ukr.net'),(9,'efwesf','xcvz','rfbvrev','seces','we@hth.ff'),(10,'asdas','fewfe','sdsggewg','qdwqd','dfvdf@efef.rvr'),(13,'Anna','arkhipchuk','sfa','wrwfe','asda@fgd.drg'),(15,'Anna','Arkhipchuk','uio','yttuoil','vamdf@yahoo.com'),(16,'Anna','Arkhipchuk','dwdwd','rg4rgr','3fdf@kfef.fefw');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-08 23:28:27
