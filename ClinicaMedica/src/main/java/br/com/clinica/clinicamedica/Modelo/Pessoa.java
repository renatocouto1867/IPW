package br.com.clinica.clinicamedica.Modelo;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Pessoa {
    protected int id_pessoa;
    protected String nome_completo;
    protected LocalDate data_nascimento;
    protected char sexo_biologico;
    protected String nome_mae;
    protected String naturalidade_municipio;
    protected String naturalidade_estado;
    protected String endereco_completo;
    protected String login;
    protected String senha;

    public Pessoa() {
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public char getSexo_biologico() {
        return sexo_biologico;
    }

    public void setSexo_biologico(char sexo_biologico) {
        this.sexo_biologico = sexo_biologico;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getNaturalidade_municipio() {
        return naturalidade_municipio;
    }

    public void setNaturalidade_municipio(String naturalidade_municipio) {
        this.naturalidade_municipio = naturalidade_municipio;
    }

    public String getNaturalidade_estado() {
        return naturalidade_estado;
    }

    public void setNaturalidade_estado(String naturalidade_estado) {
        this.naturalidade_estado = naturalidade_estado;
    }

    public String getEndereco_completo() {
        return endereco_completo;
    }

    public void setEndereco_completo(String endereco_completo) {
        this.endereco_completo = endereco_completo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa(int id_pessoa, String nome_completo, LocalDate data_nascimento, char sexo_biologico, String nome_mae, String naturalidade_municipio, String naturalidade_estado, String endereco_completo, String login, String senha) {
        this.id_pessoa = id_pessoa;
        this.nome_completo = nome_completo;
        this.data_nascimento = data_nascimento;
        this.sexo_biologico = sexo_biologico;
        this.nome_mae = nome_mae;
        this.naturalidade_municipio = naturalidade_municipio;
        this.naturalidade_estado = naturalidade_estado;
        this.endereco_completo = endereco_completo;
        this.login = login;
        this.senha = senha;
    }

    public Pessoa(String nome_completo, LocalDate data_nascimento, char sexo_biologico, String nome_mae, String naturalidade_municipio, String naturalidade_estado, String endereco_completo, String login, String senha) {
        this.nome_completo = nome_completo;
        this.data_nascimento = data_nascimento;
        this.sexo_biologico = sexo_biologico;
        this.nome_mae = nome_mae;
        this.naturalidade_municipio = naturalidade_municipio;
        this.naturalidade_estado = naturalidade_estado;
        this.endereco_completo = endereco_completo;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id_pessoa == pessoa.id_pessoa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pessoa);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id_pessoa=" + id_pessoa +
                ", nome_completo='" + nome_completo + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", sexo_biologico=" + sexo_biologico +
                ", nome_mae='" + nome_mae + '\'' +
                ", naturalidade_municipio='" + naturalidade_municipio + '\'' +
                ", naturalidade_estado='" + naturalidade_estado + '\'' +
                ", endereco_completo='" + endereco_completo + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
