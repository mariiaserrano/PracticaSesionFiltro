package Servlet;

import Servicios.ServiciosProductos;
import Utils.Constantes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Productos", urlPatterns = {"/productos"})
public class Productos extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
hazalgo(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hazalgo(request,response);
    }

    private void hazalgo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiciosProductos sp = new ServiciosProductos();
        request.setAttribute(Constantes.PRODUCTOS, sp.dameProductos());

        request.getRequestDispatcher("Jsp/productos.jsp").forward(request, response);
    }
}
