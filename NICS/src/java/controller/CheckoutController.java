
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
import model.DAO.CarrinhoDAO;
import model.DAO.CategoriaDAO;
import model.DAO.UsuarioDAO;
import model.bean.Carrinho;
import model.bean.Categoria;
import model.bean.Usuario;

/**
 *
 * @author Luan
 */
public class CheckoutController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "/WEB-INF/jsp/checkout.jsp";
        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginManter")) {

                usuario = usuarioDao.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
            }
        }
        int usu = Integer.parseInt(request.getParameter("id"));
        CategoriaDAO categoria = new CategoriaDAO();
        List<Categoria> categorias = categoria.leia();
        request.setAttribute("categoria", categorias);
        CarrinhoDAO carrinho = new CarrinhoDAO();
        List<Carrinho> carrinhos = carrinho.ler2(usu);
        request.setAttribute("carrinho", carrinhos);
        List<Carrinho> carrinhos2 = carrinho.ler3(usu);
        request.setAttribute("carrinho2", carrinhos2);
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
