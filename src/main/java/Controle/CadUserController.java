package Controle;

import DAO.UsuarioDAO;
import Modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadUserController implements Initializable {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    public void goToUser(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("user");
    }

    @FXML
    private void concludeCadUser(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("loading");

        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String senha = txtPassword.getText();
        Usuario user = new Usuario(nome,email,senha);
        new UsuarioDAO().GravaUsuario(user);

        //implementar a comunicação com o firebase
        Main.changeScreen("user");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
