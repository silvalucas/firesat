package Modelo;

public class Usuario {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nome;
    private String email;
    private String password;
    private Boolean utilizaBancoLocal;

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String password, Boolean permissao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.utilizaBancoLocal = permissao;
    }

    public Usuario(String nome, String email, String password, Boolean permissao) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.utilizaBancoLocal = permissao;
    }

    public Boolean getUtilizaBancoLocal() {
        return utilizaBancoLocal;
    }

    public void setUtilizaBancoLocal(Boolean utilizaBancoLocal) {
        this.utilizaBancoLocal = utilizaBancoLocal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
