package Modelo;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ProtecaoAmbiental extends Regiao implements Initializable {

    private String nomeLei;

    public ProtecaoAmbiental(String nome, int esquadrao, String nomeLei) {
        super(nome, esquadrao);
        this.nomeLei = nomeLei;
    }

    public String getNomeLei() {
        return nomeLei;
    }

    public void setNomeLei(String nomeLei) {
        this.nomeLei = nomeLei;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
