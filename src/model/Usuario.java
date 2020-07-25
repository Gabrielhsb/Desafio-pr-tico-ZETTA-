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
public class Usuario {
    private String cpf;
    private String nome;
    private String data_nascimento;
    private String sexo;
    private String cargos;
    private String perfis_usuario;

    public Usuario(String nome, String cpf) {
       this.cpf = cpf;
       this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargos() {
        return cargos;
    }

    public void setCargos(String cargos) {
        this.cargos = cargos;
    }

    public String getPerfis_usuario() {
        return perfis_usuario;
    }

    public void setPerfis_usuario(String perfis_usuario) {
        this.perfis_usuario = perfis_usuario;
    }

    public Usuario(String cpf, String nome, String data_nascimento, String sexo, String cargos, String perfis_usuario) {
        this.cpf = cpf;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.cargos = cargos;
        this.perfis_usuario = perfis_usuario;
    }
    
    
  
}
