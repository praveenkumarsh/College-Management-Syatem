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
-- Table structure for table `notice`
--

CREATE TABLE `notice` (
  `ImpNotice` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `Notice1` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `Notice2` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `Notice3` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `Sno` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `notice`
--

INSERT INTO `notice` (`ImpNotice`, `Notice1`, `Notice2`, `Notice3`, `Sno`) VALUES
('Submit Your First Year Registration Form', 'Result will be anounced on 1 may', 'Back Paper Will be on 1 April', 'None1', 1),
('Submit Your Second Year Registration Form', 'Result will be anounced on 2 may', 'Back Paper Will be on 1 April', 'None2', 2),
('Submit Your Third Year Registration Form', 'Result will be anounced on 3 may', 'Back Paper Will be on 3 April', 'None3', 3),
('Submit Your Fourth Year Registration Form', 'Result will be anounced on 4 may', 'Back Paper Will be on 4 April', 'None4', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`Sno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `notice`
--
ALTER TABLE `notice`
  MODIFY `Sno` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
