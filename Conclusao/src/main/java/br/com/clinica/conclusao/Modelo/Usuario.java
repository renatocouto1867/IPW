package br.com.clinica.conclusao.Modelo;

import java.util.Objects;

public class Usuario {
    private int idUsuario, idPessoa;
    private String login, senha, tipoUsuario;


    public Usuario() {
    }

    public Usuario(int idUsuario, int idPessoa, String login, String senha, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.idPessoa = idPessoa;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(int idPessoa, String login, String senha, String tipoUsuario) {
        this.idPessoa = idPessoa;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario == usuario.idUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", idPessoa=" + idPessoa +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}
