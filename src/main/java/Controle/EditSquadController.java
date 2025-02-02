package Controle;

import DAO.Conexao;
import DAO.EsquadraoDAO;
import Modelo.Esquadrao;
import Modelo.Usuario;
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
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.scene.control.cell.TextFieldTableCell.*;

public class EditSquadController implements Initializable {
    private ObservableList<Esquadrao> lista;
    @FXML
    private TableView<Esquadrao> tableSquad;
    @FXML
    private TableColumn<Esquadrao, String> nome;
    @FXML
    private TableColumn<Esquadrao, String> especialidade;
    @FXML
    private TableColumn<Esquadrao, Integer> qtdSoldados;

    public void goToSquad(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("squad");
    }

    @FXML
    private void concludeEditSquad(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");

        ArrayList<Esquadrao> todos = new ArrayList<>(tableSquad.getItems());

        EsquadraoDAO dao = new EsquadraoDAO();

        if (Usuario.utilizaBancoLocal)
            dao.AlteraEsquadrao(todos);
        else
            dao.GravaEsquadraoArray(todos);
        Main.changeScreen("squad");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Usuario.utilizaBancoLocal)
            lista = FXCollections.observableArrayList(new EsquadraoDAO().RecuperaEsquadrao(Conexao.getConnection()));
        else
            lista = FXCollections.observableArrayList(new EsquadraoDAO().RecuperaEsquadrao(false));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        especialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
        qtdSoldados.setCellValueFactory(new PropertyValueFactory<>("qtdSoldados"));
        tableSquad.setItems(lista);
        nome.setCellFactory(forTableColumn());
        especialidade.setCellFactory(forTableColumn());
        qtdSoldados.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        nome.setOnEditCommit(event -> {
            lista.get(event.getTablePosition().getRow()).setNome(event.getNewValue());
        });
        especialidade.setOnEditCommit(event -> {
            lista.get(event.getTablePosition().getRow()).setEspecialidade(event.getNewValue());
        });
        qtdSoldados.setOnEditCommit(event -> {
            lista.get(event.getTablePosition().getRow()).setQtdSoldados(event.getNewValue());
        });
    }
}
