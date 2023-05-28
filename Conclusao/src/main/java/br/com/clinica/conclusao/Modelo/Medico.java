package br.com.clinica.conclusao.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa{
    protected String crm;
    protected List<Consulta> listaConsultas;

    public Medico(String crm) {
        this.crm = crm;
    }

    public Medico(String nome_completo, LocalDate data_nascimento, char sexo_biologico, String nome_mae, String naturalidade_municipio, String naturalidade_estado, String endereco_completo, String crm) {
        super(nome_completo, data_nascimento, sexo_biologico, nome_mae, naturalidade_municipio, naturalidade_estado, endereco_completo);
        this.crm = crm;
    }

    public Medico(int id_pessoa, String nome_completo, LocalDate data_nascimento, char sexo_biologico, String nome_mae, String naturalidade_municipio, String naturalidade_estado, String endereco_completo, String crm) {
        super(id_pessoa, nome_completo, data_nascimento, sexo_biologico, nome_mae, naturalidade_municipio, naturalidade_estado, endereco_completo);
        this.crm = crm;
        this.listaConsultas = new ArrayList<>();
    }

    public Medico() {
        super();
    }

    public Medico(String nome_completo, LocalDate data_nascimento, char sexo_biologico, String nome_mae, String naturalidade_municipio, String naturalidade_estado, String endereco_completo) {
        super(nome_completo, data_nascimento, sexo_biologico, nome_mae, naturalidade_municipio, naturalidade_estado, endereco_completo);
    }

    public Medico(int id_pessoa, String nome_completo, LocalDate data_nascimento, char sexo_biologico, String nome_mae, String naturalidade_municipio, String naturalidade_estado, String endereco_completo) {
        super(id_pessoa, nome_completo, data_nascimento, sexo_biologico, nome_mae, naturalidade_municipio, naturalidade_estado, endereco_completo);
    }

    @Override
    public int getId_pessoa() {
        return super.getId_pessoa();
    }

    @Override
    public void setId_pessoa(int id_pessoa) {
        super.setId_pessoa(id_pessoa);
    }

    @Override
    public String getNome_completo() {
        return super.getNome_completo();
    }

    @Override
    public void setNome_completo(String nome_completo) {
        super.setNome_completo(nome_completo);
    }

    @Override
    public LocalDate getData_nascimento() {
        return super.getData_nascimento();
    }

    @Override
    public void setData_nascimento(LocalDate data_nascimento) {
        super.setData_nascimento(data_nascimento);
    }

    @Override
    public char getSexo_biologico() {
        return super.getSexo_biologico();
    }

    @Override
    public void setSexo_biologico(char sexo_biologico) {
        super.setSexo_biologico(sexo_biologico);
    }

    @Override
    public String getNome_mae() {
        return super.getNome_mae();
    }

    @Override
    public void setNome_mae(String nome_mae) {
        super.setNome_mae(nome_mae);
    }

    @Override
    public String getNaturalidade_municipio() {
        return super.getNaturalidade_municipio();
    }

    @Override
    public void setNaturalidade_municipio(String naturalidade_municipio) {
        super.setNaturalidade_municipio(naturalidade_municipio);
    }

    @Override
    public String getNaturalidade_estado() {
        return super.getNaturalidade_estado();
    }

    @Override
    public void setNaturalidade_estado(String naturalidade_estado) {
        super.setNaturalidade_estado(naturalidade_estado);
    }

    @Override
    public String getEndereco_completo() {
        return super.getEndereco_completo();
    }

    @Override
    public void setEndereco_completo(String endereco_completo) {
        super.setEndereco_completo(endereco_completo);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Medico{" +
                "crm='" + crm + '\'' +
                ", id_pessoa=" + id_pessoa +
                ", nome_completo='" + nome_completo + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", sexo_biologico=" + sexo_biologico +
                ", nome_mae='" + nome_mae + '\'' +
                ", naturalidade_municipio='" + naturalidade_municipio + '\'' +
                ", naturalidade_estado='" + naturalidade_estado + '\'' +
                ", endereco_completo='" + endereco_completo + '\'' +
                '}';
    }
}
