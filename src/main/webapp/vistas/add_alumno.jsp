<%@ include file="header.jsp" %>
<main>
    <div class="row justify-content-center pt-5 ">
        <div class="col-8">
            <div class="alert alert-primary text-center" role="alert">
                <strong>Administrar Alumnos</strong> Agregar
            </div>
            <div class="card-body">
                <div class="container ">
                    <form method="post" action="http://localhost:8080/jpa-laboratorio-1.0-SNAPSHOT/servlet_alumno">
                        <div class="mb-3 row">
                            <label for="inputName" class="col-2 col-form-label">Nombre</label>
                            <div class="col-10">
                                <input type="text" class="form-control text-bg-light" name="txtnombre" id="inputName"
                                       placeholder="Ingrese el nombre del alumno">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="inputName" class="col-2 col-form-label">Apellido</label>
                            <div class="col-10">
                                <input type="text" class="form-control text-bg-light" name="txtapellido" id="inputName"
                                       placeholder="Ingrese el apellido del alumno">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="inputName" class="col-2 col-form-label">Fecha de nacimiento</label>
                            <div class="col-10">
                                <input type="date" min="1970-01-01" class="form-control text-bg-light" name="txtfecha"
                                       id="inputName" placeholder="">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <div class="offset-sm-4 col-sm-8">
                                <input type="submit" class="btn btn-dark float-end" value="Agregar Alumno"
                                       name="btnAgregar">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-8">
            <div class="table-responsive">
                <h1 class="display-4">Ultimos Alumnos guardados</h1>
                <table class="table table-striped">
                    <tr class="table table-dark">
                        <td>#</td>
                        <td>Nombre</td>
                        <td>Apellido</td>
                        <td>Fecha nacimiento</td>
                        <td></td>
                    </tr>
                    <c:forEach items="${alumnos}" var="alumno">
                        <tr>
                            <td>${alumno.id}</td>
                            <td>${alumno.nombre}</td>
                            <td>${alumno.apellido}</td>
                            <td>${alumno.fechanac}</td>
                            <td>
                                <a href="http://localhost:8080/jpa-laboratorio-1.0-SNAPSHOT/servlet_alumno?accion=mod&id=${alumno.id}"
                                   class="btn btn-success">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-pencil-square" viewBox="0 0 16 16">
                                        <path d="M15.502 1.94a.5.5 0 0 1 0.706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                        <path fill-rule="evenodd"
                                              d="M1 13.5A1.51.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 12.5v11z"/>
                                    </svg>
                                </a>
                                <a href="http://localhost:8080/jpa-laboratorio-1.0-SNAPSHOT/servlet_alumno?accion=del&id=${alumno.id}"
                                   title="Eliminar alumno seleccionado" class="btn btn-danger">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-trash3-fill" viewBox="0 0 16 16">
                                        <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z"/>
                                    </svg>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</main>