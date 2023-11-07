-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 07, 2023 at 07:27 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `phonenum` varchar(20) NOT NULL,
  `country` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `birthdate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `firstname`, `lastname`, `gender`, `phonenum`, `country`, `email`, `birthdate`) VALUES
(1, 'jdoe', 'pa$$w0rd', 'John', 'Doe', 'Male', '1234567890', 'United States', 'johndoe@example.com', '1990-05-15'),
(2, 'lsmith', 'p@ss123', 'Lisa', 'Smith', 'Female', '9876543210', 'Canada', 'lisa.smith@example.com', '1988-11-02'),
(3, 'mjohnson', 'password123', 'Michael', 'Johnson', 'Male', '5551234567', 'Australia', 'michael.johnson@example.com', '1995-07-20'),
(4, 'ksmith', 'hello123', 'Karen', 'Smith', 'Female', '1231231234', 'United Kingdom', 'karen.smith@example.com', '1993-03-10'),
(5, 'ajones', 'test456', 'Alex', 'Jones', 'Male', '9998887776', 'Germany', 'alex.jones@example.com', '1992-09-25'),
(7, 'tlee', 'abc123', 'Thomas', 'Lee', 'Male', '7778889990', 'Japan', 'thomas.lee@example.com', '1991-06-18'),
(8, 'bsmith', 'pass123', 'Beth', 'Smith', 'Female', '1112223334', 'Brazil', 'beth.smith@example.com', '1994-04-05'),
(9, 'djackson', 'password!', 'David', 'Jackson', 'Male', '6667778889', 'Spain', 'david.jackson@example.com', '1997-08-12'),
(12, 'mwilliams', 'pass1234', 'Matthew', 'Williams', 'Male', '9991112223', 'Canada', 'matthew.williams@example.com', '1989-10-05'),
(13, 'esmith', 'testpass', 'Emily', 'Smith', 'Female', '4445556667', 'Australia', 'emily.smith@example.com', '1993-04-20'),
(14, 'jwilliams', 'password12', 'James', 'Williams', 'Male', '2223334446', 'United Kingdom', 'james.williams@example.com', '1991-01-15'),
(15, 'ljohnson', 'pass123!', 'Laura', 'Johnson', 'Female', '8889990001', 'Germany', 'laura.johnson@example.com', '1994-09-30'),
(17, 'kjohnson', 'password1234', 'Katherine', 'Johnson', 'Female', '1234567891', 'Japan', 'katherine.johnson@example.com', '1997-03-10'),
(19, 'ajohnson', 'testpass12', 'Anna', 'Johnson', 'Female', '1112223332', 'Spain', 'anna.johnson@example.com', '1995-05-28'),
(20, 'dwilliams', 'pass12345', 'Daniel', 'Williams', 'Male', '3334445556', 'Mexico', 'daniel.williams@example.com', '1996-11-03');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
