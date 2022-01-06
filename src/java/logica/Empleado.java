
package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Empleado extends Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String cargo;
    private Double sueldo;
    private int ventasRealizadas=0;
    private Boolean borrado = false;
    @OneToOne
    private Usuario user;
    @OneToMany
    private List<Venta> listaVentas;

    
    //Constructor vacio.
    public Empleado() {
        
    }

    //Contructor completo
    
    public Empleado(    int id, 
                        Usuario user, 
                        String cargo, 
                        Double sueldo, 
                        List<Venta> listaVentas, 
                        String nombre, 
                        String apellido, 
                        String direccion, 
                        String provincia, 
                        String localidad, 
                        String dni, 
                        Date fechaNac, 
                        String nacionalidad, 
                        String numTelefono, 
                        String email    ) {
        super(nombre, apellido, direccion, provincia, localidad, dni, fechaNac, nacionalidad, numTelefono, email);
        this.id = id;
        this.user = user;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.listaVentas = listaVentas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public int getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(int ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public Boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(Boolean borrado) {
        this.borrado = borrado;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", cargo=" + cargo + ", sueldo=" + sueldo + ", ventasRealizadas=" + ventasRealizadas + ", borrado=" + borrado + ", user=" + user + ", listaVentas=" + listaVentas + '}';
    }

    
    
}
