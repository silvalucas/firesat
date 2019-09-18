package Util;

import Modelo.Esquadrao;
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

    public UtilFirebase(int a) {

    }

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
        InputStream serviceAccount = new FileInputStream("serviceAccount.json");
        credentials = GoogleCredentials.fromStream(serviceAccount);

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

    public void salvaArquivo(ArrayList lista, String nomeArquivo) {
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

    public void salvaArquivo(Object[][] objects, String nomeArquivo) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        Date currentDate = new Date();
        final String arquivo = nomeArquivo + "-" + formatter.format(currentDate) + ".json";
        Gson gson = new Gson();
        String json = gson.toJson(objects);
        BlobId blobId = BlobId.of(options.getStorageBucket(), arquivo);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/json").build();
        try {
            //Criando Json
            FileWriter writer = new FileWriter(arquivo);
            writer.write(json);
            writer.close();
            //salvando no firebase
            InputStream file = new FileInputStream(arquivo);
            storage.create(blobInfo, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 /*ApiFuture<QuerySnapshot> query =
                db.collection("usuarios").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            System.out.println("User: " + document.getId());
            System.out.println("User: " + document.getString("Nome"));
            System.out.println("User: " + document.getString("senha"));
            System.out.println("User: " + document.getDouble("ano"));
        }*/
}
