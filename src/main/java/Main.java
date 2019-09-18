import Controle.ImagemControle;
import DAO.EsquadraoDAO;
import DAO.RegiaoDAO;
import Modelo.Esquadrao;
import Modelo.Imagem;
import Modelo.Regiao;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.cloud.storage.*;
import com.google.cloud.storage.Blob;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import javax.rmi.CORBA.Util;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import Util.UtilFirebase;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        //    EsquadraoDAO esquadraoDAO = new EsquadraoDAO();
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


    }
}
