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
import model.DAO.CarrinhoDAO;
import model.DAO.CategoriaDAO;
import model.DAO.EstoqueDAO;
import model.DAO.ProdutosDAO;
import model.DAO.UsuarioDAO;
import model.bean.Carrinho;
import model.bean.Categoria;
import model.bean.Estoque;
import model.bean.Produtos;
import model.bean.Usuario;

/**
 *
 * @author Senai
 */
@WebServlet(urlPatterns = "/colocar-carrinho")
@MultipartConfig
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
        EstoqueDAO estoque = new EstoqueDAO();
        List<Estoque> estoques = estoque.leia();
        request.setAttribute("estoque", estoques);
        String nextPage = "/WEB-INF/jsp/prtuni.jsp";
        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginManter")) {

                usuario = usuarioDao.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
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
        String action = request.getServletPath();
        if (action.equals("/colocar-carrinho")) {
            carrinho(request, response);
        } else {
            processRequest(request, response);
        }
    }

    protected void carrinho(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Carrinho carrinho = new Carrinho();
        CarrinhoDAO carrinhoDao = new CarrinhoDAO();
        String id = request.getParameter("fk_usuario");
        System.out.println(id);
        if (id.trim().equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Por favor, faça o login.');");
            out.println("window.location.href = './logar-usu';");
            out.println("</script>");


        } else {
            int id2 = Integer.parseInt(id);
            if (id2 > 0) {
                carrinho.setFkProduto(Integer.parseInt(request.getParameter("fk_produto")));
                carrinho.setFkUsuario(Integer.parseInt(request.getParameter("fk_usuario")));
                carrinho.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                carrinho.setPreco(Float.parseFloat(request.getParameter("preco")));
                carrinhoDao.create(carrinho);
                response.sendRedirect("./home");
            }
        }

    }

}
