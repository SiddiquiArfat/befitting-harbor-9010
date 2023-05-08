-- MySQL dump 10.13  Distrib 5.5.16, for Win64 (x86)
--
-- Host: localhost    Database: finease
-- ------------------------------------------------------
-- Server version	5.5.16

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountNo` varchar(255) DEFAULT NULL,
  `amount` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pin` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfhh6otya6l3sdh1v6jut588tf` (`customer_id`),
  CONSTRAINT `FKfhh6otya6l3sdh1v6jut588tf` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'34568073586',700,'User',8055,'Closed','saving',1),(2,'52017822274',50,'User',4789,'active','loan',1),(3,'97569206976',500,'user2',285,'active','saving',2),(4,'79071953629',760,'user2',8082,'active','loan',2),(5,'47095478007',0,'user3',7155,'active','saving',3),(6,'24065272703',30,'user4',5023,'active','saving',4);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zipcode` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc90hq90y53kiv2106tsfr0pm8` (`customer_id`),
  CONSTRAINT `FKc90hq90y53kiv2106tsfr0pm8` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'asd','asd',123456,NULL),(2,'asd','asd',123,NULL),(3,'asd','asd',123456,NULL),(4,'asd','asd',123456,NULL),(5,'asd','asd',43563,5);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,12,'asd@.com','123456789','User','123','user123'),(2,12,'123','1234566','user2','123','user234'),(3,12,'asd@.com','2312323123','user3','123','user345'),(4,12,'asd@.com','123456789','user4','123','user4'),(5,12,'asd@123','13123123132','asd','123','asd123');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acountNum` varchar(255) DEFAULT NULL,
  `amount` double NOT NULL,
  `date` date DEFAULT NULL,
  `deposite` bit(1) NOT NULL,
  `fromAccountNum` varchar(255) DEFAULT NULL,
  `toAccountNum` varchar(255) DEFAULT NULL,
  `withdraw` bit(1) NOT NULL,
  `account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoh8n63ujw3q31rkka4kyyu1vr` (`account_id`),
  CONSTRAINT `FKoh8n63ujw3q31rkka4kyyu1vr` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'34568073586',1000,'2023-05-08','',NULL,'34568073586','\0',1),(2,'34568073586',1000,'2023-05-08','',NULL,'34568073586','\0',1),(3,'34568073586',500,'2023-05-08','\0',NULL,'52017822274','',1),(4,'52017822274',500,'2023-05-08','','34568073586',NULL,'\0',1),(5,'34568073586',200,'2023-05-08','\0',NULL,'52017822274','',1),(6,'52017822274',200,'2023-05-08','','34568073586',NULL,'\0',1),(7,'34568073586',200,'2023-05-08','\0',NULL,'52017822274','',1),(8,'52017822274',100,'2023-05-08','','34568073586',NULL,'\0',1),(9,'34568073586',100,'2023-05-08','\0',NULL,'52017822274','',1),(10,'34568073586',500,'2023-05-08','',NULL,'34568073586','\0',1),(11,'79071953629',1200,'2023-05-08','',NULL,'79071953629','\0',4),(12,'97569206976',500,'2023-05-08','','79071953629',NULL,'\0',4),(13,'79071953629',1200,'2023-05-08','',NULL,'79071953629','\0',4),(14,'79071953629',500,'2023-05-08','\0',NULL,'97569206976','',4),(15,'79071953629',1200,'2023-05-08','',NULL,'79071953629','\0',4),(16,'79071953629',500,'2023-05-08','\0',NULL,'97569206976','',4),(17,'79071953629',10,'2023-05-08','\0',NULL,'79071953629','',4),(18,'79071953629',1200,'2023-05-08','',NULL,'79071953629','\0',4),(19,'79071953629',500,'2023-05-08','\0',NULL,'97569206976','',4),(20,'79071953629',10,'2023-05-08','\0',NULL,'79071953629','',4),(21,'79071953629',20,'2023-05-08','',NULL,'79071953629','\0',4),(22,'79071953629',50,'2023-05-08','','52017822274',NULL,'\0',2),(23,'52017822274',50,'2023-05-08','\0',NULL,'79071953629','',2),(24,'24065272703',40,'2023-05-08','',NULL,'24065272703','\0',6),(25,'24065272703',40,'2023-05-08','',NULL,'24065272703','\0',6),(26,'24065272703',10,'2023-05-08','\0',NULL,'24065272703','',6);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-08 21:46:40
