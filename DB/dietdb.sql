-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dietdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dietdb` ;

-- -----------------------------------------------------
-- Schema dietdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dietdb` DEFAULT CHARACTER SET utf8 ;
USE `dietdb` ;

-- -----------------------------------------------------
-- Table `diet_tracking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `diet_tracking` ;

CREATE TABLE IF NOT EXISTS `diet_tracking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `calories` INT NULL,
  `protein` INT NULL,
  `carb` INT NULL,
  `fat` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS sd33_noah;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'sd33_noah' IDENTIFIED BY 'noah';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'sd33_noah';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `diet_tracking`
-- -----------------------------------------------------
START TRANSACTION;
USE `dietdb`;
INSERT INTO `diet_tracking` (`id`, `calories`, `protein`, `carb`, `fat`) VALUES (1, 500, 28, 13, 6);
INSERT INTO `diet_tracking` (`id`, `calories`, `protein`, `carb`, `fat`) VALUES (2, 800, 36, 18, 9);

COMMIT;

