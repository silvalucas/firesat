package Main;

import Util.UtilFirebase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main extends Application {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        new UtilFirebase();
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
    private static Scene listSquadScene;
    private static Scene removeSquadScene;
    private static Scene editSquadScene;
    private static Scene cadRegionScene;
    private static Scene listRegionScene;
    private static Scene removeRegionScene;
    private static Scene editRegionScene;
    private static Scene cadUserScene;
    private static Scene listUserScene;
    private static Scene removeUserScene;
    private static Scene editUserScene;
    private static Scene loginScene;
    private static Scene homeSat;
    private static Scene makeImageSat;
    private static Scene reports;
    private static Scene reportsSat;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setTitle("Firesat - Em Prol da Amazonia");
        Parent fxmlHome = FXMLLoader.load(getClass().getResource("../fxml/Home.fxml"));
        homeScene = new Scene(fxmlHome, 600, 400);

        Parent fxmlLoading = FXMLLoader.load(getClass().getResource("../fxml/Loading.fxml"));
        loadingScene = new Scene(fxmlLoading, 600, 400);

        Parent fxmlCadSquad = FXMLLoader.load(getClass().getResource("../fxml/CadSquad.fxml"));
        cadSquadScene = new Scene(fxmlCadSquad, 600, 400);

        Parent fxmlCadRegion = FXMLLoader.load(getClass().getResource("../fxml/CadRegion.fxml"));
        cadRegionScene = new Scene(fxmlCadRegion, 600, 400);

        Parent fxmlCadUser = FXMLLoader.load(getClass().getResource("../fxml/CadUser.fxml"));
        cadUserScene = new Scene(fxmlCadUser, 600, 400);

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("../fxml/Login.fxml"));
        loginScene = new Scene(fxmlLogin, 600, 400);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void changeScreen(String tela) throws IOException {
        switch (tela) {
            case "squad":
                Parent fxmlSquad = FXMLLoader.load(Main.class.getResource("../fxml/Squad.fxml"));
                squadScene = new Scene(fxmlSquad, 600, 400);
                stage.setScene(squadScene);
                break;
            case "home":
                stage.setScene(homeScene);
                break;
            case "region":
                Parent fxmlRegion = FXMLLoader.load(Main.class.getResource("../fxml/Region.fxml"));
                regionScene = new Scene(fxmlRegion, 600, 400);
                stage.setScene(regionScene);
                break;
            case "user":
                Parent fxmlUser = FXMLLoader.load(Main.class.getResource("../fxml/User.fxml"));
                userScene = new Scene(fxmlUser, 600, 400);
                stage.setScene(userScene);
                break;
            case "loading":
                stage.setScene(loadingScene);
                break;
            case "cadSquad":
                stage.setScene(cadSquadScene);
                break;
            case "editSquad":
                Parent fxmlEditSquad = FXMLLoader.load(Main.class.getResource("../fxml/EditSquad.fxml"));
                editSquadScene = new Scene(fxmlEditSquad, 600, 400);
                stage.setScene(editSquadScene);
                break;
            case "removeSquad":
                Parent fxmlRemoveSquad = FXMLLoader.load(Main.class.getResource("../fxml/RemoveSquad.fxml"));
                removeSquadScene = new Scene(fxmlRemoveSquad, 600, 400);
                stage.setScene(removeSquadScene);
                break;
            case "listSquad":
                Parent fxmlListSquad = FXMLLoader.load(Main.class.getResource("../fxml/ListSquad.fxml"));
                listSquadScene = new Scene(fxmlListSquad, 600, 400);
                stage.setScene(listSquadScene);
                break;
            case "cadRegion":
                stage.setScene(cadRegionScene);
                break;
            case "editRegion":
                Parent fxmlEditRegion = FXMLLoader.load(Main.class.getResource("../fxml/EditRegion.fxml"));
                editRegionScene = new Scene(fxmlEditRegion, 600, 400);
                stage.setScene(editRegionScene);
                break;
            case "removeRegion":
                Parent fxmlRemoveRegion = FXMLLoader.load(Main.class.getResource("../fxml/RemoveRegion.fxml"));
                removeRegionScene = new Scene(fxmlRemoveRegion, 600, 400);
                stage.setScene(removeRegionScene);
                break;
            case "listRegion":
                Parent fxmlListRegion = FXMLLoader.load(Main.class.getResource("../fxml/ListRegion.fxml"));
                listRegionScene = new Scene(fxmlListRegion, 600, 400);
                stage.setScene(listRegionScene);
                break;
            case "cadUser":
                stage.setScene(cadUserScene);
                break;
            case "editUser":
                Parent fxmlEditUser = FXMLLoader.load(Main.class.getResource("../fxml/EditUser.fxml"));
                editUserScene = new Scene(fxmlEditUser, 600, 400);
                stage.setScene(editUserScene);
                break;
            case "removeUser":
                Parent fxmlRemoveUser = FXMLLoader.load(Main.class.getResource("../fxml/RemoveUser.fxml"));
                removeUserScene = new Scene(fxmlRemoveUser, 600, 400);
                stage.setScene(removeUserScene);
                break;
            case "listUser":
                Parent fxmlListUser = FXMLLoader.load(Main.class.getResource("../fxml/ListUser.fxml"));
                listUserScene = new Scene(fxmlListUser, 600, 400);
                stage.setScene(listUserScene);
                break;
            case "login":
                stage.setScene(loginScene);
                break;
            case "HomeSat":
                Parent fxmlMainSat = FXMLLoader.load(Main.class.getResource("../fxml/HomeSat.fxml"));
                homeSat = new Scene(fxmlMainSat, 600, 400);
                stage.setScene(homeSat);
                break;
            case "MakeImage":
                Parent fxmlMakeImage = FXMLLoader.load(Main.class.getResource("../fxml/MakeImageSat.fxml"));
                makeImageSat = new Scene(fxmlMakeImage, 900, 700);
                stage.setScene(makeImageSat);
                break;
            case "reports":
                Parent fxmlReports = FXMLLoader.load(Main.class.getResource("../fxml/Reports.fxml"));
                reports = new Scene(fxmlReports, 600, 400);
                stage.setScene(reports);
                break;
            case "ReportsSat":
                Parent fxmlReportsSat = FXMLLoader.load(Main.class.getResource("../fxml/ReportsSat.fxml"));
                reportsSat = new Scene(fxmlReportsSat, 600, 400);
                stage.setScene(reportsSat);
                break;
        }
    }
}
