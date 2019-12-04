package Controle;

import DAO.Conexao;
import DAO.DadosImagemDAO;
import DAO.RegiaoDAO;
import Modelo.DadosImagem;
import Modelo.Regiao;
import Modelo.Usuario;
import com.google.api.client.http.javanet.ConnectionFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import Main.Main;

import static Controle.ImagemControle.retornaAumento;
import static Util.UtilDate.localdateToDate;

public class ReportsController implements Initializable {

    @FXML
    private TableView<DadosImagem> reportsTable;

    @FXML
    private TableColumn<DadosImagem, Integer> id;

    @FXML
    private TableColumn<DadosImagem, Date> data;

    @FXML
    private TableColumn<DadosImagem, String> nome;

    @FXML
    private TableColumn<DadosImagem, Float> percentual;

    @FXML
    private ComboBox<String> comboRegiao;

    @FXML
    private DatePicker dateInicial;


    private ObservableList<Regiao> listaRegiao;

    @FXML
    private DatePicker dateFinal;

    @FXML
    private Label errorTxt;

    @FXML
    private Label statusTxt;


    public void goToHome(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("home");
    }

    public void analisar(javafx.event.ActionEvent actionEvent) {
        //Pega o que digitou na tela
        Date dtIni = localdateToDate(dateInicial.getValue());
        Date dtFin = localdateToDate(dateFinal.getValue());
        String reg = comboRegiao.getSelectionModel().getSelectedItem();
        int idRegiao = comboRegiao.getSelectionModel().getSelectedIndex();
        if (dtIni.equals("") || dtFin.equals("") || reg == null) {
            errorTxt.setText("FAVOR PREENCHER TODOS OS CAMPOS!");
            return;
        } else {
            DadosImagemDAO img = new DadosImagemDAO();
            ArrayList<DadosImagem> dados = img.imagensEntreDatas(dtIni, dtFin, listaRegiao.get(idRegiao).getId());
            String txt = "";
            if (dados.size() > 0)
                txt = retornaAumento(dados.get(dados.size() - 1).getPercentual(), dados.get(0).getPercentual());
            ObservableList<DadosImagem> lista = FXCollections.observableArrayList(dados);
            reportsTable.setItems(lista);
            statusTxt.setText(txt);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        percentual.setCellValueFactory(new PropertyValueFactory<>("percentual"));
        Connection con = Conexao.getConnection();
        if (Usuario.utilizaBancoLocal) {
            listaRegiao = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiaoProtecao(con));
            listaRegiao.addAll(FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiaoUrbana(con)));
        } else {
            listaRegiao = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiaoProtecao(false));
            listaRegiao.addAll(FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiaoUrbana(false)));
        }
        for (int i = 0; i < listaRegiao.size(); i++) {
            comboRegiao.getItems().add(listaRegiao.get(i).getNome());
        }

    }
}
