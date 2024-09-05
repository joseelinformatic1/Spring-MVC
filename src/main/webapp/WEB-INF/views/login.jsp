<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/menuSuperior.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
    <!-- Mostrar mensaje de error si existe -->
    <c:if test="${not empty errores}">
        <p style="color:red;">${errores}</p>
    </c:if>

    <!-- Formulario de login -->
    <form action="login" method="post">
        <p>Introduzca su nombre:</p>
        <!-- Mantener el nombre ingresado en caso de error -->
        <p><input type="text" name="nombre" value="${nombre}"/> </p>

        <p>Introduzca su contraseña:</p>
        <p><input type="password" name="password"/></p>

        <input type="submit" value="login">
    </form>
</div>
<%@ include file="../jspf/footer.jspf"%>
