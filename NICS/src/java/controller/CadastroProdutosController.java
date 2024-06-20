/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.DAO.CategoriaDAO;
import model.DAO.ProdutosDAO;
import model.bean.Categoria;
import model.bean.Estoque;
import model.bean.Produtos;
import model.bean.Usuario;

/**
 *
 * @author Senai
 */
@WebServlet(urlPatterns = "/criar")
@MultipartConfig
public class CadastroProdutosController extends HttpServlet {

    Produtos objProdutos = new Produtos();
    ProdutosDAO objProdutosDao = new ProdutosDAO();
    Estoque objEstoque = new Estoque();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO categoria = new CategoriaDAO();
        List<Categoria> categorias = categoria.leia();
        request.setAttribute("categoria", categorias);
        String nextPage = "/WEB-INF/jsp/adm.jsp";
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
        if (action.equals("/criar")) {
            produtos(request, response);
        } else {

        }
    }

    protected void produtos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Part filePart = request.getPart("imagem");
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] imageBytes = outputStream.toByteArray();
        objProdutos.setNomeProdutos(request.getParameter("nome"));
        objProdutos.setCategoria(Integer.parseInt(request.getParameter("cat")));
        objProdutos.setImagem(imageBytes);
        objProdutos.setPreco(Float.parseFloat(request.getParameter("preco")));
        objEstoque.setQuantidade(Integer.parseInt(request.getParameter("qtd")));
        objEstoque.setVariacao(request.getParameter("var"));
        objProdutosDao.create(objProdutos, objEstoque);
        response.sendRedirect("./cad-prt");
        

    }

}
