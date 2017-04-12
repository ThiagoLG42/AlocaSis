package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sigma development
 */
public class Funcionario extends Usuario {
    private String numeroPIS;

    public Funcionario() {
    }

    public Funcionario(String numeroPIS) {
        this.numeroPIS = numeroPIS;
    }

    public String getNumeroPIS() {
        return numeroPIS;
    }

    public void setNumeroPIS(String numeroPIS) {
        this.numeroPIS = numeroPIS;
    }
    
}
