import DAO.DadosImagemDAO;
import DAO.EsquadraoDAO;
import DAO.RegiaoDAO;
import Modelo.DadosImagem;

import java.io.IOException;
import java.util.ArrayList;

public class HomeController {
    private EsquadraoDAO esquadraoDAO = new EsquadraoDAO();
    private RegiaoDAO regiaoDAO = new RegiaoDAO();
    private DadosImagemDAO dadosImagemDAO = new DadosImagemDAO();

    public void goToSquad(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("squad");
    }

    public void goToRegion(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("region");
    }

    public void goToUser(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("user");
    }

    public void goToLogin(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("login");
    }

    public void requestInfoBtn(javafx.event.ActionEvent actionEvent) {
        esquadraoDAO.RecuperaEsquadrao(true);
        regiaoDAO.RecuperaRegiao();
        ArrayList<DadosImagem> listaImg = dadosImagemDAO.RecuperaDadosImagem(true);
        if (listaImg != null) {
            for (DadosImagem dadosImagem : listaImg) {
                dadosImagem.setBaixada(true);
            }
            dadosImagemDAO.GravaDadosImagem(listaImg);
        }
    }

    public void sendDataBtn(javafx.event.ActionEvent actionEvent) {
        esquadraoDAO.EnviaDadosEsquadrao();
        regiaoDAO.EnviaDadosRegiao();


    }

    public void reportsBtn(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("reports");
    }
}
