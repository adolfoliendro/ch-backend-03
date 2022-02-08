CREATE DATABASE `prueba`;
CREATE TABLE `prueba`.`items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `categoria` VARCHAR(255) NOT NULL,
  `stock` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `prueba`.`items` (`nombre`, `categoria`, `stock`) VALUES ('Fideos', 'Harina', '20');
INSERT INTO `prueba`.`items` (`nombre`, `categoria`, `stock`) VALUES ('Leche', 'Lacteos', '30');
INSERT INTO `prueba`.`items` (`nombre`, `categoria`, `stock`) VALUES ('Crema', 'Lacteos', '15');

SELECT * FROM prueba.items;

DELETE FROM `prueba`.`items` WHERE (`id` = '1');

UPDATE `prueba`.`items` SET `stock` = '45' WHERE (`id` = '2');

SELECT * FROM prueba.items;