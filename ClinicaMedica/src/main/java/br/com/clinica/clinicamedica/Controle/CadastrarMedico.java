package br.com.clinica.clinicamedica.Controle;

import br.com.clinica.clinicamedica.Modelo.Medico;
import br.com.clinica.clinicamedica.Modelo.Usuario;
import br.com.clinica.clinicamedica.Persistencia.ErroDAO;
import br.com.clinica.clinicamedica.Persistencia.MedicoDaoClasse;
import br.com.clinica.clinicamedica.Util.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/cadastrarmedico")
public class CadastrarMedico extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        Usuario u = new Usuario();

        u = (Usuario) session.getAttribute("usuario");

        String nome_completo = request.getParameter("nome");
        String data_nascimento = request.getParameter("dataNascimento");
        String sexo_biologico = request.getParameter("sexoBiologico");
        String nome_mae = request.getParameter("nomeMae");
        String naturalidade_municipio = request.getParameter("naturalidadeMunicipio");
        String naturalidade_estado = request.getParameter("naturalidadeEstado");
        String endereco_completo = request.getParameter("endereco");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String crm = request.getParameter("crm");
        String especialidade = request.getParameter("especialidade");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // formata uma string em data.

        /*
        System.out.println("nome "+nome_completo);
        System.out.println("nascimento"+data_nascimento);
        System.out.println("sexo "+sexo_biologico);
        System.out.println("mae"+ nome_mae);
        System.out.println("municipio "+naturalidade_municipio);
        System.out.println("estado"+naturalidade_estado);
        System.out.println("End "+endereco_completo);
        System.out.println("Login "+login);
        System.out.println("Senha "+senha);
        System.out.println("CRM "+crm);
        System.out.println("Esp "+especialidade);
         */

        if (Validador.osDadosNaoSaoVazios(new String[]{nome_completo, data_nascimento, sexo_biologico, nome_mae, naturalidade_municipio, naturalidade_estado,
                endereco_completo, login, senha, crm, especialidade})) {
            var m = new Medico();

            m.setNome_completo(nome_completo);
            m.setData_nascimento(LocalDate.parse((String.valueOf(data_nascimento)), formatter));
            m.setSexo_biologico((sexo_biologico).charAt(0));
            m.setNome_mae(nome_mae);
            m.setNaturalidade_municipio(naturalidade_municipio);
            m.setNaturalidade_estado(naturalidade_estado);
            m.setEndereco_completo(endereco_completo);
            m.setLogin(login);
            m.setSenha(senha);
            m.setCrm(crm);
            m.setEspecialidade(especialidade);

            try (MedicoDaoClasse dao = new MedicoDaoClasse()) {
                //System.out.println(m.toString());
                dao.inserir(m, u);

                response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Cadastrado com sucesso"));
            } catch (ErroDAO e) {
                response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Erro ao tentar cadastrar"));
            } catch (ErroAcesso e) {
                response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Erro Usuario sem Acesso!"));
            } catch (Exception e) {
                response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Erro ao tentar fechar a conexao"));
            }
            //melhorar este código permitindo que o usuário atualmente cadastrado seja logado automaticamente.
        } else {

            response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Está faltando dados"));
        }
    }
}
