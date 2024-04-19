-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Cze 22, 2023 at 09:35 PM
-- Wersja serwera: 8.0.33
-- Wersja PHP: 7.4.3-4ubuntu2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bazatestowa`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('jan', 'ROLE_USER'),
('Scott', 'ROLE_ADMIN'),
('xdxdxd', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `autorzy`
--

CREATE TABLE `autorzy` (
  `id` smallint NOT NULL,
  `imie` varchar(30) DEFAULT NULL,
  `nazwisko` varchar(40) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `autorzy`
--

INSERT INTO `autorzy` (`id`, `imie`, `nazwisko`, `status`) VALUES
(1, 'William', 'Shakespeare', 'NOT_DELETED'),
(2, 'Henryk', 'Sienkiewicz', 'NOT_DELETED'),
(3, 'Adam', 'Mickiewicz', 'NOT_DELETED'),
(4, 'Eliza', 'Orzeszkowa', 'NOT_DELETED'),
(5, 'Jan', 'Kowalski', 'NOT_DELETED'),
(19, 'Adam', 'Malysz', 'NOT_DELETED'),
(25, 'Krystian', 'Pudzianowski', 'NOT_DELETED'),
(26, 'Artur', 'Szpilkxddrrrdf', 'NOT_DELETED'),
(27, 'Nowy', 'Autorrr', 'NOT_DELETED'),
(28, 'FFFF', 'FFFFF', 'DELETED'),
(29, 'JJ', '123', 'DELETED');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `autorzy_to_ksiazki`
--

CREATE TABLE `autorzy_to_ksiazki` (
  `ksiazka_id` int NOT NULL,
  `autor_id` smallint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `autorzy_to_ksiazki`
--

INSERT INTO `autorzy_to_ksiazki` (`ksiazka_id`, `autor_id`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(75, 2),
(5, 3),
(75, 3),
(76, 3),
(78, 3),
(80, 3),
(6, 4),
(76, 4),
(78, 4),
(80, 4),
(1, 5),
(2, 5),
(66, 5),
(66, 19),
(73, 25),
(77, 27),
(79, 29);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `department`
--

CREATE TABLE `department` (
  `id` int NOT NULL,
  `name` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `name`) VALUES
(1, 'Biuro'),
(2, 'Kuchnia'),
(3, 'Produkcja');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `employee`
--

CREATE TABLE `employee` (
  `id` int NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `surname` varchar(64) DEFAULT NULL,
  `employee_address_id` int DEFAULT NULL,
  `department_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `surname`, `employee_address_id`, `department_id`) VALUES
