package br.com.clinica.clinicamedica.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    public static Connection pegaConexao() throws ErroDAO{
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/clinica_medica", "postgres", "Pr0fessor");
        } catch (ClassNotFoundException | SQLException e) {
            throw new ErroDAO(e);
        }
    }
}



