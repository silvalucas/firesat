package DAO;

import Modelo.Esquadrao;
import Util.UtilFirebase;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

import java.util.HashMap;
import java.util.Map;

public class EsquadraoDAO {
    private UtilFirebase util;

    public EsquadraoDAO() {
        util = new UtilFirebase();
    }

    public void GravaEsquadrao(Esquadrao esquadrao) {
        Firestore db = util.db;
        DocumentReference docRef = db.collection("Esquadrao").document();
        Map<String, Object> data = new HashMap<>();
        data.put("nome", esquadrao.getNome());
        data.put("especialidade", esquadrao.getEspecialidade());
        data.put("quantidadeSoldados", esquadrao.getQtdSoldados());
        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Aguarde...");
        while (!result.isDone()) {

             }
        System.out.println("Foii");
        }
    }
