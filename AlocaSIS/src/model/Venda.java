/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sigma development
 */
public class Venda {
    private String formaPagamento;
    private double desconto;
    private double valorTotal;
    private String chassi;
    private String cpf;

    public Venda(String formaPagamento, double desconto, double valorTotal, String chassi, String cpf) {
        this.formaPagamento = formaPagamento;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
        this.chassi = chassi;
        this.cpf = cpf;
    }

    public Venda() {
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    
    
}
