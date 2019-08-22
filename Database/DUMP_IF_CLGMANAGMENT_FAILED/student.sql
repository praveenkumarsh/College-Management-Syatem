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
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(5) NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `password`, `email`) VALUES
(12, '2k17/c0/239', 'praveen', 'dce.pks@gmail.com'),
(26, '2k15/co/213', 'deepak@123', 'deepak98@gmail.com'),
(27, '2k16/co/154', 'mohan@123', 'mohan1@yahoo.com'),
(28, '2k17/co/324', 'rahul@123', 'rah675@gmail.com'),
(29, '2k18/co/321', 'ramesh@123', 'ram8795@gmail.com'),
(30, '2k16/co/002', 'rohit@123', 'rohit98@gmail.com'),
(31, '2k12/co/432', 'suresh@123', 'suresh@hotmail.com'),
(32, 'newuser', 'newuser', 'newuser'),
(33, '2k14/co/064', 'qq', 'qq@gmail.com'),
(34, 'aa', 'aa', 'aa@gmail.com'),
(36, '2k18/co/212', 'pks', 'pks@gmail.com'),
(37, '2k16/co/089', 'ritik', 'ritik@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
