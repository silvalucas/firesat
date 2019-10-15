package Controle;

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
import Main.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RemoveSquadController implements Initializable {

    private ObservableList<Esquadrao> lista;
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
    private void removeSquad(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("loading");

        Esquadrao selecionado = tableSquad.getSelectionModel().getSelectedItem();
        ArrayList<Esquadrao> todos = new EsquadraoDAO().RecuperaEsquadrao(true);

        for(int i = 0; i < todos.size();i++){
            Esquadrao e = todos.get(i);
            if(e.getNome().equals(selecionado.getNome())){
                todos.remove(i);
                break;
            }
        }

        new EsquadraoDAO().GravaEsquadraoArray(todos);

        //implementar a remoção da linha selecionada na tableview

        Main.changeScreen("squad");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(new EsquadraoDAO().RecuperaEsquadrao(true));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        especialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
        qtdSoldados.setCellValueFactory(new PropertyValueFactory<>("qtdSoldados"));
        tableSquad.setItems(lista);
    }
}
