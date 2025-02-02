package Controle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import Main.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SquadController implements Initializable {

    public void goToHome(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("home");
    }

    public void goToCadSquad(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("cadSquad");
    }

    public void goToEditSquad(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("editSquad");
    }

    public void goToListSquad(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("listSquad");
    }

    public void goToRemoveSquad(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("removeSquad");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
