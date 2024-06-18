/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Conexao {

    private static final String url = "jdbc:mysql://db4free.net:3306/nics_luan?useSSL=false";
    private static final String usuario = "senai_lh26";
    private static final String senha = "luan1234";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, senha);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}