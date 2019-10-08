package DAO;

import Modelo.Regiao;
import Util.UtilFirebase;
import Util.UtilJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class RegiaoDAO {
    private final String nomeArquivo = "Regiao";

    public void GravaRegiao(Regiao regiao) {
        UtilFirebase util = new UtilFirebase(1);

        ArrayList<Regiao> lista = RecuperaRegiao();
        lista.add(regiao);
        util.salvaArquivo(lista, nomeArquivo);
    }

    private ArrayList<Regiao> RecuperaRegiao() {
        ArrayList<Regiao> lista = new ArrayList<>();
        Gson gson = new Gson();
        UtilJson util = new UtilJson();
        if (util.BaixaJson(nomeArquivo)) {
            try {
                Reader reader = new FileReader(nomeArquivo);
                lista = gson.fromJson(reader, new TypeToken<ArrayList<Regiao>>() {
                }.getType());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

}

