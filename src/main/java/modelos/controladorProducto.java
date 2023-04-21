package modelos;

import controladores.ControladoraPersistencia;
import java.util.List;
import javax.naming.NamingException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.SystemException;

public class controladorProducto {
    ControladoraPersistencia cont_persis;

    public void testConnection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebaJPAPU");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }

    public controladorProducto() throws NamingException, SystemException {
        this.cont_persis = new ControladoraPersistencia();
    }

    public void crearProducto(Productos productos){
        this.cont_persis.crearProducto(productos);
    }

    public List<Productos> traerListaProductos(){
        return this.cont_persis.traerListaProductos();
    }

    public Productos traerProducto(int id){
        return this.cont_persis.traerProducto(id);
    }

    public List<Productos> consultaUltimosProductos(int maxResults, int firstResult) {
        return this.cont_persis.consultaUltimos(5,1);
    }

    public void editarProducto(Productos productos){
        this.cont_persis.editarProducto(productos);
    }

    public void eliminarProducto(int id){
        this.cont_persis.eliminarProducto(id);
    }
}
