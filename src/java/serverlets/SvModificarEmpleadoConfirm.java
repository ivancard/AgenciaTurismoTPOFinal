
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
import logica.Empleado;
import logica.Usuario;

@WebServlet(name = "SvModificarEmpleadoConfirm", urlPatterns = {"/SvModificarEmpleadoConfirm"})
public class SvModificarEmpleadoConfirm extends HttpServlet {
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
        String provincia = request.getParameter("provincia");
        String nacionalidad = request.getParameter("nacionalidad");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");
        String sueldo = request.getParameter("sueldo");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        Empleado empleAEditar = control.obtenerEmpleado(id);
        Usuario newUser = new Usuario();
        
        newUser.setCuenta(user);
        newUser.setPassword(pass);
        
        empleAEditar.setNombre(nombre);
        empleAEditar.setApellido(apellido);
        empleAEditar.setDni(dni);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
        Date fecha;
        try {
            fecha = formato.parse(fechaNac);
            empleAEditar.setFechaNac(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SvModificarClienteConfirm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        empleAEditar.setDireccion(domicilio);
        empleAEditar.setLocalidad(localidad);
        empleAEditar.setProvincia(provincia);
        empleAEditar.setNacionalidad(nacionalidad);
        empleAEditar.setNumTelefono(telefono);
        empleAEditar.setEmail(email);
        empleAEditar.setCargo(cargo);
        empleAEditar.setSueldo(Double.parseDouble(sueldo));
        empleAEditar.setUser(newUser);
        
        
        control.editarEmpleado(empleAEditar);
        
        response.sendRedirect("listaEmpleados.jsp");
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
