package Modelo;

public class Regiao {
    private String nome;
    private boolean areaDeProtecao;
    private Esquadrao esquadrao;

    public Regiao(String nome, boolean areaDeProtecao, Esquadrao esquadrao) {
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

    public Esquadrao getEsquadrao() {
        return esquadrao;
    }

    public void setEsquadrao(Esquadrao esquadrao) {
        this.esquadrao = esquadrao;
    }

    @Override
    public String toString() {
        return "Regiao{" +
                "nome='" + nome + '\'' +
                ", areaDeProteção=" + areaDeProtecao +
                ", esquadrao=" + esquadrao.toString() +
                '}';
    }
}
