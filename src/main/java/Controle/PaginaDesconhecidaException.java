package Controle;

public class PaginaDesconhecidaException extends Exception {

    public PaginaDesconhecidaException() {
    }

    public PaginaDesconhecidaException(String message) {
        super(message);
    }
}
