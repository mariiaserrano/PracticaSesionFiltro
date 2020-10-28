package Servlet;

import Model.Usuario;
import Servicios.ServiciosProductos;
import Servicios.ServiciosUsuarios;

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
        String user, pass;
        user = request.getParameter("usuario");
        pass = request.getParameter("contrasena");

        if (user.isEmpty() || user == null) {
            request.getRequestDispatcher("Jsp/error.jsp").forward(request, response);
        }
        if (pass.isEmpty() || pass == null) {
            request.getRequestDispatcher("Jsp/error.jsp").forward(request, response);
        }

        if (serUs.comprobarUsuario(user, pass)) {
            sesion.setAttribute("usuario",user);
            request.getRequestDispatcher("menu.html").forward(request, response);
        }
        else {

            request.getRequestDispatcher("Jsp/error.jsp").forward(request, response);
        }


    }
}
