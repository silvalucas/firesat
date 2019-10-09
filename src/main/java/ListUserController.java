import DAO.UsuarioDAO;
import Modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListUserController implements Initializable {

    @FXML
    private TableView<Usuario> tableUser;
    @FXML
    private TableColumn<Usuario, String> nome;
    @FXML
    private TableColumn<Usuario, String> email;

    public void goToUser(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("user");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Usuario> lista = FXCollections.observableArrayList(new UsuarioDAO().RecuperaUsuario());
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableUser.setItems(lista);
    }
}
