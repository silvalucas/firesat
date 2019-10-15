package DAO;

import Modelo.Esquadrao;
import Util.UtilFirebase;
import Util.UtilDados;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

/*Classe para manipulação de dados do objeto Esquadrao
 * @version 0.0.1
 * @author Nikollas Ferreira
 * @since 15/10/2019
 */

public class EsquadraoDAO {
    private final String nomeArquivo = "Esquadrao.json";

    public EsquadraoDAO() {
    }

    /* Método para gravar um ArrayList de Esquadrao em json no diretório do firebase
     * @author Nikollas Ferreira
     * @since 15/10/2019
     */
    public void GravaEsquadraoArray(ArrayList<Esquadrao> lista) {

        UtilFirebase.salvaArquivo(lista, nomeArquivo);

    }

    /* Método para gravar Esquadrao em seu json no diretório do firebase
     * @author Nikollas Ferreira
     * @since 15/10/2019
     */
    public void GravaEsquadrao(Esquadrao esquadrao) {

        ArrayList<Esquadrao> lista;
        if ((lista = RecuperaEsquadrao(true)) == null) {
            lista = new ArrayList<>();
        }
        esquadrao.setId(lista.size());
        lista.add(esquadrao);
        UtilFirebase.salvaArquivo(lista, nomeArquivo);
    }

    /* Método para enviar os dados que estão armazenados localmente, para o diretório do firebase
     * @author Nikollas Ferreira
     * @since 15/10/2019
     */
    public void EnviaDadosEsquadrao() {
        ArrayList<Esquadrao> lista;
        if ((lista = RecuperaEsquadrao(false)) == null) {
            lista = new ArrayList<>();
        }
        UtilFirebase.salvaArquivo(lista, nomeArquivo);
    }

    /* Método para busca um ArrayList de Esquadrao em json no diretório do firebase
     * @author Nikollas Ferreira
     * @return ArrayList<Esquadrao>
     * @since 15/10/2019
     */
    public ArrayList<Esquadrao> RecuperaEsquadrao(boolean baixaDados) {
        ArrayList<Esquadrao> lista = new ArrayList<>();
        Gson gson = new Gson();
        if (baixaDados) {
            if (!UtilDados.BaixaDados(nomeArquivo)) {
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
