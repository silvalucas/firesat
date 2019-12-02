package Controle;

import java.io.IOException;
import Main.Main;

public class HomeSatController {

    public void goToLogin(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");
        Main.changeScreen("login");
    }

    public void makeImage(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");
        Main.changeScreen("MakeImage");
    }

    public void requestDataBtn(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");

        //Buscar dados de esquadrões e regiões e armazena localmente

        Main.changeScreen("HomeSat");
    }

    public void reportsBtn(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");

        Main.changeScreen("ReportsSat");
    }
}
