package org.alumno.jose.jose_primer_app_spring_boot.srv;

import org.alumno.jose.jose_primer_app_spring_boot.model.Alumno;
import org.alumno.jose.jose_primer_app_spring_boot.srv.excepciones.AlumnoDuplicadoException;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    
    List<Alumno> alumnos = new ArrayList<>();
    public AlumnoService(){
        alumnos.add(new Alumno("12345678A", "Juan Pérez", 20, "DAM", 2));
        alumnos.add(new Alumno("87654321B", "Ana García", 22, "DAW", 1));
        alumnos.add(new Alumno("11223344C", "Luis Rodríguez", 21, "DAM", 2));
        alumnos.add(new Alumno("22334455D", "Marta López", 23, "DAW", 1));
        alumnos.add(new Alumno("33445566E", "Carlos Sánchez", 19, "DAM", 1));

    }
    // Método que devuelve una lista simulada de alumnos
    public List<Alumno> listaAlumnos() {
        return alumnos;
    }

 // Método para encontrar un alumno por su DNI
 public Alumno findAlumnoByDni(String dni) {
    Optional<Alumno> alumnoEncontrado = alumnos.stream()
            .filter(alumno -> alumno.getDni().equals(dni))
            .findFirst();

    if (alumnoEncontrado.isPresent()) {
        return alumnoEncontrado.get();
    } else {
        throw new IllegalArgumentException("Alumno con DNI " + dni + " no encontrado.");
    }
}

// Método para modificar un alumno existente
public void modificarAlumno(Alumno alumnoModificado) {
    Alumno alumnoExistente = findAlumnoByDni(alumnoModificado.getDni());

    // Modificar los datos del alumno encontrado
    alumnoExistente.setNombre(alumnoModificado.getNombre());
    alumnoExistente.setEdad(alumnoModificado.getEdad());
    alumnoExistente.setCiclo(alumnoModificado.getCiclo());
    alumnoExistente.setCurso(alumnoModificado.getCurso());

    // Aquí no necesitas guardar en la lista, ya que `alumnoExistente` está referenciado en la lista
}

    public void addAlumno(Alumno alumno) throws AlumnoDuplicadoException {
        // Verificar si el alumno ya existe en la lista
        for (Alumno a : alumnos) {
            if (a.getDni().equals(alumno.getDni())) {
                throw new AlumnoDuplicadoException("Alumno con DNI " + alumno.getDni() + " ya existe.");
            }
        }
    
        // Agregar alumno si no es duplicado
        alumnos.add(alumno);
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    public void borrarAlumno(String dni) throws Exception {
        Iterator<Alumno> iterator = alumnos.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Alumno alumno = iterator.next();
            if (alumno.getDni().equals(dni)) {
                iterator.remove();  // Eliminar el alumno
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new Exception("Alumno con DNI " + dni + " no encontrado.");
        }
    }
   // Método para actualizar un alumno existente
   public void updateAlumno(Alumno alumno) {
    for (int i = 0; i < alumnos.size(); i++) {
        if (alumnos.get(i).getDni().equals(alumno.getDni())) {
            alumnos.set(i, alumno); // Actualizar el alumno encontrado
            return;
        }
    }
    throw new IllegalArgumentException("Alumno no encontrado con DNI: " + alumno.getDni());
}
}
