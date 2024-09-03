package org.alumno.jose.jose_primer_app_spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping(value={"/","/login"}, method=RequestMethod.GET)
    public String mostrarLogin(){
        return "login";
    }
   
    @RequestMapping(value={"/","/login"}, method=RequestMethod.POST)
    public String procesaLogin(@RequestParam String nombre, @RequestParam String password, ModelMap model){
        model.put("nombre", nombre);
        model.put("password", password);
        return "bienvenida";
    }
    
}
