/*
 Classe utilizada para comparar dois cargos e retorna qual é maior, para poder oredenar em ordem alfabetica.
 */
package model;

import java.text.Collator;
import java.util.Comparator;


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
