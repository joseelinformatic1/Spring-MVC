<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
    <h1>Nuevo Alumno:</h1>
    <p>
        <font color="red">${errores}</font>
    </p>
    <p> Introduzca los datos del nuevo alumno:</p>

    <!-- Formulario con prefijo 'mvc' -->
    <mvc:form modelAttribute="alumno" action="add-alumno" method="post">
        <div class="form-row">
            <div class="col">
                <mvc:label path="dni">Dni:</mvc:label>
                <mvc:input path="dni" id="dni" required="required" class="form-control" minlength="9"/>
            </div>

            <div class="col">
                <mvc:label path="nombre">Nombre:</mvc:label>
                <mvc:input path="nombre" id="nombre" required="required" class="form-control" minlength="5"/>
            </div>
        </div>

        <div class="form-row">
            <div class="col">
                <mvc:label path="edad">Edad:</mvc:label>
                <mvc:input path="edad" id="edad" required="required" class="form-control" type="number"/>
            </div>

            <div class="col">
                <mvc:label path="ciclo">Ciclo:</mvc:label>
                <mvc:input path="ciclo" id="ciclo" required="required" class="form-control"/>
            </div>

            <div class="col">
                <mvc:label path="curso">Curso:</mvc:label>
                <mvc:input path="curso" id="curso" required="required" class="form-control"/>
            </div>
        </div>
        <br>

        <button type="submit" class="btn btn-success">Añadir Alumno</button>
    </mvc:form>
</div>
