package DAO;

import Modelo.Esquadrao;
import Util.UtilFirebase;
import Util.UtilJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class EsquadraoDAO {
    private final String nomeArquivo = "Esquadrao";

    public EsquadraoDAO() {
    }

    public void GravaEsquadraoArray(ArrayList<Esquadrao> lista) {

        UtilFirebase.salvaArquivo(lista, nomeArquivo);

    }

    public void GravaEsquadrao(Esquadrao esquadrao) {


        ArrayList<Esquadrao> lista = RecuperaEsquadrao();
        lista.add(esquadrao);
        UtilFirebase.salvaArquivo(lista, nomeArquivo);

        /*DocumentReference docRef = db.collection("Esquadrao").document();
        Map<String, Object> data = new HashMap<>();
        data.put("nome", esquadrao.getNome());
        data.put("especialidade", esquadrao.getEspecialidade());
        data.put("quantidadeSoldados", esquadrao.getQtdSoldados());
        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Aguarde...");
        while (!result.isDone()) {

             }
        System.out.println("Foii");
        }*/
    }

    public ArrayList<Esquadrao> RecuperaEsquadrao() {
        ArrayList<Esquadrao> lista = new ArrayList<>();

        Gson gson = new Gson();
        UtilJson util = new UtilJson();
        if (util.BaixaJson(nomeArquivo)) {
            try {
                Reader reader = new FileReader(nomeArquivo);
                lista = gson.fromJson(reader, new TypeToken<ArrayList<Esquadrao>>() {
                }.getType());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
}
