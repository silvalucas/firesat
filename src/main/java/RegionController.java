import java.io.IOException;

public class RegionController {
    public void goToHome(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("home");
    }

    public void goToCadRegion(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("cadRegion");
    }

    public void goToListRegion(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("listRegion");
    }

    public void goToEditRegion(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("editRegion");
    }

    public void goToRemoveRegion(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("removeRegion");
    }
}
