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
    public static FirebaseOptions options;

    public UtilFirebase(int a) {

    }

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




}
