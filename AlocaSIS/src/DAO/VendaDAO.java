/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import model.Venda;

/**
 *
 * @author Sigma development
 */
public class VendaDAO {
    public boolean cadastrarVenda(Venda v) {
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO venda (formaPagamento, desconto, valorTotal,cpf,chassi)VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;
        try{
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, v.getFormaPagamento());
            stmt.setDouble(2, v.getDesconto());
            stmt.setDouble(3, v.getValorTotal());
            stmt.setString(4, v.getCpf());
            stmt.setString(5, v.getChassi());
            stmt.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.out.println("Exceção: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnetion(con, stmt);
        }
    }
}
