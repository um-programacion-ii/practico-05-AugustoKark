package ar.edu.alumno.programacion2.curso2024;

import java.util.List;
import java.util.Optional;

public interface Dao <T>{

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);

    Optional<T> get(int id);

    List<T> getAll();


}
