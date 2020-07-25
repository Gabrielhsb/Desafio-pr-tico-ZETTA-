/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.CadastroView;
/**
 *
 * @author ghsb1
 */
public class CadastroViewController {
    private CadastroView view ; 

    public CadastroViewController(CadastroView view) {
        this.view = view;
    }
    
    public void salvaUsuario(){
        
         String cpf = view.getTxtCpf().getText();
         String nome = view.getTxtNome().getText();
         String dataNascimento = view.getTxtDataNascimento().getText();
         String sexo = view.getTxtSexo().getText();
         String cargo = view.getTxtCargo().getText();
         String perfisUsuario = view.getTxtPerfilUsuario().getText();
          
        Usuario novoUsuario = new Usuario(cpf,nome,dataNascimento,sexo,cargo,perfisUsuario);
         
             try {
                 Connection conexao =  new Conexao().getConnection();
                 UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
                 usuarioDao.insert(novoUsuario);
                 
                 JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
                 
             } catch (SQLException ex) {
                 Logger.getLogger(CadastroView.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
}
