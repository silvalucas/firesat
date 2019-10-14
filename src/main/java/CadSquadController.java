import DAO.EsquadraoDAO;
import Modelo.Esquadrao;
import Modelo.Regiao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadSquadController implements Initializable {

    @FXML
    private TextField txtsoldado;

    @FXML
    private TextField txtnome;

    @FXML
    private TextField txtespecialidade;

    public void goToSquad(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("squad");
    }

    @FXML
    private void concludeCadSquad(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("loading");
        String nome = txtnome.getText();
        String especialidade = txtespecialidade.getText();
        txtnome.setText("");
        txtespecialidade.setText("");


        int quantSoldados = Integer.parseInt(txtsoldado.getText());
        txtsoldado.setText("");
        Esquadrao esquadrao = new Esquadrao(nome, especialidade, quantSoldados);
        EsquadraoDAO esquadraoDAO = new EsquadraoDAO();
        esquadraoDAO.GravaEsquadrao(esquadrao);
        Main.changeScreen("squad");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
