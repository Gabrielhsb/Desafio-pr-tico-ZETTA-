/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CargoDAO;
import dao.Conexao;
import dao.UsuarioDAO;
import model.ComparadorDeCargo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import model.Cargo;
import view.MenuView;

/**
 *
 * @author ghsb1
 */
public class MenuController {
     private final MenuView view;
     

    public MenuController(MenuView view) {
        this.view = view;
    }
    
   
        
}
