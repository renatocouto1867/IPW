package br.com.clinica.conclusao.Persistencia;
import br.com.clinica.conclusao.Modelo.Usuario;

public interface UsuarioDaoInterface {
    public void inserir(Usuario u) throws ErroDAO;
    public void deletar(Usuario u) throws ErroDAO;
    public void deletar(int codigo) throws ErroDAO;
    public void editar(Usuario u) throws ErroDAO;
    public Usuario buscar(int codigo) throws ErroDAO;
    public Usuario buscar(Usuario u) throws ErroDAO;
    public Usuario buscar(String login,String senha) throws ErroDAO;
}
