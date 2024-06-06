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
import model.bean.Carrinho;
import model.bean.Produtos;
import model.bean.Usuario;

/**
 *
 * @author Luan
 */
public class CarrinhoDAO {

    public void create(Carrinho carrinho) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareCall("INSERT INTO carrinho(fk_produto, fk_usuario, quantidade, preco) VALUES(?,?,?,?)");
            stmt.setInt(1, carrinho.getFkProduto());
            stmt.setInt(2, carrinho.getFkUsuario());
            stmt.setInt(3, carrinho.getQuantidade());
            stmt.setFloat(4, carrinho.getPreco());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            System.out.println("deu certo");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Carrinho> ler2(int id) {
        List<Carrinho> carrinho = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareCall("SELECT\n"
                    + "    c.id_carrinho,\n"
                    + "    u.nome AS nome_usuario,\n"
                    + "    p.nome_produtos AS nome_produtos,\n"
                    + "    p.imagem,\n"
                    + "    c.quantidade,\n"
                    + "    c.preco\n"
                    + "FROM\n"
                    + "    carrinho c\n"
                    + "    INNER JOIN usuario u ON c.fk_usuario = u.id_usuario\n"
                    + "    INNER JOIN produtos p ON c.fk_produto = p.id_produtos where u.id_usuario = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Carrinho cro = new Carrinho();

                cro.setIdCarrinho(rs.getInt("id_carrinho"));
                cro.setQuantidade(rs.getInt("quantidade"));
                cro.setPreco(rs.getFloat("preco"));
                cro.setNome(rs.getString("nome_usuario"));
                cro.setNomeProdutos(rs.getString("nome_produtos"));
                cro.setImagem(rs.getBytes("imagem"));

                carrinho.add(cro);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrinho;
    }

    public List<Carrinho> ler3(int id) {
        List<Carrinho> carrinho = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareCall("SELECT SUM(p.preco * c.quantidade) AS total FROM produtos p INNER JOIN carrinho c ON p.id_produtos = c.fk_produto INNER JOIN usuario u ON c.fk_usuario = u.id_usuario where u.id_usuario = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Carrinho cro = new Carrinho();
                cro.setPreco(rs.getFloat("total"));

                carrinho.add(cro);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrinho;
    }

}
