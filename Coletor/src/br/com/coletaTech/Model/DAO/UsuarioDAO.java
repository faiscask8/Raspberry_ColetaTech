/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.coletaTech.Model.DAO;

import br.com.coletaTech.Conection.ConnectionFactory;
import br.com.coletaTech.Model.Bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wesley
 */


public class UsuarioDAO {
    
public static String usuarioLogado;

public static int id_usuarioLogado; 

public boolean checkLogin(String login, String senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
                
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_usuarios WHERE CPF_USUARIOS = ? and SENHA_USUARIOS = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
               
                check = true;
                Usuario usuario = new Usuario();
                
                usuario.setNome_usuarios(rs.getString("NOME_USUARIOS"));
                usuario.setId_usuarios(rs.getInt("ID_USUARIOS"));
                usuario.setCpf_usuarios(rs.getString("CPF_USUARIOS"));                
              
                System.out.println("usuario nome: "+usuario.getNome_usuarios());
                
                id_usuarioLogado = usuario.getId_usuarios();
                usuarioLogado = usuario.getNome_usuarios();
                
            }
            
        } catch (SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return check;
    }
}
