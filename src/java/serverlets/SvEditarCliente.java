
package serverlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controladora;


@WebServlet(name = "SvEditarCliente", urlPatterns = {"/SvEditarCliente"})
public class SvEditarCliente extends HttpServlet {
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
        int id = Integer.parseInt(request.getParameter("idAEdtarCliente"));
        Cliente cliente = control.obtenerCliente(id);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("cliente", cliente);
        
        response.sendRedirect("modificarCliente.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
