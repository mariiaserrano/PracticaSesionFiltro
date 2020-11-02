package Servlet;

import Model.Producto;
import Servicios.ServiciosProductos;
import Utils.Constantes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Opciones", urlPatterns = "/opciones")
public class Opciones extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        opciones(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        opciones(request, response);
    }

    private void opciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        String mensaje = "Compra finalizada";
        ServiciosProductos sp = new ServiciosProductos();
        List<Producto> productoEnCesta = (List<Producto>) request.getSession().getAttribute(Constantes.PRODUCTO_COMPRADO);

        if (op == null || op.equals("")) {
            op = "Error";
        }

        switch (op) {
            case Constantes.ANADIR:
                request.getSession().setAttribute(Constantes.PRODUCTO_COMPRADO, productoEnCesta);
                request.setAttribute(Constantes.PRODUCTOS,sp.dameProductos());
                request.getRequestDispatcher(Constantes.JSP_PRODUCTOS_JSP).forward(request, response);
                break;

            case Constantes.COMPRAR:
                request.getSession().setAttribute(Constantes.PRODUCTO_COMPRADO, null);
                request.setAttribute(Constantes.MENSAJE, mensaje);
                request.getRequestDispatcher("Jsp/mensajeCerrarSesion.jsp").forward(request, response);
                break;

            case "Limpiar":
                request.getSession().setAttribute(Constantes.PRODUCTO_COMPRADO, null);
                request.getRequestDispatcher(Constantes.JSP_CESTA_JSP).forward(request, response);

        }


    }
}

