package DAO;

import Modelo.AreaUrbana;
import Modelo.ProtecaoAmbiental;
import Modelo.Regiao;
import Util.UtilDados;
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

    public void GravaRegiao(Regiao regiao, Connection con) {
        String aux = "";
        if (regiao instanceof ProtecaoAmbiental) {
            aux = "nomeLei";
        }
        if (regiao instanceof AreaUrbana)
            aux = "cidadePopulosa";

        String sql = "insert into regiao (nome,id_esquadrao," + aux + ") " +
                "values (?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, regiao.getNome());
            stmt.setInt(2, regiao.getEsquadrao());
            if (regiao instanceof ProtecaoAmbiental)
                stmt.setString(3, ((ProtecaoAmbiental) regiao).getNomeLei());
            if (regiao instanceof AreaUrbana)
                stmt.setString(3, ((AreaUrbana) regiao).getCidadePopulosa());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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

    public ArrayList<AreaUrbana> RecuperaRegiaoArea(Connection con) {
        ArrayList<AreaUrbana> lista = new ArrayList<>();
        String sql = "select id,nome,id_esquadrao,cidadePopulosa from regiao where nomeLei is NULL;";
        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                AreaUrbana regiao = new AreaUrbana();
                regiao.setId(rs.getInt(1));
                regiao.setNome(rs.getString(2));
                regiao.setEsquadrao(rs.getInt(3));
                regiao.setCidadePopulosa(rs.getString(4));
                lista.add(regiao);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public ArrayList<ProtecaoAmbiental> RecuperaRegiaoProtecao(Connection con) {
        ArrayList<ProtecaoAmbiental> lista = new ArrayList<>();

        String sql = "select id,nome,id_esquadrao,nomeLei from regiao where nomeLei is NOT NULL;";
        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                ProtecaoAmbiental regiao = new ProtecaoAmbiental();
                regiao.setId(rs.getInt(1));
                regiao.setNome(rs.getString(2));
                regiao.setEsquadrao(rs.getInt(3));
                regiao.setNomeLei(rs.getString(4));
                lista.add(regiao);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void AlteraRegiaoProtecao(ArrayList<ProtecaoAmbiental> lista) {

        Connection con = Conexao.getConnection();
        String sql = "UPDATE regiao SET nome = ?, nomeLei = ?, id_esquadrao = ? where id = ? ";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa

            //joga resultado da consulta no ArrayList
            for (ProtecaoAmbiental regiao : lista) {
                stmt.setString(1, regiao.getNome());
                stmt.setString(2, regiao.getNomeLei());
                stmt.setInt(3, regiao.getEsquadrao());
                stmt.setInt(4, regiao.getId());
                stmt.executeUpdate();
            }
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void AlteraRegiaoUrbana(ArrayList<AreaUrbana> lista) {

        Connection con = Conexao.getConnection();
        String sql = "UPDATE regiao SET nome = ?, cidadePopulosa = ?, id_esquadrao = ? where id = ? ";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa

            //joga resultado da consulta no ArrayList
            for (AreaUrbana regiao : lista) {
                stmt.setString(1, regiao.getNome());
                stmt.setString(2, regiao.getCidadePopulosa());
                stmt.setInt(3, regiao.getEsquadrao());
                stmt.setInt(4, regiao.getId());
                stmt.executeUpdate();
            }
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void DeletaRegiao(int id) {
        Connection con = Conexao.getConnection();
        String sql = "DELETE FROM regiao WHERE id = ?";


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

