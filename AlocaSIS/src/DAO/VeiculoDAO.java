/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Veiculo;

/**
 *
 * @author Sigma development
 */
public class VeiculoDAO {
    public boolean cadastrarVeiculo(Veiculo v) {
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO veiculo VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getFabricante());
            stmt.setString(3, v.getCor());
            stmt.setInt(4, v.getAno());
            stmt.setDouble(5, v.getPreco());
            stmt.setString(6, v.getChassi());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnetion(con, stmt);
        }
    }
    
    public List buscarVeiculo(String modelo, String chassi) {
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM veiculo WHERE modelo=? OR chassi=?";
        List<Veiculo> list = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, "%"+modelo+"%");
            stmt.setString(2, "%"+chassi+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo v = new Veiculo();
                v.setModelo(rs.getString(1));
                v.setFabricante(rs.getString(2));
                v.setCor(rs.getString(3));
                v.setAno(rs.getInt(4));
                v.setPreco(rs.getDouble(5));
                v.setChassi(rs.getString(6));

                list.add(v);
            }
            return list;

        } catch (SQLException ex) {
            System.out.println("Exceção: " + ex);
            return null;
        } finally {
            ConnectionFactory.closeConnetion(con, stmt);
        }

    }
    public boolean alterarVeiculo(Veiculo v) {
        Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE veiculo SET modelo = ?, fabricante = ?, cor = ?, ano = ?,"
                + "preco = ?, chassi = ? WHERE chassi = ?";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getFabricante());
            stmt.setString(3, v.getCor());
            stmt.setInt(4, v.getAno());
            stmt.setDouble(5, v.getPreco());
            stmt.setString(6, v.getChassi());
            stmt.setString(7, v.getChassi());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnetion(con, stmt);
        }

    }
    public boolean excluirVeiculo(Veiculo v) {
        Connection con = ConnectionFactory.getConnection();
        String sql = "DELETE FROM veiculo WHERE chassi = ?";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, v.getChassi());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnetion(con, stmt);
        }

    }
}
