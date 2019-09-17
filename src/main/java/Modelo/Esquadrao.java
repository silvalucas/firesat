package Modelo;

public class Esquadrao {
    private String nome;
    private String especialidade;
    private int qtdSoldados;

    public Esquadrao() {

    }

    public Esquadrao(String nome, String especialidade, int qtdSoldados) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.qtdSoldados = qtdSoldados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getQtdSoldados() {
        return qtdSoldados;
    }

    public void setQtdSoldados(int qtdSoldados) {
        this.qtdSoldados = qtdSoldados;
    }

    @Override
    public String toString() {
        return "Esquadrao{" +
                "nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", qtdSoldados=" + qtdSoldados +
                '}';
    }
}
