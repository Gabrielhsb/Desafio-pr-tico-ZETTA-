/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.PerfilDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ComparadorDePerfis;
import model.PerfilUsuario;
import view.GerenciadorDePerfis;

/**
 *
 * @author ghsb1
 */
public class GerenciadorDePerfisController {
    private final GerenciadorDePerfis view;
     

    public GerenciadorDePerfisController(GerenciadorDePerfis view) {
        this.view = view;
    }
    
    public ArrayList<PerfilUsuario> ListarPerfis() throws SQLException{
        
        
       Connection conexao =  new Conexao().getConnection();
       PerfilDAO perfilDao = new PerfilDAO(conexao);
       
       ArrayList<PerfilUsuario> perfis = new ArrayList<PerfilUsuario>();
       
       perfis = perfilDao.selectAll();
       
       Collections.sort(perfis,new ComparadorDePerfis());
       return perfis;
       
       
    }

    public void salvarPerfil() {
        String nome = view.getTxtNomePerfil().getText();
        
        PerfilUsuario novoPerfil = new PerfilUsuario(nome);
        Connection conexao;
         try {
             System.err.println(nome);
             conexao = new Conexao().getConnection();
              PerfilDAO perfilDao = new PerfilDAO(conexao);
              perfilDao.insert(novoPerfil);
         } catch (SQLException ex) {
             Logger.getLogger(GerenciadorDePerfis.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
   public void deletarPerfil(int posicao) throws SQLException{
       String nomeParaDeletar = view.getTxtNomePerfil().getText();
       
       Connection conexao =  new Conexao().getConnection();
       PerfilDAO perfilDao = new PerfilDAO(conexao);
       
       PerfilUsuario perfilParaRemover = new PerfilUsuario(nomeParaDeletar);
        
       
       perfilDao.delete(perfilParaRemover);
       
       
       
   }

    public void atualizarPerfil(int posicao) throws SQLException {
       String nomes = view.getTxtNomePerfil().getText();
       String[] listaNome = nomes.split("/");
       
       Connection conexao =  new Conexao().getConnection();
       PerfilDAO perfilDao = new PerfilDAO(conexao);
       
     
        
       perfilDao.update(listaNome[0], listaNome[1]);

       
    }
}
