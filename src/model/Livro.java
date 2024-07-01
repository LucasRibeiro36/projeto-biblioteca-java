package model;

public class Livro {
    
    private static Livro instance = null;
    
    private int id;
    private String exemplar;
    private String autor;
    private byte edicao;
    private short ano;
    private String disponibilidade;

    // Construtor privado para evitar instanciação externa
    private Livro() {
    }

    // Método estático para obter a instância única do Singleton
    public static Livro getInstance() {
        if (instance == null) {
            instance = new Livro();
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

    public String getExemplar() {
        return exemplar;
    }

    public void setExemplar(String exemplar) {
        this.exemplar = exemplar;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public byte getEdicao() {
        return edicao;
    }

    public void setEdicao(byte edicao) {
        this.edicao = edicao;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
