/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.CategoriaDAO;
import model.DAO.ProdutosDAO;
import model.bean.Categoria;
import model.bean.Produtos;
import model.bean.Usuario;

/**
 *
 * @author Senai
 */
public class ProdutoUnicoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO categoria = new CategoriaDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        List<Categoria> categorias = categoria.leia();
        request.setAttribute("categoria", categorias);
        ProdutosDAO produto = new ProdutosDAO();
        List<Produtos> produtos = produto.leia3(id);
        request.setAttribute("produto", produtos);
        String nextPage = "/WEB-INF/jsp/prtuni.jsp";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("usuario")) {
                System.out.println(cookie.getValue());
            }
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
