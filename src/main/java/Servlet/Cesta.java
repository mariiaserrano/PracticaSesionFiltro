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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Cesta", urlPatterns = {"/cesta"})
public class Cesta extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hazalgo(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hazalgo(request, response);
    }


    private void hazalgo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] productosComprados = request.getParameterValues(Constantes.PRODUCTO_COMPRADO);
        String mensaje = "No se añadio ningun articulo a la cesta ";
        ArrayList<Producto> productosEnCesta = (ArrayList<Producto>) request.getSession().getAttribute("productoComprado");
        ServiciosProductos sp = new ServiciosProductos();
        if (productosEnCesta == null) {
            if (productosComprados != null) {

                List<Producto> productosAnadidos = sp.anadirArticulo(productosComprados);

                request.getSession().setAttribute(Constantes.PRODUCTO_COMPRADO, productosAnadidos);

                request.getRequestDispatcher(Constantes.JSP_CESTA_JSP).forward(request, response);
            } else {
                request.setAttribute(Constantes.MENSAJE, mensaje);
                request.getRequestDispatcher(Constantes.JSP_MENSAJE_ERROR_JSP).forward(request, response);
            }


        } else {
            if (productosComprados != null) {
                List<Producto> nuevosProductos = sp.anadirArticulo(productosComprados);
                for (Producto prod : nuevosProductos) {
                    productosEnCesta.add(prod);
                }

            }
            request.getSession().setAttribute(Constantes.PRODUCTO_COMPRADO, productosEnCesta);
            request.getRequestDispatcher(Constantes.JSP_CESTA_JSP).forward(request, response);

        }

    }
}



