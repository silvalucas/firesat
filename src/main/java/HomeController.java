import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HomeController {

    public void goToSquad(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("squad");
    }

    public void goToRegion(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("region");
    }

    public void goToUser(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("user");
    }

    public void goToLogin(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("login");
    }

    public void requestInfoBtn(javafx.event.ActionEvent actionEvent) {
        //solicitar informações do firebase e inserir
    }

    public void sendDataBtn(javafx.event.ActionEvent actionEvent) {
        //Enviar dados de esquadrões, regiões e usuários para o firebase
    }

    public void reportsBtn(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("reports");
    }
}
