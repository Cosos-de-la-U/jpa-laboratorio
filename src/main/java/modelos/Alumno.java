package modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String nombre;
    private String apellido;
    @Temporal(TemporalType.DATE)
    private Date fechanac;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String apellido, Date fechanac) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanac = fechanac;
    }

    public Alumno(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }
}

