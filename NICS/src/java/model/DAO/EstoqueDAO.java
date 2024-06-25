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

/**
 *
 * @author Luan
 */
public class EstoqueDAO {

    public List<Estoque> leia() {
        List<Estoque> estoque = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM estoque");
            rs = stmt.executeQuery();
            if (rs.next()) {
                Estoque est = new Estoque();
                est.setIdEstoque(rs.getInt("id_estoque"));
                est.setFkProdutos(rs.getInt("fk_produtos"));
                est.setQuantidade(rs.getInt("quantidade"));
                est.setVariacao(rs.getString("variacao"));
                estoque.add(est);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estoque;
    }

    public List<Estoque> leia2() {
        List<Estoque> estoque = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM estoque");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque est = new Estoque();
                est.setIdEstoque(rs.getInt("id_estoque"));
                est.setFkProdutos(rs.getInt("fk_produtos"));
                est.setQuantidade(rs.getInt("quantidade"));
                est.setVariacao(rs.getString("variacao"));
                estoque.add(est);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estoque;
    }

}
