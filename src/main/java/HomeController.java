import DAO.EsquadraoDAO;
import DAO.RegiaoDAO;

import java.io.IOException;

public class HomeController {
    private EsquadraoDAO esquadraoDAO = new EsquadraoDAO();
    private RegiaoDAO regiaoDAO = new RegiaoDAO();

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
        System.out.println("chegou aqui");
    }

    public void sendDataBtn(javafx.event.ActionEvent actionEvent) {
        esquadraoDAO.EnviaDadosEsquadrao();
        regiaoDAO.EnviaDadosRegiao();
        System.out.println("chegou aqui2");
    }

    public void reportsBtn(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("reports");
    }
}
