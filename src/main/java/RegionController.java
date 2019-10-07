public class RegionController {
    public void goToHome(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("home");
    }

    public void goToCadRegion(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("cadRegion");
    }

    public void goToListRegion(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("listRegion");
    }

    public void goToEditRegion(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("editRegion");
    }

    public void goToRemoveRegion(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("removeRegion");
    }
}
