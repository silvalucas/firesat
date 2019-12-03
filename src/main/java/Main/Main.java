package Main;

import Controle.PaginaDesconhecidaException;
import Modelo.AreaUrbana;
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
    private static Scene choiceRegion;
    private static Scene urbanArea;
    private static Scene protectionArea;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        primaryStage.setTitle("Firesat - Em Prol da Amazonia");
        Parent fxmlHome = FXMLLoader.load(getClass().getResource("fxml/Home.fxml"));
        homeScene = new Scene(fxmlHome, 600, 400);

        Parent fxmlLoading = FXMLLoader.load(getClass().getResource("fxml/Loading.fxml"));
        loadingScene = new Scene(fxmlLoading, 600, 400);

        Parent fxmlCadSquad = FXMLLoader.load(getClass().getResource("fxml/CadSquad.fxml"));
        cadSquadScene = new Scene(fxmlCadSquad, 600, 400);

        Parent fxmlCadUser = FXMLLoader.load(getClass().getResource("fxml/CadUser.fxml"));
        cadUserScene = new Scene(fxmlCadUser, 600, 400);

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("fxml/Login.fxml"));
        loginScene = new Scene(fxmlLogin, 600, 400);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void changeScreen(String tela) throws PaginaDesconhecidaException {
        switch (tela) {
            case "squad":
                Parent fxmlSquad;
                try {
                    fxmlSquad = FXMLLoader.load(Main.class.getResource("fxml/Squad.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                squadScene = new Scene(fxmlSquad, 600, 400);
                stage.setScene(squadScene);
                break;
            case "home":
                stage.setScene(homeScene);
                break;
            case "user":
                Parent fxmlUser;
                try {
                    fxmlUser = FXMLLoader.load(Main.class.getResource("fxml/User.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
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
                Parent fxmlEditSquad;
                try {
                    fxmlEditSquad = FXMLLoader.load(Main.class.getResource("fxml/EditSquad.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                editSquadScene = new Scene(fxmlEditSquad, 600, 400);
                stage.setScene(editSquadScene);
                break;
            case "removeSquad":
                Parent fxmlRemoveSquad;
                try {
                    fxmlRemoveSquad = FXMLLoader.load(Main.class.getResource("fxml/RemoveSquad.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                removeSquadScene = new Scene(fxmlRemoveSquad, 600, 400);
                stage.setScene(removeSquadScene);
                break;
            case "listSquad":
                Parent fxmlListSquad;
                try {
                    fxmlListSquad = FXMLLoader.load(Main.class.getResource("fxml/ListSquad.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                listSquadScene = new Scene(fxmlListSquad, 600, 400);
                stage.setScene(listSquadScene);
                break;
            case "cadUser":
                stage.setScene(cadUserScene);
                break;
            case "editUser":
                Parent fxmlEditUser;
                try {
                    fxmlEditUser = FXMLLoader.load(Main.class.getResource("fxml/EditUser.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                editUserScene = new Scene(fxmlEditUser, 600, 400);
                stage.setScene(editUserScene);
                break;
            case "removeUser":
                Parent fxmlRemoveUser;
                try {
                    fxmlRemoveUser = FXMLLoader.load(Main.class.getResource("fxml/RemoveUser.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                removeUserScene = new Scene(fxmlRemoveUser, 600, 400);
                stage.setScene(removeUserScene);
                break;
            case "listUser":
                Parent fxmlListUser;
                try {
                    fxmlListUser = FXMLLoader.load(Main.class.getResource("fxml/ListUser.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                listUserScene = new Scene(fxmlListUser, 600, 400);
                stage.setScene(listUserScene);
                break;
            case "login":
                stage.setScene(loginScene);
                break;
            case "HomeSat":
                Parent fxmlMainSat;
                try {
                    fxmlMainSat = FXMLLoader.load(Main.class.getResource("fxml/HomeSat.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                homeSat = new Scene(fxmlMainSat, 600, 400);
                stage.setScene(homeSat);
                break;
            case "MakeImage":
                Parent fxmlMakeImage;
                try {
                    fxmlMakeImage = FXMLLoader.load(Main.class.getResource("fxml/MakeImageSat.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                makeImageSat = new Scene(fxmlMakeImage, 900, 700);
                stage.setScene(makeImageSat);
                break;
            case "reports":
                Parent fxmlReports;
                try {
                    fxmlReports = FXMLLoader.load(Main.class.getResource("fxml/Reports.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                reports = new Scene(fxmlReports, 600, 400);
                stage.setScene(reports);
                break;
            case "ReportsSat":
                Parent fxmlReportsSat;
                try {
                    fxmlReportsSat = FXMLLoader.load(Main.class.getResource("fxml/ReportsSat.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                reportsSat = new Scene(fxmlReportsSat, 600, 400);
                stage.setScene(reportsSat);
                break;
            case "choiceRegion":
                Parent fxmlChoiceRegion;
                try {
                    fxmlChoiceRegion = FXMLLoader.load(Main.class.getResource("fxml/ChoiceRegion.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                choiceRegion = new Scene(fxmlChoiceRegion, 600, 400);
                stage.setScene(choiceRegion);
                break;
            case "cadRegionUrban":
                Parent fxmlCadRegion;
                try {
                    fxmlCadRegion = FXMLLoader.load(Main.class.getResource("fxml/CadRegionUrban.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                cadRegionScene = new Scene(fxmlCadRegion, 600, 400);
                stage.setScene(cadRegionScene);
                break;
            case "editRegionUrban":
                Parent fxmlEditRegion;
                try {
                    fxmlEditRegion = FXMLLoader.load(Main.class.getResource("fxml/EditRegionUrban.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                editRegionScene = new Scene(fxmlEditRegion, 600, 400);
                stage.setScene(editRegionScene);
                break;
            case "removeRegionUrban":
                Parent fxmlRemoveRegion;
                try {
                    fxmlRemoveRegion = FXMLLoader.load(Main.class.getResource("fxml/RemoveRegionUrban.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                removeRegionScene = new Scene(fxmlRemoveRegion, 600, 400);
                stage.setScene(removeRegionScene);
                break;
            case "listRegionUrban":
                Parent fxmlListRegion;
                try {
                    fxmlListRegion = FXMLLoader.load(Main.class.getResource("fxml/ListRegionUrban.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                listRegionScene = new Scene(fxmlListRegion, 600, 400);
                stage.setScene(listRegionScene);
                break;
            case "urbanArea":
                Parent fxmlUrbanArea;
                try {
                    fxmlUrbanArea = FXMLLoader.load(Main.class.getResource("fxml/UrbanArea.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                urbanArea = new Scene(fxmlUrbanArea, 600, 400);
                stage.setScene(urbanArea);
                break;
            case "protectionArea":
                Parent fxmlProtectionArea;
                try {
                    fxmlProtectionArea = FXMLLoader.load(Main.class.getResource("fxml/ProtectionArea.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                protectionArea = new Scene(fxmlProtectionArea, 600, 400);
                stage.setScene(protectionArea);
                break;
            case "cadRegionProtection":
                Parent fxmlCadRegionProtection;
                try {
                    fxmlCadRegionProtection = FXMLLoader.load(Main.class.getResource("fxml/CadRegionProtection.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                cadRegionScene = new Scene(fxmlCadRegionProtection, 600, 400);
                stage.setScene(cadRegionScene);
                break;
            case "editRegionProtection":
                Parent fxmlEditRegionProtection;
                try {
                    fxmlEditRegionProtection = FXMLLoader.load(Main.class.getResource("fxml/EditRegionProtection.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                editRegionScene = new Scene(fxmlEditRegionProtection, 600, 400);
                stage.setScene(editRegionScene);
                break;
            case "removeRegionProtection":
                Parent fxmlRemoveRegionProtection;
                try {
                    fxmlRemoveRegionProtection = FXMLLoader.load(Main.class.getResource("fxml/RemoveRegionProtection.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!"+e);
                }
                removeRegionScene = new Scene(fxmlRemoveRegionProtection, 600, 400);
                stage.setScene(removeRegionScene);
                break;
            case "listRegionProtection":
                Parent fxmlListRegionProtection;
                try {
                    fxmlListRegionProtection = FXMLLoader.load(Main.class.getResource("fxml/ListRegionProtection.fxml"));
                } catch (IOException e) {
                    throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!");
                }
                listRegionScene = new Scene(fxmlListRegionProtection, 600, 400);
                stage.setScene(listRegionScene);
                break;
            default:
                
                throw new PaginaDesconhecidaException("Página " + tela + " não encontrada!");
        }
    }
}
