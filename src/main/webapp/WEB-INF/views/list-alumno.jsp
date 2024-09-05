<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
    <h1>${pagina.titulo}</h1>
    <p>Bienvenido ${nombre}</p> 
    <table class="table table-striped">
        <thead>
            <tr>
                <th><a href="list-alumno?orden=dni" class="nav-link">Dni</a></th>
                <th><a href="list-alumno?orden=nombre" class="nav-link">Nombre</a></th>
                <th><a href="list-alumno?orden=edadNombre" class="nav-link">Edad</a></th>
                <th><a href="list-alumno?orden=cicloNombre" class="nav-link">Ciclo</a></th>
                <th><a href="list-alumno?orden=curosNombre" class="nav-link">Curso</a></th>
                <th>Acción</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="alumno" items="${alumnos}">
                <tr>
                  <td>&nbsp;${alumno.getDni()}&nbsp;</td>
                  <td>&nbsp;${alumno.getNombre()}&nbsp;</td>
                  <td>&nbsp;${alumno.getEdad()}&nbsp;</td>
                  <td>&nbsp;${alumno.getCiclo()}&nbsp;</td>
                  <td>&nbsp;${alumno.getCurso()}&nbsp;</td>
                  <td>&nbsp;<a href="del-alumno?dni=${alumno.getDni()}" class="btn btn-danger">Borrar</a>&nbsp;</td>
                </tr>
            </c:forEach>
           
        </tbody>
    </table>
    <p><a href="add-alumno" class="btn btn-success">Añadir alumno</a></p>
</div>

<%@ include file="../jspf/footer.jspf" %>
