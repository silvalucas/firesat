package Controle;

import DAO.DadosImagemDAO;
import DAO.EsquadraoDAO;
import DAO.RegiaoDAO;
import Modelo.DadosImagem;
import Modelo.Imagem;
import Util.UtilDados;
import Main.Main;
import java.util.ArrayList;

public class HomeController {
    private EsquadraoDAO esquadraoDAO = new EsquadraoDAO();
    private RegiaoDAO regiaoDAO = new RegiaoDAO();
    private DadosImagemDAO dadosImagemDAO = new DadosImagemDAO();

    public void goToSquad(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("squad");
    }

    public void goToChoiceRegion(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("choiceRegion");
    }

    public void goToUser(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("user");
    }

    public void goToLogin(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("login");
    }

    public void requestInfoBtn(javafx.event.ActionEvent actionEvent) {
        esquadraoDAO.RecuperaEsquadrao(true);

        ArrayList<DadosImagem> listaImg = dadosImagemDAO.RecuperaDadosImagem(true);
        ImagemControle imagemControle = new ImagemControle();
        if (listaImg != null) {
            for (DadosImagem dadosImagem : listaImg) {
                UtilDados.BaixaDados(dadosImagem.getNome());
                Imagem[][] imagem = imagemControle.MontaMatriz(dadosImagem.getNome());
                int cont = imagemControle.contadorFogo(imagem);
                dadosImagem.calculaPercentual(cont);
                dadosImagem.setBaixada(true);

            }
            dadosImagemDAO.GravaDadosImagem(listaImg);

        }
    }

    public void sendDataBtn(javafx.event.ActionEvent actionEvent) {
        esquadraoDAO.EnviaDadosEsquadrao();
        regiaoDAO.EnviaDadosRegiao();
    }

    public void reportsBtn(javafx.event.ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("reports");
    }
}
