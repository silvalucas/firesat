package Controle;

import DAO.Conexao;
import DAO.EsquadraoDAO;
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

public class RemoveProtectionAreaController implements Initializable {

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
    private void removeRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");


        if (Usuario.utilizaBancoLocal) {
            ProtecaoAmbiental selecionado = tableRegion.getSelectionModel().getSelectedItem();
            ArrayList<ProtecaoAmbiental> todos = new RegiaoDAO().RecuperaRegiaoProtecao(Conexao.getConnection());

            for (int i = 0; i < todos.size(); i++) {
                ProtecaoAmbiental e = todos.get(i);
                if (e.getId() == (selecionado.getId())) {
                    new RegiaoDAO().DeletaRegiao(e.getId());
                    break;
                }
            }
        } else {
            ArrayList<ProtecaoAmbiental> todos = new RegiaoDAO().RecuperaRegiaoProtecao(true);
            todos.remove(tableRegion.getSelectionModel().getSelectedIndex());
            new RegiaoDAO().GravaRegiaoAreaProtecaoArray(todos);
        }
        Main.changeScreen("protectionArea");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<ProtecaoAmbiental> lista;
        if (Usuario.utilizaBancoLocal)
            lista = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiaoProtecao(Conexao.getConnection()));
        else
            lista = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiaoProtecao(false));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        nomeLei.setCellValueFactory(new PropertyValueFactory<>("nomeLei"));
        esquadraoResponsavel.setCellValueFactory(new PropertyValueFactory<>("esquadrao"));
        tableRegion.setItems(lista);
    }
}
