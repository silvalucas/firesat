package Modelo;

public abstract class Regiao {
    private int id;
    private String nome;
    private int esquadrao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Regiao(String nome, int esquadrao) {
        this.nome = nome;
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

    public int getEsquadrao() {
        return esquadrao;
    }

    public void setEsquadrao(int esquadrao) {
        this.esquadrao = esquadrao;
    }

    @Override
    public String toString() {
        return "Regiao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", esquadrao=" + esquadrao +
                '}';
    }


}
