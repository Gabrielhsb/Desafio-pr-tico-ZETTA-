/*
 Controller da view de cadastro de usuario, nela estão todas as funcões para funcionamento da mesma.
 */
package controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.CadastroView;

public class CadastroViewController {
    private final CadastroView view ; 

    public CadastroViewController(CadastroView view) {
        this.view = view;
    }
    //Função responsavel por salvar novos usuarios no banco de dados;
    public void salvaUsuario(){
         String cpf = view.getTxtCpf().getText();
         String nome = view.getTxtNome().getText();
         String dataNascimento = view.getTxtDataNascimento().getText();
         String sexo = view.getTxtSexo().getText();
         String cargo = view.getTxtCargo().getText();
         String perfisUsuario = view.getTxtPerfilUsuario().getText();
         
         Date data = new Date();
         data.getDate();
         SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
         String dataCadastro =  fmt.format(data);
         Usuario novoUsuario = new Usuario(cpf,nome,dataNascimento,sexo,cargo,perfisUsuario,dataCadastro);
         
             try {
                 Connection conexao =  new Conexao().getConnection();
                 UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
                 usuarioDao.insert(novoUsuario);
                 JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
                 
             } catch (SQLException ex) {
                 Logger.getLogger(CadastroView.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
             }
    }
}
