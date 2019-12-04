package Controle;

import DAO.UsuarioDAO;
import Modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Main.Main;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadUserController implements Initializable {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private CheckBox bancoLocal;

    @FXML
    private PasswordField txtPassword;

    public void goToUser(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("user");
    }

    @FXML
    private void concludeCadUser(ActionEvent actionEvent) throws PaginaDesconhecidaException {

        String email = txtEmail.getText();
        if (isValidEmailAddressRegex(email)) {
            String nome = txtNome.getText();
            String senha = txtPassword.getText();
            Boolean utilizaBancoLocal = bancoLocal.isSelected();
            Main.changeScreen("loading");
            Usuario user = new Usuario(nome, email, senha, utilizaBancoLocal);
            new UsuarioDAO().GravaUsuario(user);

            //implementar a comunicação com o firebase
            Main.changeScreen("user");
        } else{
            JOptionPane.showMessageDialog(null, "DIGITE UM EMAIL VALIDO!");
            txtEmail.setText("");
        }
    }

    public static boolean isValidEmailAddressRegex(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
