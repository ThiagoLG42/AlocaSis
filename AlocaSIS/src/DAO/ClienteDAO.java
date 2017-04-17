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

/**
 *
 * @author Sigma development
 */
public class ClienteDAO {
     public boolean cadastrarCliente(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO cliente VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getCpf());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getRg());
            stmt.setString(6, c.getCidade());
            stmt.setString(7, c.getEstado());
            stmt.setString(8, c.getCnh());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnetion(con, stmt);
        }
    }

    public boolean alterarCliente(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE cliente SET cpf = ?, numeroPIS = ?, nome = ?, email = ?, telefone = ?,"
                + "rg = ?, endereco = ?, login = ?, senha = ? WHERE cpf = ?";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getCpf());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getRg());
            stmt.setString(6, c.getCidade());
            stmt.setString(7, c.getEstado());
            stmt.setString(8, c.getCnh());
            stmt.setString(9, c.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnetion(con, stmt);
        }

    }

    public boolean excluirCliente(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        String sql = "DELETE FROM cliente WHERE cpf = ?";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, c.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnetion(con, stmt);
        }

    }

    public List buscarCliente() {
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM cliente";
        List<Cliente> list = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNome(rs.getString(1));
                c.setEmail(rs.getString(2));
                c.setCpf(rs.getString(3));
                c.setTelefone(rs.getString(4));
                c.setRg(rs.getString(5));
                c.setCidade(rs.getString(6));
                c.setEstado(rs.getString(7));
                c.setCnh(rs.getString(8));

                list.add(c);
            }
            return list;

        } catch (SQLException ex) {
            System.out.println("Exceção: " + ex);
            return null;
        } finally {
            ConnectionFactory.closeConnetion(con, stmt);
        }

    }
}
