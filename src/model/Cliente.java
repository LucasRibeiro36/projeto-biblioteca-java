package model;

public class Cliente {
    
    private static Cliente instance = null;
    
    private int id;
    private String nome;
    private String dataNasc;
    private String sexo;
    private String cpf;
    private String endereco;
    private String fone;

    // Construtor privado para evitar instanciação externa
    private Cliente() {
    }

    // Método estático para obter a instância única do Singleton
    public static Cliente getInstance() {
        if (instance == null) {
            instance = new Cliente();
        }
        return instance;
    }

    // Métodos getter e setter omitidos por brevidade
    // Você pode mantê-los como estão

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}
