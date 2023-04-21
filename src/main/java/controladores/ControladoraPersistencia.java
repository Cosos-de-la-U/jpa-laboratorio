package controladores;


import jakarta.transaction.SystemException;
import modelos.Productos;

import javax.naming.NamingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    // objeto de la clase ProductoJpaController
    ProductoJpaController productoJpa;

    // constructor
    public ControladoraPersistencia() throws NamingException, SystemException {
        this.productoJpa = new ProductoJpaController();
    }

    // Sirve para agregar nuevos productos
    public void crearProducto(Productos productos) {
        try {
            this.productoJpa.create(productos);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // consulta general de productos
    public List<Productos> traerListaProductos() {
        return this.productoJpa.findProductoEntities();
    }

    // consulta un producto en especifico
    public Productos traerProducto(int id) {
        return this.productoJpa.findProducto(id);
    }

    // actualiza la información de un producto
    public void editarProducto(Productos productos) {
        try {
            this.productoJpa.edit(productos);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // elimina un producto en especifico
    public void eliminarProducto(int id) {
        try {
            this.productoJpa.destroy(id);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // consulta los ultimos 4 productos agregados
    // i=cantidad de productos, j=desde donde comienza a contar
    public List<Productos> consultaUltimos(int i, int j) {
        int total = this.productoJpa.getProductoCount() - 4;
        return this.productoJpa.findProductoEntities(i, total);
    }
}
