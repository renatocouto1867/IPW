package br.com.clinica.clinicamedica.Persistencia;

import br.com.clinica.clinicamedica.Modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDaoClasse implements UsuarioDaoInterface, AutoCloseable {
    private Connection con;

    public UsuarioDaoClasse() throws ErroDAO {
        con = FabricaConexao.pegaConexao();
    }

    @Override
    public Usuario buscar(int codigo) throws ErroDAO {
        String sql = "select \n" +
                "pessoa.id_pessoa,\n" +
                "pessoa.nome_completo,\n" +
                "pessoa.login,\n" +
                "pessoa.senha,\n" +
                "coalesce(paciente.pessoa_id_pessoa, 0) AS paciente_id_pessoa,\n" +
                "coalesce(medico.pessoa_id_pessoa, 0) AS medico_id_pessoa\n" +
                "from clinica_medica.pessoa \n" +
                "left join clinica_medica.medico \n" +
                "on clinica_medica.medico.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa \n" +
                "left join clinica_medica.paciente\n" +
                "on clinica_medica.paciente.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa\n" +
                "where clinica_medica.pessoa.id_pessoa =?";
        int tipoPaciente, tipoMedico;
        String tipoUsuario;
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setIdPessoa(rs.getInt("id_pessoa"));
                u.setNome(rs.getString("nome_completo"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));

                {//define o tipo de usuario
                    tipoPaciente = rs.getInt("paciente_id_pessoa");
                    tipoMedico = rs.getInt("medico_id_pessoa");

                    if (tipoPaciente > 0) {
                        tipoUsuario = "paciente";
                    } else if (tipoMedico > 0) {
                        tipoUsuario = "medico";
                    } else {
                        tipoUsuario = "indefinido";
                    }
                }//fim define tipo de usuario

                u.setTipoUsuario(tipoUsuario);


                return u;
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Usuario buscar(Usuario u) throws ErroDAO {
        return buscar(u.getIdPessoa());
    }

    @Override
    public Usuario buscar(String login) throws ErroDAO {
        String sql = "select \n" +
                "pessoa.id_pessoa,\n" +
                "pessoa.nome_completo,\n" +
                "pessoa.login,\n" +
                "pessoa.senha,\n" +
                "coalesce(paciente.pessoa_id_pessoa, 0) AS paciente_id_pessoa,\n" +
                "coalesce(medico.pessoa_id_pessoa, 0) AS medico_id_pessoa\n" +
                "from clinica_medica.pessoa \n" +
                "left join clinica_medica.medico \n" +
                "on clinica_medica.medico.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa \n" +
                "left join clinica_medica.paciente\n" +
                "on clinica_medica.paciente.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa\n" +
                "where clinica_medica.pessoa.login =?";
        int tipoPaciente, tipoMedico;
        String tipoUsuario;
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, login);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setIdPessoa(rs.getInt("id_pessoa"));
                u.setNome(rs.getString("nome_completo"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));

                {//define o tipo de usuario
                    tipoPaciente = rs.getInt("paciente_id_pessoa");
                    tipoMedico = rs.getInt("medico_id_pessoa");

                    if (tipoPaciente > 0) {
                        tipoUsuario = "paciente";
                    } else if (tipoMedico > 0) {
                        tipoUsuario = "medico";
                    } else {
                        tipoUsuario = "indefinido";
                    }
                }//fim define tipo de usuario

                u.setTipoUsuario(tipoUsuario);


                return u;
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    public Usuario buscar(String login, String senha) throws ErroDAO {
        String sql = "select \n" +
                "pessoa.id_pessoa,\n" +
                "pessoa.nome_completo,\n" +
                "pessoa.login,\n" +
                "pessoa.senha,\n" +
                "coalesce(paciente.pessoa_id_pessoa, 0) AS paciente_id_pessoa,\n" +
                "coalesce(medico.pessoa_id_pessoa, 0) AS medico_id_pessoa\n" +
                "from clinica_medica.pessoa \n" +
                "left join clinica_medica.medico \n" +
                "on clinica_medica.medico.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa \n" +
                "left join clinica_medica.paciente\n" +
                "on clinica_medica.paciente.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa\n" +
                "where clinica_medica.pessoa.login =? and clinica_medica.pessoa.senha =?";
        int tipoPaciente, tipoMedico;
        String tipoUsuario;
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setIdPessoa(rs.getInt("id_pessoa"));
                u.setNome(rs.getString("nome_completo"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));

                {//define o tipo de usuario
                    tipoPaciente = rs.getInt("paciente_id_pessoa");
                    tipoMedico = rs.getInt("medico_id_pessoa");

                    if (tipoPaciente > 0) {
                        tipoUsuario = "paciente";
                    } else if (tipoMedico > 0) {
                        tipoUsuario = "medico";
                    } else {
                        tipoUsuario = "indefinido";
                    }
                }//fim define tipo de usuario

                u.setTipoUsuario(tipoUsuario);


                return u;
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }


    @Override
    public void close() throws Exception {
        con.close();
    }

    /*
    public static void main(String[] args) {
        Usuario u = new Usuario();
        u.setLogin("pedro");

        try (UsuarioDaoClasse dao = new UsuarioDaoClasse()) {
            System.out.println(dao.buscar("pedro"));

        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    */
}
