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
    private final String nomeArquivo = "Esquadrao.json";

    public EsquadraoDAO() {
    }

    public void GravaEsquadraoArray(ArrayList<Esquadrao> lista) {

        UtilFirebase.salvaArquivo(lista, nomeArquivo);

    }

    public void GravaEsquadrao(Esquadrao esquadrao) {

        ArrayList<Esquadrao> lista;
        if ((lista = RecuperaEsquadrao(true)) == null) {
            lista = new ArrayList<>();
        }
        esquadrao.setId(lista.size());
        lista.add(esquadrao);
        UtilFirebase.salvaArquivo(lista, nomeArquivo);
    }

    public void EnviaDadosEsquadrao() {
        ArrayList<Esquadrao> lista;
        if ((lista = RecuperaEsquadrao(false)) == null) {
            lista = new ArrayList<>();
        }
        UtilFirebase.salvaArquivo(lista, nomeArquivo);
    }

    public ArrayList<Esquadrao> RecuperaEsquadrao(boolean baixaDados) {
        ArrayList<Esquadrao> lista = new ArrayList<>();
        Gson gson = new Gson();
        if (baixaDados) {
            if (!UtilJson.BaixaJson(nomeArquivo)) {
                return null;
            }
        }
        try {
            Reader reader = new FileReader(nomeArquivo);
            lista = gson.fromJson(reader, new TypeToken<ArrayList<Esquadrao>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }


        return lista;
    }
}
