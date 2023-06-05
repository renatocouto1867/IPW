-- PostgreSQL does not support changing session variables like MySQL. Remove the SET statements.

-- DROP SCHEMA IF EXISTS clinica_medica CASCADE; -- Uncomment this line if you want to drop the existing schema

-- Create Schema
CREATE SCHEMA IF NOT EXISTS clinica_medica;

-- Switch to the Schema
SET search_path TO clinica_medica;

-- Table pessoa
DROP TABLE IF EXISTS pessoa CASCADE;

CREATE TABLE pessoa (
  id_pessoa SERIAL PRIMARY KEY,
  nome_completo VARCHAR(100),
  data_nascimento DATE,
  sexo_biologico CHAR(1),
  nome_mae VARCHAR(100),
  naturalidade_municipio VARCHAR(100),
  naturalidade_estado CHAR(2),
  endereco_completo VARCHAR(200),
  login VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL
);

CREATE UNIQUE INDEX login_UNIQUE ON pessoa (login);

-- Table paciente
DROP TABLE IF EXISTS paciente CASCADE;

CREATE TABLE paciente (
  convenio_medico VARCHAR(50),
  pessoa_id_pessoa INT PRIMARY KEY REFERENCES pessoa (id_pessoa)
);

-- Table medico
DROP TABLE IF EXISTS medico CASCADE;

CREATE TABLE medico (
  	crm VARCHAR(20),
	especialidade VARCHAR(20),
  	pessoa_id_pessoa INT PRIMARY KEY REFERENCES pessoa (id_pessoa)
);

-- Table consulta
DROP TABLE IF EXISTS consulta CASCADE;

CREATE TABLE consulta (
  id_consulta SERIAL PRIMARY KEY,
  entrevista TEXT,
  exame_fisico TEXT,
  exames_complementares TEXT,
  resultados_exames TEXT,
  hipoteses_diagnosticas TEXT,
  diagnostico_definitivo TEXT,
  tratamento_efetuado TEXT,
  data_hora TIMESTAMP,
  paciente_pessoa_id_pessoa INT REFERENCES paciente (pessoa_id_pessoa),
  medico_pessoa_id_pessoa INT REFERENCES medico (pessoa_id_pessoa)
);

--- insert

INSERT INTO clinica_medica.pessoa(
	nome_completo, data_nascimento, sexo_biologico, nome_mae, naturalidade_municipio, naturalidade_estado, endereco_completo, login, senha)
	VALUES ('Jose da Silva', '1985-7-20', 'M', 'Maria Silva', 'Palmas', 'TO', 'Rua 15 lote 90, Palmas TO', 'jose', '123');

INSERT INTO clinica_medica.medico(
	crm, especialidade, pessoa_id_pessoa)
	VALUES ('145CRMTO','Clinico Geral', 1);

INSERT INTO clinica_medica.pessoa(
	nome_completo, data_nascimento, sexo_biologico, nome_mae, naturalidade_municipio, naturalidade_estado, endereco_completo, login, senha)
	VALUES ('Pedro da Silva', '1988-9-20', 'M', 'Maria Silva', 'Palmas', 'TO', 'Rua 99 lote 150, Palmas TO', 'pedro', '123');

INSERT INTO clinica_medica.paciente(
	convenio_medico, pessoa_id_pessoa)
	VALUES ('SUS', 4);



INSERT INTO clinica_medica.medico(
	crm, especialidade, pessoa_id_pessoa)
	VALUES ('15 CRMTO','Pediatra', 2);
	
INSERT INTO clinica_medica.pessoa(
	nome_completo, data_nascimento, sexo_biologico, nome_mae, naturalidade_municipio, naturalidade_estado, endereco_completo, login, senha)
	VALUES ('Paula dos Santos', '1995-8-25', 'F', 'Maria dos Santos', 'Palmas', 'TO', 'Rua 19 lote 90, Palmas TO', 'paula', 'abc');

INSERT INTO clinica_medica.paciente(
	convenio_medico, pessoa_id_pessoa)
	VALUES ('Unimed', 2);
	
	
	
-- Select	
	
select * from clinica_medica.pessoa;

select * from clinica_medica.medico where pessoa_id_pessoa=2;

select * from clinica_medica.paciente;

--pesquisa medico por id
SELECT * FROM clinica_medica.pessoa inner join clinica_medica.medico on clinica_medica.medico.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa where pessoa_id_pessoa = ?;

-- pesquisa por nome
SELECT * FROM clinica_medica.pessoa inner join clinica_medica.medico on clinica_medica.medico.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa where lower(clinica_medica.pessoa.nome_completo) like lower('%Renato%');

-- pesquisa usuario por Nome
select 
pessoa.id_pessoa,
pessoa.nome_completo,
pessoa.login,
pessoa.senha,
coalesce(paciente.pessoa_id_pessoa, 0) AS paciente_id_pessoa,
coalesce(medico.pessoa_id_pessoa, 0) AS medico_id_pessoa
from clinica_medica.pessoa 
left join clinica_medica.medico 
on clinica_medica.medico.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa 
left join clinica_medica.paciente
on clinica_medica.paciente.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa
where clinica_medica.pessoa.login ='jose';


where lower(clinica_medica.pessoa.nome_completo) like lower('%Renato%');


