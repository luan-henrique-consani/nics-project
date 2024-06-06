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
public class Enderecos {
    private int idEnderecos;
    private String rua;
    private int numero;
    private String bairro;
    private String estado;
    private String cep;

    public Enderecos() {
    }

    public Enderecos(int idEnderecos, String rua, int numero, String bairro, String estado, String cep) {
        this.idEnderecos = idEnderecos;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.estado = estado;
        this.cep = cep;
    }

    public int getIdEnderecos() {
        return idEnderecos;
    }

    public void setIdEnderecos(int idEnderecos) {
        this.idEnderecos = idEnderecos;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
}
