/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.coletaTech.Model.Bean;

/**
 *
 * @author wesley
 */
public class Usuario {
    
    private int id_usuarios;
    private String nome_usuarios;
    private String senha_usuarios;
    private String cpf_usuarios;

    public int getId_usuarios() {
        return id_usuarios;
    }

    public void setId_usuarios(int id_usuarios) {
        this.id_usuarios = id_usuarios;
    }

    public String getNome_usuarios() {
        return nome_usuarios;
    }

    public void setNome_usuarios(String nome_usuarios) {
        this.nome_usuarios = nome_usuarios;
    }

    public String getSenha_usuarios() {
        return senha_usuarios;
    }

    public void setSenha_usuarios(String senha_usuarios) {
        this.senha_usuarios = senha_usuarios;
    }

    public String getCpf_usuarios() {
        return cpf_usuarios;
    }

    public void setCpf_usuarios(String cpf_usuarios) {
        this.cpf_usuarios = cpf_usuarios;
    }
    
    
}
