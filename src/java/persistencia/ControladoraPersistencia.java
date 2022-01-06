
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.Paquete;
import logica.Servicio;
import logica.Usuario;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;



public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    ClienteJpaController clienteJPA = new ClienteJpaController();
    ServicioJpaController servicioJPA = new ServicioJpaController();
    PaqueteJpaController paqueteJPA = new PaqueteJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();
    
    
    //##############-----CRUD Empleado-----##############
    
    //Alta
    public void crearEmpleado(Empleado emple, Usuario usu) {
        usuarioJPA.create(usu);
        empleadoJPA.create(emple);
    }
    //Baja
    public void eliminarEmpleado (int id){
        try {
            empleadoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarEmpleado(Empleado empleado){
        try {
            empleadoJPA.destroy(empleado.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Editar
    public void editarEmpleado(Empleado empleado){
        try {
            empleadoJPA.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Leer un empleado
    public Empleado obtenerEmpleado(int id){
        return empleadoJPA.findEmpleado(id);
    }
    public Empleado obtenerEmpleado(Empleado empleado){
        return empleadoJPA.findEmpleado(empleado.getId());
    }
    //Leer lista de empleados.
    public List<Empleado> obtenerEmpleados(){
        return empleadoJPA.findEmpleadoEntities();
    }
    
    
    
    
    
    
    //##############-----CRUD Usuario-----##############
    
    
    //Eliminar Usuario
    public void eliminarUsuario(Usuario user){
        try {
            usuarioJPA.destroy(user.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Editar usuario
    public void editarUsuario(Usuario user){
        try {
            usuarioJPA.edit(user);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //leer usuario 
    public Usuario obtenerUsuario(Usuario user){
        return usuarioJPA.findUsuario(user.getId());
    }
    //Leer usuarios
    public List<Usuario> obtenerUsuarios(){
        return usuarioJPA.findUsuarioEntities();
    }
    
    
    
    
    
    //##############-----CRUD Cliente-----##############
    
    //Alta
    public void crearCliente(Cliente cliente ){
        clienteJPA.create(cliente);
    }
    
    //Baja
    public void eliminarCliente(Cliente cliente){
        try {
            clienteJPA.destroy(cliente.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Modificacion
    public void editarCliente(Cliente cliente){
        try {
            clienteJPA.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Leer
    public Cliente obtenerCliente(int clienteId){
        return clienteJPA.findCliente(clienteId);
    }
    
    public List<Cliente> obtenerClientes(){
        return clienteJPA.findClienteEntities();
    }
    
    
    
    
    //##############-----CRUD Servicio-----##############
    
    //Alta
    public void crearServicio(Servicio servicio){
        servicioJPA.create(servicio);
    }
    
    //Baja
    public void eliminarServicio(Servicio servicio){
        try {
            servicioJPA.destroy(servicio.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Modificacion
    public void editarServicio(Servicio servicio){
        try {
            servicioJPA.edit(servicio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Leer
    public Servicio obtenerServicio(int servicioId){
        return servicioJPA.findServicio(servicioId);
    }
    
    public List<Servicio> obtenerServicios(){
        return servicioJPA.findServicioEntities();
    }
    
    
    
    
    //##############-----CRUD Paquete-----##############
    
    //Alta
    public void crearPaquete( Paquete paquete ){
        paqueteJPA.create(paquete);
    }
    
    //Baja
    public void eliminarPaquete(Paquete paquete){
        try {
            paqueteJPA.destroy(paquete.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Modificacion
    public void editarPaquete(Paquete paquete){
        try {
            paqueteJPA.edit(paquete);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Leer
    public Paquete obtenerPaquete(Paquete paquete){
        return paqueteJPA.findPaquete(paquete.getId());
    }
    
    public List<Paquete> obtenerPaquetes(){
        return paqueteJPA.findPaqueteEntities();
    }
    
    
    //##############-----CRUD Venta-----##############
    
    //Alta
    public void crearVenta(Venta venta){
        ventaJPA.create(venta);
    }
    
    //Baja
    public void eliminarVenta(Venta venta){
        try {
            ventaJPA.destroy(venta.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Modificacion
    public void editarVenta(Venta venta){
        try {
            ventaJPA.edit(venta);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Leer
    public Venta obtenerVenta(int ventaId){
        return ventaJPA.findVenta(ventaId);
    }
    public List<Venta> obtenerVentas(){
        return ventaJPA.findVentaEntities();
    }
    
    
}
