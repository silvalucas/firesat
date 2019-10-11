package Modelo;

import java.time.LocalDate;

public class DadosImagem {
    private int id;
    private String nome;
    private LocalDate data;
    private int regiao;
    private boolean baixada;
    private float percentual;

    public float getPercentual() {
        return percentual;
    }

    public void setPercentual(float percentual) {
        this.percentual = percentual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DadosImagem(int id, String nome, LocalDate data, int regiao, boolean baixada, float percentual) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.regiao = regiao;
        this.baixada = baixada;
        this.percentual = percentual;
    }

    public DadosImagem() {

    }

    public void calculaPercentual(int tam, int cont) {
        this.percentual = ((float) cont / (tam*tam)) * 100.0f;
    }

    public String retornaAumento(float valFinal, float valInicial) {
        float total = valFinal - valInicial;
        if (total == 0) {
            return "Sem aumento ou diminuição";
        }
        if (total < 0) {
            return "Diminuiu " + ((Math.abs(total))) + "%";
        }
        return "Aumentou " + ((Math.abs(total))) + "%";
    }
}
