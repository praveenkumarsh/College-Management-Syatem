-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2019 at 05:24 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentportal`
--

-- --------------------------------------------------------

--
-- Table structure for table `timetable`
--

CREATE TABLE `timetable` (
  `clas` int(3) NOT NULL,
  `8-9` varchar(20) COLLATE utf8_bin NOT NULL,
  `9-10` varchar(20) COLLATE utf8_bin NOT NULL,
  `10-11` varchar(20) COLLATE utf8_bin NOT NULL,
  `11-12` varchar(20) COLLATE utf8_bin NOT NULL,
  `12-1` varchar(20) COLLATE utf8_bin NOT NULL,
  `1-2` varchar(20) COLLATE utf8_bin NOT NULL,
  `2-3` varchar(20) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `timetable`
--

INSERT INTO `timetable` (`clas`, `8-9`, `9-10`, `10-11`, `11-12`, `12-1`, `1-2`, `2-3`) VALUES
(1, 'Communication Skills', 'Applied Physics', 'Applied Mathematics', 'Break', 'Programming', 'BME', 'Engineering Graphics'),
(2, 'Analog Electronics', 'Data Structures', 'OOPS', 'Break', 'Discrete Structures', 'M&S', 'Engineering Economic'),
(3, 'Software Engineering', 'Theory of Computatio', 'Professional Ethics', 'Break', 'Artifiial Intelligen', 'Computer Networks', 'Compiler Design'),
(4, 'B.Tech. Project-I', 'Training Seminar', 'Distributed Systems', 'Break', 'Data Mining', 'Bio Informatics', 'Cyber Forensics');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `timetable`
--
ALTER TABLE `timetable`
  ADD PRIMARY KEY (`clas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
