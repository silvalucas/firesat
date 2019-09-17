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
    /*    ImagemControle controle = new ImagemControle();
        Imagem img[][] = controle.MontaMatriz("lagoa.ppm");
        utilFirebase.GravaDadosImagem(img);*/
        Regiao regiao = new Regiao("aaaaa", true, esquadrao);
        RegiaoDAO regiaoDAO = new RegiaoDAO();
        regiaoDAO.GravaRegiao(regiao);

        /*ApiFuture<QuerySnapshot> query =
                db.collection("usuarios").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            System.out.println("User: " + document.getId());
            System.out.println("User: " + document.getString("Nome"));
            System.out.println("User: " + document.getString("senha"));
            System.out.println("User: " + document.getDouble("ano"));
        }


        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setCredentials(credentials)
                .build();
        Storage storage = storageOptions.getService();
        BlobId blobId = BlobId.of(options.getStorageBucket(), "arquivo2.json");
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/json").build();
        InputStream testFile = new FileInputStream("la.json");
        //Blob blob = storage.create(blobInfo, testFile.toString().getBytes(UTF_8));
        storage.create(blobInfo, testFile);*/

    }
}
