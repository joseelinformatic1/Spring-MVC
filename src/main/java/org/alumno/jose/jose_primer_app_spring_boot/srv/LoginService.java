package org.alumno.jose.jose_primer_app_spring_boot.srv;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean usuarioValido(String usuario, String password){
        if(usuario.contentEquals("jose")&& password.contentEquals("1234"))
            return true;
        return false;
    }
}