(1, 'Janne', 'Ahonen', 1, 1),
(3, 'Adam', 'Dadam', 3, 1),
(4, 'Wadam', 'Spp', 4, 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `employees_to_tasks`
--

CREATE TABLE `employees_to_tasks` (
  `employee_id` int NOT NULL,
  `task_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employees_to_tasks`
--

INSERT INTO `employees_to_tasks` (`employee_id`, `task_id`) VALUES
(4, 6),
(4, 7),
(3, 8),
(4, 8);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `employee_address`
--

CREATE TABLE `employee_address` (
  `id` int NOT NULL,
  `street` varchar(64) DEFAULT NULL,
  `city` varchar(64) DEFAULT NULL,
  `state` varchar(64) DEFAULT NULL,
  `zipcode` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employee_address`
--

INSERT INTO `employee_address` (`id`, `street`, `city`, `state`, `zipcode`) VALUES
(1, 'sdfgsfd', 'dfgdfg', 'sdfgsdfg', '456'),
(3, 'safd', 'sdf', 'sdf', 'sdf'),
(4, 'sdfsdf', 'sdfsf', '123', '456');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kategorie`
--

CREATE TABLE `kategorie` (
  `id` mediumint NOT NULL,
  `nazwa` varchar(40) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kategorie`
--

INSERT INTO `kategorie` (`id`, `nazwa`, `status`) VALUES
(1, 'Literatura polska', 'NOT_DELETED'),
(2, 'Literatura zagraniczna', 'NOT_DELETED'),
(3, 'Horror', 'NOT_DELETED'),
(4, 'Science-fiction', 'NOT_DELETED'),
(11, 'Nowa Kategoria', 'NOT_DELETED'),
(12, 'Komedixd', 'NOT_DELETED'),
(14, 'FFFF', 'DELETED'),
(15, 'CAT', 'DELETED');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ksiazki`
--

CREATE TABLE `ksiazki` (
  `id` int NOT NULL,
  `nazwa` varchar(100) DEFAULT NULL,
  `wydawnictwo` varchar(50) DEFAULT NULL,
  `cena` float DEFAULT NULL,
  `kategoria_id` mediumint DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ksiazki`
--

INSERT INTO `ksiazki` (`id`, `nazwa`, `wydawnictwo`, `cena`, `kategoria_id`, `status`) VALUES
(1, 'Hamlexd', 'AAA', 6.5, 2, 'NOT_DELETED'),
(2, 'Makbet', 'AAA', 6.8, 4, 'NOT_DELETED'),
(3, 'Potop', 'BBB', 18.4, 4, 'NOT_DELETED'),
(4, 'Quo vadis', 'BBB', 17.99, 1, 'NOT_DELETED'),
(5, 'Pan Tadeusz', 'CCC', 13.78, 1, 'NOT_DELETED'),
(6, 'Nad Niemnemm', 'CCC', 15.45, 1, 'NOT_DELETED'),
(66, 'Futbol na Tak', 'PZPN', 34.5, 4, 'NOT_DELETED'),
(73, 'KKK', 'haahha', 656, 12, 'NOT_DELETED'),
(75, 'Ksiazka', 'Xd2', 56.9, 4, 'DELETED'),
(76, 'und', 'ttt', 2.55, 4, 'DELETED'),
(77, 'FFFF', 'FFFFF', 23.5, 1, 'DELETED'),
(78, 'sdfsd', 'sdfsdf', 0, 12, 'DELETED'),
(79, 'AAAA', 'AAAAAA', 45.6, 15, 'DELETED'),
(80, 'dddd', 'dddd', 34.88, 4, 'NOT_DELETED');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `orders`
--

CREATE TABLE `orders` (
  `id` int NOT NULL,
  `price` float DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `date_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `price`, `status`, `date_time`, `username`) VALUES
(85, 15.45, 'FINISHED', '2023-06-22 18:30:38', 'jan'),
(86, 690.88, 'COMPLETED', '2023-06-22 21:25:58', 'jan');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tasks`
--

CREATE TABLE `tasks` (
  `id` int NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `status` enum('ASSIGNED','CLOSED','NEEDINFO','NEW','REOPENED','RESOLVED','UNCONFIRMED','VERIFIED') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` (`id`, `description`, `status`) VALUES
(1, 'sdfsdf', 'NEW'),
(6, 'dfgfd', 'NEW'),
(7, 'sdfsdf', 'NEW'),
(8, 'sfsdf', 'NEW');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `title`
--

CREATE TABLE `title` (
  `id` int NOT NULL,
  `title` varchar(64) DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `employee_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `title`
--

INSERT INTO `title` (`id`, `title`, `from_date`, `to_date`, `employee_id`) VALUES
(1, 'Prowadzacy', NULL, NULL, NULL),
(2, 'Test', NULL, NULL, NULL),
(3, 'Pomocnik', NULL, NULL, NULL),
(4, 'Test', NULL, NULL, NULL),
(5, 'Napastnik', NULL, NULL, NULL),
(6, 'Test', NULL, NULL, NULL),
(7, 'Komornik', NULL, NULL, 1),
(8, 'Test', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `username` varchar(25) NOT NULL,
  `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('jan', '$2a$10$HN9Wa3a0gve5mdyCwds2teTWpdEVLfLTyCLDrSRnerFu6eGIwk9gC', 1),
('Scott', '$2a$10$hbA/5IA2NwAPQACOkUvzUuiUULAl4evKdW7ic1R4J8ENsjLPBnAXy', 1),
('xdxdxd', '{bcrypt}$2a$10$zLvugwSuYXeTPht1u7Rux.mVzoxJ0YHvTVvsIIFjUPiOe.JFqH.ey', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zamowienia_to_ksiazki`
--

CREATE TABLE `zamowienia_to_ksiazki` (
  `ksiazka_id` int NOT NULL,
  `order_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `zamowienia_to_ksiazki`
--

INSERT INTO `zamowienia_to_ksiazki` (`ksiazka_id`, `order_id`) VALUES
(6, 85),
(73, 86),
(80, 86);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `authorities`
--
ALTER TABLE `authorities`
  ADD UNIQUE KEY `authorieties_idx_1` (`username`,`authority`);

--
-- Indeksy dla tabeli `autorzy`
--
ALTER TABLE `autorzy`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `autorzy_to_ksiazki`
--
ALTER TABLE `autorzy_to_ksiazki`
  ADD PRIMARY KEY (`ksiazka_id`,`autor_id`),
  ADD KEY `autor_id` (`autor_id`);

--
-- Indeksy dla tabeli `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employee_address_id` (`employee_address_id`),
  ADD KEY `department_id` (`department_id`);

--
-- Indeksy dla tabeli `employees_to_tasks`
--
ALTER TABLE `employees_to_tasks`
  ADD PRIMARY KEY (`employee_id`,`task_id`),
  ADD KEY `task_id` (`task_id`);

--
-- Indeksy dla tabeli `employee_address`
--
ALTER TABLE `employee_address`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `kategorie`
--
ALTER TABLE `kategorie`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `ksiazki`
--
ALTER TABLE `ksiazki`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kategoria_id` (`kategoria_id`);

--
-- Indeksy dla tabeli `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`);

--
-- Indeksy dla tabeli `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `title`
--
ALTER TABLE `title`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Indeksy dla tabeli `zamowienia_to_ksiazki`
--
ALTER TABLE `zamowienia_to_ksiazki`
  ADD PRIMARY KEY (`order_id`,`ksiazka_id`),
  ADD KEY `FK_KSIAZKA` (`ksiazka_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `autorzy`
--
ALTER TABLE `autorzy`
  MODIFY `id` smallint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `employee_address`
--
ALTER TABLE `employee_address`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `kategorie`
--
ALTER TABLE `kategorie`
  MODIFY `id` mediumint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `ksiazki`
--
ALTER TABLE `ksiazki`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;

--
-- AUTO_INCREMENT for table `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `title`
--
ALTER TABLE `title`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Constraints for table `autorzy_to_ksiazki`
--
ALTER TABLE `autorzy_to_ksiazki`
  ADD CONSTRAINT `autorzy_to_ksiazki_ibfk_1` FOREIGN KEY (`ksiazka_id`) REFERENCES `ksiazki` (`id`),
  ADD CONSTRAINT `autorzy_to_ksiazki_ibfk_2` FOREIGN KEY (`autor_id`) REFERENCES `autorzy` (`id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`employee_address_id`) REFERENCES `employee_address` (`id`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`);

--
-- Constraints for table `employees_to_tasks`
--
ALTER TABLE `employees_to_tasks`
  ADD CONSTRAINT `employees_to_tasks_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `employees_to_tasks_ibfk_2` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`);

--
-- Constraints for table `ksiazki`
--
ALTER TABLE `ksiazki`
  ADD CONSTRAINT `ksiazki_ibfk_1` FOREIGN KEY (`kategoria_id`) REFERENCES `kategorie` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Constraints for table `title`
--
ALTER TABLE `title`
  ADD CONSTRAINT `title_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `zamowienia_to_ksiazki`
--
ALTER TABLE `zamowienia_to_ksiazki`
  ADD CONSTRAINT `FK_KSIAZKA` FOREIGN KEY (`ksiazka_id`) REFERENCES `ksiazki` (`id`),
  ADD CONSTRAINT `FK_ORDER` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
