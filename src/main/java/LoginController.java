import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    public void btnEntrar(javafx.event.ActionEvent actionEvent) throws IOException {
        String user = txtUser.getText();
        String password = txtPassword.getText();
        txtPassword.setText("");
        txtUser.setText("");
        //verificar usuário e senha
        Main.changeScreen("home");
    }

}
