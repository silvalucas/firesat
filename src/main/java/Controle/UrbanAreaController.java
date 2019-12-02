package Controle;

import Main.Main;

public class UrbanAreaController {
    public void goToChoice(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("choiceRegion");
    }

    public void goToCadRegion(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("cadRegionUrban");
    }

    public void goToListRegion(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("listRegionUrban");
    }

    public void goToEditRegion(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("editRegionUrban");
    }

    public void goToRemoveRegion(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("removeRegionUrban");
    }
}
