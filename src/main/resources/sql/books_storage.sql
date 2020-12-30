-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Дек 30 2020 г., 15:22
-- Версия сервера: 10.3.13-MariaDB
-- Версия PHP: 7.1.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `books_storage`
--

-- --------------------------------------------------------

--
-- Структура таблицы `book`
--

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `number_book` int(11) DEFAULT NULL,
  `reserve_count` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `total_count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `book`
--

INSERT INTO `book` (`id`, `author`, `number_book`, `reserve_count`, `title`, `total_count`) VALUES
(1, 'Александр Грибоедов', 1, 0, 'Горе от ума', 5),
(2, 'Агата Кристи', 2, 2, '10 негритят', 10),
(3, 'Алан Александр Милн', 3, 1, 'Винни-Пух', 8),
(4, 'Александр Волков', 4, 1, 'Волшебник Изумрудного города', 4),
(5, 'Александр Грин', 5, 1, 'Алые паруса', 7),
(6, 'Александр Дюма', 6, 1, 'Три мушкетера', 10),
(7, 'Александр Пушкин', 7, 0, 'Евгений Онегин', 14);

-- --------------------------------------------------------

--
-- Структура таблицы `close_book_order`
--

CREATE TABLE `close_book_order` (
  `id` bigint(20) NOT NULL,
  `date_close_order` date DEFAULT NULL,
  `ordering_book_id` bigint(20) DEFAULT NULL,
  `worker_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `close_book_order`
--

