package Modelo;

import java.util.Date;

public class DadosImagem {
    private int id;
    private Date data;
    private int regiao;
    private boolean baixada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getRegiao() {
        return regiao;
    }

    public void setRegiao(int regiao) {
        this.regiao = regiao;
    }

    public boolean isBaixada() {
        return baixada;
    }

    public void setBaixada(boolean baixada) {
        this.baixada = baixada;
    }

    public DadosImagem(int id, Date data, int regiao, boolean baixada) {
        this.id = id;
        this.data = data;
        this.regiao = regiao;
        this.baixada = baixada;
    }

    public DadosImagem() {

    }
}
