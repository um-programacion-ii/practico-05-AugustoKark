package ar.edu.alumno.programacion2.curso2024;

import java.util.Optional;

public class Main {
    private static Dao<Alumno> alumnoDao;

    public static void main(String[] args) {
        alumnoDao = new AlumnoDao();

        createAlumno(new Alumno(3, "John", "Doe", "john.doe@gmail.com"));
        updateAlumno(1, new String[]{"Jake","Paul", "jake@domain.com"});
        deleteAlumno(2);
        printAllAlumnos();
    }

    private static void createAlumno(Alumno alumno) {
        alumnoDao.save(alumno);
    }

    private static void updateAlumno(int id, String[] params) {
        Optional<Alumno> user = alumnoDao.get(id);
        if (user.isPresent()) {
            alumnoDao.update(user.get(), params);
        } else {
            throw new IllegalArgumentException("No se encontró un alumno con el id: " + id);
        }
    }

    private static void deleteAlumno(int id) {
        Optional<Alumno> user = alumnoDao.get(id);
        if (user.isPresent()) {
            alumnoDao.delete(user.get());
        } else {
            throw new IllegalArgumentException("No se encontró un alumno con el id: " + id);
        }
    }

    private static void printAllAlumnos() {
        alumnoDao.getAll().forEach(user -> System.out.println(user.getNombre()));
    }
}