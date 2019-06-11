-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 11, 2019 at 06:55 AM
-- Server version: 10.3.14-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id9425305_foodninjaweb`
--

-- --------------------------------------------------------

--
-- Table structure for table `CART`
--

CREATE TABLE `CART` (
  `FOODID` varchar(10) NOT NULL,
  `USERID` varchar(40) NOT NULL,
  `QUANTITY` varchar(10) NOT NULL,
  `PRICE` varchar(10) NOT NULL,
  `FOODNAME` varchar(30) NOT NULL,
  `STATUS` varchar(20) NOT NULL,
  `RESTID` varchar(10) NOT NULL,
  `ORDERID` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CART`
--

INSERT INTO `CART` (`FOODID`, `USERID`, `QUANTITY`, `PRICE`, `FOODNAME`, `STATUS`, `RESTID`, `ORDERID`) VALUES
('3', 'slumberjer@gmail.com', '94', '2.00', 'Roti Canai', 'paid', '2', '28032019-OWjohGu'),
('1', 'slumberjer@gmail.com', '1', '5.00', 'Mee Goreng Mamak', 'paid', '1', '28032019-OWjohGu'),
('3', 'slumberjer@gmail.com', '5', '2.00', 'Roti Canai', 'paid', '2', '28032019-OWjohGu'),
('2', 'slumberjer@gmail.com', '1', '4.50', 'Laksa Perak', 'paid', '3', '28032019-OWjohGu');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `id` int(11) NOT NULL,
  `uid` varchar(20) CHARACTER SET latin1 NOT NULL,
  `name` varchar(20) CHARACTER SET latin1 NOT NULL,
  `phone` varchar(100) CHARACTER SET latin1 NOT NULL,
  `address` varchar(11) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `id` int(11) NOT NULL,
  `uid` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `address` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`id`, `uid`, `name`, `phone`, `address`) VALUES
(4, '222222', 'Kumar', '01346464664', 'Business '),
(11, '128278', 'Michael Jackson ', '01078757976', 'Creativity Industry '),
(12, '250632', 'Rajoo', '0101111111', 'Programming ');

-- --------------------------------------------------------

--
-- Table structure for table `data1`
--

