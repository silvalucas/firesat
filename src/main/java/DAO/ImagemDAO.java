package DAO;

import Modelo.Imagem;
import Util.UtilFirebase;
import Util.UtilDados;
import com.google.gson.Gson;

import java.io.*;

/*Classe para manipulação de dados do objeto Imagem
 * @version 0.0.1
 * @author Nikollas Ferreira
 * @since 15/10/2019
 */

public class ImagemDAO {
    public ImagemDAO() {

    }

    /* Método para gravar uma imagem em PPM no diretório do firebase
     * @author Nikollas Ferreira
     * @since 15/10/2019
     */
    public void GravaDadosImagem(Imagem img[][], String nomeArquivo) {
        UtilFirebase.salvaArquivo(img, nomeArquivo);
    }

    /* Método para buscar uma imagem em PPM no diretório do firebase
     * @author Nikollas Ferreira
     * @since 15/10/2019
     */
    public Imagem[][] RecuperaImagem(String nomeArquivo) throws IOException {
        Gson gson = new Gson();
        new UtilDados().BaixaDados(nomeArquivo);
        Reader reader = new FileReader(nomeArquivo);
        Imagem imagem[][] = gson.fromJson(reader, Imagem[][].class);
        return imagem;
    }
}
