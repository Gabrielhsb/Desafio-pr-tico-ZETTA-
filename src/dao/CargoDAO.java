/*
  Classe DAO referente ao cargo, nela esta contido as funções de CRUD num banco de dados.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cargo;

public class CargoDAO {
    private final Connection connection;

    public CargoDAO(Connection connection) {
        this.connection = connection;
    }
    //Insert
    public void insert(Cargo cargo) throws SQLException{
       
            String sql = "Insert into cargo(nome) values (?)";
            PreparedStatement state = connection.prepareStatement(sql);
            state.setString(1,cargo.getNome());
          
            state.execute();
            connection.close();

    }
    //Update
     public void update (String nomeNovo, String nomeAntigo) throws SQLException{
          String sql = "update cargo set nome = ? where nome = ?";
          PreparedStatement state = connection.prepareStatement(sql);        
           state.setString(1,nomeNovo);
           state.setString(2,nomeAntigo);                 
           state.execute();
        
    }
     //Delete
     public void delete(Cargo cargo) throws SQLException{
         String sql = "delete from cargo where nome = ? ";
          PreparedStatement state = connection.prepareStatement(sql);          
          state.setString(1,cargo.getNome());
          state.execute();
        
    }
     
     //Search
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
       
      //Select
       public ArrayList<Cargo> selectAll() throws SQLException{
         String sql = "select * from cargo";
         PreparedStatement state = connection.prepareStatement(sql);
         
        return pesquisa(state);
    }
}

