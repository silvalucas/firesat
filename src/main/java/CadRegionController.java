import DAO.EsquadraoDAO;
import DAO.RegiaoDAO;
import Modelo.Esquadrao;
import Modelo.Regiao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CadRegionController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceSelectSquad;

    @FXML
    private CheckBox checkProtectYes;

    @FXML
    private TextField txtNome;

    private ObservableList<Esquadrao> listaSquad;

    public void goToRegion(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("region");
    }

    @FXML
    private void concludeCadRegion(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("loading");

        boolean areaprotecao = checkProtectYes.isSelected();
        String nome = txtNome.getText();
        String esquadrao = choiceSelectSquad.getSelectionModel().getSelectedItem();
        checkProtectYes.setSelected(false);
        txtNome.setText("");
        Esquadrao e = new Esquadrao();
        for(int i = 0; i < listaSquad.size();i++){
            if(esquadrao.equals(listaSquad.get(i).getNome())) e = listaSquad.get(i);
        }
        Regiao regiao = new Regiao();
        regiao.setEsquadrao(e);
        regiao.setAreaDeProtecao(areaprotecao);
        regiao.setNome(nome);
        new RegiaoDAO().GravaRegiao(regiao);

        Main.changeScreen("region");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaSquad = FXCollections.observableArrayList(new EsquadraoDAO().RecuperaEsquadrao());
        for(int i=0;i<listaSquad.size();i++){
            choiceSelectSquad.getItems().add(listaSquad.get(i).getNome());
        }
    }
}
