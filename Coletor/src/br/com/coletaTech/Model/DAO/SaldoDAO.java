/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.coletaTech.Model.DAO;

import br.com.coletaTech.Conection.ConnectionFactory;
import br.com.coletaTech.Model.Bean.Saldo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author wesley
 */


public class SaldoDAO {
    
    public static long saldo_usuariologado;

    
       public long consultaSaldo( int usuario) throws SQLException{
        
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement stmt = null;
           ResultSet rs = null;

            stmt = con.prepareStatement("SELECT quant_Saldo FROM coletaTech.tb_saldo where usuario_saldo = ?");
            stmt.setInt(1, usuario);
            
            rs = stmt.executeQuery();
               
            if (rs.next()){
                Saldo saldo = new Saldo();
                saldo.setQuant_saldo(rs.getInt("quant_saldo"));
                saldo_usuariologado = saldo.getQuant_saldo();                 
            }         
           
           return saldo_usuariologado;
       }
       
       
      public long atualizaSaldo(int usuario, int saldo) throws SQLException{
          
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement stmt = null;

            stmt = con.prepareStatement("UPDATE coletatech.tb_saldo SET quant_saldo= ? WHERE usuario_saldo = ?");
            stmt.setInt(1, saldo);
            stmt.setInt(2, usuario);  
            System.out.println("Saldo: "+saldo);
            stmt.executeUpdate();
            
            
            System.out.println("Saldo Atualizado com Sucesso!");
        return 0;
          
      } 
 
    
}
