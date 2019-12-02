package Controle;

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
import javafx.scene.control.cell.TextFieldTableCell;
import Main.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditUserController implements Initializable {

    @FXML
    private TableView<Usuario> tableUser;
    private ObservableList<Usuario> lista;
    @FXML
    private TableColumn<Usuario, String> nome;
    @FXML
    private TableColumn<Usuario, String> email;

    public void goToUser(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("user");
    }

    @FXML
    private void concludeEditUser(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");

        ArrayList<Usuario> todos = new ArrayList<Usuario>(tableUser.getItems());

        UsuarioDAO dao = new UsuarioDAO();
        dao.GravaUsuarioArray(todos);

        Main.changeScreen("user");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(new UsuarioDAO().RecuperaUsuario());
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableUser.setItems(lista);
        nome.setCellFactory(TextFieldTableCell.forTableColumn());
        email.setCellFactory(TextFieldTableCell.forTableColumn());
        nome.setOnEditCommit(event -> {
            lista.get(event.getTablePosition().getRow()).setNome(event.getNewValue());
        });
        email.setOnEditCommit(event -> {
            lista.get(event.getTablePosition().getRow()).setEmail(event.getNewValue());
        });
    }
}
