package modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity(name = "producto")
public class Productos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;
    @Basic
    private String nombre;
    @Basic
    private String descripcion;
    private double precio_unitario;
    private String categoria;
  /*  @Temporal(TemporalType.DATE)
    private Date fechanac;*/

    public Productos() {
    }

    public Productos(int id_producto) {
        this.id_producto = id_producto;
    }

    public Productos(int id_producto, String nombre, String descripcion, double precio_unitario, String categoria) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
        this.categoria = categoria;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}                                   

