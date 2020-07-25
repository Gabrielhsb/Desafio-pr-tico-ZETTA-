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
import model.Usuario;


/**
 *
 * @author ghsb1
 */
public class UsuarioDAO {
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Usuario usuario) throws SQLException{
            String sql = "Insert into usuario(cpf,nome,data_nascimento,sexo,cargos,perfis_usuario) values(?,?,?,?,?,?)";
            PreparedStatement state = connection.prepareStatement(sql);
            
            state.setString(1,usuario.getCpf());
            state.setString(2,usuario.getNome());
            state.setString(3,usuario.getData_nascimento());
            state.setString(4,usuario.getSexo());
            state.setString(5,usuario.getCargos());
            state.setString(6,usuario.getPerfis_usuario());

            
            state.execute();
           
           
        
    }

    public void update (Usuario usuario) throws SQLException{
          String sql = "update usuario set cpf = ?, nome = ?, data_nascimento = ?, sexo = ?,cargos = ?, perfis_usuario= ? where cpf = ?";
          PreparedStatement state = connection.prepareStatement(sql);
            
            state.setString(1,usuario.getCpf());
            state.setString(2,usuario.getNome());
            state.setString(3,usuario.getData_nascimento());
            state.setString(4,usuario.getSexo());
            state.setString(5,usuario.getCargos());
            state.setString(6,usuario.getPerfis_usuario());
            state.setString(7,usuario.getCpf());

            
            state.execute();
        
    }
    
    public void delete(Usuario usuario) throws SQLException{
         String sql = "delete from usuario where cpf = ? ";
          PreparedStatement state = connection.prepareStatement(sql);
          
          state.setString(1,usuario.getCpf());

          state.execute();
        
    }
    
    public ArrayList<Usuario> selectAll() throws SQLException{
         String sql = "select * from usuario";
         PreparedStatement state = connection.prepareStatement(sql);
         
        return pesquisa(state);
    }

    private ArrayList<Usuario> pesquisa(PreparedStatement state) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        state.execute();
        ResultSet resultSet = state.getResultSet();

        while (resultSet.next()) {
            String cpf = resultSet.getString("cpf");
            String nome = resultSet.getString("nome");
            String dataNascimento = resultSet.getString("data_nascimento");
            String sexo = resultSet.getString("sexo");
            String cargo = resultSet.getString("cargos");
            String perfis = resultSet.getString("perfis_usuario");

            Usuario usuarioSelecionado = new Usuario(cpf, nome, dataNascimento, sexo, cargo, perfis);
            usuarios.add(usuarioSelecionado);

        }
        return usuarios;
    }
    
    
    
    public Usuario selectPorCpf(Usuario usuario) throws SQLException{
         String sql = "select * from usuario where cpf = ?";
         PreparedStatement state = connection.prepareStatement(sql);
         state.setString(1, usuario.getCpf());
 
        return pesquisa(state).get(0);
        

    }
    
    public boolean autenticarPorNomeECPF(Usuario usuario) throws SQLException {
      String sql = "select * from usuario where nome = ? and cpf = ? "  ;
      
      PreparedStatement state = connection.prepareStatement(sql);
      state.setString(1,usuario.getNome());
      state.setString(2,usuario.getCpf());
      state.execute();
      
      
       ResultSet resultado = state.getResultSet();
       return resultado.next();
   }
    
    
}
