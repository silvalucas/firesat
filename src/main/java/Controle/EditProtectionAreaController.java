package Controle;

import DAO.Conexao;
import DAO.RegiaoDAO;
import Main.Main;
import Modelo.Esquadrao;
import Modelo.ProtecaoAmbiental;
import Modelo.Regiao;
import Modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.scene.control.cell.TextFieldTableCell.forTableColumn;

public class EditProtectionAreaController implements Initializable {

    private ObservableList<ProtecaoAmbiental> lista;
    @FXML
    private TableView<ProtecaoAmbiental> tableRegion;
    @FXML
    private TableColumn<ProtecaoAmbiental, String> nome;
    @FXML
    private TableColumn<ProtecaoAmbiental, String> nomeLei;
    @FXML
    private TableColumn<ProtecaoAmbiental, Esquadrao> esquadraoResponsavel;

    public void goToRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("protectionArea");
    }

    @FXML
    private void concludeEditRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");

        ArrayList<ProtecaoAmbiental> todos = new ArrayList<>(tableRegion.getItems());
        RegiaoDAO dao = new RegiaoDAO();
        if (Usuario.utilizaBancoLocal)
            dao.AlteraRegiaoProtecao(todos);
        else
            dao.GravaRegiaoAreaProtecaoArray(todos);
        Main.changeScreen("protectionArea");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Usuario.utilizaBancoLocal)
            lista = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiaoProtecao(Conexao.getConnection()));
        else
            lista = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiaoProtecao(false));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        nomeLei.setCellValueFactory(new PropertyValueFactory<>("nomeLei"));
        esquadraoResponsavel.setCellValueFactory(new PropertyValueFactory<>("esquadrao"));
        tableRegion.setItems(lista);
        nome.setCellFactory(forTableColumn());
        nome.setOnEditCommit(event -> {
            lista.get(event.getTablePosition().getRow()).setNome(event.getNewValue());
        });
    }
}
