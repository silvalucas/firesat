import DAO.RegiaoDAO;
import Modelo.Esquadrao;
import Modelo.Regiao;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RemoveRegionController implements Initializable {

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
    private void removeRegion(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("loading");

        ArrayList<Regiao> todos = new RegiaoDAO().RecuperaRegiao();
        todos.remove(tableRegion.getSelectionModel().getSelectedIndex());
        new RegiaoDAO().GravaRegiaoArray(todos);

        Main.changeScreen("region");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Regiao> lista = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiao());
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        areaprotecao.setCellValueFactory(new PropertyValueFactory<>("areaDeProtecao"));
        esquadraoResponsavel.setCellValueFactory(new PropertyValueFactory<>("esquadrao"));
        tableRegion.setItems(lista);
    }
}
