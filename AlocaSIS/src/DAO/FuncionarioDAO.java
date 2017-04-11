/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import model.Funcionario;

/**
 *
 * @author Sigma development
 */
public class FuncionarioDAO {
    public boolean cadastrarCliente(Funcionario f){
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO cliente (nome, email, CPF, telefone, RG, endereco,login, senha, numeroPIS) VALUES ?,?,?,?,?,?,?,?,?";
        PreparedStatement stmt = null;
        try{
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getEmail());
            stmt.setInt(3, f.getCpf());
            stmt.setString(4, f.getTelefone());
            stmt.setInt(5, f.getRg());
            stmt.setString(6, f.getEndereco());
            stmt.setString(7, f.getLogin());
            stmt.setString(8, f.getSenha());
            stmt.setInt(9, f.getNumeroPIS());
            stmt.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.out.println("Exceção: "+ ex);
            return false;
        }finally{
            ConnectionFactory.closeConnetion(con, stmt);
        }
        
        
        
    }
}
