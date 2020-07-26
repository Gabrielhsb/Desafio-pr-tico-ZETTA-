/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cargo;
import model.PerfilUsuario;

/**
 *
 * @author ghsb1
 */
public class PerfilDAO {
    private final Connection connection;

    public PerfilDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(PerfilUsuario perfilUsuario) throws SQLException{
       
            
            String sql = "Insert into perfil_usuario(perfil_nome) values(?)";
            PreparedStatement state = connection.prepareStatement(sql);
            state.setString(1,perfilUsuario.getNome());
            state.execute();
            connection.close();
           
        
    }
     public void update (String nomeNovo, String nomeAntigo) throws SQLException{
          String sql = "update perfil_usuario set perfil_nome = ? where perfil_nome = ?";
          PreparedStatement state = connection.prepareStatement(sql);
        
           state.setString(1,nomeNovo);
            state.setString(2,nomeAntigo);
            
            
            state.execute();
        
    }
     public void delete(PerfilUsuario perfil) throws SQLException{
         String sql = "delete from perfil_usuario where perfil_nome = ? ";
          PreparedStatement state = connection.prepareStatement(sql);
          
          state.setString(1,perfil.getNome());

          state.execute();
        
    }
    
    private ArrayList<PerfilUsuario> pesquisa(PreparedStatement state) throws SQLException {
        ArrayList<PerfilUsuario> perfis = new ArrayList<PerfilUsuario>();
        
        state.execute();
        ResultSet resultSet = state.getResultSet();

        while (resultSet.next()) {
            String nome = resultSet.getString("perfil_nome");
           

            PerfilUsuario perfilSelecionado = new PerfilUsuario(nome);
            perfis.add(perfilSelecionado);

        }
        return perfis;
    }
    public ArrayList<PerfilUsuario> selectAll() throws SQLException{
         String sql = "select * from perfil_usuario";
         PreparedStatement state = connection.prepareStatement(sql);
         
        return pesquisa(state);
    }
    
}
