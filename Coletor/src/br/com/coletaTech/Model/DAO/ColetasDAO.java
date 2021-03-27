/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.coletaTech.Model.DAO;

import br.com.coletaTech.Conection.ConnectionFactory;
import br.com.coletaTech.Model.Bean.Coletas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author wesley
 */
public class ColetasDAO {
    
    //public int IDAtual;
    
    private Connection con = null;
    
    public ColetasDAO() {
      con = ConnectionFactory.getConnection();
    }
    
     
    public boolean gravarColetas(Coletas coletas){
        int novoId = 0;
        String sql = "INSERT INTO TB_COLETAS (DATA_COLETAS, USUARIO_COLETAS, SALDO_COLETAS) VALUES (now(), ?, ?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, coletas.getUsuario().getId_usuarios());
            stmt.setFloat(2,coletas.getSaldo_coletas());
            stmt.executeUpdate();
            
            ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (resultSet.next()) {
               novoId = resultSet.getInt("LAST_INSERT_ID()");
            }
            
            System.out.println("Salvo com sucesso! Novo ID: "+novoId);
            //IDAtual = novoId;
            
            coletas.setId_coletas(novoId);
            
            return true;
            
        } catch (SQLException ex){
            System.err.println("Error: "+ex);
            return false;
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}
