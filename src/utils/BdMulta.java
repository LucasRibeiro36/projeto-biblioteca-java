package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Multa;

/**
 *
 * @author paulojp
 */
public class BdMulta {
    
    private Connection conexao;
    
    // Estabelece uma conexão
    public BdMulta() throws SQLException {       
        this.conexao = CriaConexao.getConexao();
    }
    
    // CREATE - Adiciona um registro de multa
    public void adicionaMulta(Multa m) throws SQLException {
        String sql = "INSERT INTO multa(id_cliente, descricao, valor) VALUES(?, ?, ?)";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, m.getId_cliente());
        stmt.setString(2, m.getDescricao());
        stmt.setFloat(3, m.getValor());
        
        stmt.execute();
        stmt.close();
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta de multas por ID
    public List<Multa> getLista(String id) throws SQLException{
        String sql = "SELECT * FROM multa WHERE id_multa LIKE ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Multa> lista = new ArrayList<>();
        
        while(rs.next()) {
            Multa m = new Multa();
            m.setId_multa(rs.getInt("id_multa"));
            m.setId_cliente(rs.getInt("id_cliente"));
            m.setDescricao(rs.getString("descricao"));
            m.setValor(rs.getFloat("valor"));
            
            lista.add(m);            
        }
        
        rs.close();
        stmt.close();
        
        return lista;          
    }
    
    // SELECT - Retorna uma lista com as multas de um cliente específico
    public List<Multa> getListaMultaPorCliente(String id_cliente) throws SQLException {
        String sql = "SELECT * FROM multa WHERE id_cliente = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, id_cliente);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Multa> lista = new ArrayList<>();
        
        while(rs.next()) {
            Multa m = new Multa();
            m.setId_multa(rs.getInt("id_multa"));
            m.setId_cliente(rs.getInt("id_cliente"));
            m.setDescricao(rs.getString("descricao"));
            m.setValor(rs.getFloat("valor"));
            
            lista.add(m);            
        }
        
        rs.close();
        stmt.close();
        
        return lista;          
    }
    
    // SELECT - Retorna o valor total das multas de um cliente específico
    public float totalMultaCliente(int id_cliente) throws SQLException {
        String sql = "SELECT SUM(valor) AS totalMulta FROM multa WHERE id_cliente = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, id_cliente);

        ResultSet rs = stmt.executeQuery();

        float totalMulta = 0;

        if (rs.next()) {
            totalMulta = rs.getFloat("totalMulta");
        }

        rs.close();
        stmt.close();

        return totalMulta;
    }
    
    // DELETE - Apaga uma multa específica
    public void remove(int id) throws SQLException {       
        String sql = "DELETE FROM multa WHERE id_multa=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();        
    }
    
    // DELETE - Apaga todas as multas de um cliente
    public void removeMultas(int id_cliente) throws SQLException {       
        String sql = "DELETE FROM multa WHERE id_cliente=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, id_cliente);
        
        stmt.execute();
        stmt.close();        
    }
    
    // Outros métodos relacionados a multas podem ser adicionados aqui
    
}
