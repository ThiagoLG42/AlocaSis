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
import model.Funcionario;

/**
 *
 * @author Sigma development
 */
public class FuncionarioDAO {

    public boolean cadastrarFuncionario(Funcionario f) {
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO funcionario VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, f.getCpf());
            stmt.setString(2, f.getNumeroPIS());
            stmt.setString(3, f.getNome());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getTelefone());
            stmt.setString(6, f.getRg());
            stmt.setString(7, f.getEndereco());
            stmt.setString(8, f.getLogin());
            stmt.setString(9, f.getSenha());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnetion(con, stmt);
        }
    }

    public boolean alterarFuncionario(Funcionario f) {
        Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE funcionario SET cpf = ?, numeroPIS = ?, nome = ?, email = ?, telefone = ?,"
                + "rg = ?, endereco = ?, login = ?, senha = ? WHERE cpf = ?";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, f.getCpf());
            stmt.setString(2, f.getNumeroPIS());
            stmt.setString(3, f.getNome());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getTelefone());
            stmt.setString(6, f.getRg());
            stmt.setString(7, f.getEndereco());
            stmt.setString(8, f.getLogin());
            stmt.setString(9, f.getSenha());
            stmt.setString(10, f.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnetion(con, stmt);
        }

    }

    public boolean excluirFuncionario(Funcionario f) {
        Connection con = ConnectionFactory.getConnection();
        String sql = "DELETE FROM funcionario WHERE cpf = ?";
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, f.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Exceção: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnetion(con, stmt);
        }

    }

    public List BuscarFuncionario() {
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> list = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setCpf(rs.getString(1));
                f.setNumeroPIS(rs.getString(2));
                f.setNome(rs.getString(3));
                f.setEmail(rs.getString(4));
                f.setTelefone(rs.getString(5));
                f.setRg(rs.getString(6));
                f.setEndereco(rs.getString(7));
                f.setLogin(rs.getString(8));

                list.add(f);
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
