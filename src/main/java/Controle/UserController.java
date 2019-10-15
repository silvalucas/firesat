package Controle;

import java.io.IOException;
import Main.Main;

public class UserController {
    public void goToHome(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("home");
    }
    public void goToEditUser(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("editUser");
    }
    public void goToListUser(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("listUser");
    }
    public void goToRemoveUser(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("removeUser");
    }
    public void goToCadUser(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("cadUser");
    }
}
