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
import model.DAO.EnderecosDAO;
import model.DAO.UsuarioDAO;
import model.bean.Enderecos;
import model.bean.Usuario;

/**
 *
 * @author Senai
 */
@WebServlet(urlPatterns = "/criar-endereco")
@MultipartConfig
public class EnderecosController extends HttpServlet {

    Enderecos enderecos = new Enderecos();
    EnderecosDAO enderecosDao = new EnderecosDAO();
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDao = new UsuarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "/WEB-INF/jsp/cadEndereco.jsp";

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
        if (action.equals("/criar-endereco")) {
            end(request, response);
        } else {
            processRequest(request, response);
        }
    }

    protected void end(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        enderecos.setRua(request.getParameter("rua"));
        enderecos.setNumero(Integer.parseInt(request.getParameter("numero")));
        enderecos.setBairro(request.getParameter("bairro"));
        enderecos.setEstado(request.getParameter("estado"));
        enderecos.setCep(request.getParameter("cep"));
        usuario.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
        if (enderecos.getRua().trim().equals("") || enderecos.getBairro().trim().equals("") || enderecos.getEstado().trim().equals("") || enderecos.getCep().trim().equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Por favor, preencha todos os campos.');");
            out.println("window.location.href = './cad-usu';");
            out.println("</script>");
        } else {
            enderecosDao.create(enderecos,usuario);
            response.sendRedirect("./logar-usu");
        }

    }

}
