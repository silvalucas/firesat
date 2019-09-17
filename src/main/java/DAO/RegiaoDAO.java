package DAO;

import Modelo.Regiao;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;

import java.util.HashMap;
import java.util.Map;

import static Util.UtilFirebase.db;

public class RegiaoDAO {
    public void GravaRegiao(Regiao regiao) {
        DocumentReference docRef = db.collection("Regiao").document();
        Map<String, Object> data = new HashMap<>();
        data.put("nome", regiao.getNome());
        data.put("esquadrao", regiao.getEsquadrao().getNome());
        data.put("areaProtecao", regiao.isAreaDeProtecaoo());
        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Aguarde...");
        while (!result.isDone()) {

        }
        System.out.println("Foii");
    }

}

