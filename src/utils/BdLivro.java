package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Livro;

/**
 *
 * @author paulojp
 */
public class BdLivro {
    
    private Connection conexao;
    
    // Estabelece uma conexão
    public BdLivro() throws SQLException {       
        this.conexao = CriaConexao.getConexao();
    }
    
    // CREATE - Adiciona um registro de livro
    public void adicionaLivro(Livro l) throws SQLException {
        String sql = "INSERT INTO livro(exemplar, autor, edicao, ano, disponibilidade) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, l.getExemplar());
        stmt.setString(2, l.getAutor());
        stmt.setByte(3, l.getEdicao());
        stmt.setShort(4, l.getAno());
        stmt.setString(5, l.getDisponibilidade());
        
        stmt.execute();
        stmt.close();
    }
    
    // SELECT - Retorna uma lista de livros com base no exemplar
    public List<Livro> getLista(String exemplar) throws SQLException {
        String sql = "SELECT * FROM livro WHERE exemplar LIKE ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, "%" + exemplar + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        List<Livro> lista = new ArrayList<>();
        
        while (rs.next()) {
            Livro l = new Livro();
            l.setId(rs.getInt("id_livro"));
            l.setExemplar(rs.getString("exemplar"));
            l.setAutor(rs.getString("autor"));
            l.setEdicao(rs.getByte("edicao"));
            l.setAno(rs.getShort("ano"));
            l.setDisponibilidade(rs.getString("disponibilidade"));
            lista.add(l);            
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }
    
    // UPDATE - Atualiza informações de um livro
    public void altera(Livro l) throws SQLException {
        String sql = "UPDATE livro SET exemplar=?, autor=?, edicao=?, ano=?, disponibilidade=? WHERE id_livro=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, l.getExemplar());
        stmt.setString(2, l.getAutor());
        stmt.setByte(3, l.getEdicao());
        stmt.setShort(4, l.getAno());
        stmt.setString(5, l.getDisponibilidade());
        stmt.setInt(6, l.getId());
        
        stmt.execute();
        stmt.close();
    }
    
    // UPDATE - Atualiza a disponibilidade de um livro
    public void alteraDisponibilidadeLivro(Livro l) throws SQLException {
        String sql = "UPDATE livro SET disponibilidade=? WHERE id_livro=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, l.getDisponibilidade());
        stmt.setInt(2, l.getId());
        
        stmt.execute();
        stmt.close();
    }
    
    // DELETE - Remove um livro
    public void remove(int id) throws SQLException {       
        String sql = "DELETE FROM livro WHERE id_livro=?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
    }
    
    // Outros métodos relacionados a livros podem ser adicionados aqui
    
}
