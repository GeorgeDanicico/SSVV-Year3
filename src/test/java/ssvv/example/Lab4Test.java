package ssvv.example;

import org.junit.Test;
import ssvv.example.src.domain.Nota;
import ssvv.example.src.domain.Student;
import ssvv.example.src.domain.Tema;
import ssvv.example.src.repository.NotaRepository;
import ssvv.example.src.repository.StudentRepository;
import ssvv.example.src.repository.TemaRepository;
import ssvv.example.src.service.Service;
import ssvv.example.src.validation.NotaValidator;
import ssvv.example.src.validation.StudentValidator;
import ssvv.example.src.validation.TemaValidator;
import ssvv.example.src.validation.Validator;

import static org.junit.Assert.assertEquals;

public class Lab4Test {

    private Validator<Student> studentValidator = new StudentValidator();
    private StudentRepository studentRepository = new StudentRepository(studentValidator);
    private Validator<Tema> temaValidator = new TemaValidator();
    private TemaRepository temaRepository = new TemaRepository(temaValidator);
    private Validator<Nota> notaValidator = new NotaValidator();
    private NotaRepository notaRepository = new NotaRepository(notaValidator);

    private Service service = new Service(studentRepository, temaRepository, notaRepository);


    @Test
    public void tc_1_bigbang1() {
        int response = service.saveStudent("30", "Robert Cojocariu", 937);
        assertEquals(0, response);
    }

    @Test
    public void tc_2_bigbang2() {
        int response = service.saveTema("99", "test", 12, 6);
        assertEquals(0, response);
    }

    @Test
    public void tc_3_integration() {
        service.saveStudent("30", "Robert Cojocariu", 937);
        service.saveTema("99", "test", 12, 6);
        int response = service.saveNota("30", "99", 9.5, 7, "good");
        assertEquals(0, response);
    }
}
