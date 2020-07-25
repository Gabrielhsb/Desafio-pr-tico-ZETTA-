/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ghsb1
 */
public class Cargo {
    private String nome;
    private int id;

    public Cargo(String nome) {
         this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cargo(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }
    
    
    
}
