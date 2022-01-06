
package serverlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Cliente;
import logica.Controladora;
import logica.Servicio;
import logica.Venta;


@WebServlet(name = "SvModificarVentaServicioConfirm", urlPatterns = {"/SvModificarVentaServicioConfirm"})
public class SvModificarVentaServicioConfirm extends HttpServlet {
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
        
        String dni = request.getParameter("dni");
        String fechaVenta = request.getParameter("fechaVenta");
        String metodoDePago = request.getParameter("metodoDePagoHiden");
        String servicioLista = request.getParameter("servicioListaHidden");
        
        Venta newVenta = control.obtenerVenta(id);
        Servicio newServicio = new Servicio();
        Cliente newCliente = new Cliente();
        
        
        
       
        
        
        //Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
        Date fecha;
        try {
            fecha = formato.parse(fechaVenta);
            newVenta.setFechaVenta(fecha);

        } catch (ParseException ex) {
            Logger.getLogger(SvModificarVentaServicioConfirm.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        //Encuentra el servicio
        List<Servicio> listaServicio = control.obtenerServicios();
        for (Servicio object : listaServicio) {
            if (object.getNombreServ().equals(servicioLista)) {
                newServicio = object;
            }
        }
        
        //Encuentra el cliente
        List<Cliente> listaCliente = control.obtenerClientes();
        
        for (Cliente cliente : listaCliente) {
            if (cliente.getDni().equals(dni)) {
                newCliente = cliente;
            }
        }
        
        
        newVenta.setMetodoDePago(metodoDePago);
        newVenta.setServicio(newServicio);
        newVenta.setCliente(newCliente);
        
        control.editarVenta(newVenta);
        
        response.sendRedirect("listaVentas.jsp");
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
