import DAO.ImagemDAO;
import DAO.RegiaoDAO;
import Modelo.Imagem;
import Modelo.Regiao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

public class MakeImageController implements Initializable {

    @FXML
    private HBox root;
    private Button[][] btn = new Button[20][20];
    ;
    private Imagem[][] imagem = new Imagem[20][20];
    private ObservableList<Regiao> listaRegiao;
    private TextField codigo;
    private TextField data;
    private ChoiceBox<String> choiceSelectRegion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GridPane grid = new GridPane();
        grid.setId("grid");
        float tam = 35;
        int i, j;
        for (i = 0; i < 20; i++)
            for (j = 0; j < 20; j++) {
                int x = i, y = j;
                btn[i][j] = new Button("");
                grid.add(btn[i][j], j, i);
                btn[i][j].setPrefWidth(35);
                btn[i][j].setPrefHeight(35);
                btn[i][j].setStyle("-fx-background-color: green");
                btn[i][j].setOnAction(e ->
                {
                    if (btn[x][y].getStyle().equals("-fx-background-color: green")) {
                        btn[x][y].setStyle("-fx-background-color: red");
                    } else {
                        btn[x][y].setStyle("-fx-background-color: green");
                    }
                });
            }
        Button concluir = new Button("CONCLUIR");
        concluir.setStyle("-fx-background-color: none;" +
                "-fx-border-color: #cacaca;" +
                "-fx-border-radius: 5;");
        concluir.setPrefSize(100,40);

        concluir.setOnAction(e -> {
            for (int a = 0; a < 20; a++) {
                for (int b = 0; b < 20; b++) {
                    if (btn[a][b].getStyle().equals("-fx-background-color: red")) {
                        imagem[a][b] = new Imagem(255, 0, 0);
                    } else {
                        imagem[a][b] = new Imagem(0, 255, 0);
                    }
                }
            }
            String cdgImg = codigo.getText();
            String dataImg = data.getText();
            String regiaoImg = choiceSelectRegion.getSelectionModel().getSelectedItem();
            Calendar data = Calendar.getInstance();
            int day = data.get(Calendar.DAY_OF_MONTH);
            int mes = data.get(Calendar.MONTH);
            int ano = data.get(Calendar.YEAR);
            int hora = data.get(Calendar.HOUR_OF_DAY);
            int min = data.get(Calendar.MINUTE);
            int seg = data.get(Calendar.SECOND);
            String idImagem = String.valueOf(day) + String.valueOf(mes) + String.valueOf(ano) + String.valueOf(hora)+ String.valueOf(min) + String.valueOf(seg) + ".ppm";

            new ImagemDAO().GravaDadosImagem(imagem, idImagem);
            //implementar gravação do json com o id da imagem

            try {
                Main.changeScreen("HomeSat");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Button voltar = new Button("VOLTAR");
        voltar.setStyle("-fx-background-color: none;" +
                "-fx-border-color: #cacaca;" +
                "-fx-border-radius: 5;");
        voltar.setPrefSize(100,40);
        voltar.setOnAction(e -> {
            try {
                Main.changeScreen("HomeSat");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        HBox horizontal = new HBox();
        horizontal.setSpacing(10);
        horizontal.getChildren().addAll(concluir,voltar);

        VBox vertical = new VBox();
        vertical.setPadding(new Insets(50, 10, 10, 10));
        vertical.setSpacing(20);

        Label titulo = new Label();
        titulo.setText("GERAR IMAGEM");
        titulo.setFont(new Font("Segoe UI Semibold", 20));

        Label txtcodigo = new Label();
        txtcodigo.setText("CODIGO");
        txtcodigo.setFont(new Font("Segoe UI Semilight", 12));
        codigo = new TextField();
        codigo.setPrefSize(100, 40);

        Label txtdata = new Label();
        txtdata.setText("DATA");
        txtdata.setFont(new Font("Segoe UI Semilight", 12));
        data = new TextField();
        data.setPromptText("DD/MM/YYYY");
        data.setPrefSize(100, 40);

        Label txtregiao = new Label();
        txtregiao.setText("REGIAO");
        txtregiao.setFont(new Font("Segoe UI Semilight", 12));
        choiceSelectRegion = new ChoiceBox<>();
        choiceSelectRegion.setPrefSize(100, 40);

        listaRegiao = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiao());
        for (i = 0; i < listaRegiao.size(); i++) {
            choiceSelectRegion.getItems().add(listaRegiao.get(i).getNome());
        }

        root.getChildren().add(grid);
        vertical.getChildren().addAll(titulo, txtcodigo, codigo, txtdata, data, txtregiao, choiceSelectRegion, horizontal);
        root.getChildren().add(vertical);
    }

}
