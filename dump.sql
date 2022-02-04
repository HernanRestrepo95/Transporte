-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: transporte
-- ------------------------------------------------------
-- Server version	5.5.5-10.6.5-MariaDB

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
-- Table structure for table `conductor`
--

DROP TABLE IF EXISTS `conductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conductor` (
  `id` bigint(20) NOT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numero_documento` bigint(20) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `id_tipo_identificacion` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK80jcxt6jcw5stivo8sugnwx16` (`id_tipo_identificacion`),
  CONSTRAINT `FK80jcxt6jcw5stivo8sugnwx16` FOREIGN KEY (`id_tipo_identificacion`) REFERENCES `tipo_identificacion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conductor`
--

LOCK TABLES `conductor` WRITE;
/*!40000 ALTER TABLE `conductor` DISABLE KEYS */;
INSERT INTO `conductor` VALUES (27,'Cali','Valle','Cra 28 # 3 - 68','Prueba Representante',1234567,'Colombia','3154789521',1),(28,'Cali','Valle','Cra 28 # 3 - 68','Prueba Conductor2',12345678,'Colombia','3154789521',1),(29,'Cali','Valle','Cra 28 # 3 - 68','Prueba Conductor3',123456789,'Colombia','3154789521',1),(30,'Cali','Valle','Cra 28 # 3 - 68','Prueba Conductor4',123456789,'Colombia','3154789521',1);
/*!40000 ALTER TABLE `conductor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conductor_vehiculo`
--

DROP TABLE IF EXISTS `conductor_vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conductor_vehiculo` (
  `id_conductor` bigint(20) NOT NULL,
  `id_vehiculo` bigint(20) NOT NULL,
  KEY `FK500485an3qlkmw2ejnx83crgs` (`id_vehiculo`),
  KEY `FKe6bh1ca7hjo92r53iiefns85j` (`id_conductor`),
  CONSTRAINT `FK500485an3qlkmw2ejnx83crgs` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculo` (`id`),
  CONSTRAINT `FKe6bh1ca7hjo92r53iiefns85j` FOREIGN KEY (`id_conductor`) REFERENCES `conductor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conductor_vehiculo`
--

LOCK TABLES `conductor_vehiculo` WRITE;
/*!40000 ALTER TABLE `conductor_vehiculo` DISABLE KEYS */;
INSERT INTO `conductor_vehiculo` VALUES (27,24),(27,25),(28,26),(29,24),(29,25),(30,24),(30,25);
/*!40000 ALTER TABLE `conductor_vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `id` bigint(20) NOT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `id_representante_legal` bigint(20) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numero_documento` bigint(20) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `id_tipo_identificacion` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtfwqthcfqc8f46gsj5f42i60s` (`id_tipo_identificacion`),
  KEY `FKfkk06vv492m5a6goilrk0st5k` (`id_representante_legal`),
  CONSTRAINT `FKfkk06vv492m5a6goilrk0st5k` FOREIGN KEY (`id_representante_legal`) REFERENCES `representante_legal` (`id`),
  CONSTRAINT `FKtfwqthcfqc8f46gsj5f42i60s` FOREIGN KEY (`id_tipo_identificacion`) REFERENCES `tipo_identificacion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (23,'Cali','Valle','Cra 28 # 3 - 68',22,'Prueba Empresa',123456,'Colombia','3154789521',1);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (32);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `representante_legal`
--

DROP TABLE IF EXISTS `representante_legal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `representante_legal` (
  `id` bigint(20) NOT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numero_documento` bigint(20) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `id_tipo_identificacion` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdbqdx7mrj1xyth9p356o23s49` (`id_tipo_identificacion`),
  CONSTRAINT `FKdbqdx7mrj1xyth9p356o23s49` FOREIGN KEY (`id_tipo_identificacion`) REFERENCES `tipo_identificacion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `representante_legal`
--

LOCK TABLES `representante_legal` WRITE;
/*!40000 ALTER TABLE `representante_legal` DISABLE KEYS */;
INSERT INTO `representante_legal` VALUES (22,'Cali','Valle','Cra 28 # 3 - 68','Prueba Representante',12345,'Colombia','3154789521',1);
/*!40000 ALTER TABLE `representante_legal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_identificacion`
--

DROP TABLE IF EXISTS `tipo_identificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_identificacion` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_identificacion`
--

LOCK TABLES `tipo_identificacion` WRITE;
/*!40000 ALTER TABLE `tipo_identificacion` DISABLE KEYS */;
INSERT INTO `tipo_identificacion` VALUES (1,'cedula de ciudadania'),(2,'tarjeta de identidad'),(3,'documento nacional de identidad'),(4,'tarjeta pasaporte'),(5,'registro civil'),(6,'cedula de extranjeria');
/*!40000 ALTER TABLE `tipo_identificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo` (
  `id` bigint(20) NOT NULL,
  `chasis` varchar(255) DEFAULT NULL,
  `fecha_matricula` datetime(6) DEFAULT NULL,
  `linea` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` bigint(20) DEFAULT NULL,
  `motor` varchar(255) DEFAULT NULL,
  `pasajeros_pie` bigint(20) DEFAULT NULL,
  `pasajeros_sentados` bigint(20) DEFAULT NULL,
  `peso_bruto` bigint(20) DEFAULT NULL,
  `peso_seco` bigint(20) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `puertas` bigint(20) DEFAULT NULL,
  `id_empresa` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1vwq4tx69a5x2e2oyui79sfmq` (`id_empresa`),
  CONSTRAINT `FK1vwq4tx69a5x2e2oyui79sfmq` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (24,'Chasis','2021-03-31 19:00:00.000000','Carro','Ford',2021,'1600',10,10,10,10,'ERF123',10,23),(25,'Chasis','2021-03-31 19:00:00.000000','Camioneta','Ford',2021,'1600',10,10,10,10,'EWS456',10,23),(26,'Chasis','2021-03-31 19:00:00.000000','Bus','Ford',2021,'1600',10,10,10,10,'HYG789',10,23),(31,'Chasis','2021-03-31 19:00:00.000000','Carro','Ford',2021,'1600',10,10,10,10,'FYH789',10,23);
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'transporte'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-03 18:49:05
