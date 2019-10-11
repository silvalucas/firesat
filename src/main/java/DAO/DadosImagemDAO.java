package DAO;

import Modelo.DadosImagem;
import Util.UtilFirebase;
import Util.UtilJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DadosImagemDAO {
    private final String nomeArquivo = "Imagem.json";

    public DadosImagemDAO() {
    }

    public void GravaDadosImagemoArray(ArrayList<DadosImagem> lista) {

        UtilFirebase.salvaArquivo(lista, nomeArquivo);

    }

    public void GravaDadosImagem(DadosImagem imagem) {

        ArrayList<DadosImagem> lista;
        if ((lista = RecuperaDadosImagem(true)) == null) {
            lista = new ArrayList<>();
        }
        imagem.setId(lista.size());
        lista.add(imagem);
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

    public ArrayList<DadosImagem> imagensEntreDatas(String data1, String data2) {
        Date date1 = stringToDate(data1);
        Date date2 = stringToDate(data2);

        ArrayList<DadosImagem> lista;
        ArrayList<DadosImagem> aux = new ArrayList<>();
        if ((lista = RecuperaDadosImagem(false)) != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getData().after(date1) && lista.get(i).getData().compareTo(date2) <= 0) {
                    aux.add(lista.get(i));
                }
            }
            return aux;
        } else
            return null;
    }

    public Date stringToDate(String txt) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            return sdf.parse(txt);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
