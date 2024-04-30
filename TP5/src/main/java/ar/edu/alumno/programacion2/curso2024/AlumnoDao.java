package ar.edu.alumno.programacion2.curso2024;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public class AlumnoDao implements Dao<Alumno>{
    private HashMap<Integer, Alumno> alumnos;

    public AlumnoDao(){
        alumnos = new HashMap<>();
//        alumnos.put(1,new Alumno(1,"Franco","Narvae","fr.narvaez@gmail.com"));
//        alumnos.put(2,new Alumno(2,"Augusto","Kark","akrk@gmail.com"));

    }

    @Override
    public void save(Alumno alumno) {
        int numList=alumnos.size();
        alumnos.put(alumno.getLegajo(),alumno);


    }

    @Override
    public void update(Alumno alumno, String[] params) {
        alumno.setNombre(params[0]);
        alumno.setApellido(params[1]);
        alumno.setEmail(params[2]);
        alumnos.put(alumno.getLegajo(), alumno);
    }

    @Override
    public void delete(Alumno alumno) {
        alumnos.remove(alumno.getLegajo());
    }

    @Override
    public Optional<Alumno> get(int id) {
        return Optional.ofNullable(alumnos.get((id)));
    }

    @Override
    public List<Alumno> getAll() {
        return new ArrayList<>(alumnos.values());

    }
}
