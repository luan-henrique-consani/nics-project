/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Enderecos;

/**
 *
 * @author Luan
 */
public class EnderecosDAO {
        public void create(Enderecos endereco) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareCall("INSERT INTO endereco(rua, numero, bairro, estado, cep) VALUES (?,?,?,?,?)");
            stmt.setString(1, endereco.getRua());
            stmt.setInt(2, endereco.getNumero());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getEstado());
            stmt.setString(5, endereco.getCep());
            stmt.executeUpdate();


            stmt.close();
            conexao.close();
            System.out.println("deu certo");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}