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
import logica.Controladora;
import logica.Servicio;
import serverlets.SvModificarClienteConfirm;

@WebServlet(urlPatterns = {"/SvModificarServicioConfirm"})
public class SvModificarServicioConfirm extends HttpServlet {
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
        String nombreServ = request.getParameter("nombreServ");
        String descripcion = request.getParameter("descripcion");
        String destino = request.getParameter("destino");
        String costo = request.getParameter("costo");
        String fechaServ = request.getParameter("fechaServ");
        
        Servicio newServicio = control.obtenerServicio(id);
        
        newServicio.setNombreServ(nombreServ);
        newServicio.setDescripcion(descripcion);
        newServicio.setDestino(destino);
        newServicio.setCosto(Double.parseDouble(costo));
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
        Date fecha;
        try {
            fecha = formato.parse(fechaServ);
            newServicio.setFecha(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SvModificarClienteConfirm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        control.editarServicio(newServicio);
        
        response.sendRedirect("listServicios.jsp");
        
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
