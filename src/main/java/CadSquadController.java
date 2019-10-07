import DAO.EsquadraoDAO;
import Modelo.Esquadrao;
import Modelo.Regiao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadSquadController implements Initializable {

    @FXML
    private TextField txtsoldado;

    @FXML
    private TextField txtnome;

    @FXML
    private TextField txtespecialidade;

    public void goToSquad(ActionEvent actionEvent) {
        Main.changeScreen("squad");
    }

    @FXML
    private void concludeCadSquad(javafx.event.ActionEvent actionEvent) {
        Main.changeScreen("loading");
        String nome = txtnome.getText();
        System.out.println(nome);
        String especialidade = txtespecialidade.getText();
        System.out.println(especialidade);

        int quantSoldados = Integer.parseInt(txtsoldado.getText());
        System.out.println(quantSoldados);
        Esquadrao esquadrao = new Esquadrao(nome, especialidade, quantSoldados);
        EsquadraoDAO esquadraoDAO = new EsquadraoDAO();
        esquadraoDAO.GravaEsquadrao(esquadrao);
        Main.changeScreen("squad");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
