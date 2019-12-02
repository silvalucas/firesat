package Controle;

import java.io.IOException;
import Main.Main;

public class UserController {
    public void goToHome(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("home");
    }
    public void goToEditUser(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("editUser");
    }
    public void goToListUser(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("listUser");
    }
    public void goToRemoveUser(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("removeUser");
    }
    public void goToCadUser(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("cadUser");
    }
}
