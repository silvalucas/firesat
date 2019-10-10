import DAO.RegiaoDAO;
import Modelo.DadosImagem;
import Modelo.Regiao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportsController implements Initializable {

    @FXML
    private TableView<DadosImagem> reportsTable;

    @FXML
    private ComboBox<String> comboRegiao;

    @FXML
    private TextField dateInicial;

    @FXML
    private Label statusAnalise;
    private ObservableList<Regiao> listaRegiao;

    @FXML
    private TextField dateFinal;

    @FXML
    private Label errorTxt;

    public void goToHome(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("home");
    }

    public void analisar(javafx.event.ActionEvent actionEvent){
        //Pega os trem q ele digitou na tela
        String dtIni = dateInicial.getText();
        String dtFin = dateFinal.getText();
        String reg = comboRegiao.getSelectionModel().getSelectedItem();
        System.out.println(dtIni +" " + dtFin + " " + reg);

        if(dtIni.equals("") || dtFin.equals("") || reg == null){
            errorTxt.setText("FAVOR PREENCHER TODOS OS CAMPOS!");
            return;
        } else{
            //continua o breguenait
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaRegiao = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiao());
        for (int i = 0; i < listaRegiao.size(); i++) {
            comboRegiao.getItems().add(listaRegiao.get(i).getNome());
        }
    }
}
