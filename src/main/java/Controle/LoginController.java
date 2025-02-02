package Controle;

import DAO.UsuarioDAO;
import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private RadioButton radioAnalise;

    @FXML
    private RadioButton radioSatelite;

    @FXML
    private Label errorMsg;

    public void btnEntrar(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        String user = txtUser.getText();
        String password = txtPassword.getText();
        txtPassword.setText("");
        txtUser.setText("");

        boolean usuario = new UsuarioDAO().AutenticaUsuario(user, password);

        boolean analise = radioAnalise.isSelected();
        boolean satelite = radioSatelite.isSelected();

        if (!analise && !satelite) {
            errorMsg.setText("SELECIONE UM DOS MODULOS!");
        } else if (satelite) {
            if (usuario) {
                Main.changeScreen("HomeSat");
                errorMsg.setText("");
            } else {
                errorMsg.setText("CAMPO USUARIO/SENHA INCORRETO.");
            }
        } else {
            if (usuario) {
                Main.changeScreen("home");
                errorMsg.setText("");
            } else {
                errorMsg.setText("CAMPO USUARIO/SENHA INCORRETO.");
            }
        }
    }

    public void limpaSatelite(javafx.event.ActionEvent actionEvent) {
        radioSatelite.setSelected(false);
    }

    public void limpaAnalise(javafx.event.ActionEvent actionEvent) {
        radioAnalise.setSelected(false);
    }
}
