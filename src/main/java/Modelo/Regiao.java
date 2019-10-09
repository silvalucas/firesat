package Modelo;

public class Regiao {
    private String nome;
    private boolean areaDeProtecao;
    private int esquadrao;

    public Regiao(String nome, boolean areaDeProtecao, int esquadrao) {
        this.nome = nome;
        this.areaDeProtecao = areaDeProtecao;
        this.esquadrao = esquadrao;
    }

    public Regiao() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getAreaDeProtecao() {
        return areaDeProtecao;
    }

    public void setAreaDeProtecao(boolean areaDeProtecao) {
        this.areaDeProtecao = areaDeProtecao;
    }

    public boolean isAreaDeProtecao() {
        return areaDeProtecao;
    }

    public int getEsquadrao() {
        return esquadrao;
    }

    public void setEsquadrao(int esquadrao) {
        this.esquadrao = esquadrao;
    }

    @Override
    public String toString() {
        return "Regiao{" +
                "nome='" + nome + '\'' +
                ", areaDeProteção=" + areaDeProtecao +
                ", esquadrao=" + esquadrao +
                '}';
    }
}
