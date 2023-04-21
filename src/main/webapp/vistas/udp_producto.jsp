<%@ include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main>
    <!--seteo de variables con JSQL//-->
    <c:set var="idAlumno" value="${productos.id}" />
    <c:set var="aluNombre" value="${productos.nombre}" />
    <c:set var="aluApellido" value="${productos.apellido}" />
    <c:set var="fechaNacimiento" value="${productos.fechanac}" />
    <fmt:formatDate var="fechaFormateada" value="${fechaNacimiento}" pattern="yyyyMM-dd" />
    <!--Fin de seteo de variables//-->

    <form action="http://localhost:8080/jpa-laboratorio-1.0-SNAPSHOT/servlet_alumno" method="post">

        <div class="container " style="margin-top: 30px;" >
            <div class="card mb-3 row col-10">
                <div class="card-header alert alert-primary">
                    <strong>Actualizar información del estudiante</strong>
                </div>
                <div class="card-body ">
                    <div class="mb-1 row">
                        <input type="hidden" value="${idAlumno}" name="txtid">
                        <label for="inputName" class="card-title">Nombre</label>
                        <div class="col-10">
                            <input type="text" value="${aluNombre}" class="form-control" name="txtnombre" id="inputName" placeholder="Name">
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="mb-1 row">
                        <label for="inputName" class="card-title">Apellido</label>
                        <div class="col-10">
                            <input type="text" value="${aluApellido}" class="form-control" name="txtapellido" id="inputName" placeholder="ingrese el nombre del productos">
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="mb-1 row">
                        <label for="inputName" class="card-title">Fecha nacimiento</label>
                        <div class="col-10">
                            <input type="date" pattern="yyyy-MM-dd" value="${fechaFormateada}" class="form-control" name="txtfecha" id="inputName" placeholder="ingrese el apellido del productos">
                        </div>
                    </div>
                </div>
                <div class="card-footer text-muted">
                    <input type="submit" value="Guardar información" name="btnUpdate" class="btn btn-dark">
                </div>
            </div>
        </div>

    </form>

</main>

<%@ include file="footer.jsp" %>