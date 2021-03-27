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
public class Itens {
    
    private int id_itens;
    private Coletas coletas;
    private Produtos produtos;
    private double quant_itens;

    public int getId_itens() {
        return id_itens;
    }

    public void setId_itens(int id_itens) {
        this.id_itens = id_itens;
    }

    public Coletas getColetas() {
        return coletas;
    }

    public void setColetas(Coletas coletas) {
        this.coletas = coletas;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public double getQuant_itens() {
        return quant_itens;
    }

    public void setQuant_itens(double quant_itens) {
        this.quant_itens = quant_itens;
    }

    
}
