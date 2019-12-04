package Controle;

import DAO.Conexao;
import Main.Main;
import DAO.RegiaoDAO;
import Modelo.*;
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

public class ListProtectionAreaController implements Initializable {

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<ProtecaoAmbiental> lista;
        if (Usuario.utilizaBancoLocal) {
            lista = FXCollections.observableArrayList(
                    new RegiaoDAO().RecuperaRegiaoProtecao(Conexao.getConnection()));
        } else {
            lista = FXCollections.observableArrayList(
                    new RegiaoDAO().RecuperaRegiaoProtecao(false));
        }
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        nomeLei.setCellValueFactory(new PropertyValueFactory<>("nomeLei"));
        esquadraoResponsavel.setCellValueFactory(new PropertyValueFactory<>("esquadrao"));
        tableRegion.setItems(lista);
    }
}
