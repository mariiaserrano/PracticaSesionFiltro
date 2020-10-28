package Servlet;

import Model.Usuario;
import Servicios.ServiciosProductos;
import Servicios.ServiciosUsuarios;
import Utils.Constantes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        iniciaSesion(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        iniciaSesion(request, response);
    }

    private void iniciaSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiciosUsuarios serUs = new ServiciosUsuarios();
        var sesion = request.getSession();
        String user = request.getParameter(Constantes.USUARIO);
        String pass = request.getParameter(Constantes.CONTRASENA);

        if (user == null || user.isEmpty()) {
            request.getRequestDispatcher(Constantes.JSP_ERROR_JSP).forward(request, response);
        }
        if (pass == null || pass.isEmpty()) {
            request.getRequestDispatcher(Constantes.JSP_ERROR_JSP).forward(request, response);
        }

        if (serUs.comprobarUsuario(user, pass)) {
            sesion.setAttribute(Constantes.USUARIO, user);
            request.getRequestDispatcher("menu.html").forward(request, response);
        } else {

            request.getRequestDispatcher(Constantes.JSP_ERROR_JSP).forward(request, response);
        }


    }
}
