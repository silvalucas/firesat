package DAO;

import Modelo.Usuario;
import Util.UtilFirebase;
import Util.UtilJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class UsuarioDAO {
    private final String nomeArquivo = "Usuario";

    public UsuarioDAO() {
    }

    public void GravaUsuarioArray(ArrayList<Usuario> lista) {

        UtilFirebase.salvaArquivo(lista, nomeArquivo);

    }

    public void GravaUsuario(Usuario esquadrao) {

        ArrayList<Usuario> lista;
        if ((lista = RecuperaUsuario()) == null) {
            lista = new ArrayList<>();
        }
        lista.add(esquadrao);
        UtilFirebase.salvaArquivo(lista, nomeArquivo);

    }

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

    public ArrayList<Usuario> RecuperaUsuario() {
        ArrayList<Usuario> lista = new ArrayList<>();

        Gson gson = new Gson();

        if (UtilJson.BaixaJson(nomeArquivo)) {
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