INSERT INTO `close_book_order` (`id`, `date_close_order`, `ordering_book_id`, `worker_id`) VALUES
(1, '2020-12-30', 1, 3),
(2, '2020-12-30', 5, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `ordering_book`
--

CREATE TABLE `ordering_book` (
  `id` bigint(20) NOT NULL,
  `count_day_order` int(11) NOT NULL,
  `date_order` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time_order` time DEFAULT NULL,
  `book_id` bigint(20) DEFAULT NULL,
  `reader_id` bigint(20) DEFAULT NULL,
  `worker_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `ordering_book`
--

INSERT INTO `ordering_book` (`id`, `count_day_order`, `date_order`, `status`, `time_order`, `book_id`, `reader_id`, `worker_id`) VALUES
(1, 14, '2020-12-30', 'закрыт', '15:12:40', 1, 1, 2),
(2, 12, '2020-12-30', 'активный', '15:12:52', 2, 1, 2),
(3, 10, '2020-12-09', 'активный', '15:13:00', 3, 1, 2),
(4, 12, '2020-12-30', 'активный', '15:13:48', 6, 3, 3),
(5, 16, '2020-12-30', 'закрыт', '15:13:58', 5, 2, 3),
(8, 12, '2020-12-06', 'активный', '15:16:58', 2, 3, 2),
(9, 5, '2020-12-30', 'активный', '15:17:10', 5, 4, 2),
(10, 15, '2020-12-30', 'активный', '15:17:20', 4, 2, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `reader`
--

CREATE TABLE `reader` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `number_phone` varchar(50) DEFAULT NULL,
  `patronym` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `reader`
--

INSERT INTO `reader` (`id`, `first_name`, `last_name`, `number_phone`, `patronym`) VALUES
(1, 'Алексей', 'Котов', '1111', 'Викторович'),
(2, 'Алла', 'Олейникова', '1112', 'Владимировна'),
(3, 'Владимир', 'Шустрый', '1122', 'Алексеевич'),
(4, 'Инна', 'Власенко', '1222', 'Григорьевна');

-- --------------------------------------------------------

--
-- Структура таблицы `reader_all_books`
--

CREATE TABLE `reader_all_books` (
  `reader_id` bigint(20) NOT NULL,
  `all_books_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `reader_all_books`
--

INSERT INTO `reader_all_books` (`reader_id`, `all_books_id`) VALUES
(1, 1),
(2, 5);

-- --------------------------------------------------------

--
-- Структура таблицы `reader_reserve_books`
--

CREATE TABLE `reader_reserve_books` (
  `reader_id` bigint(20) NOT NULL,
  `reserve_books_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `reader_reserve_books`
--

INSERT INTO `reader_reserve_books` (`reader_id`, `reserve_books_id`) VALUES
(1, 2),
(1, 3),
(2, 4),
(3, 2),
(3, 6),
(4, 5);

-- --------------------------------------------------------

--
-- Структура таблицы `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `role`
--

INSERT INTO `role` (`id`, `role_name`) VALUES
(1, 'USER');

-- --------------------------------------------------------

--
-- Структура таблицы `worker`
--

CREATE TABLE `worker` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `patronym` varchar(50) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `worker`
--

INSERT INTO `worker` (`id`, `first_name`, `last_name`, `password`, `patronym`, `role_id`) VALUES
(1, 'admin', 'admin', '$2a$10$Ur00/RV6UcnXfGtIXlNOE.lpQvnHY5XP97Pfqa7U9CQYG2/yV1ghK', 'admin', 1),
(2, 'Татьяна', 'Емельянович', '$2a$10$k.AzCyCxgiO7wxsjVZjUmeak8NHg8i6haZgz2/a7y0zfpV8BB6Emi', 'Витальевна', 1),
(3, 'Полина', 'Сечина', '$2a$10$NzKrcUqOa8ALnghY7U4Fc.akHu6vwbKmZhpmV7Q0cEmO0UVzauFYi', 'Владимировна', 1);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `close_book_order`
--
ALTER TABLE `close_book_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt9v58njhw1uhqgtyepiemj4wb` (`ordering_book_id`),
  ADD KEY `FKkklc4tk68ib0p25ru4wwhhpv5` (`worker_id`);

--
-- Индексы таблицы `ordering_book`
--
ALTER TABLE `ordering_book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKeph2ukcrwpwfovnw3md2yw9h7` (`book_id`),
  ADD KEY `FKfa47o5gi9j42pa0mms1qgqwsn` (`reader_id`),
  ADD KEY `FK8evbr7cwjkq8519fbncnxbx9q` (`worker_id`);

--
-- Индексы таблицы `reader`
--
ALTER TABLE `reader`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `reader_all_books`
--
ALTER TABLE `reader_all_books`
  ADD PRIMARY KEY (`reader_id`,`all_books_id`),
  ADD KEY `UK_rvi2jx24n5vai294mqrrc0y3d` (`all_books_id`) USING BTREE;

--
-- Индексы таблицы `reader_reserve_books`
--
ALTER TABLE `reader_reserve_books`
  ADD PRIMARY KEY (`reader_id`,`reserve_books_id`),
  ADD KEY `UK_d7s3tt69dr55ekuml9oxpmatm` (`reserve_books_id`) USING BTREE;

--
-- Индексы таблицы `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `worker`
--
ALTER TABLE `worker`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrt045idbwchsrtfjwc91b7lyy` (`role_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `book`
--
ALTER TABLE `book`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT для таблицы `close_book_order`
--
ALTER TABLE `close_book_order`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `ordering_book`
--
ALTER TABLE `ordering_book`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT для таблицы `reader`
--
ALTER TABLE `reader`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `worker`
--
ALTER TABLE `worker`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `close_book_order`
--
ALTER TABLE `close_book_order`
  ADD CONSTRAINT `FKkklc4tk68ib0p25ru4wwhhpv5` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`),
  ADD CONSTRAINT `FKt9v58njhw1uhqgtyepiemj4wb` FOREIGN KEY (`ordering_book_id`) REFERENCES `ordering_book` (`id`);

--
-- Ограничения внешнего ключа таблицы `ordering_book`
--
ALTER TABLE `ordering_book`
  ADD CONSTRAINT `FK8evbr7cwjkq8519fbncnxbx9q` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`),
  ADD CONSTRAINT `FKeph2ukcrwpwfovnw3md2yw9h7` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKfa47o5gi9j42pa0mms1qgqwsn` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`id`);

--
-- Ограничения внешнего ключа таблицы `reader_all_books`
--
ALTER TABLE `reader_all_books`
  ADD CONSTRAINT `FK4p5lokkyj44fvxnmvdoa9o1h7` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`id`),
  ADD CONSTRAINT `FKar6b2pfx03xbvekgbuedk0akc` FOREIGN KEY (`all_books_id`) REFERENCES `book` (`id`);

--
-- Ограничения внешнего ключа таблицы `reader_reserve_books`
--
ALTER TABLE `reader_reserve_books`
  ADD CONSTRAINT `FKhjkrj2mrmy088rv3r0y831g6r` FOREIGN KEY (`reserve_books_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKk083qg1upjdfrknmp8hf8ccrv` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`id`);

--
-- Ограничения внешнего ключа таблицы `worker`
--
ALTER TABLE `worker`
  ADD CONSTRAINT `FKrt045idbwchsrtfjwc91b7lyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
