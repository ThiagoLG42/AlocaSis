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
public class Gerente extends Usuario {
    private String senhaExtra;

    public String getSenhaExtra() {
        return senhaExtra;
    }

    public void setSenhaExtra(String senhaExtra) {
        this.senhaExtra = senhaExtra;
    }
    
}
