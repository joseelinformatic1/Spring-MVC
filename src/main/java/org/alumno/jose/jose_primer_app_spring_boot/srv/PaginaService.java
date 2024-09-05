package org.alumno.jose.jose_primer_app_spring_boot.srv;

import org.alumno.jose.jose_primer_app_spring_boot.model.Pagina;
import org.springframework.stereotype.Service;

@Service
public class PaginaService {
    private Pagina paginaActual;

    public void SetPagina(Pagina pagina) {
       this.paginaActual=pagina;
    }
    
    public Pagina getPagina(){
        return this.paginaActual;
    }
}
