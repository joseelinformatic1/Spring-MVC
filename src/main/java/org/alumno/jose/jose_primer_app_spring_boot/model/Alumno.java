package org.alumno.jose.jose_primer_app_spring_boot.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class Alumno implements Serializable, Comparable<Alumno> {
    private static final long serialVersionUID = 1L;
    @Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El DNI debe tener 8 números y una letra")
    private String dni;
    @NotNull(message = "El nombre no puede estar vacio")
    @Size(min=3,message="Un nombre minimo tiene que tener 3 letras")
    private String nombre;
    @Range(min = 18, max = 99, message = "La edad debe estar entre 18 y 99 años")

    private int edad;
    @Pattern(regexp = "[A-Z]+", message = "Solo pueden ser letras en mayusculas")

    private String ciclo;
    @Range(min = 1, max = 2, message = "Los modulos tienen como maximo dos cursos")

    private Integer curso;

    // Constructor
    public Alumno(String dni, String nombre, int edad, String ciclo, int curso) {
        super();
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.ciclo = ciclo;
        this.curso = curso;
    }

    public Alumno(String dni) {
        super();
        this.dni = dni;
    }

    public Alumno() {

    }

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    @Override
    public int compareTo(Alumno arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
