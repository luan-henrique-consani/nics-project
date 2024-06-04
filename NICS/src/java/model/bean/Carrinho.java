/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Luan
 */
public class Carrinho {
    private int idCarrinho;
    private int fkUsuario;
    private int fkProduto;
    private int quantidade;

    public Carrinho() {
    }

    public Carrinho(int idCarrinho, int fkUsuario, int fkProduto, int quantidade) {
        this.idCarrinho = idCarrinho;
        this.fkUsuario = fkUsuario;
        this.fkProduto = fkProduto;
        this.quantidade = quantidade;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(int fkProduto) {
        this.fkProduto = fkProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
