/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author ghsb1
 */
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
