/*
 Classe responsavel por fazer a conexção com o banco de dados.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Conexao {
    
    public Connection getConnection() throws SQLException{
        
        String url = "jdbc:postgresql://localhost:5432/empresa";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","postgres");
        
        Connection conexao = DriverManager.getConnection(url, props);
        return conexao;
        
    }
    
}
