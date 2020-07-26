/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.Collator;
import java.util.Comparator;

/**
 *
 * @author ghsb1
 */
 public class ComparadorDeCargo implements Comparator<Cargo> {
    public int compare(Cargo cargo1, Cargo cargo2){
        String nome1 = cargo1.getNome();
        String nome2 = cargo2.getNome();
        int maior = Collator.getInstance().compare(nome1, nome2);
         if(maior < 0){
             return -1;
         } else {
             return +1;
         }
    }
    
}
