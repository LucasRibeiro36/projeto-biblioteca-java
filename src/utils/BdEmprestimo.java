package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;

public class BdEmprestimo {
    
    private static BdEmprestimo instance = null;
    private Connection conexao;
    
    // Construtor privado para evitar instanciação externa
    private BdEmprestimo() throws SQLException {
        this.conexao = CriaConexao.getConexao();
    }
    
    // Método estático para obter a instância única do Singleton
    public static BdEmprestimo getInstance() throws SQLException {
        if (instance == null) {
            instance = bdEmprestimo.getLista(id);
        }
        return instance;
    }
    
    // CREATE - Adiciona um registro de empréstimo
    public void adicionaEmprestimo(Emprestimo e) throws SQLException {
        String sql = "INSERT INTO emprestimo(id_cliente, id_livro, data_emprestimo, data_devolucao) VALUES(?, ?, ?, ?)";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, e.getId_cliente());
        stmt.setInt(2, e.getId_livro());
        stmt.setString(3, e.getData_emprestimo());
        stmt.setString(4, e.getData_devolucao());
        
        stmt.execute();
        stmt.close();
    }
    
    // SELECT - Retorna uma lista com os empréstimos baseados no ID do empréstimo
    public List<Emprestimo> getLista(String id) throws SQLException {
        String sql = "SELECT * FROM emprestimo WHERE id_emprestimo = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Emprestimo> lista = new ArrayList<>();
        
        while (rs.next()) {
            Emprestimo e = new Emprestimo();
            e.setId_emprestimo(rs.getInt("id_emprestimo"));
            e.setId_cliente(rs.getInt("id_cliente"));
            e.setId_livro(rs.getInt("id_livro"));
            e.setData_emprestimo(rs.getString("data_emprestimo"));
            e.setData_devolucao(rs.getString("data_devolucao"));
            lista.add(e);            
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }
    
    // SELECT - Retorna uma lista de empréstimos de um cliente específico
    public List<Emprestimo> getListaPorCliente(String id_cliente) throws SQLException {
        String sql = "SELECT * FROM emprestimo WHERE id_cliente = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, id_cliente);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Emprestimo> lista = new ArrayList<>();
        
        while (rs.next()) {
            Emprestimo e = new Emprestimo();
            e.setId_emprestimo(rs.getInt("id_emprestimo"));
            e.setId_cliente(rs.getInt("id_cliente"));
            e.setId_livro(rs.getInt("id_livro"));
            e.setData_emprestimo(rs.getString("data_emprestimo"));
            e.setData_devolucao(rs.getString("data_devolucao"));
            lista.add(e);            
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }
    
    // DELETE - Remove um registro de empréstimo
    public void remove(int id) throws SQLException {
        String sql = "DELETE FROM emprestimo WHERE id_emprestimo=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
    }
    
    // Outros métodos relacionados a empréstimos podem ser adicionados aqui
    
}
