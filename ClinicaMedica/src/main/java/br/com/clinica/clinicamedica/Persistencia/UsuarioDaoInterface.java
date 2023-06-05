package br.com.clinica.clinicamedica.Persistencia;

import br.com.clinica.clinicamedica.Modelo.Usuario;

public interface UsuarioDaoInterface {
    public Usuario buscar(int codigo) throws ErroDAO;

    public Usuario buscar(Usuario u) throws ErroDAO;

    public Usuario buscar(String login) throws ErroDAO;
    public Usuario buscar(String login, String senha) throws ErroDAO;
}
