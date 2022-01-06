
package serverlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Venta;

@WebServlet(name = "SvEditarVenta", urlPatterns = {"/SvEditarVenta"})
public class SvEditarVenta extends HttpServlet {
Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idAEditarVenta"));
        
        Venta ventaAEditar = control.obtenerVenta(id);
        
        HttpSession miSesion = request.getSession();
        
        miSesion.setAttribute("venta", ventaAEditar);
        if (ventaAEditar.getPaquete() == null) {        
            response.sendRedirect("modificarVenta.jsp");
        }else{
            response.sendRedirect("modificarVentaPaquete.jsp");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
