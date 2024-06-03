/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Estoque;
import model.bean.Produtos;
import model.bean.Usuario;

/**
 *
 * @author Senai
 */
public class ProdutosDAO {

    public void create(Produtos produtos, Estoque estoque) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareCall("call insert_dois(?,?,?,?,?,?)");
            stmt.setString(1, produtos.getNomeProdutos());
            stmt.setInt(2, produtos.getCategoria());
            stmt.setBytes(3, produtos.getImagem());
            stmt.setFloat(4, produtos.getPreco());
            stmt.setInt(5, estoque.getQuantidade());
            stmt.setString(6, estoque.getVariacao());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            System.out.println("deu certo");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public List<Produtos> leia() {
        List<Produtos> produtos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos prt = new Produtos();
                prt.setIdProdutos(rs.getInt("id_produtos0"));
                prt.setNomeProdutos(rs.getString("nome_produtos"));
                prt.setCategoria(rs.getInt("fk_categoria"));
                prt.setImagem(rs.getBytes("imagem"));
                prt.setPreco(rs.getFloat("preco"));
                produtos.add(prt);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}