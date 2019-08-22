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
-- Database: `thirdyear`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `day` int(20) NOT NULL,
  `2k16/co/002` int(1) NOT NULL DEFAULT '0',
  `2k16/co/154` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`day`, `2k16/co/002`, `2k16/co/154`) VALUES
(1, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sub1`
--

CREATE TABLE `sub1` (
  `day` int(20) NOT NULL,
  `2k16/co/089` int(1) NOT NULL DEFAULT '0',
  `2k16/co/002` int(1) NOT NULL DEFAULT '0',
  `2k16/co/154` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `sub1`
--

INSERT INTO `sub1` (`day`, `2k16/co/089`, `2k16/co/002`, `2k16/co/154`) VALUES
(1, 0, 1, 0),
(2, 1, 0, 1),
(3, 0, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sub2`
--

CREATE TABLE `sub2` (
  `day` int(20) NOT NULL,
  `2k16/co/089` int(1) NOT NULL DEFAULT '0',
  `2k16/co/002` int(1) NOT NULL DEFAULT '0',
  `2k16/co/154` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `sub2`
--

INSERT INTO `sub2` (`day`, `2k16/co/089`, `2k16/co/002`, `2k16/co/154`) VALUES
(1, 0, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sub3`
--

CREATE TABLE `sub3` (
  `day` int(20) NOT NULL,
  `2k16/co/089` int(1) NOT NULL DEFAULT '0',
  `2k16/co/002` int(1) NOT NULL DEFAULT '0',
  `2k16/co/154` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `sub3`
--

INSERT INTO `sub3` (`day`, `2k16/co/089`, `2k16/co/002`, `2k16/co/154`) VALUES
(1, 0, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sub4`
--

CREATE TABLE `sub4` (
  `day` int(20) NOT NULL,
  `2k16/co/089` int(1) NOT NULL DEFAULT '0',
  `2k16/co/002` int(1) NOT NULL DEFAULT '0',
  `2k16/co/154` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `sub4`
--

INSERT INTO `sub4` (`day`, `2k16/co/089`, `2k16/co/002`, `2k16/co/154`) VALUES
(1, 0, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sub5`
--

CREATE TABLE `sub5` (
  `day` int(20) NOT NULL,
  `2k16/co/089` int(1) NOT NULL DEFAULT '0',
  `2k16/co/002` int(1) NOT NULL DEFAULT '0',
  `2k16/co/154` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `sub5`
--

INSERT INTO `sub5` (`day`, `2k16/co/089`, `2k16/co/002`, `2k16/co/154`) VALUES
(1, 0, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sub6`
--

CREATE TABLE `sub6` (
  `day` int(20) NOT NULL,
  `2k16/co/089` int(1) NOT NULL DEFAULT '0',
  `2k16/co/002` int(1) NOT NULL DEFAULT '0',
  `2k16/co/154` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `sub6`
--

INSERT INTO `sub6` (`day`, `2k16/co/089`, `2k16/co/002`, `2k16/co/154`) VALUES
(1, 0, 1, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`day`);

--
-- Indexes for table `sub1`
--
ALTER TABLE `sub1`
  ADD PRIMARY KEY (`day`);

--
-- Indexes for table `sub2`
--
ALTER TABLE `sub2`
  ADD PRIMARY KEY (`day`);

--
-- Indexes for table `sub3`
--
ALTER TABLE `sub3`
  ADD PRIMARY KEY (`day`);

--
-- Indexes for table `sub4`
--
ALTER TABLE `sub4`
  ADD PRIMARY KEY (`day`);

--
-- Indexes for table `sub5`
--
ALTER TABLE `sub5`
  ADD PRIMARY KEY (`day`);

--
-- Indexes for table `sub6`
--
ALTER TABLE `sub6`
  ADD PRIMARY KEY (`day`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `day` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sub1`
--
ALTER TABLE `sub1`
  MODIFY `day` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sub2`
--
ALTER TABLE `sub2`
  MODIFY `day` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sub3`
--
ALTER TABLE `sub3`
  MODIFY `day` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sub4`
--
ALTER TABLE `sub4`
  MODIFY `day` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sub5`
--
ALTER TABLE `sub5`
  MODIFY `day` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sub6`
--
ALTER TABLE `sub6`
  MODIFY `day` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
