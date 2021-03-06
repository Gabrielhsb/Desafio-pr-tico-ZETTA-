/*
 Classe utilizada para comparar dois Perfis e retorna qual é maior, para poder oredenar em ordem alfabetica.
 */
package model;

import java.text.Collator;
import java.util.Comparator;
/**
 *
 * @author ghsb1
 */
public class ComparadorDePerfis implements Comparator<PerfilUsuario> {
    public int compare(PerfilUsuario perfil1, PerfilUsuario perfil2){
        String nome1 = perfil1.getNome();
        String nome2 = perfil2.getNome();
        int maior = Collator.getInstance().compare(nome1, nome2);
         if(maior < 0){
             return -1;
         } else {
             return +1;
         }
    }
}
