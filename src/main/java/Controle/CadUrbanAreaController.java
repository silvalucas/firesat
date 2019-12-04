package Controle;

import DAO.Conexao;
import DAO.EsquadraoDAO;
import DAO.RegiaoDAO;
import Modelo.AreaUrbana;
import Modelo.Esquadrao;
import Modelo.Regiao;
import Modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import Main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CadUrbanAreaController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceSelectSquad;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField cidadePopulosa;

    private ObservableList<Esquadrao> listaSquad;

    public void goToRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("urbanArea");
    }

    @FXML
    private void concludeCadRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");

        String cidade = cidadePopulosa.getText();
        String nome = txtNome.getText();
        String esquadrao = choiceSelectSquad.getSelectionModel().getSelectedItem();
        cidadePopulosa.setText("");
        txtNome.setText("");
        Esquadrao e = new Esquadrao();
        for (int i = 0; i < listaSquad.size(); i++) {
            if (esquadrao.equals(listaSquad.get(i).getNome())) e = listaSquad.get(i);
        }
        AreaUrbana area = new AreaUrbana();
        area.setEsquadrao(e.getId());
        area.setCidadePopulosa(cidade);
        area.setNome(nome);
        if (Usuario.utilizaBancoLocal)
            new RegiaoDAO().GravaRegiao(area, Conexao.getConnection());
        else
            new RegiaoDAO().GravaRegiaoAreaUrbana(area);
        Main.changeScreen("urbanArea");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Esquadrao> listaAux;
        if ((listaAux = new EsquadraoDAO().RecuperaEsquadrao(Conexao.getConnection())) != null) {
            listaSquad = FXCollections.observableArrayList(listaAux);
        } else {
            listaSquad = FXCollections.observableArrayList();
        }

        for (Esquadrao esquadrao : listaSquad) {
            choiceSelectSquad.getItems().add(esquadrao.getNome());
        }
    }
}
