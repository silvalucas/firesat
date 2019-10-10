package DAO;

import Modelo.DadosImagem;
import Util.UtilFirebase;
import Util.UtilJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class DadosImagemDAO {
    private final String nomeArquivo = "Imagem.json";

    public DadosImagemDAO() {
    }

    public void GravaDadosImagemoArray(ArrayList<DadosImagem> lista) {

        UtilFirebase.salvaArquivo(lista, nomeArquivo);

    }

    public void GravaEsquadrao(DadosImagem esquadrao) {

        ArrayList<DadosImagem> lista;
        if ((lista = RecuperaDadosImagem(true)) == null) {
            lista = new ArrayList<>();
        }
        esquadrao.setId(lista.size());
        lista.add(esquadrao);
        UtilFirebase.salvaArquivo(lista, nomeArquivo);
    }

    public void EnviaDadosImagem() {
        ArrayList<DadosImagem> lista;
        if ((lista = RecuperaDadosImagem(false)) == null) {
            lista = new ArrayList<>();
        }
        UtilFirebase.salvaArquivo(lista, nomeArquivo);
    }

    public ArrayList<DadosImagem> RecuperaDadosImagem(boolean baixaDados) {
        ArrayList<DadosImagem> lista = new ArrayList<>();
        Gson gson = new Gson();
        if (baixaDados) {
            if (!UtilJson.BaixaJson(nomeArquivo)) {
                return null;
            }
        }
        try {
            Reader reader = new FileReader(nomeArquivo);
            lista = gson.fromJson(reader, new TypeToken<ArrayList<DadosImagem>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }


        return lista;
    }
}
