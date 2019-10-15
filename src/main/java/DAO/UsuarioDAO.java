package DAO;

import Modelo.Usuario;
import Util.UtilFirebase;
import Util.UtilDados;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

/*Classe para manipulação de dados do objeto Usuario
 * @version 0.0.1
 * @author Nikollas Ferreira
 * @since 15/10/2019
 */

public class UsuarioDAO {
    private final String nomeArquivo = "Usuario";

    public UsuarioDAO() {
    }

    /* Método para gravar um ArrayList do objeto Usuario em json no diretório do firebase
     * @author Nikollas Ferreira
     * @since 15/10/2019
     */
    public void GravaUsuarioArray(ArrayList<Usuario> lista) {

        UtilFirebase.salvaArquivo(lista, nomeArquivo);

    }

    /* Método para gravar um Usuario no seu json no diretório do firebase
     * @author Nikollas Ferreira
     * @since 15/10/2019
     */
    public void GravaUsuario(Usuario esquadrao) {

        ArrayList<Usuario> lista;
        if ((lista = RecuperaUsuario()) == null) {
            lista = new ArrayList<>();
        }
        lista.add(esquadrao);
        UtilFirebase.salvaArquivo(lista, nomeArquivo);

    }

    /* Método para autenticar o usuario e senha na tela de login
     * @author Lucas Oliveira
     * @since 15/10/2019
     * @return boolean
     */
    public boolean AutenticaUsuario(String email, String senha) {
        ArrayList<Usuario> lista = RecuperaUsuario();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getEmail().equals(email)) {
                if (lista.get(i).getPassword().equals(senha)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    /* Método para buscar um ArrayList do objeto Usuario em json no diretório do firebase
     * @author Nikollas Ferreira
     * @since 15/10/2019
     * @return ArrayList<Usuario>
     */
    public ArrayList<Usuario> RecuperaUsuario() {
        ArrayList<Usuario> lista = new ArrayList<>();

        Gson gson = new Gson();

        if (UtilDados.BaixaDados(nomeArquivo)) {
            try {
                Reader reader = new FileReader(nomeArquivo);
                lista = gson.fromJson(reader, new TypeToken<ArrayList<Usuario>>() {
                }.getType());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        return lista;
    }
}
