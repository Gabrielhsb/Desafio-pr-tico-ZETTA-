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
import javax.swing.JOptionPane;
import model.Usuario;
import view.LoginView;
import view.MenuView;

/**
 *
 * @author ghsb1
 */
public class LoginController {
    
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        String nome = view.getTxtNome().getText();
        String cpf = view.getTxtCpf().getText();
        
        Usuario usuarioAutenticar = new Usuario(nome, cpf);
        
        Connection conexao =  new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        
       boolean existe =  usuarioDao.autenticarPorNomeECPF(usuarioAutenticar);
       if(existe){
           MenuView telaDeMenu = new MenuView();
          telaDeMenu.setVisible(true);
       }else {
           JOptionPane.showMessageDialog(view, "Usuario ou senha invalido!!");
       }
        
        
    }
    
    
}
