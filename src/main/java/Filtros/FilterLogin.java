package Filtros;

import Utils.Constantes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterLogin", urlPatterns = {"/cesta", "/productos"})
public class FilterLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
       // String loginURI = request.getContextPath() + "/login";

        boolean loggedIn = session != null && session.getAttribute(Constantes.USUARIO) != null;
       // boolean loginRequest = request.getRequestURI().equals(loginURI);

       if(session != null && session.getAttribute(Constantes.USUARIO)!= null){
           chain.doFilter(request,response);
       }
       else{
           request.getRequestDispatcher(Constantes.JSP_ERROR_JSP).forward(request, response);
       }


        /*if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("Jsp/error.jsp").forward(request, response);
        }*/



       // chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
