<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
    <h1>Actualizar Alumno:</h1>
    <p>
        <font color="red">${errores}</font>
    </p>
    <p> Modifique los datos del alumno:</p>

    <!-- Formulario con datos del alumno -->
    <mvc:form modelAttribute="alumno" action="save-alumno" method="post">
        <div class="form-row">
            <div class="col">
                <mvc:label path="dni">Dni:</mvc:label>
                <mvc:input path="dni" readonly="true" class="form-control"/>
            </div>

            <div class="col">
                <mvc:label path="nombre">Nombre:</mvc:label>
                <mvc:input path="nombre" required="required" class="form-control"/>
                <mvc:errors path="nombre" cssClass="text-warning" />
            </div>
        </div>

        <div class="form-row">
            <div class="col">
                <mvc:label path="edad">Edad:</mvc:label>
                <mvc:input path="edad" required="required" class="form-control" type="number"/>
                <mvc:errors path="edad" cssClass="text-warning" />
            </div>

            <div class="col">
                <mvc:label path="ciclo">Ciclo:</mvc:label>
                <mvc:input path="ciclo" required="required" class="form-control"/>
                <mvc:errors path="ciclo" cssClass="text-warning" />
            </div>

            <div class="col">
                <mvc:label path="curso">Curso:</mvc:label>
                <mvc:input path="curso" required="required" class="form-control"/>
                <mvc:errors path="curso" cssClass="text-warning" />
            </div>
        </div>
        <br>

        <button type="submit" class="btn btn-primary">Guardar Cambios</button>
    </mvc:form>
</div>
