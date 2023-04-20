package servlets_sis;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.SystemException;
import modelos.Alumno;
import modelos.controladorAlumno;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "AlumnoServlet", urlPatterns = {"/servlet_alumno"})
public class servlet_alumno extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private controladorAlumno calumno = new controladorAlumno();
    private Alumno alumno = new Alumno();

    public servlet_alumno() throws SystemException, NamingException {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion=request.getParameter("accion");
        int id = 0;
        if(request.getParameter("id")!=null){
            id=Integer.parseInt(request.getParameter("id"));
        }

        List<Alumno> consultaGeneral=this.calumno.traerListaAlumnos();
        System.out.println(consultaGeneral);
        switch(accion){
            case "con":
                request.setAttribute("alumnos",consultaGeneral);
                request.getRequestDispatcher("vistas/view_alumno.jsp").forward(request, response);
                break;

            case "mod":
                Alumno alumno=this.calumno.traerAlumno(id );
                request.setAttribute("alumno",alumno);
                request.getRequestDispatcher("vistas/upd_alumno.jsp").forward(request, response);
                break;

            case "del":
                this.calumno.eliminarAlumno(id);
                consultaGeneral=this.calumno.traerListaAlumnos();
                request.setAttribute("alumnos",consultaGeneral);
                request.getRequestDispatcher("vistas/view_alumno.jsp").forward(request, response);
                break;

            case "add":
                List<Alumno> consultaUltimos=this.calumno.consultaUltimosAlumnos(5, 1);
                request.setAttribute("alumnos",consultaUltimos);
                request.getRequestDispatcher("vistas/add_alumno.jsp").forward(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre=request.getParameter("txtnombre");
        String apellido=request.getParameter("txtapellido");
        String fechaStr = request.getParameter("txtfecha").trim().toString();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = LocalDate.parse(fechaStr, formato);
        Date date = java.sql.Date.valueOf(fecha);

        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setFechanac(date);

        String btnAgregar = request.getParameter("btnAgregar");
        String btnUpdate = request.getParameter("btnUpdate");

        if (btnAgregar != null && !btnAgregar.isEmpty()) {
            //viene el dato de agregar
            this.calumno.crearAlumno(alumno);
        } else if (btnUpdate != null && !btnUpdate.isEmpty()){
            int id=Integer.parseInt(request.getParameter("txtid"));
            alumno.setId(id);
            this.calumno.editarAlumno(alumno);
        }

        List<Alumno> consultaUltimos=this.calumno.consultaUltimosAlumnos(5, 1);
        request.setAttribute("alumnos",consultaUltimos);
        request.getRequestDispatcher("vistas/add_alumno.jsp").forward(request, response);
    }

}
