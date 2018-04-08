-- phpMyAdmin SQL Dump
-- version 4.0.10.16
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 08, 2018 at 11:46 AM
-- Server version: 5.1.73
-- PHP Version: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `springboot`
--

-- --------------------------------------------------------

--
-- Table structure for table `files`
--

CREATE TABLE IF NOT EXISTS `files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) NOT NULL,
  `file_date` varchar(100) NOT NULL,
  `file_location` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `files`
--

INSERT INTO `files` (`id`, `file_name`, `file_date`, `file_location`) VALUES
(1, 'IMG_0230.JPG', '23 MAR 2016', 'Bangkok'),
(2, 'IMG_0548.JPG', '31 MAR 2016', 'Chonburi');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `role_name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=40 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`) VALUES
(1, NULL, 'user101@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(2, NULL, 'user102@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(3, NULL, 'user103@gmail.com', 'manager'),
(4, NULL, 'user104@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(5, NULL, 'user105@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(6, NULL, 'user106@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(7, NULL, 'user107@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(8, NULL, 'user108@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(9, NULL, 'user109@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(10, NULL, 'user110@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(11, NULL, 'user111@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(12, NULL, 'user112@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(13, NULL, 'user113@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(14, NULL, 'user114@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(15, NULL, 'user115@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(16, NULL, 'user116@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(17, NULL, 'user117@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(18, NULL, 'user118@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(19, NULL, 'user119@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(20, NULL, 'user120@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(21, NULL, 'user121@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(22, NULL, 'user122@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(23, NULL, 'user123@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(24, NULL, 'user124@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(25, NULL, 'user125@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(26, NULL, 'user126@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(27, NULL, 'user127@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(28, NULL, 'user128@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(29, NULL, 'user129@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(30, NULL, 'user130@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(31, NULL, 'user131@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(32, NULL, 'user132@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(33, NULL, 'user133@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(34, NULL, 'user134@gmail.com', '1d0258c2440a8d19e716292b231e3190'),
(35, 'test', 'user300@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(36, 'test2', 'user500@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(37, 'testt', 'mmpattt.t@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(38, 'testt', 'mmpattt@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055'),
(39, 'testt', '122@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055');

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 2),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 1),
(16, 1),
(17, 1),
(18, 1),
(19, 1),
(20, 1),
(21, 1),
(22, 1),
(23, 1),
(24, 1),
(25, 1),
(26, 1),
(27, 1),
(28, 1),
(29, 1),
(30, 1),
(31, 1),
(32, 1),
(33, 1),
(34, 1),
(39, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
