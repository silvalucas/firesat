import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.cloud.storage.*;
import com.google.cloud.storage.Blob;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        System.out.println("Olha mundo");

        InputStream serviceAccount = new FileInputStream("serviceAccount.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setStorageBucket("firesat-3983a.appspot.com")
                .build();
        FirebaseApp app = FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("usuarios").document("piruzao");
        Map<String, Object> data = new HashMap<>();
        data.put("Nome", "Kid");
        data.put("senha", "toma");
        data.put("ano", 1969);
        ApiFuture<WriteResult> result = docRef.set(data);
        Thread.sleep(5000);
        ApiFuture<QuerySnapshot> query =
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
        storage.create(blobInfo,testFile);

    }
}
