/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.PerfilUsuario;

/**
 *
 * @author ghsb1
 */
public class PerfilUsuarioDAO {
    private final Connection connection;

    public PerfilUsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(PerfilUsuario perfilUsuario) throws SQLException{
       
            
            String sql = "Insert into Perfil_Usuario(perfil_nome) values('"+perfilUsuario.getNome()+"')";
            PreparedStatement state = connection.prepareStatement(sql);
            state.execute();
            connection.close();
           
        
    }
    
}
