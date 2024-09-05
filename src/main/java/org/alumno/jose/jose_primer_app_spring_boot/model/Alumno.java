package org.alumno.jose.jose_primer_app_spring_boot.model;

public class Alumno {
    private String dni;
    private String nombre;
    private int edad;
    private String ciclo;
    private int curso;

    // Constructor
    public Alumno(String dni, String nombre, int edad, String ciclo, int curso) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.ciclo = ciclo;
        this.curso = curso;
    }
    public Alumno(){
        
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
}
