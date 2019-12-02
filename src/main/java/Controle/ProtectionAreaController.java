package Controle;

import Main.Main;

public class ProtectionAreaController {
    public void goToChoice(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("choiceRegion");
    }

    public void goToCadRegion(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("cadRegionProtection");
    }

    public void goToListRegion(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("listRegionProtection");
    }

    public void goToEditRegion(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("editRegionProtection");
    }

    public void goToRemoveRegion(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("removeRegionProtection");
    }
}
