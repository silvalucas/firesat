package Controle;

import Main.Main;

public class ChoiceRegionController {
    public void goToHome(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("home");
    }

    public void goToUrbanArea(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("urbanArea");
    }

    public void goToProtectionArea(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("protectionArea");
    }
}
