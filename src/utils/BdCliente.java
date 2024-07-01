package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class BdCliente {
    
    private static BdCliente instance = null;
    private Connection conexao;
    
    // Construtor privado para evitar instanciação externa
    private BdCliente() throws SQLException {
        this.conexao = CriaConexao.getConexao();
    }
    
    // Método estático para obter a instância única do Singleton
    public static BdCliente getInstance() throws SQLException {
        if (instance == null) {
            instance = BdCliente.getInstance();
        }
        return instance;
    }
    
    // CREATE - Adiciona um registro
    public void adicionaCliente(Cliente c) throws SQLException {
        String sql = "INSERT INTO cliente(nome, data_nasc, sexo, cpf, endereco, fone)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getDataNasc());
        stmt.setString(3, c.getSexo());
        stmt.setString(4, c.getCpf());
        stmt.setString(5, c.getEndereco());
        stmt.setString(6, c.getFone());
        
        stmt.execute();
        stmt.close();
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta
    public List<Cliente> getLista(String nome) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE nome like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Cliente> lista = new ArrayList<>();
        
        while (rs.next()) {
            Cliente c = new Cliente();
            c.setId(rs.getInt("id_cliente"));
            c.setNome(rs.getString("nome"));
            c.setDataNasc(rs.getString("data_nasc"));
            c.setSexo(rs.getString("sexo"));
            c.setCpf(rs.getString("cpf"));
            c.setEndereco(rs.getString("endereco"));
            c.setFone(rs.getString("fone"));
            lista.add(c);            
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }
    
    // UPDATE - Atualiza registros
    public void altera(Cliente c) throws SQLException {
        String sql = "UPDATE cliente set nome=?, data_nasc=?, sexo=?, cpf=?, endereco=?, fone=?"
                + "WHERE id_cliente=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getDataNasc());
        stmt.setString(3, c.getSexo());
        stmt.setString(4, c.getCpf());
        stmt.setString(5, c.getEndereco());
        stmt.setString(6, c.getFone());
        stmt.setInt(7, c.getId());
        
        stmt.execute();
        stmt.close();
    }
    
    // DELETE - Apaga registros
    public void remove(int id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id_cliente=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
    }
}
