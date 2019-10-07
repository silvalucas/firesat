public class UserController {
    public void goToHome(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("home");
    }
    public void goToEditUser(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("editUser");
    }
    public void goToListUser(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("listUser");
    }
    public void goToRemoveUser(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("removeUser");
    }
    public void goToCadUser(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("cadUser");
    }
}
