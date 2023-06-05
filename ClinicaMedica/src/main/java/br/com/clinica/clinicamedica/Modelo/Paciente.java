package br.com.clinica.clinicamedica.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa{
    protected String convenio_medico;
    protected List <Consulta> listaConsultas;

    public Paciente() {
    }

    public Paciente(int id_pessoa, String nome_completo, LocalDate data_nascimento, char sexo_biologico, String nome_mae, String naturalidade_municipio, String naturalidade_estado, String endereco_completo, String login, String senha, String convenio_medico) {
        super(id_pessoa, nome_completo, data_nascimento, sexo_biologico, nome_mae, naturalidade_municipio, naturalidade_estado, endereco_completo, login, senha);
        this.convenio_medico = convenio_medico;
        this.listaConsultas = new ArrayList<>();
    }
    public Paciente(String nome_completo, LocalDate data_nascimento, char sexo_biologico, String nome_mae, String naturalidade_municipio, String naturalidade_estado, String endereco_completo, String login, String senha, String convenio_medico) {
        super(nome_completo, data_nascimento, sexo_biologico, nome_mae, naturalidade_municipio, naturalidade_estado, endereco_completo, login, senha);
        this.convenio_medico = convenio_medico;
        this.listaConsultas = new ArrayList<>();
    }
}
