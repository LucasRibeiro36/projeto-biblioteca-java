package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Classe responsável por criar e fornecer conexões com o banco de dados MySQL.
 */
public class CriaConexao {
    
    // Método estático para obter uma conexão com o banco de dados
    public static Connection getConexao() throws SQLException {
        try {
            // Carrega a classe do driver JDBC
            Class.forName("com.mysql.jdbc.Driver");
            
            // URL de conexão com o banco de dados (substitua os valores conforme seu ambiente)
            String url = "jdbc:mysql://localhost/biblioteca";
            
            // Faz a conexão com o banco de dados usando usuário e senha
            return DriverManager.getConnection(url, "root", "P9544504");
        } catch (ClassNotFoundException e) {
            // Lança uma SQLException caso o driver JDBC não seja encontrado
            throw new SQLException("Driver MySQL não encontrado", e);
        }   
    }
    
}
