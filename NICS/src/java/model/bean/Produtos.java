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
public class Produtos {
    private int idProdutos;
    private int categoria;
    private String nomeProdutos;
    private byte[] imagem;
    private float preco;
    private int quantidade;

    public Produtos() {
    }

    public Produtos(int idProdutos, int categoria, String nomeProdutos, byte[] imagem, float preco, int quantidade) {
        this.idProdutos = idProdutos;
        this.categoria = categoria;
        this.nomeProdutos = nomeProdutos;
        this.imagem = imagem;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNomeProdutos() {
        return nomeProdutos;
    }

    public void setNomeProdutos(String nomeProdutos) {
        this.nomeProdutos = nomeProdutos;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
