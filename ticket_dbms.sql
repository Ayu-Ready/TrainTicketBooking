-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 26, 2018 at 06:47 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ticket_dbms`
--

-- --------------------------------------------------------

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
CREATE TABLE IF NOT EXISTS `passenger` (
  `ticket_no` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) NOT NULL,
  `froms` varchar(50) NOT NULL,
  `tos` varchar(50) NOT NULL,
  `trainno` varchar(50) NOT NULL,
  `name1` varchar(50) NOT NULL,
  `age1` varchar(50) NOT NULL,
  `name2` varchar(50) NOT NULL,
  `age2` varchar(50) NOT NULL,
  `name3` varchar(50) NOT NULL,
  `age3` varchar(50) NOT NULL,
  `name4` varchar(50) NOT NULL,
  `age4` varchar(50) NOT NULL,
  `amount` bigint(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `account` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'Booked',
  PRIMARY KEY (`ticket_no`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `print`
--

DROP TABLE IF EXISTS `print`;
CREATE TABLE IF NOT EXISTS `print` (
  `no` int(5) NOT NULL,
  `train` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `amount` bigint(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
CREATE TABLE IF NOT EXISTS `signup` (
  `user` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `aadhar` varchar(50) NOT NULL,
  `bank` varchar(50) NOT NULL,
  `amount` bigint(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
CREATE TABLE IF NOT EXISTS `train` (
  `trainno` varchar(50) NOT NULL,
  `froms` varchar(50) NOT NULL,
  `tos` varchar(50) NOT NULL,
  `amount` bigint(50) NOT NULL,
  `days` text NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`trainno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `train`
--

INSERT INTO `train` (`trainno`, `froms`, `tos`, `amount`, `days`, `status`) VALUES
('12975', 'tpty', 'mas', 200, 'Mon,Tue', 'On'),
('12', 'tpty', 'mas', 250, 'Mon', 'On'),
('21956', 'tpty', 'mas', 200, 'Mon,Fri', 'On'),
('64598', 'tpty', 'mumbai', 1200, 'Mon,Fri,Sat', 'Cancelled'),
('2512', 'ratlam', 'mum', 4560, 'Mon,Wed', 'Cancelled'),
('11041', 'mumbai', 'chennai', 500, 'Mon,Tue,Fri', 'Cancelled'),
('12915', 'mumbai', 'delhi', 300, 'Fri,Sat', 'On'),
('12546', 'mumbai', 'delhi', 200, 'Mon,Tue', 'Cancelled');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
