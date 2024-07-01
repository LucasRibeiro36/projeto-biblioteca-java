package model;

public class Emprestimo {
    
    private static Emprestimo instance = null;
    
    private int id_emprestimo;
    private int id_cliente;
    private int id_livro;
    private String data_emprestimo;
    private String data_devolucao;

    // Construtor privado para evitar instanciação externa
    private Emprestimo() {
    }

    // Método estático para obter a instância única do Singleton
    public static Emprestimo getInstance() {
        if (instance == null) {
            instance = new Emprestimo();
        }
        return instance;
    }

    // Métodos getter e setter omitidos por brevidade
    // Você pode mantê-los como estão

    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}
