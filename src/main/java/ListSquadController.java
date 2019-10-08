import DAO.EsquadraoDAO;
import Modelo.Esquadrao;
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

public class ListSquadController implements Initializable {

    @FXML
    private TableView<Esquadrao> tableSquad;
    @FXML
    private TableColumn<Esquadrao, String> nome;
    @FXML
    private TableColumn<Esquadrao, String> especialidade;
    @FXML
    private TableColumn<Esquadrao, Integer> qtdSoldados;


    public void goToSquad(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("squad");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Esquadrao> lista = FXCollections.observableArrayList(new EsquadraoDAO().RecuperaEsquadrao());
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        especialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
        qtdSoldados.setCellValueFactory(new PropertyValueFactory<>("qtdSoldados"));
        tableSquad.setItems(lista);

    }
}
