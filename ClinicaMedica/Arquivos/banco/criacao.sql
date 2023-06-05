-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema clinica_medica
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `clinica_medica` ;

-- -----------------------------------------------------
-- Schema clinica_medica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clinica_medica` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `clinica_medica` ;

-- -----------------------------------------------------
-- Table `pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pessoa` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id_pessoa` INT NOT NULL AUTO_INCREMENT,
  `nome_completo` VARCHAR(100) NULL DEFAULT NULL,
  `data_nascimento` DATE NULL DEFAULT NULL,
  `sexo_biologico` ENUM('M', 'F') NULL DEFAULT NULL,
  `nome_mae` VARCHAR(100) NULL DEFAULT NULL,
  `naturalidade_municipio` VARCHAR(100) NULL DEFAULT NULL,
  `naturalidade_estado` CHAR(2) NULL DEFAULT NULL,
  `endereco_completo` VARCHAR(200) NULL DEFAULT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) CHARACTER SET 'armscii8' NOT NULL,
  PRIMARY KEY (`id_pessoa`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `login_UNIQUE` ON `pessoa` (`login` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `paciente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `paciente` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `paciente` (
  `convenio_medico` VARCHAR(50) NULL DEFAULT NULL,
  `pessoa_id_pessoa` INT NOT NULL,
  PRIMARY KEY (`pessoa_id_pessoa`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `medico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medico` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `medico` (
  `crm` VARCHAR(20) NULL DEFAULT NULL,
  `pessoa_id_pessoa` INT NOT NULL,
  PRIMARY KEY (`pessoa_id_pessoa`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `consulta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `consulta` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `consulta` (
  `id_consulta` INT NOT NULL AUTO_INCREMENT,
  `entrevista` TEXT NULL DEFAULT NULL,
  `exame_fisico` TEXT NULL DEFAULT NULL,
  `exames_complementares` TEXT NULL DEFAULT NULL,
  `resultados_exames` TEXT NULL DEFAULT NULL,
  `hipoteses_diagnosticas` TEXT NULL DEFAULT NULL,
  `diagnostico_definitivo` TEXT NULL DEFAULT NULL,
  `tratamento_efetuado` TEXT NULL DEFAULT NULL,
  `data_hora` DATETIME NULL DEFAULT NULL,
  `paciente_pessoa_id_pessoa` INT NOT NULL,
  `medico_pessoa_id_pessoa` INT NOT NULL,
  PRIMARY KEY (`id_consulta`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
