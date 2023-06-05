package br.com.clinica.clinicamedica.Persistencia;

import br.com.clinica.clinicamedica.Controle.ErroAcesso;
import br.com.clinica.clinicamedica.Modelo.Medico;
import br.com.clinica.clinicamedica.Modelo.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class MedicoDaoClasse implements MedicoDaoInterface, AutoCloseable {
    private final Connection con;

    public MedicoDaoClasse() throws ErroDAO {
        con = FabricaConexao.pegaConexao();
    }


    @Override
    public void inserir(Medico m, Usuario u) throws ErroDAO, ErroAcesso {
        if (u.getTipoUsuario().equals("medico")) {

            String sql = "INSERT INTO clinica_medica.pessoa(nome_completo, data_nascimento, " +
                    "sexo_biologico, nome_mae, naturalidade_municipio, naturalidade_estado, endereco_completo, login, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String sql1 = "INSERT INTO clinica_medica.medico(crm,especialidade, pessoa_id_pessoa)VALUES (?, ?, ?)";


            try (PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, m.getNome_completo());
                pstm.setDate(2, Date.valueOf(m.getData_nascimento()));
                pstm.setString(3, String.valueOf(m.getSexo_biologico()));
                pstm.setString(4, m.getNome_mae());
                pstm.setString(5, m.getNaturalidade_municipio());
                pstm.setString(6, m.getNaturalidade_estado());
                pstm.setString(7, m.getEndereco_completo());
                pstm.setString(8, m.getLogin());
                pstm.setString(9, m.getSenha());

                pstm.executeUpdate();
                ResultSet rs = pstm.getGeneratedKeys();
                if (rs.next()) {
                    m.setId_pessoa(rs.getInt(1));
                }
                if (m.getId_pessoa() > 0) {

                    try (PreparedStatement pstm1 = con.prepareStatement(sql1)) {
                        pstm1.setString(1, m.getCrm());
                        pstm1.setString(2, m.getEspecialidade());
                        pstm1.setInt(3, m.getId_pessoa());

                        pstm1.executeUpdate();
                    }
                }

            } catch (SQLException e) {
                throw new ErroDAO(e);
            }

        } else {
            throw new ErroAcesso("Acesso não autorizado");
        }

    }

    @Override
    public void editar(Medico m, Usuario u) throws ErroDAO, ErroAcesso {
        if (u.getTipoUsuario().equals("medico")) {

            String sql = "UPDATE clinica_medica.pessoa SET nome_completo=?, data_nascimento=?, " +
                    "sexo_biologico=?, nome_mae=?, naturalidade_municipio=?, naturalidade_estado=?, " +
                    "endereco_completo=?, senha=? where id_pessoa=?";

            String sql1 = "UPDATE clinica_medica.medico SET crm=?, especialidade=? where pessoa_id_pessoa=?";

            try (PreparedStatement pstm = con.prepareStatement(sql)) {
                pstm.setString(1, m.getNome_completo());
                pstm.setDate(2, Date.valueOf(m.getData_nascimento()));
                pstm.setString(3, String.valueOf(m.getSexo_biologico()));
                pstm.setString(4, m.getNome_mae());
                pstm.setString(5, m.getNaturalidade_municipio());
                pstm.setString(6, m.getNaturalidade_estado());
                pstm.setString(7, m.getEndereco_completo());
                pstm.setString(8, m.getSenha());
                pstm.setInt(9, m.getId_pessoa());
                pstm.executeUpdate();

                try (PreparedStatement pstm1 = con.prepareStatement(sql1)) {
                    pstm1.setString(1, m.getCrm());
                    pstm1.setString(2, m.getEspecialidade());
                    pstm1.setInt(3, m.getId_pessoa());
                    pstm1.executeUpdate();
                }
            } catch (SQLException e) {
                throw new ErroDAO(e);
            }

        } else {
            throw new ErroAcesso("Acesso não autorizado");
        }

    }

    @Override
    public Medico buscar(Medico m, Usuario u) throws ErroDAO, ErroAcesso {
        if (u.getTipoUsuario().equals("medico")) {
            return buscar(m.getId_pessoa(), u);
        } else {
            throw new ErroAcesso("Acesso não autorizado");
        }
    }

    @Override
    public Medico buscar(int codigo, Usuario u) throws ErroDAO, ErroAcesso {
        if (u.getTipoUsuario().equals("medico")) {

            String sql = "SELECT * FROM clinica_medica.pessoa inner join clinica_medica.medico on " +
                    "clinica_medica.medico.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa where pessoa_id_pessoa = ?";
            try (PreparedStatement pstm = con.prepareStatement(sql)) {
                pstm.setInt(1, codigo);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    Medico m = new Medico();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // formata uma string em data.
                    m.setId_pessoa(rs.getInt("id_pessoa"));
                    m.setNome_completo(rs.getString("nome_completo"));
                    m.setData_nascimento(LocalDate.parse((String.valueOf(rs.getDate("data_nascimento"))), formatter));
                    m.setSexo_biologico((rs.getString("sexo_biologico")).charAt(0));
                    m.setNome_mae(rs.getString("nome_mae"));
                    m.setNaturalidade_municipio(rs.getString("naturalidade_municipio"));
                    m.setNaturalidade_estado(rs.getString("naturalidade_estado"));
                    m.setEndereco_completo(rs.getString("endereco_completo"));
                    m.setLogin(rs.getString("login"));
                    m.setSenha(rs.getString("senha"));
                    m.setCrm(rs.getString("crm"));
                    m.setEspecialidade(rs.getString("especialidade"));
                    return m;
                }
                return null;
            } catch (SQLException e) {
                throw new ErroDAO(e);
            }
        } else {
            throw new ErroAcesso("Acesso não autorizado");
        }
    }

    @Override
    public List<Medico> listarMedicos(Usuario u) throws ErroDAO, ErroAcesso {
        if (u.getTipoUsuario().equals("medico")) {

            List<Medico> medicoList = new ArrayList<>();

            String sql = "SELECT * FROM clinica_medica.pessoa inner join clinica_medica.medico on clinica_medica.medico.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa";
            try (PreparedStatement pstm = con.prepareStatement(sql)) {
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    Medico m = new Medico();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // formata uma string em data.
                    m.setId_pessoa(rs.getInt("id_pessoa"));
                    m.setNome_completo(rs.getString("nome_completo"));
                    m.setData_nascimento(LocalDate.parse((String.valueOf(rs.getDate("data_nascimento"))), formatter));
                    m.setSexo_biologico((rs.getString("sexo_biologico")).charAt(0));
                    m.setNome_mae(rs.getString("nome_mae"));
                    m.setNaturalidade_municipio(rs.getString("naturalidade_municipio"));
                    m.setNaturalidade_estado(rs.getString("naturalidade_estado"));
                    m.setEndereco_completo(rs.getString("endereco_completo"));
                    m.setLogin(rs.getString("login"));
                    m.setSenha(rs.getString("senha"));
                    m.setCrm(rs.getString("crm"));
                    m.setEspecialidade(rs.getString("especialidade"));
                    medicoList.add(m);
                }
                return medicoList;
            } catch (SQLException e) {
                throw new ErroDAO(e);
            }
        } else {
            throw new ErroAcesso("Acesso não autorizado");
        }

    }

    @Override
    public List<Medico> buscarNome(String nome, Usuario u) throws ErroDAO, ErroAcesso {
        if (u.getTipoUsuario().equals("medico")) {
            List<Medico> medicoList = new ArrayList<>();
            String pesquisa = "%" + nome + "%";

            String sql = "SELECT * FROM clinica_medica.pessoa inner join clinica_medica.medico on " +
                    "clinica_medica.medico.pessoa_id_pessoa=clinica_medica.pessoa.id_pessoa where " +
                    "lower(clinica_medica.pessoa.nome_completo) like lower(?);";

            try (PreparedStatement pstm = con.prepareStatement(sql)) {
                pstm.setString(1, pesquisa);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    Medico m = new Medico();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // formata uma string em data.
                    m.setId_pessoa(rs.getInt("id_pessoa"));
                    m.setNome_completo(rs.getString("nome_completo"));
                    m.setData_nascimento(LocalDate.parse((String.valueOf(rs.getDate("data_nascimento"))), formatter));
                    m.setSexo_biologico((rs.getString("sexo_biologico")).charAt(0));
                    m.setNome_mae(rs.getString("nome_mae"));
                    m.setNaturalidade_municipio(rs.getString("naturalidade_municipio"));
                    m.setNaturalidade_estado(rs.getString("naturalidade_estado"));
                    m.setEndereco_completo(rs.getString("endereco_completo"));
                    m.setLogin(rs.getString("login"));
                    m.setSenha(rs.getString("senha"));
                    m.setCrm(rs.getString("crm"));
                    m.setEspecialidade(rs.getString("especialidade"));
                    medicoList.add(m);
                }
                return medicoList;
            } catch (SQLException e) {
                throw new ErroDAO(e);
            }

        } else {
            throw new ErroAcesso("Acesso não autorizado");
        }
    }

    @Override
    public void close() throws Exception {
        con.close();
    }

    /*
    public static void main(String[] args) {
        Medico m = new Medico();
        m.setId_pessoa(1);
        m.setNome_completo("Renato Couto");
        m.setData_nascimento(LocalDate.of(1980, 8, 13));
        m.setSexo_biologico('M');
        m.setNome_mae("Amalia");
        m.setNaturalidade_municipio("Uruaçú");
        m.setNaturalidade_estado("GO");
        m.setEndereco_completo("106 Norte, Palmas TO");
        m.setLogin("renato");
        m.setSenha("123");
        m.setCrm("15 CRM-TO");
        m.setEspecialidade("Clinica Geral");

        try (MedicoDaoClasse dao = new MedicoDaoClasse()) {
            //System.out.println((dao.buscar(m)).toString());
            System.out.println(dao.buscarNome("renato").toString());

        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    */

}
