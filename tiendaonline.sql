-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: database:3306
-- Tiempo de generación: 23-11-2023 a las 07:05:20
-- Versión del servidor: 8.1.0
-- Versión de PHP: 8.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tiendaonline`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` bigint NOT NULL,
  `estado_pedido` bit(1) NOT NULL,
  `fecha_pedido` datetime NOT NULL,
  `fecha_entrega` datetime NOT NULL,
  `id_cliente` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `estado_pedido`, `fecha_pedido`, `fecha_entrega`, `id_cliente`) VALUES
(1, b'0', '2021-11-02 11:23:00', '2023-12-22 10:23:00', 1),
(2, b'0', '2023-11-21 10:24:00', '2023-11-24 10:24:00', 3),
(4, b'0', '2023-11-21 10:24:00', '2023-11-28 10:24:00', 1),
(5, b'0', '2023-11-21 10:24:00', '2023-11-28 10:24:00', 1),
(6, b'0', '2023-11-21 10:24:00', '2023-12-03 10:24:00', 1),
(7, b'0', '2023-11-21 10:24:00', '2023-12-04 10:24:00', 1),
(8, b'0', '2023-11-21 10:24:00', '2023-11-23 10:24:00', 1),
(9, b'0', '2023-11-21 10:24:00', '2023-12-01 10:24:00', 1),
(10, b'0', '2023-11-21 10:24:00', '2023-11-25 10:24:00', 1),
(11, b'1', '2023-11-22 10:59:39', '2023-11-30 10:59:39', 2),
(12, b'1', '2023-11-22 11:00:17', '2023-11-28 11:00:17', 1),
(13, b'1', '2023-11-22 11:01:42', '2023-11-30 11:01:42', 2),
(14, b'1', '2023-11-22 11:03:09', '2023-11-30 11:03:09', 2),
(15, b'1', '2023-11-22 11:05:56', '2023-12-05 11:05:56', 6),
(16, b'0', '2023-11-22 11:06:09', '2023-11-30 11:06:09', 1),
(17, b'0', '2023-11-22 11:06:09', '2023-11-25 11:06:09', 1),
(18, b'0', '2023-11-22 11:06:09', '2023-11-27 11:06:09', 1),
(19, b'0', '2023-11-22 11:06:09', '2023-11-27 11:06:09', 1),
(20, b'0', '2023-11-22 11:06:09', '2023-12-05 11:06:09', 1),
(21, b'0', '2023-11-22 11:06:09', '2023-11-25 11:06:09', 1),
(22, b'0', '2023-11-22 11:06:09', '2023-11-27 11:06:09', 1),
(23, b'0', '2023-11-22 11:06:09', '2023-11-29 11:06:09', 1),
(24, b'0', '2023-11-22 11:06:10', '2023-12-02 11:06:10', 1),
(25, b'0', '2023-11-22 11:06:10', '2023-12-02 11:06:10', 1),
(26, b'0', '2023-11-22 11:06:17', '2023-11-27 11:06:17', 1),
(27, b'0', '2023-11-22 11:06:17', '2023-11-28 11:06:17', 1),
(28, b'0', '2023-11-22 11:06:18', '2023-12-03 11:06:18', 1),
(29, b'0', '2023-11-22 11:06:18', '2023-12-04 11:06:18', 1),
(30, b'0', '2023-11-22 11:06:18', '2023-12-05 11:06:18', 1),
(31, b'0', '2023-11-22 11:06:18', '2023-11-28 11:06:18', 1),
(32, b'0', '2023-11-22 11:06:18', '2023-12-02 11:06:18', 1),
(33, b'0', '2023-11-22 11:06:18', '2023-12-06 11:06:18', 1),
(34, b'0', '2023-11-22 11:06:18', '2023-11-24 11:06:18', 1),
(35, b'0', '2023-11-22 11:06:18', '2023-11-28 11:06:18', 1),
(36, b'1', '2023-11-22 11:10:02', '2023-11-24 11:10:02', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `prize` float NOT NULL,
  `stock` int NOT NULL,
  `id_pedido` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `name`, `categoria`, `prize`, `stock`, `id_pedido`) VALUES
