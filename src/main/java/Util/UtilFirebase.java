package Util;

import Modelo.Esquadrao;
import Modelo.Imagem;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UtilFirebase {
    public static Firestore db;
    public static GoogleCredentials credentials;
    public static FirebaseOptions options;
    public static Storage storage;

    public UtilFirebase() {
        try {
            getCredentials();
            getInstance();
            getStorage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getCredentials() throws IOException {
        //InputStream serviceAccount = new FileInputStream("serviceAccount.json");
        credentials = GoogleCredentials.fromStream(UtilFirebase.class.getResourceAsStream("serviceAccount.json"));

    }

    private static void getInstance() {
        options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setStorageBucket("fire-sat.appspot.com")
                .build();
        FirebaseApp app = FirebaseApp.initializeApp(options);
        db = FirestoreClient.getFirestore();
    }

    private static void getStorage() {
        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setCredentials(credentials)
                .build();
        storage = storageOptions.getService();
    }

    public static void salvaArquivo(ArrayList lista, String nomeArquivo) {
        Gson gson = new Gson();
        String json = gson.toJson(lista);
        BlobId blobId = BlobId.of(options.getStorageBucket(), nomeArquivo);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/json").build();
        try {
            //Criando Json
            FileWriter writer = new FileWriter(nomeArquivo);
            writer.write(json);
            writer.close();
            //salvando no firebase
            InputStream file = new FileInputStream(nomeArquivo);
            storage.create(blobInfo, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void salvaArquivo(Imagem[][] imagem, String arquivo) {
        final int tamX = 20;
        final int tamY = 20;
        String dados = "P3\r\n" + tamX + " " + tamY + "\r\n255\r\n" + UtilPpm.matrizImagemToString(imagem);
        BlobId blobId = BlobId.of(options.getStorageBucket(), arquivo);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/x-portable-pixmap").build();
        try {
            //Criando Json
            FileWriter writer = new FileWriter(arquivo);
            writer.write(dados);
            writer.close();
            //salvando no firebase
            InputStream file = new FileInputStream(arquivo);
            storage.create(blobInfo, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
