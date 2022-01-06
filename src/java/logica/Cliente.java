
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

@Entity
public class Cliente extends Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany
    private List<Venta> comprasRealizadas;
    @Basic
    private Boolean borrado = false;

    public Cliente() {
    }

    public Cliente( int id,
                    List<Venta> comprasRealizadas,
                    String nombre, 
                    String apellido, 
                    String direccion, 
                    String provincia, 
                    String localidad, 
                    String dni, 
                    Date fechaNac, 
                    String nacionalidad, 
                    String numTelefono, 
                    String email)   {
        super(nombre, apellido, direccion, provincia, localidad, dni, fechaNac, nacionalidad, numTelefono, email);
        this.id = id;
        this.comprasRealizadas = comprasRealizadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Venta> getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setComprasRealizadas(List<Venta> comprasRealizadas) {
        this.comprasRealizadas = comprasRealizadas;
    }

    public Boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(Boolean borrado) {
        this.borrado = borrado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + super.getNombre() + ", apellido=" + super.getApellido() + ", borrado=" + borrado + '}';
    }

    public void setBorrado(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
