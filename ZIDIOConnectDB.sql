-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: zidioconnect
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `application_history`
--

DROP TABLE IF EXISTS `application_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `application_id` int NOT NULL,
  `candidate_email` varchar(255) NOT NULL,
  `recruiter_email` varchar(255) NOT NULL,
  `old_status` enum('pending','accepted','rejected') DEFAULT NULL,
  `new_status` enum('pending','accepted','rejected') NOT NULL,
  `changed_by` varchar(255) NOT NULL,
  `change_reason` text,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_application_id` (`application_id`),
  KEY `idx_candidate_email` (`candidate_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_history`
--

LOCK TABLES `application_history` WRITE;
/*!40000 ALTER TABLE `application_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `application_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applications`
--

DROP TABLE IF EXISTS `applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `job_id` int DEFAULT NULL,
  `recruiter_email` varchar(255) DEFAULT NULL,
  `candidate_email` varchar(255) DEFAULT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `resume` longblob,
  `education` varchar(30) DEFAULT NULL,
  `phoneno` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `address` text,
  `gender` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `linkedin` varchar(30) DEFAULT NULL,
  `github` varchar(40) DEFAULT NULL,
  `pwebsite` varchar(40) DEFAULT NULL,
  `jobtitle` varchar(50) DEFAULT NULL,
  `excompany` varchar(50) DEFAULT NULL,
  `duration` varchar(40) DEFAULT NULL,
  `skills` varchar(50) DEFAULT NULL,
  `responsibility` text,
  `exsalary` varchar(20) DEFAULT NULL,
  `applied_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applications`
--

LOCK TABLES `applications` WRITE;
/*!40000 ALTER TABLE `applications` DISABLE KEYS */;
/*!40000 ALTER TABLE `applications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidate` (
  `studentid` int DEFAULT NULL,
  `studname` varchar(30) DEFAULT NULL,
  `studemail` varchar(30) DEFAULT NULL,
  `resumelink` varchar(20) DEFAULT NULL,
  `socialmedialink` varchar(30) DEFAULT NULL,
  `createddate` date DEFAULT NULL,
  `updateddate` date DEFAULT NULL,
  `createdby` varchar(20) DEFAULT NULL,
  `updatedby` varchar(20) DEFAULT NULL,
  `experience` varchar(20) DEFAULT NULL,
  `excompanyname` varchar(20) DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `actualsalary` int DEFAULT NULL,
  `expectedsalary` int DEFAULT NULL,
  `skills` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS `companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companies` (
  `companyid` int NOT NULL,
  `companyname` varchar(30) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `website` varchar(30) DEFAULT NULL,
  `reviews` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `location` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`companyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobposting`
--

DROP TABLE IF EXISTS `jobposting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobposting` (
  `jobid` int NOT NULL,
  `title` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `jobtype` varchar(20) DEFAULT NULL,
  `posteddate` date DEFAULT NULL,
  `location` varchar(30) DEFAULT NULL,
  `salaryrange` int DEFAULT NULL,
  `recruiterid` int DEFAULT NULL,
  `companyid` int NOT NULL,
  PRIMARY KEY (`jobid`),
  KEY `companyid` (`companyid`),
  CONSTRAINT `jobposting_ibfk_1` FOREIGN KEY (`companyid`) REFERENCES `companies` (`companyid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobposting`
--

LOCK TABLES `jobposting` WRITE;
/*!40000 ALTER TABLE `jobposting` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobposting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobseeker`
--

DROP TABLE IF EXISTS `jobseeker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobseeker` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobseeker`
--

LOCK TABLES `jobseeker` WRITE;
/*!40000 ALTER TABLE `jobseeker` DISABLE KEYS */;
INSERT INTO `jobseeker` VALUES ('','','',NULL,NULL,'male'),('abc@gmail.com','20202','Sudhir L ','9284889124','2001-12-01','other'),('ajinkya@gmail.com','101010','Ajinkya Jadhav','1012131415','2001-10-06','other'),('anand@gmail.com','10101','Anand FC','9284359595','2002-12-09','other'),('riteshnevage2211@gmail.com','101010','Ritesh Madhukar Nevage ','9766232211','2002-02-20','male'),('sachin@gmail.com','121212','sachin patil','2345678912','2025-06-06','male'),('sandesh@gmail.com','101010','Sandesh Bhosale','9834579434','2002-12-05','male'),('shubhamchougule@gmail.com','9454','Shubham Vinayak Chougule','8433579454','2000-02-08','male'),('sudhir@gmail.com','00000','Sudhir Jadhav','8291248857','2002-02-10','male'),('sudhirlanjekar333@gmail.com','sudhir777','Sudhir L ','9834579434','2001-12-08','male'),('xyz@gmail.com','00000','ritesh nevge','2345678923','2001-02-04','female');
/*!40000 ALTER TABLE `jobseeker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newpost`
--

DROP TABLE IF EXISTS `newpost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `newpost` (
  `id` int NOT NULL AUTO_INCREMENT,
  `recruiter_email` varchar(100) DEFAULT NULL,
  `comname` varchar(100) DEFAULT NULL,
  `jobroll` varchar(100) DEFAULT NULL,
  `skill` text,
  `loc` varchar(100) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `salary` varchar(50) DEFAULT NULL,
  `exp` varchar(50) DEFAULT NULL,
  `des` text,
  `post_type` varchar(20) DEFAULT 'internship',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newpost`
--

LOCK TABLES `newpost` WRITE;
/*!40000 ALTER TABLE `newpost` DISABLE KEYS */;
INSERT INTO `newpost` VALUES (1,'rajendrakumbhar9021@gmail.com',NULL,'Backend Intern','Jsp,JDBC','Hydrabad','2025-12-08','12,000 INR','6 Months','Java Backend','internship'),(2,'tanishka@gmail.com','Github','UI UX Designer ','Html , css , Tailwind ','USA','2025-09-08','12,000 INR','2+ yrs','Designing modern webpages','internship'),(3,'purv@gmail.com','MicroSoft','Java Developer','JSP,JDBC','Hydrabad','2025-03-08','8-10 LPA','2+ yrs','good at core and advance java','job'),(4,'rajendrakumbhar9021@gmail.com','AngleOne','DevOps','Pro at CI/CD piplines','Kolhapur','2025-09-08','5-6 LPA','2+ yrs','Having experitise in automation ','job'),(5,'rajendrakumbhar9021@gmail.com','AngleOne','UI UX Designer ','Html , css , Tailwind ','USA','2002-01-20','8-10 LPA','2+ yrs','Full time work in office ','internship'),(6,'rajendrakumbhar9021@gmail.com','Github','UI UX Designer ','Html , css , Tailwind ','Kolhapur','2025-08-08','8-10 LPA','9 Months','Full time work in office ','job');
/*!40000 ALTER TABLE `newpost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `candidate_email` varchar(255) NOT NULL,
  `recruiter_email` varchar(255) NOT NULL,
  `message` text NOT NULL,
  `status` enum('accepted','rejected') NOT NULL,
  `is_read` tinyint(1) DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_candidate_email` (`candidate_email`),
  KEY `idx_recruiter_email` (`recruiter_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruiter`
--

DROP TABLE IF EXISTS `recruiter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recruiter` (
  `id` int NOT NULL AUTO_INCREMENT,
  `recruiter_email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `comwebsite` varchar(255) DEFAULT NULL,
  `comname` varchar(150) NOT NULL,
  `jobroll` varchar(255) NOT NULL,
  `skill` text NOT NULL,
  `loc` varchar(100) NOT NULL,
  `deadline` date NOT NULL,
  `salary` varchar(50) DEFAULT NULL,
  `exp` varchar(100) DEFAULT NULL,
  `des` text,
  `post_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`recruiter_email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruiter`
--

LOCK TABLES `recruiter` WRITE;
/*!40000 ALTER TABLE `recruiter` DISABLE KEYS */;
INSERT INTO `recruiter` VALUES (1,'gouri@gmail.com','101112','Gouri Patil','https://www.google.com','google','Java Full Stack','Good at springboot','Kolhapur','2025-10-08','5000','3 months','Having good conversetion skills ','internship'),(2,'purv@gmail.com','101010','Purv Kumbhar','http://www.microsoft.com','MicroSOft','JavaScript','Core Concepts Of HTML','Reote','2025-11-06','3000INR','6 months','DOM Manipulation Technique','internship'),(3,'rahul@gmail.com','11062002','Rahul Kumbhar','https://www.google.com','google','Angular','JavaScript ','Kolhapur','2025-10-07','3000INR','0-2 yrs','Single Page Application','internship'),(4,'rajendrakumbhar9021@gmail.com','101010','Rajendra Krushna Kumbhar','https://www.tradingview.com','AngelOne','Data Analyst ','PowerBI Tools','Hydrabad','2025-12-07','5-7 LPA','0-1+ yrs','Streamlining data collection methods to create automated and easy-to-use routines','job'),(5,'shubhangi@gmail.com','101010','Shubhanhi Kumbhar','https://www.google.com','google','Java Full Stack','Good at springboot','Kolhapur','2025-10-06','8 to 10 LPA','0-2 yrs','Having good conversetion skills ','job'),(6,'sudhir@gmail.com','101112','Sudhir Lanjekar','https://www.google.com','google','Java Full Stack','Good at springboot','Kolhapur','2025-10-08','7-8 LPA','2+ yrs','Having good conversetion skills ',NULL),(7,'tanishka@gmail.com','101115','Tanishka Jadhav','https://github.com','Github','UI Designer','Ui design specialist','Remote','2025-02-08','4-5 LPA','2+ yrs','design and build the visual and interactive components for websites ','job'),(8,'sudhirlanjekar@gmail.com','12345','sudhir mohan lanjekar','https://www.youtube.com/','google','java full stack','spring boot','pune','2025-06-25','3-4LPA','o-1','good at core and advance java','job');
/*!40000 ALTER TABLE `recruiter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruiter_inbox`
--

DROP TABLE IF EXISTS `recruiter_inbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recruiter_inbox` (
  `id` int NOT NULL AUTO_INCREMENT,
  `recruiter_email` varchar(255) DEFAULT NULL,
  `candidate_email` varchar(255) DEFAULT NULL,
  `job_id` varchar(100) DEFAULT NULL,
  `post_type` varchar(50) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `resume` text,
  `education` text,
  `phoneno` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `address` text,
  `gender` varchar(20) DEFAULT NULL,
  `linkedin` varchar(255) DEFAULT NULL,
  `github` varchar(255) DEFAULT NULL,
  `pwebsite` varchar(255) DEFAULT NULL,
  `jobtitile` varchar(255) DEFAULT NULL,
  `excomapny` varchar(255) DEFAULT NULL,
  `duration` varchar(100) DEFAULT NULL,
  `skills` text,
  `responsibility` text,
  `exsalary` varchar(100) DEFAULT NULL,
  `application_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` enum('pending','accepted','rejected') DEFAULT 'pending',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `application_status` varchar(20) DEFAULT 'pending',
  `interview_date` date DEFAULT NULL,
  `interview_time` time DEFAULT NULL,
  `interview_mode` varchar(100) DEFAULT NULL,
  `interview_link` varchar(255) DEFAULT NULL,
  `jobroll` varchar(255) DEFAULT NULL,
  `companyname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_application` (`candidate_email`,`recruiter_email`,`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruiter_inbox`
--

LOCK TABLES `recruiter_inbox` WRITE;
/*!40000 ALTER TABLE `recruiter_inbox` DISABLE KEYS */;
INSERT INTO `recruiter_inbox` VALUES (1,'gouri@gmail.com','abc@gmail.com','1','internship','sdjhje','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','sddfs','6568454654654',NULL,'suhdjg','male','https://copilot.microsoft.com','https://copilot.microsoft.com','https://copilot.microsoft.com','jknjknjkb','jhjknjkhkj','jkhjkbjjkl','jjhjhj','uhhbhjvghjbhg','hbhjhbkhbhbjhb','2025-06-21 12:48:35','pending','2025-07-25 13:14:15','accepted','2025-07-27','21:47:00','Google Meet ','https://www.google.com',NULL,NULL),(2,'purv@gmail.com','abc@gmail.com','2','internship','sdjhje','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','sddfs','6568454654654',NULL,'suhdjg','male','https://copilot.microsoft.com','https://copilot.microsoft.com','https://copilot.microsoft.com','jknjknjkb','jhjknjkhkj','jkhjkbjjkl','jjhjhj','uhhbhjvghjbhg','hbhjhbkhbhbjhb','2025-06-23 14:14:17','pending','2025-07-25 13:14:15','accepted','2025-07-27','21:47:00','Google Meet ','https://www.google.com',NULL,NULL),(3,'rahul@gmail.com','abc@gmail.com','3','internship','sdjhje','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','sddfs','6568454654654',NULL,'suhdjg','male','https://copilot.microsoft.com','https://copilot.microsoft.com','https://copilot.microsoft.com','jknjknjkb','jhjknjkhkj','jkhjkbjjkl','jjhjhj','uhhbhjvghjbhg','hbhjhbkhbhbjhb','2025-06-23 14:14:22','pending','2025-07-25 13:14:15','accepted','2025-07-27','21:47:00','Google Meet ','https://www.google.com',NULL,NULL),(7,'rajendrakumbhar9021@gmail.com','shubhamchougule@gmail.com','4','job','Shubham Vinayak Chougule','Assignment.docx','Diploma','8433579454',NULL,'Kolhapur,Maharastra','male','https://www.bing.com','https://github.com','https://github.com','','','','','','','2025-06-26 11:49:12','pending','2025-06-27 11:17:19','accepted','2025-06-30','19:00:00','Google Meet ','https://www.google.com',NULL,NULL),(8,'rajendrakumbhar9021@gmail.com','anand@gmail.com','4','job','Anand Jayant Gaikwad','RahulFinalCV.pdf','Udemy Course','9689474726',NULL,'Pune,Maharastra','male','https://www.bing.com','https://github.com','https://github.com','','','','','','','2025-06-26 12:00:06','pending','2025-06-26 12:02:00','accepted','2025-06-30','11:00:00','Google Meet ','https://www.google.com',NULL,NULL),(9,'tanishka@gmail.com','sudhirlanjekar333@gmail.com','2','internship','Sudhir Mohan Lanjekar','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','MCA ','9834579434',NULL,'New Mumbai , Maharastra ','male','https://www.bing.com','https://github.com','https://www.bing.com','UI UX Designer ','SadaBand IT Solutions ','2+ yrs ','Proficiency in designing tool','Worked as a team leader and worked on various projects','4-5 LPA','2025-06-28 12:49:52','pending','2025-07-25 08:30:10','accepted','2025-07-01','14:02:00','Google Meet ','https://www.google.com',NULL,NULL),(10,'rajendrakumbhar9021@gmail.com','sudhirlanjekar333@gmail.com','1','internship','Sudhir Mohan Lanjekar','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','MCA ','9834579434',NULL,'New Mumbai , Maharastra ','male','https://www.bing.com','https://github.com','https://www.bing.com','UI UX Designer ','SadaBand IT Solutions ','2+ yrs ','Proficiency in designing tool','Worked as a team leader and worked on various projects','4-5 LPA','2025-06-28 13:31:57','pending','2025-07-25 08:30:10','accepted','2025-07-01','14:02:00','Google Meet ','https://www.google.com',NULL,NULL),(11,'gouri@gmail.com','sudhirlanjekar333@gmail.com','1','internship','Sudhir Mohan Lanjekar','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','MCA ','9834579434',NULL,'New Mumbai , Maharastra ','male','https://www.bing.com','https://github.com','https://www.bing.com','UI UX Designer ','SadaBand IT Solutions ','2+ yrs ','Proficiency in designing tool','Worked as a team leader and worked on various projects','4-5 LPA','2025-07-24 06:05:50','pending','2025-07-25 08:30:10','accepted','2025-07-01','14:02:00','Google Meet ','https://www.google.com',NULL,NULL),(12,'gouri@gmail.com','sandesh@gmail.com','1','internship','Sandesh Bhosale','AdmissionRecipt.pdf','MAC(computer science)','9834579434',NULL,'Kolhapur,Maharastra','male','https://www.bing.com','https://www.google.com','https://github.com','Java Developer','MuteFrog It Solutions','2022 to 2024','Java, Springboot, JSP','Contributed in various projects , and worked with responsibility','5-7 LPA','2025-07-24 06:09:02','pending','2025-07-24 06:09:02','pending',NULL,NULL,NULL,NULL,NULL,NULL),(13,'rajendrakumbhar9021@gmail.com','abc@gmail.com','5','internship','sdjhje','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','sddfs','6568454654654',NULL,'suhdjg','male','https://copilot.microsoft.com','https://copilot.microsoft.com','https://copilot.microsoft.com','jknjknjkb','jhjknjkhkj','jkhjkbjjkl','jjhjhj','uhhbhjvghjbhg','hbhjhbkhbhbjhb','2025-07-25 08:34:19','pending','2025-07-25 13:14:15','accepted','2025-07-27','21:47:00','Google Meet ','https://www.google.com',NULL,NULL),(14,'tanishka@gmail.com','abc@gmail.com','2','internship','sdjhje','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','sddfs','6568454654654',NULL,'suhdjg','male','https://copilot.microsoft.com','https://copilot.microsoft.com','https://copilot.microsoft.com','jknjknjkb','jhjknjkhkj','jkhjkbjjkl','jjhjhj','uhhbhjvghjbhg','hbhjhbkhbhbjhb','2025-07-25 08:35:26','pending','2025-07-25 13:14:15','accepted','2025-07-27','21:47:00','Google Meet ','https://www.google.com',NULL,NULL),(15,'rajendrakumbhar9021@gmail.com','abc@gmail.com','4','job','sdjhje','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','sddfs','6568454654654',NULL,'suhdjg','male','https://copilot.microsoft.com','https://copilot.microsoft.com','https://copilot.microsoft.com','jknjknjkb','jhjknjkhkj','jkhjkbjjkl','jjhjhj','uhhbhjvghjbhg','hbhjhbkhbhbjhb','2025-07-25 09:50:11','pending','2025-07-25 13:14:15','accepted','2025-07-27','21:47:00','Google Meet ','https://www.google.com',NULL,NULL),(16,'rajendrakumbhar9021@gmail.com','sudhirlanjekar333@gmail.com','5','internship','Sudhir Mohan Lanjekar','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','MCA ','9834579434',NULL,'New Mumbai , Maharastra ','male','https://www.bing.com','https://github.com','https://www.bing.com','UI UX Designer ','SadaBand IT Solutions ','2+ yrs ','Proficiency in designing tool','Worked as a team leader and worked on various projects','4-5 LPA','2025-07-25 09:51:59','pending','2025-07-25 13:32:39','accepted',NULL,NULL,NULL,NULL,NULL,NULL),(17,'rahul@gmail.com','sudhirlanjekar333@gmail.com','3','internship','Sudhir Mohan Lanjekar','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','MCA ','9834579434',NULL,'New Mumbai , Maharastra ','male','https://www.bing.com','https://github.com','https://www.bing.com','UI UX Designer ','SadaBand IT Solutions ','2+ yrs ','Proficiency in designing tool','Worked as a team leader and worked on various projects','4-5 LPA','2025-07-25 09:52:57','pending','2025-07-25 13:32:39','accepted',NULL,NULL,NULL,NULL,NULL,NULL),(18,'purv@gmail.com','sudhirlanjekar333@gmail.com','3','job','Sudhir Mohan Lanjekar','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','MCA ','9834579434',NULL,'New Mumbai , Maharastra ','male','https://www.bing.com','https://github.com','https://www.bing.com','UI UX Designer ','SadaBand IT Solutions ','2+ yrs ','Proficiency in designing tool','Worked as a team leader and worked on various projects','4-5 LPA','2025-07-25 10:17:21','pending','2025-07-25 13:32:39','accepted',NULL,NULL,NULL,NULL,'Java Developer','MicroSOft'),(19,'rajendrakumbhar9021@gmail.com','sudhirlanjekar333@gmail.com','6','job','Sudhir Mohan Lanjekar','Ã Â¤ÂÃ Â¤Â£Ã Â¤Â¤Ã Â¥Â Ã Â¤Â¯Ã Â¤Â¾Ã Â¤Â¦Ã Â¥Â Ã Â¥Â¨Ã Â¥Â¦Ã Â¥Â¨Ã Â¥Â«.pdf','MCA ','9834579434',NULL,'New Mumbai , Maharastra ','male','https://www.bing.com','https://github.com','https://www.bing.com','UI UX Designer ','SadaBand IT Solutions ','2+ yrs ','Proficiency in designing tool','Worked as a team leader and worked on various projects','4-5 LPA','2025-07-25 10:17:38','pending','2025-07-25 13:32:39','accepted',NULL,NULL,NULL,NULL,'UI UX Designer ','AngelOne'),(20,'rajendrakumbhar9021@gmail.com','shubhamchougule@gmail.com','5','internship','Shubham Vinayak Chougule','Assignment.docx','Diploma','8433579454',NULL,'Kolhapur,Maharastra','male','https://www.bing.com','https://github.com','https://github.com','','','','','','','2025-07-25 13:32:01','pending','2025-07-25 13:32:01','pending',NULL,NULL,NULL,NULL,'UI UX Designer ','AngelOne');
/*!40000 ALTER TABLE `recruiter_inbox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlogin`
--

DROP TABLE IF EXISTS `userlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userlogin` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlogin`
--

LOCK TABLES `userlogin` WRITE;
/*!40000 ALTER TABLE `userlogin` DISABLE KEYS */;
INSERT INTO `userlogin` VALUES ('edihewf@gmail.com','wduygewygeger');
/*!40000 ALTER TABLE `userlogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userregisterationuserregisteration`
--

DROP TABLE IF EXISTS `userregisterationuserregisteration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userregisterationuserregisteration` (
  `uid` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone_no` int DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `adress` text,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userregisterationuserregisteration`
--

LOCK TABLES `userregisterationuserregisteration` WRITE;
/*!40000 ALTER TABLE `userregisterationuserregisteration` DISABLE KEYS */;
INSERT INTO `userregisterationuserregisteration` VALUES ('sudhir@gmail.com','00000','Sudhir L ',0,'female','Kolhapur ','Married','Jobseeker'),('abc@gmail.com','12345','ritesh nevge',0,'male','pune','Married','Recruiter');
/*!40000 ALTER TABLE `userregisterationuserregisteration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viewprofile`
--

DROP TABLE IF EXISTS `viewprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viewprofile` (
  `fullname` varchar(50) DEFAULT NULL,
  `resume` longblob,
  `email` varchar(255) DEFAULT NULL,
  `education` varchar(30) DEFAULT NULL,
  `phoneno` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `address` text,
  `gender` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `linkedin` varchar(30) DEFAULT NULL,
  `github` varchar(40) DEFAULT NULL,
  `pwebsite` varchar(40) DEFAULT NULL,
  `jobtitile` varchar(50) DEFAULT NULL,
  `excomapny` varchar(50) DEFAULT NULL,
  `duration` varchar(40) DEFAULT NULL,
  `skills` varchar(50) DEFAULT NULL,
  `responsibility` text,
  `exsalary` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viewprofile`
--

LOCK TABLES `viewprofile` WRITE;
/*!40000 ALTER TABLE `viewprofile` DISABLE KEYS */;
INSERT INTO `viewprofile` VALUES ('sdjhje',_binary 'à¤à¤£à¤¤à¥ à¤¯à¤¾à¤¦à¥ à¥¨à¥¦à¥¨à¥«.pdf','abc@gmail.com','sddfs','6568454654654',NULL,'suhdjg','male','Single','https://copilot.microsoft.com','https://copilot.microsoft.com','https://copilot.microsoft.com','jknjknjkb','jhjknjkhkj','jkhjkbjjkl','jjhjhj','uhhbhjvghjbhg','hbhjhbkhbhbjhb'),('Rahul Rajendra Kumbhar',_binary 'NoteGPT-ER Diagram-1747037047437.pdf','rrk11062002@gmail.com','BCA','1012131415',NULL,'Kolhapur,Maharastra','male','Single','https://www.bing.com','https://github.com','','','','','','',''),('Sudhir Lanjekar ',_binary 'ZidioConnect-ER â Eraser.mhtml','sudhirlanjekar@gmail.com','MCA','9766232211',NULL,'Kolhapur,Maharastra','male','Single','https://www.bing.com','https://www.bing.com','https://www.bing.com','','','','','',''),('Sandesh Bhosale',_binary 'AdmissionRecipt.pdf','sandesh@gmail.com','MAC(computer science)','9834579434',NULL,'Kolhapur,Maharastra','male','Single','https://www.bing.com','https://www.google.com','https://github.com','Java Developer','MuteFrog It Solutions','2022 to 2024','Java, Springboot, JSP','Contributed in various projects , and worked with responsibility','5-7 LPA'),('Ritesh Madhukar Nevage ',_binary 'Adobe Scan 05 Feb 2025 (2) (1).pdf','riteshnevage@gmail.com','MCA ','9766232211',NULL,'Kolhapur,Maharastra','male','Single','https://www.bing.com','https://github.com','https://github.com','UI UX Designer  ','SadaBand IT Solutions ','2+ yrs ','Excellent Knowledge about frontend ','helped in various big projects ','3-4LPA'),('Ritesh Madhukar Nevage ',_binary 'recruiter_application_system.java','riteshnevage@gmail.com','MCA ','9766232211',NULL,'Kolhapur,Maharastra','male','Single','https://www.bing.com','https://github.com','https://github.com','','','','','',''),('Shubham Vinayak Chougule',_binary 'Assignment.docx','shubhamchougule@gmail.com','Diploma','8433579454',NULL,'Kolhapur,Maharastra','male','Single','https://www.bing.com','https://github.com','https://github.com','','','','','',''),('Anand Jayant Gaikwad',_binary 'RahulFinalCV.pdf','anand@gmail.com','Udemy Course','9689474726',NULL,'Pune,Maharastra','male','Single','https://www.bing.com','https://github.com','https://github.com','','','','','',''),('Sudhir Mohan Lanjekar',_binary 'à¤à¤£à¤¤à¥ à¤¯à¤¾à¤¦à¥ à¥¨à¥¦à¥¨à¥«.pdf','sudhirlanjekar333@gmail.com','MCA ','9834579434',NULL,'New Mumbai , Maharastra ','male','Single','https://www.bing.com','https://github.com','https://www.bing.com','UI UX Designer ','SadaBand IT Solutions ','2+ yrs ','Proficiency in designing tool','Worked as a team leader and worked on various projects','4-5 LPA');
/*!40000 ALTER TABLE `viewprofile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-25 19:17:53
