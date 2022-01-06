
package serverlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import logica.Paquete;
import logica.Servicio;
import logica.Venta;


@WebServlet(name = "SvModificarVentaPaqueteConfirm", urlPatterns = {"/SvModificarVentaPaqueteConfirm"})
public class SvModificarVentaPaqueteConfirm extends HttpServlet {
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
        String metodoDePago = request.getParameter("inputPagoHiddenPaquete");
        String servicioLista = request.getParameter("serviciosCheckedList");
        
        Venta newVenta = control.obtenerVenta(id);
        
        Cliente newCliente = new Cliente();
        List<Servicio> listaServicios = new ArrayList<Servicio>();
        Paquete paque = new Paquete();
        List<Cliente> listaCliente = control.obtenerClientes();
        
        for (Cliente cliente : listaCliente) {
            if (cliente.getDni().equals(dni)) {
                newCliente = cliente;
            }
        }
        
        
        //Fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
        Date fecha;
        try {
            fecha = formato.parse(fechaVenta);
            newVenta.setFechaVenta(fecha);

        } catch (ParseException ex) {
            Logger.getLogger(SvModificarVentaServicioConfirm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String [] vectServicios = servicioLista.split(" ");
        
        List<Servicio> listaServiciosClase= control.obtenerServicios();
        
        for (String vectServicio : vectServicios) {
            
            for (Servicio servicio : listaServiciosClase) {
                if (servicio.getNombreServ().equals(vectServicio)) {
                    listaServicios.add(servicio);
                }
            }
        }
        
        
        paque.setCostoFinal(newVenta.calcularComicionesPago( paque.getCosto(), metodoDePago ));
        
        paque.setListaServicios(listaServicios);
        
        control.crearPaquete(paque);
        
        
        
        newVenta.setCliente(newCliente);
        newVenta.setMetodoDePago(metodoDePago);
        newVenta.setPaquete(paque);
        newVenta.setMontoInicial(paque.getCosto());
        newVenta.setMontoFinal(paque.getCostoFinal());
        
        control.editarVenta(newVenta);
        
        response.sendRedirect("listaVenta.jsp");
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
