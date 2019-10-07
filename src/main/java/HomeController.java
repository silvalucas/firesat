import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HomeController {

    public void goToSquad(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("squad");
    }
    public void goToRegion(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("region");
    }
    public void goToUser(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("user");
    }
    public void goToLogin(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("login");
    }
}
