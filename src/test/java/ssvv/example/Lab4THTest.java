package ssvv.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
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

@RunWith(MockitoJUnitRunner.class)
public class Lab4THTest {
    @Mock
    private Validator<Student> studentValidator;
    @Mock
    private Validator<Tema> temaValidator;
    @Mock
    private Validator<Nota> notaValidator;
    private Service service;

    @InjectMocks
    private StudentRepository studentRepositoryMock;
    @InjectMocks
    private TemaRepository temaRepositoryMock;
    @InjectMocks
    private NotaRepository notaRepositoryMock;

    @Before
    public void setUp() {
        service =  new Service(studentRepositoryMock, temaRepositoryMock, notaRepositoryMock);
    }

    @Test
    public void tc_1_incremental() {
        int response = service.saveStudent("30", "Robert Cojocariu", 937);
        assertEquals(0, response);
    }

    @Test
    public void tc_2_incremental() {
        int addStudentResponse = service.saveStudent("30", "Robert Cojocariu", 937);
        assertEquals(0, addStudentResponse);
        int addTemaResponse = service.saveTema("99", "test", 12, 6);
        assertEquals(0, addTemaResponse);
    }

    @Test
    public void tc_3_incremental() {
        int addStudentResponse = service.saveStudent("30", "Robert Cojocariu", 937);
        assertEquals(0, addStudentResponse);
        int addTemaResponse = service.saveTema("99", "test", 12, 6);
        assertEquals(0, addTemaResponse);
        int addGradeResponse = service.saveNota("30", "99", 9.5, 7, "good");
        assertEquals(0, addGradeResponse);
    }
}
