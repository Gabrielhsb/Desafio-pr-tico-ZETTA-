/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import model.Cargo;
import model.ComparadorDeCargo;
import view.GerenciadorDeCargo;
import view.MenuView;

/**
 *
 * @author ghsb1
 */
public class GerenciadorDeCargoController {
    private final GerenciadorDeCargo view;
     

    public GerenciadorDeCargoController(GerenciadorDeCargo view) {
        this.view = view;
    }
    
    public ArrayList<Cargo> ListarCargos() throws SQLException{
        
        
       Connection conexao =  new Conexao().getConnection();
       CargoDAO cargoDao = new CargoDAO(conexao);
       
       ArrayList<Cargo> cargos = new ArrayList<Cargo>();
       
       cargos = cargoDao.selectAll();
       
       Collections.sort(cargos,new ComparadorDeCargo());
       return cargos;
       
       
    }

    public void salvarCargo() {
        String nome = view.getTxtCargoNome().getText();
        
        Cargo novoCargo = new Cargo(nome);
        Connection conexao;
         try {
             conexao = new Conexao().getConnection();
              CargoDAO cargoDao = new CargoDAO(conexao);
              cargoDao.insert(novoCargo);
         } catch (SQLException ex) {
             Logger.getLogger(GerenciadorDeCargo.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
   public void deletarCargo(int posicao) throws SQLException{
       String nomeParaDeletar = view.getTxtCargoNome().getText();
       
       Connection conexao =  new Conexao().getConnection();
       CargoDAO cargoDao = new CargoDAO(conexao);
       
       Cargo cargoParaRemover = new Cargo(nomeParaDeletar);
        
       
       cargoDao.delete(cargoParaRemover);
       
       
       
   }

    public void atualizarCargo(int posicao) throws SQLException {
       String nomes = view.getTxtCargoNome().getText();
       String[] listaNome = nomes.split("/");
       
       Connection conexao =  new Conexao().getConnection();
       CargoDAO cargoDao = new CargoDAO(conexao);
       
     
        
       cargoDao.update(listaNome[0], listaNome[1]);

       
    }
}
