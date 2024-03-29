package br.com.clinica.conclusao.Persistencia;

public class ErroDAO extends Exception{
    public ErroDAO() {
        super("Erro DAO");
    }

    public ErroDAO(String message) {
        super("Erro DAO: "+message);
    }

    public ErroDAO(String message, Throwable cause) {
        super(message, cause);
    }

    public ErroDAO(Throwable cause) {
        super("Erro DAO: "+cause);
    }

    protected ErroDAO(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
