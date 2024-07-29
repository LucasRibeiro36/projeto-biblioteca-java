package model;

public class Multa {
    
    private static Multa instance = null;
    
    private int id_multa;
    private int id_cliente;
    private String descricao;
    private float valor;

    // Construtor privado para evitar instanciação externa
    private Multa() {
    }

    // Método estático para obter a instância única do Singleton
    public static Multa getInstance() {
        if (instance == null) {
            instance = new Multa();
        }
        return instance;
    }

    

    public int getId_multa() {
        return id_multa;
    }

    public void setId_multa(int id_multa) {
        this.id_multa = id_multa;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
