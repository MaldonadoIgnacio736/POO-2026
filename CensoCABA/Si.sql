-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema censocaba
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema censocaba
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `censocaba` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `censocaba` ;

-- -----------------------------------------------------
-- Table `censocaba`.`comuna`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `censocaba`.`comuna` (
  `idComuna` INT NOT NULL,
  `numSedeComunal` INT NOT NULL,
  PRIMARY KEY (`idComuna`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `censocaba`.`barrio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `censocaba`.`barrio` (
  `idBarrio` INT NOT NULL,
  `nombreBarrio` VARCHAR(45) NOT NULL,
  `superficieHectareas` INT NOT NULL,
  `idComuna` VARCHAR(45) NULL DEFAULT NULL,
  `barriocol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idBarrio`),
  CONSTRAINT `fk_Comuna`
    FOREIGN KEY (`idBarrio`)
    REFERENCES `censocaba`.`comuna` (`idComuna`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `censocaba`.`barriocomplejoshabitacionales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `censocaba`.`barriocomplejoshabitacionales` (
  `idBarrioComplejo` INT NOT NULL,
  `cantMonoblocks` INT NOT NULL,
  `consorcioMacroActivo` TINYINT NOT NULL,
  PRIMARY KEY (`idBarrioComplejo`),
  CONSTRAINT `fk_idBarrio`
    FOREIGN KEY (`idBarrioComplejo`)
    REFERENCES `censocaba`.`barrio` (`idBarrio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `censocaba`.`barrioformal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `censocaba`.`barrioformal` (
  `idBarrioFormal` INT NOT NULL,
  `cantEdificiosPropiedadHorizontal` INT NOT NULL,
  `porcentajeAsfalto` FLOAT NOT NULL,
  PRIMARY KEY (`idBarrioFormal`),
  CONSTRAINT `fk_idBarrioFormal`
    FOREIGN KEY (`idBarrioFormal`)
    REFERENCES `censocaba`.`barrio` (`idBarrio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `censocaba`.`barrioplanurbanizacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `censocaba`.`barrioplanurbanizacion` (
  `idBarrio` INT NOT NULL,
  `numLeyLegisladorCABA` INT NOT NULL,
  `conexionAgua` TINYINT NOT NULL,
  PRIMARY KEY (`idBarrio`),
  CONSTRAINT `fk_BarrioFormal`
    FOREIGN KEY (`idBarrio`)
    REFERENCES `censocaba`.`barrio` (`idBarrio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `censocaba`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `censocaba`.`persona` (
  `DNi` INT NOT NULL,
  `nombreCompleto` VARCHAR(45) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `situacionLaboral` TINYINT NOT NULL,
  `idBarrio` INT NOT NULL,
  PRIMARY KEY (`DNi`, `nombreCompleto`),
  CONSTRAINT `idBarrioPersona`
    FOREIGN KEY (`DNi`)
    REFERENCES `censocaba`.`barrio` (`idBarrio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
