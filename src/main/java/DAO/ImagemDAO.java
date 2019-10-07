package DAO;

import Modelo.Imagem;
import Util.UtilFirebase;
import Util.UtilJson;
import com.google.gson.Gson;

import java.io.*;

public class ImagemDAO {
    public ImagemDAO() {

    }

    public void GravaDadosImagem(Imagem img[][]) {
        UtilFirebase util = new UtilFirebase();
        util.salvaArquivo(img, "Imagem");
        /*
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
        fileTemp.delete();*/
    }


    public Imagem[][] RecuperaImagem(String nomeArquivo) throws IOException {

        Gson gson = new Gson();
        new UtilJson().BaixaJson(nomeArquivo);
        Reader reader = new FileReader(nomeArquivo);
        Imagem imagem[][] = gson.fromJson(reader, Imagem[][].class);
        return imagem;
    }
}
