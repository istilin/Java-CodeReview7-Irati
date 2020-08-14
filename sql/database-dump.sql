-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 14, 2020 at 10:29 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `CR7_Irati`
--

-- --------------------------------------------------------

--
-- Table structure for table `Classes`
--

CREATE TABLE `Classes` (
  `classId` int(11) NOT NULL,
  `className` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Classes`
--

INSERT INTO `Classes` (`classId`, `className`) VALUES
(1, '1a'),
(2, '1b'),
(3, '1c'),
(4, '2a'),
(5, '2b'),
(6, '2c'),
(7, '3a'),
(8, '3b'),
(9, '3c');

-- --------------------------------------------------------

--
-- Table structure for table `ConnectTeacherClassSubject`
--

CREATE TABLE `ConnectTeacherClassSubject` (
  `fk_teacherId` int(11) NOT NULL,
  `fk_classId` int(11) NOT NULL,
  `fk_subjectId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ConnectTeacherClassSubject`
--

INSERT INTO `ConnectTeacherClassSubject` (`fk_teacherId`, `fk_classId`, `fk_subjectId`) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 3, 1),
(1, 4, 1),
(1, 5, 1),
(1, 6, 1),
(1, 7, 1),
(1, 7, 5),
(1, 8, 1),
(1, 9, 1),
(2, 5, 2),
(2, 6, 2),
(2, 7, 2),
(2, 8, 2),
(2, 9, 2),
(3, 1, 2),
(3, 2, 2),
(3, 3, 2),
(3, 4, 2),
(4, 1, 4),
(4, 2, 4),
(4, 3, 4),
(4, 4, 4),
(4, 5, 4),
(4, 6, 4),
(4, 7, 4),
(4, 8, 4),
(4, 9, 4),
(5, 1, 3),
(5, 2, 3),
(5, 3, 3),
(5, 4, 3),
(5, 5, 3),
(5, 6, 3),
(5, 7, 3),
(5, 8, 3),
(5, 9, 3);

-- --------------------------------------------------------

--
-- Table structure for table `Students`
--

CREATE TABLE `Students` (
  `studentId` int(11) NOT NULL,
  `studentName` varchar(55) NOT NULL,
  `studentSurname` varchar(55) NOT NULL,
  `studentEmail` varchar(55) NOT NULL,
  `fk_classId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Students`
--

INSERT INTO `Students` (`studentId`, `studentName`, `studentSurname`, `studentEmail`, `fk_classId`) VALUES
(1, 'Bart', 'Simpson', 'b.simpson@simpsons.edu', 7),
(2, 'Lisa', 'Simpson', 'l.simpson@simpsons.edu', 1),
(3, 'Milhouse', 'Van Houten', 'm.van_houten@simpsons.edu', 8),
(4, 'Nelson', 'Muntz', 'n.muntz@simpsons.edu', 9),
(5, 'Ralph', 'Wiggum', 'r.wiggum@simpsons.edu', 2),
(6, 'Kearney', 'Zzyzwicz', 'k.zzyzwicz@simpsons.edu', 4),
(7, 'Todd', 'Flanders', 't.flanders@simpsons.edu', 3),
(8, 'Martin', 'Prince', 'm.prince@simpsons.edu', 1),
(9, 'Rod', 'Flanders', 'r.flanders@simpsons.edu', 7),
(10, 'Dolph', 'Starbeam', 'd.starbeam@simpsons.edu', 5),
(11, 'Sherri', 'Mackleberry', 's.mackleberry@simpsons.edu', 8),
(12, 'Terri', 'Mackleberry', 't.mackleberry@simpsons.edu', 9),
(13, 'Wendell', 'Borton', 'w.borton@simpsons.edu', 6);

-- --------------------------------------------------------

--
-- Table structure for table `Subjects`
--

CREATE TABLE `Subjects` (
  `subjectId` int(11) NOT NULL,
  `subjectName` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Subjects`
--

INSERT INTO `Subjects` (`subjectId`, `subjectName`) VALUES
(1, 'Nagging'),
(2, 'Main'),
(3, 'P.E.'),
(4, 'Music'),
(5, 'Ethics');

-- --------------------------------------------------------

--
-- Table structure for table `Teachers`
--

CREATE TABLE `Teachers` (
  `teacherId` int(11) NOT NULL,
  `teacherName` varchar(55) NOT NULL,
  `teacherSurname` varchar(55) NOT NULL,
  `teacherEmail` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Teachers`
--

INSERT INTO `Teachers` (`teacherId`, `teacherName`, `teacherSurname`, `teacherEmail`) VALUES
(1, 'Seymour', 'Skinner', 's.skinner@simpsons.edu'),
(2, 'Edna', 'Krabappel', 'e.krabappel@simpsons.edu'),
(3, 'Elizabeth', 'Hoover', 'e.hoover@simpsons.edu'),
(4, 'Dewey', 'Largo', 'd.largo@simpsons.edu'),
(5, 'Brunella', 'Pommelhorst', 'b.pommelhorst@simpsons.edu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Classes`
--
ALTER TABLE `Classes`
  ADD PRIMARY KEY (`classId`);

--
-- Indexes for table `ConnectTeacherClassSubject`
--
ALTER TABLE `ConnectTeacherClassSubject`
  ADD PRIMARY KEY (`fk_teacherId`,`fk_classId`,`fk_subjectId`),
  ADD KEY `fk_classId` (`fk_classId`),
  ADD KEY `fk_subjectId` (`fk_subjectId`);

--
-- Indexes for table `Students`
--
ALTER TABLE `Students`
  ADD PRIMARY KEY (`studentId`),
  ADD UNIQUE KEY `studentEmail` (`studentEmail`),
  ADD KEY `fk_classId` (`fk_classId`);

--
-- Indexes for table `Subjects`
--
ALTER TABLE `Subjects`
  ADD PRIMARY KEY (`subjectId`);

--
-- Indexes for table `Teachers`
--
ALTER TABLE `Teachers`
  ADD PRIMARY KEY (`teacherId`),
  ADD UNIQUE KEY `teacherEmail` (`teacherEmail`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Classes`
--
ALTER TABLE `Classes`
  MODIFY `classId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `Students`
--
ALTER TABLE `Students`
  MODIFY `studentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `Subjects`
--
ALTER TABLE `Subjects`
  MODIFY `subjectId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `Teachers`
--
ALTER TABLE `Teachers`
  MODIFY `teacherId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ConnectTeacherClassSubject`
--
ALTER TABLE `ConnectTeacherClassSubject`
  ADD CONSTRAINT `connectteacherclasssubject_ibfk_1` FOREIGN KEY (`fk_teacherId`) REFERENCES `Teachers` (`teacherId`),
  ADD CONSTRAINT `connectteacherclasssubject_ibfk_2` FOREIGN KEY (`fk_classId`) REFERENCES `Classes` (`classId`),
  ADD CONSTRAINT `connectteacherclasssubject_ibfk_3` FOREIGN KEY (`fk_subjectId`) REFERENCES `Subjects` (`subjectId`);

--
-- Constraints for table `Students`
--
ALTER TABLE `Students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`fk_classId`) REFERENCES `Classes` (`classId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
