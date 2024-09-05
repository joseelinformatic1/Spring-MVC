package org.alumno.jose.jose_primer_app_spring_boot.model;

public class Pagina {
    private String titulo;
    private String url;

    // Constructor
    public Pagina(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }

    // Getter para titulo
    public String getTitulo() {
        return titulo;
    }

    // Setter para titulo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter para url
    public String getUrl() {
        return url;
    }

    // Setter para url
    public void setUrl(String url) {
        this.url = url;
    }
}
