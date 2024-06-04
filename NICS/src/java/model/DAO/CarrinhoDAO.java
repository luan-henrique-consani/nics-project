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
import model.bean.Carrinho;


/**
 *
 * @author Luan
 */
public class CarrinhoDAO {
    
        public void create(Carrinho carrinho) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareCall("INSERT INTO carrinho(fk_produto, fk_usuario, quantidade) VALUES(?,?,?)");
            stmt.setInt(1, carrinho.getFkProduto());
            stmt.setInt(2, carrinho.getFkUsuario());
            stmt.setInt(3, carrinho.getQuantidade());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            System.out.println("deu certo");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
