package DAO;

import Modelo.Imagem;
import Util.UtilJson;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.gson.Gson;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import static Util.UtilFirebase.*;

public class ImagemDAO {
    public ImagemDAO() {

    }

    public void GravaDadosImagem(Imagem img[][]) {
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        Date currentDate = new Date();
        final String arquivo = "Arquivo-" + formatter2.format(currentDate) + ".json";
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Map<String, Object> data = new HashMap<>();

        data.put("imagem", arquivo);
        data.put("data", formatter.format(currentDate));
        data.put("baixada", false);
        ApiFuture<WriteResult> result = docRef.set(data);
        while (!result.isDone()) {

        }
        File fileTemp = new File(arquivo);
        fileTemp.delete();
    }


    public Imagem[][] RecuperaImagem(String nome) throws IOException {

        Gson gson = new Gson();
        new UtilJson().BaixaJson(nome);
        Reader reader = new FileReader(nome);
        Imagem imagem[][] = gson.fromJson(reader, Imagem[][].class);
        return imagem;
    }
}
