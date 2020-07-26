/*
Controller da view de gerencia de perfis, nela estão todas as funcões para funcionamento da mesma.
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
import javax.swing.JOptionPane;
import model.ComparadorDePerfis;
import model.PerfilUsuario;
import view.GerenciadorDePerfis;

public class GerenciadorDePerfisController {
    private final GerenciadorDePerfis view;
     
    public GerenciadorDePerfisController(GerenciadorDePerfis view) {
        this.view = view;
    }
    //Função responsavel por listar os perfis em ordem alfabetica.
    public ArrayList<PerfilUsuario> ListarPerfis() throws SQLException{
       Connection conexao =  new Conexao().getConnection();
       PerfilDAO perfilDao = new PerfilDAO(conexao);
       ArrayList<PerfilUsuario> perfis = new ArrayList<PerfilUsuario>();      
       perfis = perfilDao.selectAll();       
       Collections.sort(perfis,new ComparadorDePerfis());
       
       conexao.close();
       return perfis;
       
       
    }
    //Função responsavel por salvar um novo perfil no banco de dados
    public void salvarPerfil() {
        String nome = view.getTxtNomePerfil().getText();
        
        PerfilUsuario novoPerfil = new PerfilUsuario(nome);
        Connection conexao;
         try {
             conexao = new Conexao().getConnection();
              PerfilDAO perfilDao = new PerfilDAO(conexao);
              perfilDao.insert(novoPerfil);
              conexao.close();
              JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
         } catch (SQLException ex) {
             Logger.getLogger(GerenciadorDePerfis.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
         } 
    }
    //Função responsavel por deletar um perfil do banco de dados
   public void deletarPerfil(int posicao) throws SQLException{
       String nomeParaDeletar = view.getTxtNomePerfil().getText();
       Connection conexao =  new Conexao().getConnection();
       try{
       PerfilDAO perfilDao = new PerfilDAO(conexao);
       PerfilUsuario perfilParaRemover = new PerfilUsuario(nomeParaDeletar);
        JOptionPane.showMessageDialog(null, "Deletado com Sucesso!");
       perfilDao.delete(perfilParaRemover);
      
       }catch (SQLException ex) {
             Logger.getLogger(GerenciadorDePerfis.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao deletar!");
             
         }
       conexao.close();
       
   }
    //Função responsavel por atualizar nome de um perfil no banco de dados
    public void atualizarPerfil(int posicao) throws SQLException {
       String nomes = view.getTxtNomePerfil().getText();
       String[] listaNome = nomes.split("/");
        Connection conexao =  new Conexao().getConnection();
       try{
       PerfilDAO perfilDao = new PerfilDAO(conexao);
       perfilDao.update(listaNome[0], listaNome[1]);
       JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
       }catch (SQLException ex) {
             Logger.getLogger(GerenciadorDePerfis.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao Atualizar!");
         }
       conexao.close();
    }
}
