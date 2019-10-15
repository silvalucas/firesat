package DAO;

import Modelo.Regiao;
import Util.UtilDados;
import Util.UtilFirebase;
import Util.UtilDados;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

/*Classe para manipulação de dados do objeto Região
 * @version 0.0.1
 * @author Nikollas Ferreira
 * @since 15/10/2019
 */

public class RegiaoDAO {
    private final String nomeArquivo = "Regiao.json";

    /*Método para gravar uma Região no diretório do firebase
     * @author Nikollas Ferreira
     * @return ArrayList<Regiao>
     * @since 15/10/2019
     */
    public void GravaRegiao(Regiao regiao) {
        ArrayList<Regiao> lista;
        if ((lista = RecuperaRegiao()) == null) {
            lista = new ArrayList<>();
        }
        regiao.setId(lista.size());
        lista.add(regiao);
        UtilFirebase.salvaArquivo(lista, nomeArquivo);
    }

    /*Método para gravar todas as Regiões no diretório do firebase
     * @author Nikollas Ferreira
     * @return ArrayList<Regiao>
     * @since 15/10/2019
     */
    public void GravaRegiaoArray(ArrayList<Regiao> lista) {

        UtilFirebase.salvaArquivo(lista, nomeArquivo);

    }

    /*Método de enviar as Regiões cadastradas localmente para o diretório do firebase
     * @author Nikollas Ferreira
     * @return ArrayList<Regiao>
     * @since 15/10/2019
     */
    public void EnviaDadosRegiao() {
        ArrayList<Regiao> lista;
        if ((lista = RecuperaRegiao()) == null) {
            lista = new ArrayList<>();
        }
        UtilFirebase.salvaArquivo(lista, nomeArquivo);
    }

    /*Método para buscar as Regiões cadastradas no diretório do firebase
    * @author Nikollas Ferreira
    * @return ArrayList<Regiao>
    * @since 15/10/2019
     */
    public ArrayList<Regiao> RecuperaRegiao() {
        ArrayList<Regiao> lista = new ArrayList<>();
        Gson gson = new Gson();
        if (UtilDados.BaixaDados(nomeArquivo)) {
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

