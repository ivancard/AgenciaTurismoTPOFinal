package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String nombreServ;
    private String descripcion;
    private String destino;
    private Double costo;
    private Boolean borrado = false;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToMany
    private List<Paquete> listaPaquetes;
    @OneToMany
    public List<Venta> listaVentas;

    public Servicio() {
    }

    public Servicio(int id, String nombreServ, String descripcion, String destino, Double costo, Date fecha, List<Paquete> listaPaquetes, List<Venta> listaVentas) {
        this.id = id;
        this.nombreServ = nombreServ;
        this.descripcion = descripcion;
        this.destino = destino;
        this.costo = costo;
        this.fecha = fecha;
        this.listaPaquetes = listaPaquetes;
        this.listaVentas = listaVentas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreServ() {
        return nombreServ;
    }

    public void setNombreServ(String nombreServ) {
        this.nombreServ = nombreServ;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(Boolean borrado) {
        this.borrado = borrado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<Paquete> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public String toString() {
        return "Servicio{" + "id=" + id + ", nombreServ=" + nombreServ + ", descripcion=" + descripcion + ", destino=" + destino + ", costo=" + costo + ", borrado=" + borrado + ", fecha=" + fecha + ", listaPaquetes=" + listaPaquetes + ", listaVentas=" + listaVentas + '}';
    }

    

    
    
    
    
    
}
