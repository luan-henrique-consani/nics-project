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
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author Senai
 */
public class UsuarioDAO {

    public int logar(Usuario usuario) {
        int idUsuario = 0;

        try {

            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareCall("SELECT id_usuario FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            rs = stmt.executeQuery();

            if (rs.next()) {
                idUsuario = rs.getInt("id_usuario");
                System.out.println("DAO: " + usuario.getIdUsuario());
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idUsuario;
    }

    public void create(Usuario usuario) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareCall("INSERT INTO usuario(nome, senha, email, telefone, cpf) VALUES (?,?,?,?,?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getCpf());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            System.out.println("deu certo");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario leia(int id) {
        Usuario usuario = new Usuario();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {    
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCpf(rs.getString("cpf"));
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
        public List<Usuario> leia2() {
        List<Usuario> usuario = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            while (rs.next()) {   
                Usuario usu = new Usuario();
                usu.setIdUsuario(rs.getInt("id_usuario"));
                usu.setNome(rs.getString("nome"));
                usu.setSenha(rs.getString("senha"));
                usu.setTelefone(rs.getString("telefone"));
                usu.setCpf(rs.getString("cpf"));
                usuario.add(usu);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

}
