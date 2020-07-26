/*
 Classe DAO referente ao PerfilUsuario, nela esta contido as funções de CRUD num banco de dados.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PerfilUsuario;

public class PerfisUsuarioDAO {
     private final Connection connection;

    public PerfisUsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(PerfilUsuario perfil) throws SQLException{
       
            String sql = "Insert into perfil_usuario(nome) values = ?";
            PreparedStatement state = connection.prepareStatement(sql);
            state.setString(1,perfil.getNome());
            state.execute();
            connection.close();

    }
    
     public void update (PerfilUsuario perfil) throws SQLException{
          String sql = "update perfil_usuario nome = ?";
          PreparedStatement state = connection.prepareStatement(sql);
          state.setString(1,perfil.getNome());
    
          state.execute();
        
    }
     
     public void delete(PerfilUsuario perfil) throws SQLException{
         String sql = "delete from  perfil_usuario where nome = ? ";
          PreparedStatement state = connection.prepareStatement(sql);
          state.setString(1,perfil.getNome());
          state.execute();
        
    
       }
     
      private ArrayList<PerfilUsuario> pesquisa(PreparedStatement state) throws SQLException {
        ArrayList<PerfilUsuario> perfis = new ArrayList<PerfilUsuario>();
        state.execute();
        ResultSet resultSet = state.getResultSet();

        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
           
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
