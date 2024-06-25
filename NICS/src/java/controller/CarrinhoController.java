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
import model.DAO.ProdutosDAO;
import model.DAO.UsuarioDAO;
import model.bean.Carrinho;
import model.bean.Categoria;
import model.bean.Produtos;
import model.bean.Usuario;

/**
 *
 * @author Luan
 */
@WebServlet(urlPatterns = {"/deletar"})
@MultipartConfig
public class CarrinhoController extends HttpServlet {

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

        String parametro = request.getParameter("id");
        if (parametro != null) {
            int usu = Integer.parseInt(parametro);
            CategoriaDAO categoria = new CategoriaDAO();
            List<Categoria> categorias = categoria.leia();
            request.setAttribute("categoria", categorias);
            CarrinhoDAO carrinho = new CarrinhoDAO();
            List<Carrinho> carrinhos = carrinho.ler2(usu);
            request.setAttribute("carrinho", carrinhos);
            List<Carrinho> carrinhos2 = carrinho.ler3(usu);
            request.setAttribute("carrinho2", carrinhos2);
        }else{
            
        }

        String nextPage = "/WEB-INF/jsp/carrinho.jsp";
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
        if (action.equals("/deletar")) {
            deletar(request, response);
        }
    }

    protected void deletar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCarrinho = Integer.parseInt(request.getParameter("idCarrinho"));
        CarrinhoDAO carrinhoDao = new CarrinhoDAO();
        carrinhoDao.delete(idCarrinho);
        response.sendRedirect("./home");
    }
}
