package org.alumno.jose.jose_primer_app_spring_boot.srv.excepciones;

public class AlumnoDuplicadoException extends RuntimeException{
    public AlumnoDuplicadoException(){
        super("El alumno ya existe en la lista.");
    }

    public AlumnoDuplicadoException(String mensaje){
        super(mensaje);
    }
}
