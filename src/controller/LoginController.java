/*
  Controller da view de Login, nela estão todas as funcões para funcionamento da mesma.
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

public class LoginController {
    
    private final LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    //Função responsavel por autenticar o login, caso ele esteja no banco de dados o login é concluido.
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
