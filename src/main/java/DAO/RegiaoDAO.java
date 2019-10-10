package DAO;

import Modelo.Regiao;
import Util.UtilFirebase;
import Util.UtilJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jdk.jshell.execution.Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class RegiaoDAO {
    private final String nomeArquivo = "Regiao.json";

    public void GravaRegiao(Regiao regiao) {
        ArrayList<Regiao> lista;
        if ((lista = RecuperaRegiao()) == null) {
            lista = new ArrayList<>();
        }
        lista.add(regiao);
        UtilFirebase.salvaArquivo(lista, nomeArquivo);
    }

    public void GravaRegiaoArray(ArrayList<Regiao> lista) {

        UtilFirebase.salvaArquivo(lista, nomeArquivo);

    }

    public void EnviaDadosRegiao() {
        ArrayList<Regiao> lista;
        if ((lista = RecuperaRegiao()) == null) {
            lista = new ArrayList<>();
        }
        UtilFirebase.salvaArquivo(lista, nomeArquivo);
    }

    public ArrayList<Regiao> RecuperaRegiao() {
        ArrayList<Regiao> lista = new ArrayList<>();
        Gson gson = new Gson();
        if (UtilJson.BaixaJson(nomeArquivo)) {
            try {
                Reader reader = new FileReader(nomeArquivo);
                lista = gson.fromJson(reader, new TypeToken<ArrayList<Regiao>>() {
                }.getType());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return lista;
    }

}

