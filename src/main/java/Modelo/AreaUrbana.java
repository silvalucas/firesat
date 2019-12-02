package Modelo;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AreaUrbana extends Regiao implements Initializable {

    private String cidadePopulosa;

    public AreaUrbana(String nome, int esquadrao, String cidadePopulosa) {
        super(nome, esquadrao);
        this.cidadePopulosa = cidadePopulosa;
    }

    public String getCidadePopulosa() {
        return cidadePopulosa;
    }

    public void setCidadePopulosa(String cidadePopulosa) {
        this.cidadePopulosa = cidadePopulosa;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
