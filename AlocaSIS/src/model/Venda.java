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
    private String servicosAdicionais;
    private double desconto;
    private double valorTotal;
    private int chassi;

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getServicosAdicionais() {
        return servicosAdicionais;
    }

    public void setServicosAdicionais(String servicosAdicionais) {
        this.servicosAdicionais = servicosAdicionais;
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

    public int getChassi() {
        return chassi;
    }

    public void setChassi(int chassi) {
        this.chassi = chassi;
    }
    
    
}
