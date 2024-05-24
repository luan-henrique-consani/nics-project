/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Senai
 */
public class Categoria {
    private int iCategoria;
    private String nomeCategoria;

    public Categoria() {
    }

    public Categoria(int iCategoria, String nomeCategoria) {
        this.iCategoria = iCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public int getiCategoria() {
        return iCategoria;
    }

    public void setiCategoria(int iCategoria) {
        this.iCategoria = iCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    
    
    
}
