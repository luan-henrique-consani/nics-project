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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.CategoriaDAO;
import model.DAO.ProdutosDAO;
import model.DAO.UsuarioDAO;
import model.bean.Categoria;
import model.bean.Produtos;
import model.bean.Usuario;

@WebServlet(urlPatterns = "/achar")
@MultipartConfig
public class IndexController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginManter")) {

                usuario = usuarioDao.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
            }
        }
        CategoriaDAO categoria = new CategoriaDAO();
        List<Categoria> categorias = categoria.leia();
        request.setAttribute("categoria", categorias);
        ProdutosDAO produto = new ProdutosDAO();
        List<Produtos> produtos = produto.leia();
        request.setAttribute("produto", produtos);
        String nextPage = "/WEB-INF/jsp/index.jsp";

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
        String action = request.getServletPath();
        if (action.equals("/achar")) {
            achar(request, response);
        } else {
            processRequest(request, response);
        }
    }

    protected void achar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO categoria = new CategoriaDAO();
        List<Categoria> categorias = categoria.leia();
        request.setAttribute("categoria", categorias);
        String pesquisar = request.getParameter("pesquisar");
        System.out.println(request.getParameter("pesquisar"));
        ProdutosDAO produto = new ProdutosDAO();
        List<Produtos> produtos = produto.leia4(pesquisar);
        request.setAttribute("produto", produtos);
        String url = "/WEB-INF/jsp/pesquisar.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
