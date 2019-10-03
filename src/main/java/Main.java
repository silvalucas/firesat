import DAO.EsquadraoDAO;
import DAO.RegiaoDAO;
import Modelo.Esquadrao;
import Modelo.Regiao;
import Util.UtilFirebase;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Main extends Application {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        launch(args);

      /*  //    EsquadraoDAO esquadraoDAO = new EsquadraoDAO();
        Esquadrao esquadrao = new Esquadrao("nomi", "fogareu", 65);
        //   esquadraoDAO.GravaEsquadrao(esquadrao);

        UtilFirebase utilFirebase = new UtilFirebase();
        EsquadraoDAO esquadraoDAO = new EsquadraoDAO();
        // esquadraoDAO.GravaEsquadrao(esquadrao);
        ArrayList<EsquadraoDAO> lista = esquadraoDAO.RecuperaEsquadrao();
        if (!lista.isEmpty()) {
            System.out.println("tem coisa");
        }
        Regiao regiao = new Regiao("nome", true, esquadrao);
        RegiaoDAO regiaoDAO = new RegiaoDAO();
        regiaoDAO.GravaRegiao(regiao);

*/
    }

    private static Stage stage;
    private static Scene homeScene;
    private static Scene squadScene;
    private static Scene regionScene;
    private static Scene userScene;
    private static Scene loadingScene;
    private static Scene cadSquadScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setTitle("Firesat - Em Prol da Amazonia");
        Parent fxmlHome = FXMLLoader.load(getClass().getResource("fxml/Home.fxml"));
        homeScene = new Scene(fxmlHome, 600, 400);

        Parent fxmlSquad = FXMLLoader.load(getClass().getResource("fxml/Squad.fxml"));
        squadScene = new Scene(fxmlSquad, 600, 400);

        Parent fxmlRegion = FXMLLoader.load(getClass().getResource("fxml/Region.fxml"));
        regionScene = new Scene(fxmlRegion, 600, 400);

        Parent fxmlUser = FXMLLoader.load(getClass().getResource("fxml/User.fxml"));
        userScene = new Scene(fxmlUser, 600, 400);

        Parent fxmlLoading = FXMLLoader.load(getClass().getResource("fxml/Loading.fxml"));
        loadingScene = new Scene(fxmlLoading, 600, 400);

        Parent fxmlCadSquad = FXMLLoader.load(getClass().getResource("fxml/CadSquad.fxml"));
        cadSquadScene = new Scene(fxmlCadSquad, 600, 400);

        primaryStage.setScene(homeScene);
        primaryStage.show();
    }

    public static void changeScreen(String tela) {
        switch (tela){
            case "squad":
                stage.setScene(squadScene);
                break;
            case "home":
                stage.setScene(homeScene);
                break;
            case "region":
                stage.setScene(regionScene);
                break;
            case "user":
                stage.setScene(userScene);
                break;
            case "loading":
                stage.setScene(loadingScene);
                break;
            case "cadSquad":
                stage.setScene(cadSquadScene);
                break;
        }
    }
}
