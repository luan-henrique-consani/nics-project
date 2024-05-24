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
public class Estoque {
    private int idEstoque;
    private int fkProdutos;
    private int quantidade;
    private String variacao;

    public Estoque() {
    }

    public Estoque(int idEstoque, int fkProdutos, int quantidade, String variacao) {
        this.idEstoque = idEstoque;
        this.fkProdutos = fkProdutos;
        this.quantidade = quantidade;
        this.variacao = variacao;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getFkProdutos() {
        return fkProdutos;
    }

    public void setFkProdutos(int fkProdutos) {
        this.fkProdutos = fkProdutos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getVariacao() {
        return variacao;
    }

    public void setVariacao(String variacao) {
        this.variacao = variacao;
    }
    
    
    
    
}
