package br.com.clinica.clinicamedica.Controle;

import br.com.clinica.clinicamedica.Modelo.Usuario;
import br.com.clinica.clinicamedica.Persistencia.ErroDAO;
import br.com.clinica.clinicamedica.Persistencia.UsuarioDaoClasse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/logar")
public class Logar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login=request.getParameter("inputUsuario");
        String senha=request.getParameter("inputSenha");
        HttpSession sessao=request.getSession();
        if(sessao.getAttribute("usuario")==null)
        {
            if (login != null && senha != null &&
                    login.length() > 0 && senha.length() > 0) {
                Usuario u;
                try (UsuarioDaoClasse dao = new UsuarioDaoClasse()) {
                    u = dao.buscar(login, senha);
                    if (u != null) {
                        sessao.setAttribute("usuario", u);
                        response.sendRedirect("index.jsp");
                    } else {
                        response.sendRedirect("login.jsp?mensagem=" + URLEncoder.encode("Login ou senha incorretos"));
                    }
                } catch (ErroDAO e) {
                    response.sendRedirect("login.jsp?mensagem=" + URLEncoder.encode("Erro ao tentar logar"));
                } catch (Exception e) {
                    response.sendRedirect("login.jsp?mensagem=" + URLEncoder.encode("Erro ao tentar fechar a conexão"));
                }
            } else {

                response.sendRedirect("login.jsp?mensagem=" + URLEncoder.encode("Está faltando dados"));
            }
        }else
        {
            response.sendRedirect("login.jsp?mensagem=" + URLEncoder.encode("Você precisa sair da sua conta antes de tentar logar com outro usuário"));
        }
    }
}
