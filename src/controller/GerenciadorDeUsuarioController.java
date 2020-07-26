/*
  Controller da view de Gerencia de usuario, nela estão todas as funcões para funcionamento da mesma.
 */
package controller;

import dao.UsuarioDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.GerenciadorDeUsuario;

public class GerenciadorDeUsuarioController {
    private final GerenciadorDeUsuario view;

    public GerenciadorDeUsuarioController(GerenciadorDeUsuario view) {
        this.view = view;
    }   
    //Função responsavel por atualizar as informações do usuario no banco de dados.
    public void atualizarUsuario() throws SQLException {
         String cpf = view.getTxtCpfUsuario().getText();
         String nome = view.getTxtNomeUsuario().getText();
         String dataNascimento = view.getTxtNascimentoUsuario().getText();
         String sexo = view.getTxtSexoUsuario().getText();
         String cargo = view.getTxtCargoUsuario().getText();
         String perfisUsuario = view.getTxtPerfilUsuario().getText();
         
         Usuario usuarioAtualizado = new Usuario(cpf,nome,dataNascimento,sexo,cargo,perfisUsuario, "27/07/2020");
       
       try{
       Connection conexao =  new Conexao().getConnection();
       UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
       usuarioDao.update(usuarioAtualizado);
       JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
       }catch (SQLException ex) {
             Logger.getLogger(GerenciadorDeUsuario.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao Atualizar!");
         } 
       
    }
}
