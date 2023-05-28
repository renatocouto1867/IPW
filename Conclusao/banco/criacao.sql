-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema clinica_medica
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema clinica_medica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clinica_medica` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
-- -----------------------------------------------------
-- Schema clinica_medica2
-- -----------------------------------------------------
USE `clinica_medica` ;

-- -----------------------------------------------------
-- Table `clinica_medica`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinica_medica`.`pessoa` (
  `id_pessoa` INT NOT NULL AUTO_INCREMENT,
  `nome_completo` VARCHAR(100) NULL DEFAULT NULL,
  `data_nascimento` DATE NULL DEFAULT NULL,
  `sexo_biologico` ENUM('M', 'F') NULL DEFAULT NULL,
  `nome_mae` VARCHAR(100) NULL DEFAULT NULL,
  `naturalidade_municipio` VARCHAR(100) NULL DEFAULT NULL,
  `naturalidade_estado` CHAR(2) NULL DEFAULT NULL,
  `endereco_completo` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id_pessoa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `clinica_medica`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinica_medica`.`paciente` (
  `convenio_medico` VARCHAR(50) NULL DEFAULT NULL,
  `pessoa_id_pessoa` INT NOT NULL,
  PRIMARY KEY (`pessoa_id_pessoa`),
  CONSTRAINT `fk_paciente_pessoa1`
    FOREIGN KEY (`pessoa_id_pessoa`)
    REFERENCES `clinica_medica`.`pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `clinica_medica`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinica_medica`.`medico` (
  `crm` VARCHAR(20) NULL DEFAULT NULL,
  `pessoa_id_pessoa` INT NOT NULL,
  PRIMARY KEY (`pessoa_id_pessoa`),
  CONSTRAINT `fk_medico_pessoa1`
    FOREIGN KEY (`pessoa_id_pessoa`)
    REFERENCES `clinica_medica`.`pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `clinica_medica`.`consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinica_medica`.`consulta` (
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
  PRIMARY KEY (`id_consulta`),
  INDEX `fk_consulta_paciente1_idx` (`paciente_pessoa_id_pessoa` ASC) VISIBLE,
  INDEX `fk_consulta_medico1_idx` (`medico_pessoa_id_pessoa` ASC) VISIBLE,
  CONSTRAINT `fk_consulta_paciente1`
    FOREIGN KEY (`paciente_pessoa_id_pessoa`)
    REFERENCES `clinica_medica`.`paciente` (`pessoa_id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_medico1`
    FOREIGN KEY (`medico_pessoa_id_pessoa`)
    REFERENCES `clinica_medica`.`medico` (`pessoa_id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `clinica_medica`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinica_medica`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `id_pessoa` INT NULL DEFAULT NULL,
  `login` VARCHAR(50) NULL DEFAULT NULL,
  `senha` VARCHAR(50) NULL DEFAULT NULL,
  `tipo_usuario` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  INDEX `id_pessoa` (`id_pessoa` ASC) VISIBLE,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
  CONSTRAINT `usuario_ibfk_1`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `clinica_medica`.`pessoa` (`id_pessoa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
