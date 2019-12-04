package Controle;

import DAO.Conexao;
import DAO.RegiaoDAO;
import Modelo.AreaUrbana;
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

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.scene.control.cell.TextFieldTableCell.forTableColumn;

public class EditUrbanAreaController implements Initializable {

    private ObservableList<AreaUrbana> lista;
    @FXML
    private TableView<AreaUrbana> tableRegion;
    @FXML
    private TableColumn<AreaUrbana, String> nome;
    @FXML
    private TableColumn<AreaUrbana, String> cidadePopulosa;
    @FXML
    private TableColumn<AreaUrbana, Esquadrao> esquadraoResponsavel;

    public void goToRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("urbanArea");
    }

    @FXML
    private void concludeEditRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");

        ArrayList<AreaUrbana> todos = new ArrayList<>(tableRegion.getItems());

        RegiaoDAO dao = new RegiaoDAO();
        if (Usuario.utilizaBancoLocal)
            dao.AlteraRegiaoUrbana(todos);
        else
            dao.GravaRegiaoUrbanaArray(todos);
        Main.changeScreen("urbanArea");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiaoUrbana(Conexao.getConnection()));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cidadePopulosa.setCellValueFactory(new PropertyValueFactory<>("cidadePopulosa"));
        esquadraoResponsavel.setCellValueFactory(new PropertyValueFactory<>("esquadrao"));
        tableRegion.setItems(lista);
        nome.setCellFactory(forTableColumn());
        nome.setOnEditCommit(event -> {
            lista.get(event.getTablePosition().getRow()).setNome(event.getNewValue());
        });
    }
}