CREATE TABLE `data1` (
  `id` int(11) NOT NULL,
  `uid` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(150) NOT NULL,
  `address` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data1`
--

INSERT INTO `data1` (`id`, `uid`, `name`, `phone`, `address`) VALUES
(9, 'Final Year Project', 'Monday & Thursday\r\n10.30am to 12.30pm', 'http://static1.squarespace.com/static/5c0f220b4611a0330c7298d0/t/5c388994758d46785aae07c4/1547209111452/Social%2BC.png?format=1500w', 'Group A'),
(10, 'English ', 'Monday & Thursday\r\n4.00pm to 5.30pm', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMoefbmj-KEADaJR4R3bGkDNzJtmFNOer524BmdGggxn-UK8D-KQ', 'Group B'),
(11, 'Web Engineering', 'Tuesday & Thursday\r\n8.30am to 10.00pm', 'http://www.philadelphia.edu.jo/academics/shanna/uploads/web-re-engineering1.jpg', 'Group C'),
(12, 'Data Structure 2', 'Sunday & Wednesday\r\n1.00m to 3.00pm', 'http://blog.crazycodersgroup.com/wp-content/uploads/2018/08/logo.jpg', 'Group D'),
(13, 'Mandrin', 'Monday & Wednesday\r\n10.00am to 12.00pm', 'http://dropping-dozens.000webhostapp.com/image/man.jpg', 'Group E'),
(14, 'Ko-k', 'Saturday\r\n10.00am to 12.00pm', 'https://images.app.goo.gl/yuFzme5JWTfTdLDZA', 'Group F');

-- --------------------------------------------------------

--
-- Table structure for table `ORDERED`
--

CREATE TABLE `ORDERED` (
  `ORDERID` varchar(20) NOT NULL,
  `USERID` varchar(10) NOT NULL,
  `TOTAL` varchar(10) NOT NULL,
  `DATE` timestamp(6) NOT NULL DEFAULT current_timestamp(6)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ORDERED`
--

INSERT INTO `ORDERED` (`ORDERID`, `USERID`, `TOTAL`, `DATE`) VALUES
('28032019-OWjohGu', 'slumberjer', '207.5', '2019-03-28 05:54:37.867905');

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE `profile` (
  `id` int(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  `photo` varchar(250) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profile`
--

INSERT INTO `profile` (`id`, `name`, `time`, `photo`) VALUES
(1, 'Project 2 ', 'Monday & Thursday\r\n10.30am to 12.30pm', 'http://dropping-dozens.000webhostapp.com//image/pro.png'),
(2, 'English ', 'Monday & Thursday\r\n4.00pm to 5.30pm', 'http://dropping-dozens.000webhostapp.com/image/eng.jpg'),
(3, 'Web Engineering', 'Tuesday & Thursday\r\n8.30am to 10.00pm', 'http://dropping-dozens.000webhostapp.com/image/web.jpg'),
(4, 'Data Stucture', 'Sunday & Wednesday\r\n1.00m to 3.00pm', 'http://dropping-dozens.000webhostapp.com/image/dt.jpg'),
(5, 'Mandrin', 'Monday & Wednesday\r\n10.00am to 12.00pm', 'http://dropping-dozens.000webhostapp.com/image/man.jpg'),
(6, 'Ko-k', 'Saturday\r\n10.00am to 12.00pm', 'http://dropping-dozens.000webhostapp.com/image/kk.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `StudentTable`
--

CREATE TABLE `StudentTable` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` int(11) NOT NULL,
  `class` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `StudentTable`
--

INSERT INTO `StudentTable` (`id`, `name`, `phone_number`, `class`) VALUES
(1, 'Logainllll', 143237431, 'Project'),
(2, 'Logain ', 333, '33');

-- --------------------------------------------------------

--
-- Table structure for table `USER`
--

CREATE TABLE `USER` (
  `EMAIL` varchar(100) NOT NULL,
  `PASSWORD` varchar(60) NOT NULL,
  `PHONE` varchar(15) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `LOCATION` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `USER`
--

INSERT INTO `USER` (`EMAIL`, `PASSWORD`, `PHONE`, `NAME`, `LOCATION`) VALUES
('abc@gmail.com', '5975676ae179641188b2bde3c8d545d8334991f6', '0194702439', 'Ahmad Hanis', 'Changlun'),
('abcd@gmail.com', '8cb2237d0679ca88db6464eac60da96345513964', '01234545959', 'John', 'Changlun'),
('slumberjer@gmail.com', '1b64dad048eda4f2a22621490c0ea7a1db37ad43', '0194702493', 'Hanis', 'All'),
('ahmad@gmail.com', '8cb2237d0679ca88db6464eac60da96345513964', '01934455765', 'Ahmad', 'All'),
('qq1819301928@gmail.com', '0c8134c9a330eac5a89c4f18bcfe77e4780be309', '01135747336', 'Yang', 'Sintok'),
('nur28@gmail.com', '711880e2bde35b7f74ac2a54f37e82524aa797b6', '018', 'nur', 'All'),
('tupperware@gmail.com', '7c222fb2927d828af22f592134e8932480637c0d', '0163335555', 'tupperware', 'Sintok'),
('gemini285@gmail.com', '367ac64a16d19e2afefcf7c5fab8666dda92f9de', '018', 'gemini', 'All'),
('lg', 'lg', '0143237431', 'lg', 'Banting');

-- --------------------------------------------------------

--
-- Table structure for table `UserLoginTable`
--

CREATE TABLE `UserLoginTable` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_password` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `UserLoginTable`
--

INSERT INTO `UserLoginTable` (`id`, `first_name`, `last_name`, `user_email`, `user_password`) VALUES
(1, 'lg', 'lg', 'lg', 'lg'),
(3, 'Logain', 'Kk', 'kk', 'kk'),
(4, 'rathi', 'baby', 'rathibaby93@hotmail.my', 'panda'),
(5, 'Gowry', 'Muniandy', 'gowry.muniandy@gmail.com', '2704lggl'),
(6, 'Logain ', 'Rajoo', 'logain@gmail.com', '9494'),
(7, 'Gowry', 'Muniandy', 'tt', 'tt'),
(8, 'Logain ', 'G', 'ssiwieusm2018@gmail.com', '94'),
(9, 'Gowry', 'Muniandy', 'lg@gmail.com', '94'),
(10, 'Gowry', 'Muniandy', 'dd', 'f'),
(11, 'Gowry', 'Muniandy', 'logain0427@gmail.comqq', '1'),
(12, 'Gowry', 'Muniandy', 'yy', 'yy'),
(13, 'Gowry', 'Muniandy', 'ttt', '66'),
(14, 'Gowry', 'Muniandy', 'tttoo', '66'),
(15, 'T', 'Y', 'o', 'p'),
(18, 'Logain ', 'Theran ', 'logain0427@gmail.com', 'lggl');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data1`
--
ALTER TABLE `data1`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `profile`
--
ALTER TABLE `profile`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `StudentTable`
--
ALTER TABLE `StudentTable`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`EMAIL`);

--
-- Indexes for table `UserLoginTable`
--
ALTER TABLE `UserLoginTable`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `data`
--
ALTER TABLE `data`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `data1`
--
ALTER TABLE `data1`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `profile`
--
ALTER TABLE `profile`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `StudentTable`
--
ALTER TABLE `StudentTable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `UserLoginTable`
--
ALTER TABLE `UserLoginTable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
