/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.UsuarioDAO;
import model.bean.Usuario;

/**
 *
 * @author Senai
 */
@WebServlet(urlPatterns = "/log-usu")
@MultipartConfig
public class LogarController extends HttpServlet {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDao = new UsuarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "/WEB-INF/jsp/login.jsp";
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
        if (action.equals("/log-usu")) {
            logar(request, response);
        } else {
            processRequest(request, response);
        }

    }

    protected void logar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login</title>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
        out.println("<link rel=\"stylesheet\" href=\"styles/login.css\">");
        out.println("</head>");
        out.println("<body>");

        if (usuario.getEmail().trim().equals("") || usuario.getSenha().trim().equals("")) {
            out.println("<script>");
            out.println("Swal.fire({");
            out.println("icon: 'error',");
            out.println("title: 'Opa...',");
            out.println("text: 'Por favor, preencha todos os campos!'");
            out.println("}).then(() => {");
            out.println("window.location.href = './logar-usu';");
            out.println("});");
            out.println("</script>");
        } else {
            int idUsuario = usuarioDao.logar(usuario);
            if (idUsuario > 0) {
                Cookie servilet = new Cookie("loginManter", Integer.toString(idUsuario));
                response.addCookie(servilet);
                if (idUsuario == 1) {
                    response.sendRedirect("./cad-prt");
                } else {
                    response.sendRedirect("redirect.jsp");
                }
            } else {
            out.println("<script>");
            out.println("Swal.fire({");
            out.println("icon: 'error',");
            out.println("title: 'Opa...',");
            out.println("text: 'Por favor, faça o cadastro!'");
            out.println("}).then(() => {");
            out.println("window.location.href = './cad-usu';");
            out.println("});");
            out.println("</script>");
            }
        }

        out.println("</body>");
        out.println("</html>");
    }

}
