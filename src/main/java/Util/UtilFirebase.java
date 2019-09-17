package Util;

import Modelo.Imagem;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.storage.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilFirebase {
    public static Firestore db;
    public static GoogleCredentials credentials;
    private static FirebaseOptions options;

    public UtilFirebase() {
        try {
            getCredentials();
            getInstance();
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

    public void GravaDadosImagem(Imagem img[][]) {
        final String arquivo = "Arquivo.json";
        //imagem para json
        Gson gson = new Gson();
        String json = gson.toJson(img);
        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setCredentials(credentials)
                .build();
        Storage storage = storageOptions.getService();
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
        DocumentReference docRef = db.collection("imagens").document();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy ");
        Date currentDate = new Date();
        Map<String, Object> data = new HashMap<>();

        data.put("imagem", arquivo);
        data.put("data", formatter.format(currentDate));
        data.put("baixada", false);
        ApiFuture<WriteResult> result = docRef.set(data);

       /* for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                data.put("red", img[i][j].getRed());
                data.put("green", img[i][j].getGreen());
                data.put("blue", img[i][j].getBlue());
                docRef.set(data);
                docRef = db.collection("imagens").document("Cor1").collection("Cores").document(i + " " + j);
            }*/


    }

    public void PegaDadosImagem(String nome) {
        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setCredentials(credentials)
                .build();
        Storage storage = storageOptions.getService();
        Blob blob = storage.get(BlobId.of(options.getStorageBucket(), nome));
        Path destFilePath = Paths.get("Arquivo.json");
        blob.downloadTo(destFilePath);
    }

    public Imagem[][] RecuperaImagem() throws IOException {

        Gson gson = new Gson();
        PegaDadosImagem("Arquivo.json");
        Reader reader = new FileReader("Arquivo.json");
        Imagem imagem[][] = gson.fromJson(reader, Imagem[][].class);


        return imagem;
    }
}
