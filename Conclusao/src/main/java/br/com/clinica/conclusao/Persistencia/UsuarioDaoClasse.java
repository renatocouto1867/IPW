package br.com.clinica.conclusao.Persistencia;

import br.com.clinica.conclusao.Modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDaoClasse implements UsuarioDaoInterface, AutoCloseable {
    private final Connection con;

    public UsuarioDaoClasse() throws ErroDAO {
        con = FabricaConexao.pegaConexao();
    }

    @Override
    public void inserir(Usuario u) throws ErroDAO {
        String sql = "insert into usuario(pessoa, login, senha, tipo) values(?,?,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstm.setInt(1, u.getIdUsuario());
            pstm.setString(2, u.getLogin());
            pstm.setString(3, u.getSenha());
            pstm.setString(4, u.getTipoUsuario());

            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                u.setIdUsuario(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }//inserir

    @Override
    public void deletar(Usuario u) throws ErroDAO {
        String sql = "DELETE FROM usuario WHERE id_usuario=?;";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, u.getIdUsuario());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void deletar(int codigo) throws ErroDAO {
        String sql = "DELETE FROM usuario WHERE id_usuario=?;";

        try (PreparedStatement pstm1 = con.prepareStatement(sql)) {
            pstm1.setInt(1, codigo);
            pstm1.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }//deletarUsuarioId


    @Override
    public void editar(Usuario u) throws ErroDAO {
        String sql = "update usuario set login =?, senha = ? where tipo_usuario=?;";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, u.getLogin());
            pstm.setString(2, u.getSenha());
            pstm.setString(3, u.getTipoUsuario());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }//editar

    @Override
    public Usuario buscar(int codigo) throws ErroDAO {
        String sql = "select * from usuario where id_usuario=?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setIdUsuario(rs.getInt("id_pessoa"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setTipoUsuario(rs.getString("tipo_usuario"));
                return u;
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }//buscar

    @Override
    public Usuario buscar(Usuario u) throws ErroDAO {
        return buscar(u.getIdUsuario());
    }

    @Override
    public Usuario buscar(String login, String senha) throws ErroDAO {
        String sql = "select * from usuario where login=? and senha=?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setIdUsuario(rs.getInt("id_pessoa"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setTipoUsuario(rs.getString("tipo_usuario"));
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
        u.setSenha("abc");
        try (UsuarioDaoClasse dao = new UsuarioDaoClasse()) {
            System.out.println(dao.buscar("jose", "123"));

        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }*/
}
