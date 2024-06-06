/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Base64;

/**
 *
 * @author Luan
 */
public class Carrinho {

    private int idCarrinho;
    private int fkUsuario;
    private int fkProduto;
    private float preco;
    private int quantidade;
    private String nomeProdutos;
    private byte[] imagem;
    private String nome;

    public Carrinho() {
    }

    public String getImgBase64() {
        if (imagem != null) {
            return Base64.getEncoder().encodeToString(imagem);
        } else {
            return "";
        }
    }

    public Carrinho(int idCarrinho, int fkUsuario, int fkProduto, float preco, int quantidade, String nomeProdutos, byte[] imagem, String nome) {
        this.idCarrinho = idCarrinho;
        this.fkUsuario = fkUsuario;
        this.fkProduto = fkProduto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.nomeProdutos = nomeProdutos;
        this.imagem = imagem;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
