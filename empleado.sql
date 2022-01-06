-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-12-2021 a las 03:29:32
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `agencia_de_turismo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID` int(11) NOT NULL,
  `APELLIDO` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `BORRADO` tinyint(1) DEFAULT 0,
  `CARGO` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DIRECCION` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DNI` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHANAC` date DEFAULT NULL,
  `LOCALIDAD` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NACIONALIDAD` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NUMTELEFONO` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PROVINCIA` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SUELDO` double DEFAULT NULL,
  `VENTASREALIZADAS` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`ID`, `APELLIDO`, `BORRADO`, `CARGO`, `DIRECCION`, `DNI`, `EMAIL`, `FECHANAC`, `LOCALIDAD`, `NACIONALIDAD`, `NOMBRE`, `NUMTELEFONO`, `PROVINCIA`, `SUELDO`, `VENTASREALIZADAS`, `USER_ID`) VALUES
(4, 'Cardenas', 0, 'desarrollador', 'Francisco de Aguirre 559', '39628310', 'ivaanlml@gmail.com', '1996-02-04', 'Lomas De Zamora', 'Argentino', 'Ivan', '1159773237', 'Buenos Aires', 55.555, 0, 3),
(853, 'Admin', 0, 'Administrador', 'Francisco de Aguirre 559', '12475634', 'admin@gmail.com', '1996-02-05', 'Lomas de zamora', 'Argentino', 'Admin', '1127357419', 'Buenos Aires', 99999, 0, 852);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_EMPLEADO_USER_ID` (`USER_ID`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FK_EMPLEADO_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `usuario` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
