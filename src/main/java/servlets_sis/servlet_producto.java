package servlets_sis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.SystemException;
import modelos.Productos;
import modelos.controladorProducto;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/servlet_producto"})
public class servlet_producto extends HttpServlet {

    private controladorProducto cproducto = new controladorProducto();
    private Productos productos = new Productos();

    public servlet_producto() throws SystemException, NamingException {
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        String accion=request.getParameter("accion");
        int id = 0;
        if(request.getParameter("id")!=null){
            id=Integer.parseInt(request.getParameter("id"));
        }

        List<Productos> consultaGeneral = this.cproducto.traerListaProductos();
        for (Productos p : consultaGeneral) {
            System.out.println("ID: " + p.getId_producto());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Descripción: " + p.getDescripcion());
            System.out.println("Precio unitario: " + p.getPrecio_unitario());
            System.out.println("Categoría: " + p.getCategoria());
            System.out.println();
        }

        switch(accion){
            case "con":
                request.setAttribute("productos",consultaGeneral);
                request.getRequestDispatcher("vistas/view_producto.jsp").forward(request, response);
                try {
                    cproducto.testConnection(); // call a method that tests the connection
                    System.out.println("Connection to database successful");
                } catch (Exception e) {
                    System.out.println("Error connecting to database: " + e.getMessage());
                }
                break;

            case "mod":
                Productos productos =this.cproducto.traerProducto(id );
                request.setAttribute("producto", productos);
                request.getRequestDispatcher("vistas/upd_producto.jsp").forward(request, response);
                break;

            case "del":
                this.cproducto.eliminarProducto(id);
                consultaGeneral=this.cproducto.traerListaProductos();
                request.setAttribute("productos",consultaGeneral);
                request.getRequestDispatcher("vistas/view_producto.jsp").forward(request, response);
                break;

            case "add":
                List<Productos> consultaUltimos=this.cproducto.consultaUltimosProductos(5, 1);
                request.setAttribute("productos",consultaUltimos);
                request.getRequestDispatcher("vistas/add_producto.jsp").forward(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre=request.getParameter("txtnombre");
        String descripcion=request.getParameter("txtdescripcion");
        //String fechaStr = request.getParameter("txtfecha").trim().toString();
            double precio_unitario = Double.parseDouble(request.getParameter("txtprecio_unitario"));
        String categoria = request.getParameter("txtcategoria");

        //DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate fecha = LocalDate.parse(fechaStr, formato);
        //Date date = java.sql.Date.valueOf(fecha);

        productos.setNombre(nombre);
        productos.setDescripcion(descripcion);
        productos.setPrecio_unitario(precio_unitario);
        productos.setCategoria(categoria);

        String btnAgregar = request.getParameter("btnAgregar");
        String btnUpdate = request.getParameter("btnUpdate");

        if (btnAgregar != null && !btnAgregar.isEmpty()) {
            //viene el dato de agregar
            this.cproducto.crearProducto(productos);
        } else if (btnUpdate != null && !btnUpdate.isEmpty()){
            int id=Integer.parseInt(request.getParameter("txtid"));
            productos.setId_producto(id);
            this.cproducto.editarProducto(productos);
        }

        List<Productos> consultaUltimos=this.cproducto.consultaUltimosProductos(5, 1);
        request.setAttribute("productos",consultaUltimos);
        request.getRequestDispatcher("vistas/add_producto.jsp").forward(request, response);
    }

}
