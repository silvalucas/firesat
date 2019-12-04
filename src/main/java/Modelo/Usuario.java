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
    private boolean permissao;
    public static Boolean utilizaBancoLocal = false;


    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String password, Boolean permissao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.permissao = permissao;
        utilizaBancoLocal = permissao;
    }

    public Usuario(String nome, String email, String password, Boolean permissao) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.permissao = permissao;
    }

    public Boolean getPermissao() {
        return permissao;
    }

    public void setUtilizaBancoLocal(Boolean permissao) {
        this.permissao = permissao;
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
