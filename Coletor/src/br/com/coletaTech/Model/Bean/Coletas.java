/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.coletaTech.Model.Bean;

import java.util.Date;

/**
 *
 * @author wesley
 */
public class Coletas {
    
    private int id_coletas;
    private Date data_coletas;
    private Usuario usuario;
    private int saldo_coletas;

    public int getId_coletas() {
        return id_coletas;
    }

    public void setId_coletas(int id_coletas) {
        this.id_coletas = id_coletas;
    }

    public Date getData_coletas() {
        return data_coletas;
    }

    public void setData_coletas(Date data_coletas) {
        this.data_coletas = data_coletas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public int getSaldo_coletas() {
        return saldo_coletas;
    }

    public void setSaldo_coletas(int saldo_coletas) {
        this.saldo_coletas = saldo_coletas;
    }

    
    
}
