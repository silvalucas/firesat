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
}
