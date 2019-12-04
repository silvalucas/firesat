package Controle;

import DAO.Conexao;
import DAO.EsquadraoDAO;
import DAO.RegiaoDAO;
import Main.Main;
import Modelo.Esquadrao;
import Modelo.ProtecaoAmbiental;
import Modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CadProtectionAreaController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceSelectSquad;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField nomeLei;

    private ObservableList<Esquadrao> listaSquad;

    public void goToRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("protectionArea");
    }

    @FXML
    private void concludeCadRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");

        String lei = nomeLei.getText();
        String nome = txtNome.getText();
        String esquadrao = choiceSelectSquad.getSelectionModel().getSelectedItem();
        nomeLei.setText("");
        txtNome.setText("");
        Esquadrao e = new Esquadrao();
        for (int i = 0; i < listaSquad.size(); i++) {
            if (esquadrao.equals(listaSquad.get(i).getNome())) e = listaSquad.get(i);
        }
        ProtecaoAmbiental area = new ProtecaoAmbiental();
        area.setEsquadrao(e.getId());
        area.setNomeLei(lei);
        area.setNome(nome);
        if (Usuario.utilizaBancoLocal)
            new RegiaoDAO().GravaRegiao(area, Conexao.getConnection());
        else
            new RegiaoDAO().GravaRegiaoProtecao(area);
        Main.changeScreen("protectionArea");
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
