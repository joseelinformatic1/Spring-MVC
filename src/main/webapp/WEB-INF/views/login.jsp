<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/menuSuperior.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <div class="container">
        <p>
            <font color="red">${errores}</font>
        </p>
        <form action="login" method="post">
            <p>Introduzca su nombre:</p>
            <p><input type="text" name="nombre"/> </p>
            <p>Introduzca su contraseña</p>
            <p><input type="password" name="password"/></p>
                <input type="submit" value="login">
        </form>
    </div>
    <%@ include file="../jspf/footer.jspf"%>