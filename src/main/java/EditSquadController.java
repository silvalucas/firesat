import DAO.EsquadraoDAO;
import Modelo.Esquadrao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.scene.control.cell.TextFieldTableCell.*;

public class EditSquadController implements Initializable {

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

    @FXML
    private void concludeEditSquad(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("loading");

        ArrayList<Esquadrao> todos = new ArrayList<Esquadrao>();

        for(int i = 0; i < tableSquad.getItems().size();i++){
            Esquadrao e = tableSquad.getItems().get(i);
            System.out.println(i + "-" + e);
            todos.add(e);
        }

        for (int i = 0; i<todos.size();i++){
            System.out.println("\\" + todos.get(i));
        }

        Main.changeScreen("squad");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Esquadrao> lista = FXCollections.observableArrayList(new EsquadraoDAO().RecuperaEsquadrao());
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        especialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
        qtdSoldados.setCellValueFactory(new PropertyValueFactory<>("qtdSoldados"));
        tableSquad.setItems(lista);
        nome.setCellFactory(forTableColumn());
        especialidade.setCellFactory(forTableColumn());
        qtdSoldados.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }
}
