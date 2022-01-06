
package serverlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controladora;
import logica.Empleado;
import logica.Servicio;
import logica.Usuario;


@WebServlet(name = "SvServicioVenta", urlPatterns = {"/SvServicioVenta"})
public class SvServicioVenta extends HttpServlet {
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
        String dniCliente = request.getParameter("dni");
        String metodoDePago = request.getParameter("metodoDePago");
        String service = request.getParameter("servicioListaHidden");
        String fechaVenta = request.getParameter("fechaVenta");
        
        Cliente cli = new Cliente();
        Empleado emple = new Empleado();
        Usuario us = new Usuario();
        Servicio serv = new Servicio();
        
        HttpSession miSesion=request.getSession(); 
        String usu=(String) miSesion.getAttribute("user"); 
        String pass=(String) miSesion.getAttribute("pass"); 
        
        List<Usuario> usuarios = control.obtenerUsuarios();
        List<Cliente> clientes = control.obtenerClientes();
        List<Empleado> empleados = control.obtenerEmpleados();
        List<Servicio> servicios = control.obtenerServicios();
        
        
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dniCliente)) {
                cli=cliente;               
                break;
            }
        }
        
            miSesion.setAttribute("clienteNombre", cli.getNombre());
        
        
        
        for (Usuario usuario : usuarios) {
            if (usuario.getCuenta().equals(usu) && usuario.getPassword().equals(pass)) {
                
                us= usuario;
            }
        }
        
        
        
        for (Empleado empleado : empleados) {
            
            if (empleado.getUser().getId() == us.getId()) {
                emple = empleado;
            }
            
        }
        
        
        
        
        for (Servicio servicio1 : servicios) {
            if (servicio1.getNombreServ().equals(service)) {
                serv = servicio1;
            }
        }
        
        
        miSesion.setAttribute("pagoMetodo", metodoDePago);
        
        
        control.crearVenta(emple, cli, metodoDePago, serv, fechaVenta);
        
        response.sendRedirect("confirmacionVentaServicio.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
