package Controle;

public class PaginaDesconhecidaException extends Exception {

    public PaginaDesconhecidaException() {  printStackTrace();
    }

    public PaginaDesconhecidaException(String message) {
        super(message);
        printStackTrace();

    }
}
