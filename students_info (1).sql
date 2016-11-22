-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2016 at 09:54 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `students_info`
--
CREATE DATABASE IF NOT EXISTS `students_info` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `students_info`;

-- --------------------------------------------------------

--
-- Table structure for table `course_info`
--

CREATE TABLE IF NOT EXISTS `course_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(20) NOT NULL,
  `college` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `course_info`
--

INSERT INTO `course_info` (`id`, `year`, `college`) VALUES
(1, '5th year', 'CEA'),
(6, '1st year', 'CBA');

-- --------------------------------------------------------

--
-- Table structure for table `personal_info`
--

CREATE TABLE IF NOT EXISTS `personal_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `age` int(3) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Dumping data for table `personal_info`
--

INSERT INTO `personal_info` (`id`, `firstname`, `lastname`, `age`, `gender`, `contact`, `address`) VALUES
(1, 'Jarrel', 'Costiniano', 23, 'Male', '09262526548', 'Pampanga'),
(6, 'LerraJ', 'Costiniano', 22, 'Male', '402 1034', 'San Fernando'),
(32, 'LerraJ', 'Costiniano', 24, 'M', '0910', 'Angeles');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `emailaddress` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `filepath` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `emailaddress` (`emailaddress`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `emailaddress`, `password`, `filepath`) VALUES
(1, 'lerraj', 'lerraj@jarrel.com', '1234', 'C:/Users/Costiniano/Desktop/TORO/apache-tomcat-8.0.39/webapps/data/upload_form.jsp'),
(6, 'lerrajssw', 'lerraj@jarrel.comssw', '1234', ''),
(7, 'lerrajssws', 'lerraj@jarrel.comssws', '1234', ''),
(8, 'jarrel', 'jarrel', '1234', 'C:\\Users\\Costiniano\\Desktop\\TORO\\apache-tomcat-8.0.39\\webapps\\data\\'),
(9, 'lerrassr', 'lerraj@jarrel.comtre', '1234', NULL),
(10, 'lerrajsssere', 'lerraj@jarrel.comdsds', 'A6xnQhbz4Vx2HuGl4lXwZ5U2I8iziLRFnhP5eNfIRvQ=', NULL),
(11, 'lerrajssseres', 'lerraj@jarrel.comdsdss', 'A6xnQhbz4Vx2HuGl4lXwZ5U2I8iziLRFnhP5eNfIRvQ=', 'C:/Users/Costiniano/Desktop/TORO/apache-tomcat-8.0.39/webapps/data/C:\\Users\\Costiniano\\Documents\\2x5.docx'),
(13, 'lerrajssseresds', 'lerraj@jarrel.comdsdsss', 'WZRHGrsBESr8wYFZ9sx0tPURuZgG2lmzyvWpwXPKz8U=', NULL),
(15, 'JarrelBC', 'jarrel@gmail.com', 'A6xnQhbz4Vx2HuGl4lXwZ5U2I8iziLRFnhP5eNfIRvQ=', 'C:/Users/Costiniano/Desktop/TORO/apache-tomcat-8.0.39/webapps/data/download');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
