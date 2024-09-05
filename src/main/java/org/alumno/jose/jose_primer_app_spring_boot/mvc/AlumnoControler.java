package org.alumno.jose.jose_primer_app_spring_boot.mvc;

import org.alumno.jose.jose_primer_app_spring_boot.model.Alumno;
import org.alumno.jose.jose_primer_app_spring_boot.model.Pagina;
import org.alumno.jose.jose_primer_app_spring_boot.srv.AlumnoService;
import org.alumno.jose.jose_primer_app_spring_boot.srv.PaginaService;
import org.alumno.jose.jose_primer_app_spring_boot.srv.excepciones.AlumnoDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes("nombre")
public class AlumnoControler {
    Pagina pagina= new Pagina("Alumnos","list-alumno");
    @Autowired
    AlumnoService alumnoService;
    @Autowired
    PaginaService paginaServicio;
    
   @RequestMapping(value = "/list-alumno", method=RequestMethod.GET)
    public String listarAlumno(ModelMap model) {
        model.addAttribute("alumnos", alumnoService.listaAlumnos());
        model.addAttribute("pagina", pagina);
        
        return "list-alumno";
    }

    @RequestMapping(value = "/add-alumno", method=RequestMethod.GET)
    public String mostrarAlumno(ModelMap model) {
        paginaServicio.SetPagina(pagina);
        model.addAttribute("pagina",paginaServicio.getPagina());
        model.addAttribute("alumno",new Alumno("","NuevoAlumno",18,"DAW",2));
        
        return "add-alumno";
    }

    @RequestMapping(value="/add-alumno", method=RequestMethod.POST)
    public String addAlumno(Alumno alumno,ModelMap model) {
        String errores="";
        paginaServicio.SetPagina(pagina);
        model.addAttribute("pagina",pagina);
        try {
            alumnoService.addAlumno(alumno);
            //Para evitar pasar parámetros inncesarios
            model.clear();
            //Para evitar inserciones duplicadas comentamos código y redirigimos a listar
            return "redirect:list-alumno";
        } catch (NumberFormatException e) {
            errores=e.getMessage();
        }catch (AlumnoDuplicadoException e){
            errores=e.toString();
        }
        model.addAttribute("errores",errores);
        return "add-alumno";
    }
    
    
}
