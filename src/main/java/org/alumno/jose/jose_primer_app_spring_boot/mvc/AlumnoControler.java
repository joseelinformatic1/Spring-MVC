package org.alumno.jose.jose_primer_app_spring_boot.mvc;

import org.alumno.jose.jose_primer_app_spring_boot.model.Alumno;
import org.alumno.jose.jose_primer_app_spring_boot.model.Pagina;
import org.alumno.jose.jose_primer_app_spring_boot.srv.AlumnoService;
import org.alumno.jose.jose_primer_app_spring_boot.srv.PaginaService;
import org.alumno.jose.jose_primer_app_spring_boot.srv.excepciones.AlumnoDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;



@Controller
@SessionAttributes("nombre")
public class AlumnoControler {

    Pagina pagina = new Pagina("Alumnos","list-alumno");
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
    public String addAlumno(@Valid Alumno alumno,BindingResult validacion,ModelMap model) {
    
        if (validacion.hasErrors()) {
            return "add-alumno";
        }
        //Si llega aqui no hay errores de validación
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
        return "update-alumno";
    }

    // Método para actualizar un alumno
    @RequestMapping(value = "/save-alumno", method = RequestMethod.POST)
    public String modificarAlumno(@Valid Alumno alumno,BindingResult validacion,ModelMap model) {
        if (validacion.hasErrors()) {
            // Si hay errores de validación, se vuelve a la página de actualización
            return "update-alumno";
        }
        String errores="";

        try {
            // Llamar al servicio para modificar el alumno
            alumnoService.updateAlumno(alumno);
            // Limpiar el modelo antes de redireccionar
            model.clear();
            // Redirigir al listado de alumnos
            return "redirect:list-alumno";
        }catch (NumberFormatException e){
            errores=e.getMessage();
        } catch (AlumnoDuplicadoException e) {
            model.addAttribute("errores", "Error al modificar el alumno: " + e.getMessage());
            errores=e.getMessage();  
        }
        model.addAttribute("errores",errores);
        return "update-alumno";
    }
    // Método que borra un alumno y redirige al listado
    @RequestMapping(value = "/del-alumno", method = RequestMethod.GET)
    public String delAlumno(@RequestParam("dni") String dni, ModelMap model) {
        try {
            alumnoService.borrarAlumno(dni);  // Borrar el alumno por DNI
            model.clear();  // Limpiar el modelo
        } catch (Exception e) {
            model.addAttribute("errores", e.getMessage());  // Añadir error si ocurre
        }
        return "redirect:/list-alumno";  // Redirigir al listado de alumnos
    }

     // Método para recuperar un alumno por su DNI y enviarlo a update-alumno.jsp
     @RequestMapping(value = "/update-alumno", method = RequestMethod.GET)
     public String mostrarFormularioUpdateAlumno(@RequestParam("dni") String dni, ModelMap model) {
         try {
             // Buscar el alumno por su DNI
             Alumno alumno = alumnoService.findAlumnoByDni(dni);
 
             // Enviar el alumno recuperado al JSP
             model.addAttribute("alumno", alumno);
 
             // Redirigir al JSP de actualización de alumno
             return "update-alumno"; // Nombre del archivo JSP (update-alumno.jsp)
 
         } catch (IllegalArgumentException e) {
             // Si no se encuentra el alumno, mostrar un mensaje de error
             model.addAttribute("errores", "Alumno con DNI " + dni + " no encontrado.");
             return "redirect:list-alumno"; // Redirigir al listado de alumnos
         }
     }


 
    
    
}
