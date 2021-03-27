/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.coletaTech.Model.DAO;

import br.com.coletaTech.Conection.ConnectionFactory;
import br.com.coletaTech.Model.Bean.Itens;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wesley
 */
public class ItensColetasDAO {
    
    private Connection con = null;
    
    public ItensColetasDAO() {
      con = ConnectionFactory.getConnection();
    }
    
        public boolean gravarItensColetas( Itens itens){
            
        String sql = "INSERT INTO TB_ITENS (produto_itens, quantidade_itens, coleta_itens) VALUES (?, ?, ?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, itens.getProdutos().getId_produtos());
            stmt.setFloat(2, (float) itens.getQuant_itens());
            stmt.setInt(3, itens.getColetas().getId_coletas());
            
            System.out.println("Gravando itens no final");
            System.out.println("Produto: "+ itens.getProdutos().getId_produtos());
            System.out.println("Quantidade: "+itens.getQuant_itens());
            System.out.println("Coleta: "+ itens.getColetas().getId_coletas());
            stmt.executeUpdate();
            
            System.out.println("Item Salvo com sucesso!");
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ItensColetasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
      }
    
}
