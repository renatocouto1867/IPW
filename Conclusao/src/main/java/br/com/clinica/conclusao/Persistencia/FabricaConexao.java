package br.com.clinica.conclusao.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    public static Connection pegaConexao() throws ErroDAO{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/clinica_medica?useSSL=false","root","Pr0fessor");
        } catch (ClassNotFoundException | SQLException e) {
            throw new ErroDAO(e);
        }
    }
}



