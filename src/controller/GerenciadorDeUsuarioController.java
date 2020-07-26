/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import model.Usuario;
import view.GerenciadorDeUsuario;

/**
 *
 * @author ghsb1
 */
public class GerenciadorDeUsuarioController {
    private final GerenciadorDeUsuario view;
     

    public GerenciadorDeUsuarioController(GerenciadorDeUsuario view) {
        this.view = view;
    }
    
    public void atualizarUsuario() throws SQLException {
         String cpf = view.getTxtCpfUsuario().getText();
         String nome = view.getTxtNomeUsuario().getText();
         String dataNascimento = view.getTxtNascimentoUsuario().getText();
         String sexo = view.getTxtSexoUsuario().getText();
         String cargo = view.getTxtCargoUsuario().getText();
         String perfisUsuario = view.getTxtPerfilUsuario().getText();
         
         Usuario usuarioAtualizado = new Usuario(cpf,nome,dataNascimento,sexo,cargo,perfisUsuario, "27/07/2020");
       
       
       Connection conexao =  new Conexao().getConnection();
       UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
       
       
        
       usuarioDao.update(usuarioAtualizado);

       
    }
}
