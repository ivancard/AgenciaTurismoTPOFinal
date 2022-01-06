
package serverlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;


@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class SvCliente extends HttpServlet {
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
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String domicilio = request.getParameter("domicilio");
        String provincia = request.getParameter("provincia");
        String localidad = request.getParameter("localidad");
        String dni = request.getParameter("dni");
        String fechaNac = request.getParameter("fechaNac");
        String nacionalidad = request.getParameter("nacionalidad");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        
        
        
        
        control.crearCliente(nombre, apellido, domicilio, provincia, localidad, dni, fechaNac, nacionalidad, telefono, email);
        
        response.sendRedirect("confirmacionAltaCliente.jsp");
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
