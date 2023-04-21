package modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
public class Ordenes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_producto;
    private int cantidad;
    private String categoria;
    @Temporal(TemporalType.DATE)
    private Date fecha_orden;
    private String direccion_entrega;

    public Ordenes() {
    }

    public Ordenes(int id) {
        this.id = id;
    }

    public Ordenes(int id, int id_producto, int cantidad, String categoria, Date fecha_orden, String direccion_entrega) {
        this.id = id;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.fecha_orden = fecha_orden;
        this.direccion_entrega = direccion_entrega;
    }

    public int getId_orden() {
        return id;
    }

    public void setId_orden(int id) {
        this.id = id;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getcantidad() {
        return cantidad;
    }

    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(Date fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public String getDireccion_entrega() {
        return direccion_entrega;
    }

    public void setDireccion_entrega(String direccion_entrega) {
        this.direccion_entrega = direccion_entrega;
    }
}
