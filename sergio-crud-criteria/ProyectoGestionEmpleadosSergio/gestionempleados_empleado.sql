-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: gestionempleados
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idempleado` int NOT NULL AUTO_INCREMENT,
  `nombreempleado` varchar(45) DEFAULT NULL,
  `apellidoempleado` varchar(45) DEFAULT NULL,
  `sueldoempleado` int DEFAULT NULL,
  `departamentoempleado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idempleado`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Luis','Morante',15000,'Fiestas'),(2,'Natalia','Vitti',20000,'Deportes'),(3,'Pepe','Ruiz',12000,'Campo'),(4,'Manolo','Ablebuti',14000,'Fiestas'),(5,'Paola','Ortiga',25000,'Deporte'),(6,'Juan','de la Torre',34000,'Tecnología'),(8,'Rocío','Santana',36000,'Fiestas'),(9,'Luisa','Belmonte',51000,'Deportes'),(10,'María','Wright',18000,'Campo'),(11,'Claudia','Feldespato',13000,'Campo'),(12,'Jaime','Quesada',13000,'Tecnología'),(13,'Amaya','Maya',18000,'Tecnología'),(14,'Paco','Mer',20000,'Deportes'),(16,'Genaro','Pui',10000,'Fiestas'),(17,'Juan','Tamariz',34000,'Deportes'),(18,'Javier','GÃ¼enzeslao',37000,'Campo'),(19,'Juan','Juarez',28000,'Fiestas'),(20,'Sonia','Di Lecce',43000,'Fiestas');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-22 12:44:48
