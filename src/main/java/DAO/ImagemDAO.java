package DAO;

import Modelo.Imagem;
import Util.UtilFirebase;
import Util.UtilJson;
import com.google.gson.Gson;

import java.io.*;

public class ImagemDAO {
    public ImagemDAO() {

    }

    public void GravaDadosImagem(Imagem img[][], String nomeArquivo) {
        UtilFirebase.salvaArquivo(img, nomeArquivo);
    }


    public Imagem[][] RecuperaImagem(String nomeArquivo) throws IOException {
        Gson gson = new Gson();
        new UtilJson().BaixaJson(nomeArquivo);
        Reader reader = new FileReader(nomeArquivo);
        Imagem imagem[][] = gson.fromJson(reader, Imagem[][].class);
        return imagem;
    }
}
