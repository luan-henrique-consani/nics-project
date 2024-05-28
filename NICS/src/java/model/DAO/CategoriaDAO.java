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
import model.bean.Categoria;

/**
 *
 * @author Senai
 */
public class CategoriaDAO {
        public List<Categoria> leia() {
        List<Categoria> categoria = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM categorias");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setiCategoria(rs.getInt("id_categoria"));
                cat.setNomeCategoria(rs.getString("nome_categoria"));
                categoria.add(cat);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoria;
    }
    
}
