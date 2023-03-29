package ssvv.example;

import org.junit.Test;
import ssvv.example.src.domain.Student;
import ssvv.example.src.domain.Tema;
import ssvv.example.src.repository.StudentRepository;
import ssvv.example.src.repository.TemaRepository;
import ssvv.example.src.service.Service;
import ssvv.example.src.validation.StudentValidator;
import ssvv.example.src.validation.TemaValidator;
import ssvv.example.src.validation.Validator;

import static org.junit.Assert.assertEquals;

public class TemaTest {

    private Validator<Tema> temaValidator = new TemaValidator();
    private TemaRepository temaRepository = new TemaRepository(temaValidator);
    private Service service = new Service(null, temaRepository, null);


    @Test
    public void tc_1_validTema() {
        int response = service.saveTema("99", "test", 12, 6);
        assertEquals(0, response);
    }

    @Test
    public void tc_2_invalidTemaBigDeadline() {
        int response = service.saveTema("99", "test", 20, 6);
        assertEquals(1, response);
    }
}
