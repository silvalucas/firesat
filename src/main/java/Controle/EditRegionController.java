package Controle;

import DAO.RegiaoDAO;
import Modelo.Esquadrao;
import Modelo.Regiao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Main.Main;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.scene.control.cell.TextFieldTableCell.forTableColumn;

public class EditRegionController implements Initializable {

    private ObservableList<Regiao> lista;
    @FXML
    private TableView<Regiao> tableRegion;
    @FXML
    private TableColumn<Regiao, String> nome;
    @FXML
    private TableColumn<Regiao, Boolean> areaprotecao;
    @FXML
    private TableColumn<Regiao, Esquadrao> esquadraoResponsavel;

    public void goToRegion(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("region");
    }

    @FXML
    private void concludeEditRegion(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("loading");

        ArrayList<Regiao> todos = new ArrayList<Regiao>(tableRegion.getItems());

        RegiaoDAO dao = new RegiaoDAO();
        dao.GravaRegiaoArray(todos);

        Main.changeScreen("region");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiao());
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        areaprotecao.setCellValueFactory(new PropertyValueFactory<>("areaDeProtecao"));
        esquadraoResponsavel.setCellValueFactory(new PropertyValueFactory<>("esquadrao"));
        tableRegion.setItems(lista);
        nome.setCellFactory(forTableColumn());
        areaprotecao.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        nome.setOnEditCommit(event -> {
            lista.get(event.getTablePosition().getRow()).setNome(event.getNewValue());
        });
        areaprotecao.setOnEditCommit(event -> {
            lista.get(event.getTablePosition().getRow()).setAreaDeProtecao(event.getNewValue());
        });
    }
}
