
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Basic
    private Double montoInicial;
    private String metodoDePago;
    private Double montoFinal;
    private boolean borrado = false;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Servicio servicio;
    @ManyToOne
    private Paquete paquete;
    @ManyToOne
    private Empleado empleado;
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;

    public Venta() {
    }

    public Venta(int id, Double montoInicial, String metodoDePago, Double montoFinal, Cliente cliente, Servicio servicio, Paquete paquete, Empleado empleado, Date fechaVenta) {
        this.id = id;
        this.montoInicial = montoInicial;
        this.metodoDePago = metodoDePago;
        this.montoFinal = montoFinal;
        this.cliente = cliente;
        this.servicio = servicio;
        this.paquete = paquete;
        this.empleado = empleado;
        this.fechaVenta = fechaVenta;
    }
    
    public Double calcularComicionesPago(Double costo, String metodoPago){
        Double costoComiciones = costo;
        
        switch (metodoPago) {
            case "efectivo": costoComiciones = costo;
                break;
            case "tarjetaDebito": costoComiciones = costo + costo*0.3;
                break;
            case "tarjetaCredito":costoComiciones = costo + costo*0.9;
                break;
            case "monederoVirtual":costoComiciones = costo;
                break;
            case "transferencia":costoComiciones = costo + costo*0.245;
                break;
            default:    costoComiciones = costo;
                break;
        }
        
        return  costoComiciones;
    } 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(Double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public Double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(Double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    
    
    
        
}
