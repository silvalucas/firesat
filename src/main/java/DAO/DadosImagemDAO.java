package DAO;

import Modelo.DadosImagem;
import Modelo.Imagem;
import Util.UtilDate;
import Util.UtilFirebase;
import Util.UtilDados;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/*Classe para manipulação de dados do objeto DadosImagem
 * @version 0.0.1
 * @author Nikollas Ferreira
 * @since 15/10/2019
 */

public class DadosImagemDAO {
    private final String nomeArquivo = "Imagem.json";

    public DadosImagemDAO() {
    }

    /* Método que grava um Arraylist do objeto DadosImagem no seu json
     * @author Nikollas Ferreira
     * @since 15/10/2019
     */
    public void GravaDadosImagem(ArrayList<DadosImagem> lista) {
        UtilFirebase.salvaArquivo(lista, nomeArquivo);
    }

    /* Método que ao cadastrar a imagem, seta o objeto DadosImagem no seu json
     * @author Nikollas Ferreira
     * @since 15/10/2019
     */
    public void GravaDadosImagem(DadosImagem imagem, Connection con) {
        String sql = "insert into imagem (nome,percentual,data,caminho,baixada,regiao_id) " +
                "values (?,?,?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, imagem.getNome());
            stmt.setFloat(2, imagem.getPercentual());
            stmt.setDate(3, (java.sql.Date) Date.from(imagem.getData().
                    atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            stmt.setString(4, nomeArquivo);
            stmt.setBoolean(5, imagem.isBaixada());
            stmt.setInt(6, imagem.getRegiao());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    /* Método para buscar json do objeto DadosImagem
     * @author Nikollas Ferreira
     * @since 15/10/2019
     * @return Arraylist<DadosImagem> if success
     */
    public ArrayList<DadosImagem> RecuperaDadosImagem(boolean baixaDados, Connection con) {
        ArrayList<DadosImagem> lista = new ArrayList<>();
        String sql = "select id,nome,percentual,data,baixada,regiao_id from imagem;";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                DadosImagem imagem = new DadosImagem();
                imagem.setId(rs.getInt(1));
                imagem.setNome(rs.getString(2));
                imagem.setPercentual(rs.getFloat(3));
                imagem.setData(rs.getDate(4).toLocalDate());
                imagem.setBaixada(rs.getBoolean(5));
                imagem.setRegiao(rs.getInt(6));

                lista.add(imagem);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public ArrayList<DadosImagem> RecuperaDadosImagem(boolean baixaDados) {
        ArrayList<DadosImagem> lista;
        Gson gson = new Gson();
        if (baixaDados) {
            if (!UtilDados.BaixaDados(nomeArquivo)) {
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

    /*Método para listar as imagens conforme data inicial e final fornecidas pelo usuário
     * @author Nikollas Ferreira
     * @since 15/10/2019
     * @return Arraylist<DadosImagem> if success
     */
    public ArrayList<DadosImagem> imagensEntreDatas(Date data1, Date data2, int id) {
        ArrayList<DadosImagem> lista;
        ArrayList<DadosImagem> aux = new ArrayList<>();
        if ((lista = RecuperaDadosImagem(false)) != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (UtilDate.localdateToDate(lista.get(i).getData()).compareTo(data1) >= 0
                        &&
                        UtilDate.localdateToDate(lista.get(i).getData()).compareTo(data2) <= 0) {
                    if (id == lista.get(i).getRegiao())
                        aux.add(lista.get(i));
                }
            }
            return aux;
        } else
            return null;
    }

}
