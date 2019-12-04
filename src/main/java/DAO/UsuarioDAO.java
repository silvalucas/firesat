package DAO;

import Modelo.Usuario;
import Util.UtilFirebase;
import Util.UtilDados;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void GravaUsuario(Usuario usuario) {

        ArrayList<Usuario> lista;
        if ((lista = RecuperaUsuario()) == null) {
            lista = new ArrayList<>();
        }
        lista.add(usuario);
        UtilFirebase.salvaArquivo(lista, nomeArquivo);

    }

    public void GravaUsuario(Usuario usuario, Connection con) {
        String sql = "insert into usuario (nome,senha,email ) values (?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getEmail());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /* Método para autenticar o usuario e senha na tela de login
     * @author Lucas Oliveira
     * @since 15/10/2019
     * @return boolean
     */
    public boolean AutenticaUsuario(String email, String senha) {
        ArrayList<Usuario> lista = RecuperaUsuario();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getEmail().equals(email) && lista.get(i).getPassword().equals(senha)) {

                Usuario.utilizaBancoLocal = lista.get(i).getPermissao();
                return true;
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

    public ArrayList<Usuario> RecuperaUsuario(Connection con) {
        ArrayList<Usuario> lista = new ArrayList<>();

        String sql = "select id,nome,senha,email from usuario;";
        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNome(rs.getString(2));
                usuario.setPassword(rs.getString(3));
                usuario.setEmail(rs.getString(4));
                lista.add(usuario);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
