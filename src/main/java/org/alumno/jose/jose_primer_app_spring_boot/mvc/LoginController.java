package org.alumno.jose.jose_primer_app_spring_boot.mvc;

import org.alumno.jose.jose_primer_app_spring_boot.srv.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("nombre")
public class LoginController {
    @Autowired
    LoginService loginServicio;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String principal(){
        return "login";
    }

    @RequestMapping(value = "login", method=RequestMethod.GET)
    public String mostrarLogin() {
        return "login";
    }
    
   
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String procesaLogin(@RequestParam String nombre, @RequestParam String password, ModelMap model) {
        if (!loginServicio.usuarioValido(nombre, password)) {
            //usuario inválido, volver a intentar logearse
            model.put("errores", "Usuario '" + nombre + "' o contraseña incorrectos");
            return "login";
        } 
        // Si llega aquí es proque el usuario era valido
        model.put("nombre", nombre);
        model.put("password",password);
        return "bienvenida";
        
    }
    
    
}
