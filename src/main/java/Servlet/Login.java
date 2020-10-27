package Servlet;

import Servicios.ServiciosProductos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        iniciaSesion(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        iniciaSesion(request, response);
    }

    private void iniciaSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* String usuarioRecibido = request.getParameter("usuario");

        var usuario = (String)request.getSession().getAttribute(usuarioRecibido);

        if (usuario !=null )
            response.getWriter().println(usuario);
        else
            response.getWriter().println("error");*/
        var sesion = request.getSession();
        String user, pass;
        user = request.getParameter("usuario");
        pass = request.getParameter("contrasena");

        if(user.equals("admin") && pass.equals("admin") && sesion.getAttribute("usuario") == null){
             ServiciosProductos sp = new ServiciosProductos();
            request.setAttribute("productos", sp.dameProductos());

            request.getRequestDispatcher("Jsp/productos.jsp").forward(request, response);
        }else{

            request.getRequestDispatcher("Jsp/error.jsp").forward(request, response);
        }



    }
}
