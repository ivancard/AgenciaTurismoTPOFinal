
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Paquete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private Double costo;
    private Double costoFinal=0.0;
    private Boolean borrado = false;
    @ManyToMany
    private List<Servicio> listaServicios;
    @OneToMany
    private List<Venta> listaDePaquetes;

    public Paquete() {
    }

    public Paquete(int id, Double costo, List<Servicio> listaServicios, List<Venta> listaDePaquetes) {
        this.id = id;
        this.costo = costo;
        this.listaServicios = listaServicios;
        this.listaDePaquetes = listaDePaquetes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(Double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public Boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(Boolean borrado) {
        this.borrado = borrado;
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public List<Venta> getListaDePaquetes() {
        return listaDePaquetes;
    }

    public void setListaDePaquetes(List<Venta> listaDePaquetes) {
        this.listaDePaquetes = listaDePaquetes;
    }

    @Override
    public String toString() {
        return "Paquete{" + "id=" + id + ", costo=" + costo + ", costoFinal=" + costoFinal + ", borrado=" + borrado + ", listaServicios=" + listaServicios + ", listaDePaquetes=" + listaDePaquetes + '}';
    }

    
}
