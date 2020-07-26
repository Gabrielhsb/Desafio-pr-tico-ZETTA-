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
import model.Usuario;

/**
 *
 * @author ghsb1
 */
public class CargoDAO {
    private final Connection connection;

    public CargoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Cargo cargo) throws SQLException{
       
 
            String sql = "Insert into cargo(nome) values (?)";
            PreparedStatement state = connection.prepareStatement(sql);
            state.setString(1,cargo.getNome());
            state.execute();
            connection.close();

    }
    
     public void update (String nomeNovo, String nomeAntigo) throws SQLException{
          String sql = "update cargo set nome = ? where nome = ?";
          PreparedStatement state = connection.prepareStatement(sql);
        
           state.setString(1,nomeNovo);
            state.setString(2,nomeAntigo);
            
            
            state.execute();
        
    }
     public void delete(Cargo cargo) throws SQLException{
         String sql = "delete from cargo where nome = ? ";
          PreparedStatement state = connection.prepareStatement(sql);
          
          state.setString(1,cargo.getNome());

          state.execute();
        
    }
     
      private ArrayList<Cargo> pesquisa(PreparedStatement state) throws SQLException {
        ArrayList<Cargo> cargos = new ArrayList<Cargo>();
        
        state.execute();
        ResultSet resultSet = state.getResultSet();

        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
           

            Cargo cargoSelecionado = new Cargo(nome);
            cargos.add(cargoSelecionado);

        }
        return cargos;
    }
 
       public ArrayList<Cargo> selectAll() throws SQLException{
         String sql = "select * from cargo";
         PreparedStatement state = connection.prepareStatement(sql);
         
        return pesquisa(state);
    }
}

