
package logica;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    
    //######## Empleado
    
    public void crearEmpleado(  String nombre, 
                                String apellido,
                                String domicilio,
                                String provincia,
                                String localidad, 
                                String dni, 
                                String fechaNac, 
                                String nacionalidad, 
                                String telefono, 
                                String email, 
                                String nombreUsu, 
                                String password, 
                                String cargo, 
                                String sueldo) {
        
        Usuario usu = new Usuario(nombreUsu, password);
        Empleado emple = new Empleado();
        
        emple.setNombre(nombre);
        emple.setApellido(apellido);
        emple.setDireccion(domicilio);
        emple.setProvincia(provincia);
        emple.setLocalidad(localidad);
        emple.setDni(dni);
        Date fecha = new Date(fechaNac);
        emple.setFechaNac(fecha);
        emple.setNacionalidad(nacionalidad);
        emple.setNumTelefono(telefono);
        emple.setEmail(email);
        emple.setUser(usu);
        emple.setCargo(cargo);
        emple.setSueldo(Double.parseDouble(sueldo));
        
        controlPersis.crearEmpleado(emple, usu);
    }

    public void eliminarEmpleado(String idEmpleado){
        
        List<Empleado> empleadoList = controlPersis.obtenerEmpleados();
        
        for (Empleado empleado : empleadoList) {
            if (empleado.getId() == Integer.parseInt(idEmpleado) ) {
                controlPersis.eliminarEmpleado(empleado);
            }
        }
        
    }
    
    public void editarEmpleado(Empleado empleado){
        controlPersis.editarEmpleado(empleado);
    }
    
    public Empleado obtenerEmpleado(int empleadoId){
        return controlPersis.obtenerEmpleado(empleadoId);
    }
    public List<Empleado> obtenerEmpleados(){
         return controlPersis.obtenerEmpleados();
    }
    
    public String obtenerNombreEmpleado(String user,String pass){
    
        List<Empleado> listEmple = controlPersis.obtenerEmpleados();
        
        for (Empleado empleado : listEmple) {
            if (empleado.getUser().getCuenta().equals(user) && empleado.getUser().getPassword().equals(pass)) {
                return empleado.getNombre() + " " + empleado.getApellido();
            }
        }
        return "Nombre";
    }
    
    public String obtenerCargoEmpleado(String user,String pass){
    
        List<Empleado> listEmple = controlPersis.obtenerEmpleados();
        
        for (Empleado empleado : listEmple) {
            if (empleado.getUser().getCuenta().equals(user) && empleado.getUser().getPassword().equals(pass)) {
                return empleado.getCargo();
            }
        }
        return "Nombre";
    }
    
    
    //######## Usuario
    
    public void eliminarUsuario (Usuario user){
        controlPersis.eliminarUsuario(user);
    }
    
    public void editarUsuario(Usuario user){
        controlPersis.editarUsuario(user);
    }
    
    public List<Usuario> obtenerUsuarios (){
        return controlPersis.obtenerUsuarios();
    }
    
    public boolean  verificarUsuario(String user, String pass){
        List<Usuario> listaUsuarios = controlPersis.obtenerUsuarios();
        if (listaUsuarios != null) {
            
            for (Usuario usuario : listaUsuarios) {
                if ( usuario.getCuenta().equals(user) && usuario.getPassword().equals(pass)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //######## Cliente
    
    //Alta
    public void crearCliente(   String nombre, 
                                String apellido,
                                String domicilio,
                                String provincia,
                                String localidad, 
                                String dni, 
                                String fechaNac, 
                                String nacionalidad, 
                                String telefono, 
                                String email) {
        Cliente cliente = new Cliente();
        
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(domicilio);
        cliente.setProvincia(provincia);
        cliente.setLocalidad(localidad);
        cliente.setDni(dni);
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = format.parse(fechaNac);
            cliente.setFechaNac(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cliente.setNacionalidad(nacionalidad);
        cliente.setNumTelefono(telefono);
        cliente.setEmail(email);
        
        controlPersis.crearCliente(cliente);
        
    }
    
    //Baja
    public void eliminarCliente(String idCliente){
        List<Cliente> clienteList = controlPersis.obtenerClientes();
        
        for (Cliente cliente : clienteList) {
            if (cliente.getId() == Integer.parseInt(idCliente) ) {
                controlPersis.eliminarCliente(cliente);
            }
        }
    }
    
    //Modificacion
    public void editarCliente(Cliente cliente){
        controlPersis.editarCliente(cliente);
    }
    
    //Lectura
    public Cliente obtenerCliente(int clienteId){
        return controlPersis.obtenerCliente(clienteId);
    }
    
    public List<Cliente> obtenerClientes(){
        return controlPersis.obtenerClientes();
    }
    
    
    //######## Servicio
    
    //Alta
    public void crearServicio(  String nombreServ,
                                String descripcion,
                                String destino,
                                String costo,
                                String fecha
                                ){
        Servicio servicio = new Servicio();
        servicio.setNombreServ(nombreServ);
        servicio.setDescripcion(descripcion);
        servicio.setDestino(destino);
        servicio.setCosto(Double.parseDouble(costo));
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fech = formato.parse(fecha);
            servicio.setFecha(fech);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        controlPersis.crearServicio(servicio);
    }
    
    //Baja 
    public void eliminarServicio(String idServicio){
        List<Servicio> listaServicio = controlPersis.obtenerServicios();
        
        for (Servicio servicio : listaServicio) {
            if (servicio.getId() == Integer.parseInt(idServicio)) {
                controlPersis.eliminarServicio(servicio);
            }
        }
    }
    
    //Modificacion
    public void editarServicio (Servicio servicio){
        controlPersis.editarServicio(servicio);
    }
    
    //Leer servicio
    public Servicio obtenerServicio(int servicioId){
        return controlPersis.obtenerServicio(servicioId);
    }
  
    
    public List<Servicio> obtenerServicios(){
        return controlPersis.obtenerServicios();
    }
    
    
    //######## Paquete
    
    //Alta
    public void crearPaquete( Paquete paquete ){
        
        controlPersis.crearPaquete(paquete);
        
        //paquete.setCosto(Double.parseDouble(costo));
        
    }
    
    //Baja 
    public void eliminarPaquete(Paquete paquete){
        controlPersis.eliminarPaquete(paquete);
    }
    
    //Modificacion
    public void editarPaquete(Paquete paquete){
        controlPersis.editarPaquete(paquete);
    }
    
    //Leer
    public Paquete obtenerPaquete(Paquete paquete){
        return controlPersis.obtenerPaquete(paquete);
    }
    
    public List<Paquete> obtenerPaquetes(){
        return controlPersis.obtenerPaquetes();
    }
    
    
    //######## Venta 
    
    //Alta
    public void crearVenta(Empleado empleado ,Cliente cliente, String metodoDePago, Servicio servicio, String fechaVenta ){
        Venta venta = new Venta();
        venta.setEmpleado(empleado);
        venta.setCliente(cliente);
        venta.setMetodoDePago(metodoDePago);
        venta.setServicio(servicio);
        
        //Asigna fecha de venta
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = format.parse(fechaVenta);
            venta.setFechaVenta(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        venta.setMontoInicial(servicio.getCosto());
        
        venta.setMontoFinal( venta.calcularComicionesPago( servicio.getCosto(), metodoDePago ));
        
        controlPersis.crearVenta(venta);
        
        
    }
    //Venta Paquete
    public void crearVenta(Empleado empleado ,Cliente cliente, String metodoDePago, Paquete listServicio, String fechaVenta ){
        
        Venta venta = new Venta();
        
        
        listServicio.setCostoFinal(venta.calcularComicionesPago( listServicio.getCosto(), metodoDePago ));
        
        controlPersis.crearPaquete(listServicio);
        
        venta.setMontoInicial(listServicio.getCosto());
        venta.setMontoFinal(listServicio.getCostoFinal());
        
        empleado.setVentasRealizadas(empleado.getVentasRealizadas() + 1);
        
        venta.setEmpleado(empleado);
        venta.setCliente(cliente);
        venta.setMetodoDePago(metodoDePago);
        venta.setPaquete(listServicio);
        
        //Asigna fecha de venta
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = format.parse(fechaVenta);
            venta.setFechaVenta(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        controlPersis.crearVenta(venta);
        
        
    }
    
    //Baja
    public void eliminarVenta(String idVenta){
        List<Venta> listaVentas = controlPersis.obtenerVentas();
        
        for (Venta venta : listaVentas) {
            if (venta.getId() == Integer.parseInt(idVenta)) {
                controlPersis.eliminarVenta(venta);
            }
        }
    }
    
    //EditarVenta
    public void editarVenta(Venta newVenta){
        controlPersis.editarVenta(newVenta);
    }
    
    //leer
    public List<Venta> obtenerVentas(){
        return controlPersis.obtenerVentas();
    }

    public Venta obtenerVenta(int id) {
        return controlPersis.obtenerVenta(id);
    }

    
}
