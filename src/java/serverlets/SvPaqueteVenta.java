
package serverlets;

import java.io.IOException;
import java.util.ArrayList;
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
import logica.Paquete;
import logica.Servicio;
import logica.Usuario;


@WebServlet(name = "SvPaqueteVenta", urlPatterns = {"/SvPaqueteVenta"})
public class SvPaqueteVenta extends HttpServlet {
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
        String metodoDePago = request.getParameter("inputPagoHiddenPaquete");
        String fechaVenta = request.getParameter("fechaVenta");
        String serviciosCheckedList = request.getParameter("serviciosCheckedList");
        
        
        Cliente cli = new Cliente();
        Empleado emple = new Empleado();
        Usuario us = new Usuario();
        Paquete paque = new Paquete();
        List<Servicio> listaServicios = new ArrayList<Servicio>();
        Double costo = 0.0;
        
        
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
        
        //separar servicios seleccionados 
        String [] vectServicios = serviciosCheckedList.split(" ");
        
        for (String vectServicio : vectServicios) {
            
            for (Servicio servicio : servicios) {
                if (servicio.getNombreServ().equals(vectServicio)) {
                    listaServicios.add(servicio);
                }
            }
        }
        
        
        
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
        
        for (Servicio servicio : listaServicios) {
            costo += servicio.getCosto();
        }
        
        paque.setListaServicios(listaServicios);
        paque.setCosto(costo);
        
        
        
        miSesion.setAttribute("pagoMetodoPaquete", metodoDePago);
        miSesion.setAttribute("empleadoPaquete", emple.toString());
        miSesion.setAttribute("clientePaquete", cli.toString());
        miSesion.setAttribute("paquetePaquete", paque.toString());
        miSesion.setAttribute("fechaPaquete", fechaVenta);
        
        
        
        
        
        control.crearVenta(emple, cli, metodoDePago, paque, fechaVenta);
        
        response.sendRedirect("confirmacionVentaServicio.jsp");
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
