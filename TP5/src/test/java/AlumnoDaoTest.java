import ar.edu.alumno.programacion2.curso2024.Alumno;
import ar.edu.alumno.programacion2.curso2024.AlumnoDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class AlumnoDaoTest {

    private AlumnoDao alumnoDao;
    private Alumno alumno1;

    @BeforeEach
    public void setup() {
        alumnoDao = new AlumnoDao();
        alumno1 = new Alumno(1, "Franco", "Narvaez", "fr.narva@gmail.com");
        alumnoDao.save(alumno1);
    }

    @Test
    public void testSave() {
        Alumno alumno2 = new Alumno(2, "John", "Doe", "john.doe@gmail.com");
        alumnoDao.save(alumno2);
        assertEquals(alumno2, alumnoDao.get(2).orElse(null));
    }

    @Test
    public void testUpdate() {
        String[] newParams = {"John", "Doe", "john.doe@gmail.com"};
        alumnoDao.update(alumno1, newParams);
        assertEquals("John", alumnoDao.get(1).orElse(null).getNombre());
        assertEquals("Doe", alumnoDao.get(1).orElse(null).getApellido());
        assertEquals("john.doe@gmail.com", alumnoDao.get(1).orElse(null).getEmail());
    }

    @Test
    public void testDelete() {
        alumnoDao.delete(alumno1);
        assertFalse(alumnoDao.get(1).isPresent());
    }

  @Test
public void testGetAll() {
    AlumnoDao localAlumnoDao = new AlumnoDao();
    Alumno localAlumno1 = new Alumno(1, "Franco", "Narvaez", "fr.narva@gmail.com");
    localAlumnoDao.save(localAlumno1);
    assertEquals(1, localAlumnoDao.getAll().size());
}

    @Test
    public void testGet() {
        assertEquals(alumno1, alumnoDao.get(1).orElse(null));
    }

}
