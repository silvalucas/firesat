package Controle;

import DAO.EsquadraoDAO;
import Main.Main;
import Modelo.Esquadrao;
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
    private TextField nomelei;

    private ObservableList<Esquadrao> listaSquad;

    public void goToRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("protectionArea");
    }

    @FXML
    private void concludeCadRegion(ActionEvent actionEvent) {
        /*Main.changeScreen("loading");

        boolean areaprotecao = checkProtectYes.isSelected();
        String nome = txtNome.getText();
        String esquadrao = choiceSelectSquad.getSelectionModel().getSelectedItem();
        checkProtectYes.setSelected(false);
        txtNome.setText("");
        Esquadrao e = new Esquadrao();
        for (int i = 0; i < listaSquad.size(); i++) {
            if (esquadrao.equals(listaSquad.get(i).getNome())) e = listaSquad.get(i);
        }
        Regiao regiao = new Regiao();
        regiao.setEsquadrao(e.getId());
        regiao.setAreaDeProtecao(areaprotecao);
        regiao.setNome(nome);
        new RegiaoDAO().GravaRegiao(regiao);

        Main.changeScreen("region");*/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*ArrayList<Esquadrao> listaAux;
        if ((listaAux = new EsquadraoDAO().RecuperaEsquadrao(false)) != null) {
            listaSquad = FXCollections.observableArrayList(listaAux);
        } else {
            listaSquad = FXCollections.observableArrayList();
        }

        for (Esquadrao esquadrao : listaSquad) {
            choiceSelectSquad.getItems().add(esquadrao.getNome());
        }*/
    }
}
