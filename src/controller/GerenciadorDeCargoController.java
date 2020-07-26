/*
 Controller da view de gerencia de cargos, nela estão todas as funcões para funcionamento da mesma.
 */
package controller;

import dao.CargoDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cargo;
import model.ComparadorDeCargo;
import view.GerenciadorDeCargo;

public class GerenciadorDeCargoController {
    private final GerenciadorDeCargo view;
     
    public GerenciadorDeCargoController(GerenciadorDeCargo view) {
        this.view = view;
    }
    
    //Função que lista os cargos em ordem alfabetica.
    public ArrayList<Cargo> ListarCargos() throws SQLException{

       Connection conexao =  new Conexao().getConnection();
       CargoDAO cargoDao = new CargoDAO(conexao);
       ArrayList<Cargo> cargos = new ArrayList<Cargo>();
       cargos = cargoDao.selectAll();
       Collections.sort(cargos,new ComparadorDeCargo());
       
       conexao.close();
       return cargos;
       
       
    }
    //Função que salva um novo cargo no banco de dados;
    public void salvarCargo() {
        String nome = view.getTxtCargoNome().getText();
        Cargo novoCargo = new Cargo(nome);
        Connection conexao;
         try {
             conexao = new Conexao().getConnection();
              CargoDAO cargoDao = new CargoDAO(conexao);
              cargoDao.insert(novoCargo);
              conexao.close();
              JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
         } catch (SQLException ex) {
             Logger.getLogger(GerenciadorDeCargo.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
         }
         
    }
    //Função que deleta o cargo do banco de dados.
   public void deletarCargo(int posicao) throws SQLException{
       String nomeParaDeletar = view.getTxtCargoNome().getText();
       Connection conexao =  new Conexao().getConnection();
       CargoDAO cargoDao = new CargoDAO(conexao);
       Cargo cargoParaRemover = new Cargo(nomeParaDeletar);
       try{
       cargoDao.delete(cargoParaRemover);
       conexao.close();
        JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
       }catch (SQLException ex) {
             Logger.getLogger(GerenciadorDeCargo.class.getName()).log(Level.SEVERE, null, ex);
             conexao.close();
              JOptionPane.showMessageDialog(null, "Erro ao apagar!");
             
         }
           
   }
   //Função que atualiza o cargo no banco de dados.
    public void atualizarCargo(int posicao) throws SQLException {
       String nomes = view.getTxtCargoNome().getText();
       String[] listaNome = nomes.split("/");
        Connection conexao =  new Conexao().getConnection();
       CargoDAO cargoDao = new CargoDAO(conexao);
       
       try{
       cargoDao.update(listaNome[0], listaNome[1]);
       conexao.close();
       JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
       }catch (SQLException ex) {
             Logger.getLogger(GerenciadorDeCargo.class.getName()).log(Level.SEVERE, null, ex);
             conexao.close();
              JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
             
         }
       
    }
}
