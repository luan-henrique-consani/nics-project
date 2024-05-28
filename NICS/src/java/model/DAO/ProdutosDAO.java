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
import model.bean.Estoque;
import model.bean.Produtos;

/**
 *
 * @author Senai
 */
public class ProdutosDAO {
    
    
    
    public void create(Produtos produtos, Estoque estoque){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareCall("CALL insert_dois(?,?,?,?,?,?)");
            stmt.setString(1, produtos.getNomeProdutos());
            stmt.setInt(2, produtos.getCategoria());
            stmt.setBytes(3, produtos.getImagem());
            stmt.setInt(4, estoque.getQuantidade());
            stmt.setFloat(5, produtos.getPreco());
            stmt.setString(6, estoque.getVariacao());
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            System.out.println("deu certo");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
