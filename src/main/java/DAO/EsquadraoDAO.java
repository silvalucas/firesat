package DAO;

import Modelo.DadosImagem;
import Modelo.Esquadrao;
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

    public void GravaEsquadrao(Esquadrao esquadrao, Connection con) {
        String sql = "insert into esquadrao (nome,descricao_especialidade,qtd_soldado) " +
                "values (?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, esquadrao.getNome());
            stmt.setString(2, esquadrao.getEspecialidade());
            stmt.setInt(3, esquadrao.getQtdSoldados());


            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /* Método para enviar os dados que estão armazenados localmente, para o diretório do firebase
     * @author Nikollas Ferreira
     * @since 15/10/2019
     */
    public void EnviaDadosEsquadrao() {
        ArrayList<Esquadrao> lista;
        if ((lista = RecuperaEsquadrao(true)) == null) {
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

    public ArrayList<Esquadrao> RecuperaEsquadrao(Connection con) {
        ArrayList<Esquadrao> lista = new ArrayList<>();
        String sql = "select id,nome,descricao_especialidade,qtd_soldado from esquadrao;";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Esquadrao esquadrao = new Esquadrao();
                esquadrao.setId(rs.getInt(1));
                esquadrao.setNome(rs.getString(2));
                esquadrao.setEspecialidade(rs.getString(3));
                esquadrao.setQtdSoldados(rs.getInt(4));
                lista.add(esquadrao);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void AlteraEsquadrao(ArrayList<Esquadrao> lista) {
        Connection con = Conexao.getConnection();
        String sql = "UPDATE esquadrao SET nome = ?, descricao_especialidade = ?, qtd_soldado = ? where id = ? ";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa

            //joga resultado da consulta no ArrayList
            for (Esquadrao esquadrao : lista) {
                stmt.setString(1, esquadrao.getNome());
                stmt.setString(2, esquadrao.getEspecialidade());
                stmt.setInt(3, esquadrao.getQtdSoldados());
                stmt.setInt(4, esquadrao.getId());
                stmt.executeUpdate();
            }
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void DeletaEsquadrao(int id) {
        Connection con = Conexao.getConnection();
        String sql = "DELETE FROM esquadrao WHERE id = ?";


        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
