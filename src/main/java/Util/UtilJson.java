package Util;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.nio.file.Path;
import java.nio.file.Paths;

import static Util.UtilFirebase.credentials;
import static Util.UtilFirebase.options;

public class UtilJson {

    public UtilJson() {
    }

    public boolean BaixaJson(String nome) {
        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setCredentials(credentials)
                .build();
        Storage storage = storageOptions.getService();
        Blob blob = storage.get(BlobId.of(options.getStorageBucket(), nome));
        Path destFilePath = Paths.get(nome);
        if (blob != null){
            blob.downloadTo(destFilePath);
            return true;
        }
        return false;
    }
}
