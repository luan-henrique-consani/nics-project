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
import model.bean.Pedidos;

/**
 *
 * @author Senai
 */
public class PedidosDAO {

    public List<Pedidos> ler2(int id) {
        List<Pedidos> pedidos = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareCall("SELECT\n"
                    + "    pe.id_pedidos,\n"
                    + "    u.nome AS usuario_nome,\n"
                    + "    p.imagem,\n"
                    + "    pe.valor,\n"
                    + "    pe.data_compra,\n"
                    + "    e.rua,\n"
                    + "    e.numero\n"
                    + "FROM\n"
                    + "    pedidos pe\n"
                    + "    INNER JOIN usuario u ON pe.fk_usuario = u.id_usuario\n"
                    + "    INNER JOIN endereco e ON pe.fk_enderecos = e.id_enderecos\n"
                    + "	INNER JOIN produtos p ON pe.fk_produto = p.id_produtos  where u.id_usuario = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pedidos ped = new Pedidos();
                ped.setIdPedidos(rs.getInt("id_pedidos"));
                ped.setNome(rs.getString("usuario_nome"));
                ped.setImagem(rs.getBytes("imagem"));
                ped.setValor(rs.getFloat("valor"));
                ped.setDataCompra(rs.getDate("data_compra"));
                ped.setRua(rs.getString("rua"));
                ped.setNumero(rs.getInt("numero"));

                pedidos.add(ped);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public void create(Pedidos pedidos) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareCall("INSERT INTO pedidos(valor, fk_usuario, fk_produtos, fk_enderecos, data_compra) VALUES(?,?,?,?,now())");
            stmt.setFloat(1, pedidos.getValor());
            stmt.setInt(2, pedidos.getFkUsuario());
            stmt.setInt(3, pedidos.getFkProdutos());
            stmt.setInt(4, pedidos.getFkEnderecos());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            System.out.println("deu certo");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
