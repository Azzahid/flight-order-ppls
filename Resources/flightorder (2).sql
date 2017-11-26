-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 14, 2017 at 06:23 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flightorder`
--

-- --------------------------------------------------------

--
-- Table structure for table `airports`
--

CREATE TABLE `airports` (
  `Id` int(11) NOT NULL,
  `Name` varchar(64) NOT NULL,
  `LocationId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `airports`
--

INSERT INTO `airports` (`Id`, `Name`, `LocationId`) VALUES
(1, 'Soekarno Hatta', 2),
(2, 'Sultan Mahmud Badarudin', 3),
(3, 'Raden Intan', 4),
(4, 'Husain Sastradinata', 1);

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `Id` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `FlightId` int(11) NOT NULL,
  `Status` varchar(25) NOT NULL,
  `PassengerName` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`Id`, `UserId`, `FlightId`, `Status`, `PassengerName`) VALUES
(1, 1, 1, 'Lunas', 'Azzahid Adhitya'),
(2, 1, 2, 'Pending', 'Ade Surya');

-- --------------------------------------------------------

--
-- Table structure for table `departure`
--

CREATE TABLE `departure` (
  `Id` int(11) NOT NULL,
  `airportID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departure`
--

INSERT INTO `departure` (`Id`, `airportID`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

-- --------------------------------------------------------

--
-- Table structure for table `destination`
--

CREATE TABLE `destination` (
  `Id` int(11) NOT NULL,
  `airportID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `destination`
--

INSERT INTO `destination` (`Id`, `airportID`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `Id` int(11) NOT NULL,
  `DestinationId` int(11) NOT NULL,
  `DepartureId` int(11) NOT NULL,
  `Quota` int(11) NOT NULL,
  `Company` varchar(64) NOT NULL,
  `Price` double NOT NULL,
  `Quality` varchar(25) NOT NULL,
  `BoardingTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`Id`, `DestinationId`, `DepartureId`, `Quota`, `Company`, `Price`, `Quality`, `BoardingTime`) VALUES
(1, 1, 3, 99, 'Garuda Indonesia', 1000000, 'Bisnis', '2017-11-22 03:20:00'),
(2, 3, 1, 99, 'Garuda Indonesia', 1000000, 'Bisnis', '2017-11-22 05:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `locations`
--

CREATE TABLE `locations` (
  `Id` int(11) NOT NULL,
  `Province` varchar(25) NOT NULL,
  `Town` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `locations`
--

INSERT INTO `locations` (`Id`, `Province`, `Town`) VALUES
(1, 'Jawa Barat', 'Bandung'),
(2, 'Jakarta', 'Jakarta Pusat'),
(3, 'Sumatera Selatan', 'Palembang'),
(4, 'Lampung', 'Bandar Lampung');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Id` int(11) NOT NULL,
  `Username` varchar(64) NOT NULL,
  `Name` varchar(64) NOT NULL,
  `Password` varchar(64) NOT NULL,
  `token` varchar(64) DEFAULT NULL,
  `validDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Id`, `Username`, `Name`, `Password`, `token`, `validDate`) VALUES
(1, 'fcarnock0', 'Ferdie Carnock', 'bismillah', '43ec4ef6-db3c-4110-ad17-7d59019376a0', '2017-11-15 22:09:14'),
(2, 'efilkov1', 'Edwina Filkov', 'IbMeFoXM6Ik', '', '0000-00-00 00:00:00'),
(3, 'mmaleby2', 'Miller Maleby', 'kQM0zi4FrP', '', '0000-00-00 00:00:00'),
(4, 'jheeks3', 'Jessie Heeks', 'jG73xZAcKzQ', '', '0000-00-00 00:00:00'),
(5, 'tgerok4', 'Tamara Gerok', 'nlNbXBGtZV', '', '0000-00-00 00:00:00'),
(6, 'pchesswas5', 'Pierson Chesswas', 'wJNWgC3', '', '0000-00-00 00:00:00'),
(7, 'strevarthen6', 'Stanwood Trevarthen', '68PKi0g', '', '0000-00-00 00:00:00'),
(8, 'mwilce7', 'Marris Wilce', 'TPRMvRxrqvv', '', '0000-00-00 00:00:00'),
(9, 'zclewett8', 'Zeb Clewett', 'Hk5INvHf', '', '0000-00-00 00:00:00'),
(10, 'dbrickdale9', 'Darill Brickdale', 'EjoB8iQByBv', '', '0000-00-00 00:00:00'),
(11, 'bdegoeya', 'Bert Degoey', 'rR0g2tUzrx', '', '0000-00-00 00:00:00'),
(12, 'bmuldowneyb', 'Bret Muldowney', '2CtySraOm', '', '0000-00-00 00:00:00'),
(13, 'sgerlingc', 'Shelly Gerling', 'RzHtN5l', '', '0000-00-00 00:00:00'),
(14, 'pfendd', 'Padgett Fend', 'm2DePA', '', '0000-00-00 00:00:00'),
(15, 'tollise', 'Tatiana Ollis', 'WzsbYX', '', '0000-00-00 00:00:00'),
(16, 'kfossickf', 'Ken Fossick', 'EZLS5C', '', '0000-00-00 00:00:00'),
(17, 'nboxhillg', 'Nalani Boxhill', 'br9hA9', '', '0000-00-00 00:00:00'),
(18, 'sdollinh', 'Shaughn Dollin', 'zn67rJT', '', '0000-00-00 00:00:00'),
(19, 'sdunsi', 'Shayne Duns', 'qfzffI31qgFC', '', '0000-00-00 00:00:00'),
(20, 'vautyj', 'Vivienne Auty', 'lVji6QXn9', '', '0000-00-00 00:00:00'),
(21, 'agobelk', 'Aimil Gobel', '4hJZRG', '', '0000-00-00 00:00:00'),
(22, 'sreynaldsl', 'Silvana Reynalds', 'Gv6Kk2xx', '', '0000-00-00 00:00:00'),
(23, 'cblakslandm', 'Cull Blaksland', 'KdBPd7yQM', '', '0000-00-00 00:00:00'),
(24, 'wbridgenn', 'West Bridgen', 'yQFeyFQi', '', '0000-00-00 00:00:00'),
(25, 'aronaldsono', 'Alicea Ronaldson', 'dA6hFAO', '', '0000-00-00 00:00:00'),
(26, 'nriggottp', 'Nolana Riggott', 'EIGq9bLqYg', '', '0000-00-00 00:00:00'),
(27, 'mrawsthornq', 'Myranda Rawsthorn', 'p1mDqkxJHBB', '', '0000-00-00 00:00:00'),
(28, 'bdayer', 'Bibbye Daye', 'EtTk8wKn', '', '0000-00-00 00:00:00'),
(29, 'dbaldreys', 'Dorice Baldrey', 'zYa8IsIp', '', '0000-00-00 00:00:00'),
(30, 'dstopfordt', 'Doug Stopford', 'LgKlsbgbJK5L', '', '0000-00-00 00:00:00'),
(31, 'adraycottu', 'Ashley Draycott', 'kcPVUONX3l', '', '0000-00-00 00:00:00'),
(32, 'ademeltv', 'Angil Demelt', 'BIlatbkn2q', '', '0000-00-00 00:00:00'),
(33, 'mnuddw', 'Moises Nudd', 'sH1misdSW7', '', '0000-00-00 00:00:00'),
(34, 'ecurmex', 'Eddy Curme', '2arccfM', '', '0000-00-00 00:00:00'),
(35, 'blangcastery', 'Bernadine Langcaster', 'izTNAPsX', '', '0000-00-00 00:00:00'),
(36, 'ncostellz', 'Neala Costell', 'BmJNcH', '', '0000-00-00 00:00:00'),
(37, 'dcronk10', 'Derril Cronk', 'Um9Afy8', '', '0000-00-00 00:00:00'),
(38, 'dmolesworth11', 'Devinne Molesworth', 'cXMbcoIFim', '', '0000-00-00 00:00:00'),
(39, 'tgergely12', 'Tracey Gergely', 'iLLx7qd8I3', '', '0000-00-00 00:00:00'),
(40, 'bchaffyn13', 'Berkly Chaffyn', 'Jr63DS', '', '0000-00-00 00:00:00'),
(41, 'ihurles14', 'Isabel Hurles', 'A8vvoToN', '', '0000-00-00 00:00:00'),
(42, 'mlevitt15', 'Mariana Levitt', 'WDGNMp4', '', '0000-00-00 00:00:00'),
(43, 'lmozzi16', 'Leonidas Mozzi', 'wRF5Qmgl', '', '0000-00-00 00:00:00'),
(44, 'mstonehewer17', 'Martina Stonehewer', 'S1R7o8CYRRu', '', '0000-00-00 00:00:00'),
(45, 'tfehners18', 'Tricia Fehners', '8N89PlPMfH', '', '0000-00-00 00:00:00'),
(46, 'wacey19', 'Wittie Acey', 'xtw0Og', '', '0000-00-00 00:00:00'),
(47, 'amcilwrath1a', 'Asa McIlwrath', 'Cl8oLbToh', '', '0000-00-00 00:00:00'),
(48, 'ejohananoff1b', 'Ebony Johananoff', 's3N8xcCga9mU', '', '0000-00-00 00:00:00'),
(49, 'ccoper1c', 'Charis Coper', 'eMSN36H', '', '0000-00-00 00:00:00'),
(50, 'lgebb1d', 'Lev Gebb', '16xspZ', '', '0000-00-00 00:00:00'),
(51, 'hbowlesworth1e', 'Henrie Bowlesworth', 'Mq7R3dr', '', '0000-00-00 00:00:00'),
(52, 'ldorber1f', 'Lexy Dorber', 'EqZdIA8TRTK', '', '0000-00-00 00:00:00'),
(53, 'jhallam1g', 'Jolynn Hallam', 'Fr5kMtges2C3', '', '0000-00-00 00:00:00'),
(54, 'atoffolo1h', 'Antonio Toffolo', 'TbUdfg', '', '0000-00-00 00:00:00'),
(55, 'ethompstone1i', 'Erminia Thompstone', 'oQZ1c6Wckt', '', '0000-00-00 00:00:00'),
(56, 'pmercik1j', 'Paddie Mercik', 'Cmyk5ECIkeL', '', '0000-00-00 00:00:00'),
(57, 'rmaile1k', 'Rodrique Maile', '7NFtKxjF', '', '0000-00-00 00:00:00'),
(58, 'cridgedell1l', 'Che Ridgedell', '6FixLzwEOMwp', '', '0000-00-00 00:00:00'),
(59, 'agossipin1m', 'Anallise Gossipin', 'H1kEml3ygrv', '', '0000-00-00 00:00:00'),
(60, 'cthibodeaux1n', 'Claudianus Thibodeaux', 'hs1xtq', '', '0000-00-00 00:00:00'),
(61, 'mrubert1o', 'Marwin Rubert', '1ed4Rm3Wzv', '', '0000-00-00 00:00:00'),
(62, 'lgoozee1p', 'Lonny Goozee', 'SKEp1K31v3ZA', '', '0000-00-00 00:00:00'),
(63, 'kdoree1q', 'Kristoforo Doree', 'B8RU9gWdgl8', '', '0000-00-00 00:00:00'),
(64, 'cjindacek1r', 'Charlton Jindacek', '2aHh5yu5', '', '0000-00-00 00:00:00'),
(65, 'sgislebert1s', 'Shanda Gislebert', 'SW3IGNzRHDLx', '', '0000-00-00 00:00:00'),
(66, 'mloseke1t', 'Man Loseke', '9DSOU6YTcdiB', '', '0000-00-00 00:00:00'),
(67, 'bgiamuzzo1u', 'Bunny Giamuzzo', 'jDcj1W', '', '0000-00-00 00:00:00'),
(68, 'sbroyd1v', 'Sena Broyd', 'Ci0KLl1Hri', '', '0000-00-00 00:00:00'),
(69, 'cwrightam1w', 'Chan Wrightam', 'GZ95Mifhqli', '', '0000-00-00 00:00:00'),
(70, 'dnornable1x', 'Dewain Nornable', 'QLZSp6bu3w3R', '', '0000-00-00 00:00:00'),
(71, 'kbasile1y', 'Karim Basile', 'AflJJXgea', '', '0000-00-00 00:00:00'),
(72, 'imcculloch1z', 'Ian McCulloch', 'YMLX7qDxd', '', '0000-00-00 00:00:00'),
(73, 'mroch20', 'Maible Roch', '5sOpROpvZR', '', '0000-00-00 00:00:00'),
(74, 'csalan21', 'Corabella Salan', 'wCTeKCuBq2', '', '0000-00-00 00:00:00'),
(75, 'mabramowsky22', 'Madelene Abramowsky', 'ikv7XiMaZ', '', '0000-00-00 00:00:00'),
(76, 'abarmby23', 'Alaster Barmby', 'fyJRUV', '', '0000-00-00 00:00:00'),
(77, 'hdimic24', 'Hale Dimic', 'WsoYJIf0', '', '0000-00-00 00:00:00'),
(78, 'cferriman25', 'Clementine Ferriman', 'vbEzknW', '', '0000-00-00 00:00:00'),
(79, 'ccarletto26', 'Charo Carletto', 'kkVM1Y8exu2', '', '0000-00-00 00:00:00'),
(80, 'hgiurio27', 'Helli Giurio', 'YQQZdOF', '', '0000-00-00 00:00:00'),
(81, 'khuffadine28', 'Kerrin Huffadine', 'cdzInVLqKVg', '', '0000-00-00 00:00:00'),
(82, 'amosdill29', 'Alexis Mosdill', 'WfhF7Wt', '', '0000-00-00 00:00:00'),
(83, 'ajeanin2a', 'Angelle Jeanin', '4odH5uIR', '', '0000-00-00 00:00:00'),
(84, 'amalenfant2b', 'Arleyne Malenfant', 'W4rwweYCU', '', '0000-00-00 00:00:00'),
(85, 'rbrosoli2c', 'Rube Brosoli', 'AvFjyPA229', '', '0000-00-00 00:00:00'),
(86, 'wverling2d', 'Wilhelmina Verling', 'U7Edxw5gc3C', '', '0000-00-00 00:00:00'),
(87, 'dcolborn2e', 'Donna Colborn', 'agUtowpjR7', '', '0000-00-00 00:00:00'),
(88, 'jletford2f', 'Jessica Letford', '6MXsOl', '', '0000-00-00 00:00:00'),
(89, 'bbarlas2g', 'Barbabas Barlas', '8lpknVB', '', '0000-00-00 00:00:00'),
(90, 'malvey2h', 'Malva Alvey', 'D3c2P0MXJxFy', '', '0000-00-00 00:00:00'),
(91, 'bwilkins2i', 'Byrann Wilkins', 'b3NxqxNw0', '', '0000-00-00 00:00:00'),
(92, 'ekittiman2j', 'Elton Kittiman', 'tLzizaQB', '', '0000-00-00 00:00:00'),
(93, 'qoffen2k', 'Quent Offen', 'DOMrV433', '', '0000-00-00 00:00:00'),
(94, 'gklemps2l', 'Gamaliel Klemps', 'ko18Ecm20tx', '', '0000-00-00 00:00:00'),
(95, 'kcankett2m', 'Kordula Cankett', 'PwYernEZkxI', '', '0000-00-00 00:00:00'),
(96, 'jthies2n', 'Jeffy Thies', 'LFNiyB7F', '', '0000-00-00 00:00:00'),
(97, 'cspuner2o', 'Candy Spuner', 'yDR9iYjt8nt', '', '0000-00-00 00:00:00'),
(98, 'rgethin2p', 'Raviv Gethin', 'tYeszM', '', '0000-00-00 00:00:00'),
(99, 'vosban2q', 'Veronike Osban', 'az9fDiNX', '', '0000-00-00 00:00:00'),
(100, 'rgristhwaite2r', 'Raddy Gristhwaite', 'fOvSqlgeOV', '', '0000-00-00 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `airports`
--
ALTER TABLE `airports`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Location` (`LocationId`);

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Flight` (`FlightId`),
  ADD KEY `User` (`UserId`);

--
-- Indexes for table `departure`
--
ALTER TABLE `departure`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `departureLocation` (`airportID`);

--
-- Indexes for table `destination`
--
ALTER TABLE `destination`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `destinationLocation` (`airportID`);

--
-- Indexes for table `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Departure` (`DepartureId`),
  ADD KEY `Destination` (`DestinationId`);

--
-- Indexes for table `locations`
--
ALTER TABLE `locations`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `airports`
--
ALTER TABLE `airports`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `departure`
--
ALTER TABLE `departure`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `destination`
--
ALTER TABLE `destination`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `flight`
--
ALTER TABLE `flight`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `locations`
--
ALTER TABLE `locations`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `airports`
--
ALTER TABLE `airports`
  ADD CONSTRAINT `Location` FOREIGN KEY (`LocationId`) REFERENCES `locations` (`Id`);

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `Flight` FOREIGN KEY (`FlightId`) REFERENCES `flight` (`Id`),
  ADD CONSTRAINT `User` FOREIGN KEY (`UserId`) REFERENCES `users` (`Id`);

--
-- Constraints for table `departure`
--
ALTER TABLE `departure`
  ADD CONSTRAINT `departureLocation` FOREIGN KEY (`airportID`) REFERENCES `airports` (`Id`);

--
-- Constraints for table `destination`
--
ALTER TABLE `destination`
  ADD CONSTRAINT `destinationLocation` FOREIGN KEY (`airportID`) REFERENCES `airports` (`Id`);

--
-- Constraints for table `flight`
--
ALTER TABLE `flight`
  ADD CONSTRAINT `Departure` FOREIGN KEY (`DepartureId`) REFERENCES `departure` (`Id`),
  ADD CONSTRAINT `Destination` FOREIGN KEY (`DestinationId`) REFERENCES `destination` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
