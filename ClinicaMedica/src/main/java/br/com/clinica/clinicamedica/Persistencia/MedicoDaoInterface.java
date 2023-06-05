package br.com.clinica.clinicamedica.Persistencia;
import br.com.clinica.clinicamedica.Controle.ErroAcesso;
import br.com.clinica.clinicamedica.Modelo.Medico;
import br.com.clinica.clinicamedica.Modelo.Usuario;

import java.util.List;

public interface MedicoDaoInterface {
    public void inserir(Medico m, Usuario u) throws ErroDAO, ErroAcesso;
    public void editar(Medico m, Usuario u) throws ErroDAO, ErroAcesso;
    public Medico buscar(int codigo, Usuario u) throws ErroDAO, ErroAcesso;
    public Medico buscar(Medico m, Usuario u) throws ErroDAO, ErroAcesso;
    public List<Medico> listarMedicos(Usuario u) throws ErroDAO, ErroAcesso;
    public List<Medico> buscarNome(String nome, Usuario u) throws ErroDAO, ErroAcesso;
}