(1, 'Manzana Golden', 'Fruta', 2.85, 48, 1),
(2, 'Manzana Golden', 'Fruta', 2.85, 48, 1),
(3, 'Manzana Golden', 'Fruta', 2.85, 48, 1),
(4, 'Manzana Golden', 'Fruta', 2.85, 48, 1),
(5, 'Manzana Golden', 'Fruta', 2.85, 48, 1),
(6, 'Manzana Golden', 'Fruta', 2.85, 48, 1),
(7, 'Manzana Golden', 'Fruta', 2.85, 48, 1),
(8, 'Manzana Golden', 'Fruta', 2.85, 48, 1),
(9, 'Manzana Golden', 'Fruta', 2.85, 48, 1),
(10, 'Manzana Golden', 'Fruta', 2.85, 48, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` bit(1) DEFAULT NULL,
  `surname` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `address`, `email`, `lastname`, `name`, `password`, `role`, `surname`, `username`) VALUES
(1, 'Calle San José', 'email0@ausiasmarch.net', 'lastname0', 'Elena', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'0', 'Ortega', 'kirachan'),
(2, 'Calle San Rafael', 'email1@ausiasmarch.net', 'lastname1', 'Monica', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'Puig', 'monichan'),
(3, 'address2', 'email2@ausiasmarch.net', 'lastname2', 'name2', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname2', 'username2'),
(4, 'address3', 'email3@ausiasmarch.net', 'lastname3', 'name3', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname3', 'username3'),
(5, 'address4', 'email4@ausiasmarch.net', 'lastname4', 'name4', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname4', 'username4'),
(6, 'address5', 'email5@ausiasmarch.net', 'lastname5', 'name5', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname5', 'username5'),
(7, 'address6', 'email6@ausiasmarch.net', 'lastname6', 'name6', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname6', 'username6'),
(8, 'address7', 'email7@ausiasmarch.net', 'lastname7', 'name7', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname7', 'username7'),
(9, 'address8', 'email8@ausiasmarch.net', 'lastname8', 'name8', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname8', 'username8'),
(10, 'address9', 'email9@ausiasmarch.net', 'lastname9', 'name9', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname9', 'username9'),
(11, 'address10', 'email10@ausiasmarch.net', 'lastname10', 'name10', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname10', 'username10'),
(12, 'address11', 'email11@ausiasmarch.net', 'lastname11', 'name11', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname11', 'username11'),
(13, 'address12', 'email12@ausiasmarch.net', 'lastname12', 'name12', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname12', 'username12'),
(14, 'address13', 'email13@ausiasmarch.net', 'lastname13', 'name13', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname13', 'username13'),
(15, 'address14', 'email14@ausiasmarch.net', 'lastname14', 'name14', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname14', 'username14'),
(16, 'address15', 'email15@ausiasmarch.net', 'lastname15', 'name15', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname15', 'username15'),
(17, 'address16', 'email16@ausiasmarch.net', 'lastname16', 'name16', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname16', 'username16'),
(18, 'address17', 'email17@ausiasmarch.net', 'lastname17', 'name17', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname17', 'username17'),
(19, 'address18', 'email18@ausiasmarch.net', 'lastname18', 'name18', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname18', 'username18'),
(20, 'address19', 'email19@ausiasmarch.net', 'lastname19', 'name19', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname19', 'username19'),
(21, 'address20', 'email20@ausiasmarch.net', 'lastname20', 'name20', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname20', 'username20'),
(22, 'address21', 'email21@ausiasmarch.net', 'lastname21', 'name21', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname21', 'username21'),
(23, 'address22', 'email22@ausiasmarch.net', 'lastname22', 'name22', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname22', 'username22'),
(24, 'address23', 'email23@ausiasmarch.net', 'lastname23', 'name23', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname23', 'username23'),
(25, 'address24', 'email24@ausiasmarch.net', 'lastname24', 'name24', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname24', 'username24'),
(26, 'address25', 'email25@ausiasmarch.net', 'lastname25', 'name25', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname25', 'username25'),
(27, 'address26', 'email26@ausiasmarch.net', 'lastname26', 'name26', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname26', 'username26'),
(28, 'address27', 'email27@ausiasmarch.net', 'lastname27', 'name27', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname27', 'username27'),
(29, 'address28', 'email28@ausiasmarch.net', 'lastname28', 'name28', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname28', 'username28'),
(30, 'address29', 'email29@ausiasmarch.net', 'lastname29', 'name29', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname29', 'username29'),
(31, 'aaaaaaaaaaaaaaaaaaaaaaaa', 'laura@gmail.com', NULL, 'Laura', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'0', 'Gómez', 'aaaaaaaaa'),
(33, 'Calle San Pablo', 'sanda@gmail.com', '', 'Sandra', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'Fernandez', 'sandra05'),
(34, 'Calle San Pablo', 'sanda@gmail.com', 'Gomez', 'Sandra', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'Fernandez', 'sandra05'),
(35, 'Calle San Pablo', 'sanda@gmail.com', 'Gomez', 'Sandra', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'Fernandez', 'sandra05'),
(36, 'address0', 'email0@ausiasmarch.net', 'lastname0', 'name0', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname0', 'username0'),
(37, 'address1', 'email1@ausiasmarch.net', 'lastname1', 'name1', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname1', 'username1'),
(38, 'address2', 'email2@ausiasmarch.net', 'lastname2', 'name2', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname2', 'username2'),
(39, 'address3', 'email3@ausiasmarch.net', 'lastname3', 'name3', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname3', 'username3'),
(40, 'address4', 'email4@ausiasmarch.net', 'lastname4', 'name4', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname4', 'username4'),
(41, 'address0', 'email0@ausiasmarch.net', 'lastname0', 'name0', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname0', 'username0'),
(42, 'address1', 'email1@ausiasmarch.net', 'lastname1', 'name1', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname1', 'username1'),
(43, 'address2', 'email2@ausiasmarch.net', 'lastname2', 'name2', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname2', 'username2'),
(44, 'address3', 'email3@ausiasmarch.net', 'lastname3', 'name3', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname3', 'username3'),
(45, 'address4', 'email4@ausiasmarch.net', 'lastname4', 'name4', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname4', 'username4'),
(46, 'address5', 'email5@ausiasmarch.net', 'lastname5', 'name5', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname5', 'username5'),
(47, 'address6', 'email6@ausiasmarch.net', 'lastname6', 'name6', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname6', 'username6'),
(48, 'address7', 'email7@ausiasmarch.net', 'lastname7', 'name7', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname7', 'username7'),
(49, 'address8', 'email8@ausiasmarch.net', 'lastname8', 'name8', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname8', 'username8'),
(50, 'address9', 'email9@ausiasmarch.net', 'lastname9', 'name9', 'e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e', b'1', 'surname9', 'username9');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbphsp3c2ybpud5hthw7u8t340` (`id_cliente`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKioi0b2bhj9qm0nrebs04ald0s` (`id_pedido`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FKbphsp3c2ybpud5hthw7u8t340` FOREIGN KEY (`id_cliente`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `FKioi0b2bhj9qm0nrebs04ald0s` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
