
package serverlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Cliente;
import logica.Controladora;


@WebServlet(name = "SvModificarClienteConfirm", urlPatterns = {"/SvModificarClienteConfirm"})
public class SvModificarClienteConfirm extends HttpServlet {
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
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String fechaNac = request.getParameter("fechaNac");
        String domicilio = request.getParameter("domicilio");
        String localidad = request.getParameter("localidad");
        String provincia = request.getParameter("nacionalidad");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        
        Cliente cliAEditar = control.obtenerCliente(id);
        
        cliAEditar.setNombre(nombre);
        cliAEditar.setApellido(apellido);
        cliAEditar.setDni(dni);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
        Date fecha;
        try {
            fecha = formato.parse(fechaNac);
            cliAEditar.setFechaNac(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SvModificarClienteConfirm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cliAEditar.setDireccion(domicilio);
        cliAEditar.setLocalidad(localidad);
        cliAEditar.setProvincia(provincia);
        cliAEditar.setNumTelefono(telefono);
        cliAEditar.setEmail(email);
        
        
        control.editarCliente(cliAEditar);
        
        response.sendRedirect("listaClientes.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
