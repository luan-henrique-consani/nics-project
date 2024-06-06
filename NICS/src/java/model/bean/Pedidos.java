/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Base64;
import java.util.Date;

/**
 *
 * @author Senai
 */
public class Pedidos {

    private int idPedidos;
    private float valor;
    private int fkUsuario;
    private int fkProdutos;
    private int fkEnderecos;
    private Date dataCompra;
    private String rua;
    private int numero;
    private byte[] imagem;
    private String nome;

    public Pedidos() {
    }

    public String getImgBase64() {
        if (imagem != null) {
            return Base64.getEncoder().encodeToString(imagem);
        } else {
            return "";
        }
    }

    public Pedidos(int idPedidos, float valor, int fkUsuario, int fkProdutos, int fkEnderecos, Date dataCompra, String rua, int numero, byte[] imagem, String nome) {
        this.idPedidos = idPedidos;
        this.valor = valor;
        this.fkUsuario = fkUsuario;
        this.fkProdutos = fkProdutos;
        this.fkEnderecos = fkEnderecos;
        this.dataCompra = dataCompra;
        this.rua = rua;
        this.numero = numero;
        this.imagem = imagem;
        this.nome = nome;
    }

    public int getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(int idPedidos) {
        this.idPedidos = idPedidos;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkProdutos() {
        return fkProdutos;
    }

    public void setFkProdutos(int fkProdutos) {
        this.fkProdutos = fkProdutos;
    }

    public int getFkEnderecos() {
        return fkEnderecos;
    }

    public void setFkEnderecos(int fkEnderecos) {
        this.fkEnderecos = fkEnderecos;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
