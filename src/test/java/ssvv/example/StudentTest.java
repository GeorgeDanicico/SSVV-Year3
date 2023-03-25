package ssvv.example;

import ssvv.example.src.domain.Student;
import ssvv.example.src.repository.StudentRepository;
import ssvv.example.src.service.Service;
import ssvv.example.src.validation.StudentValidator;
import ssvv.example.src.validation.Validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StudentTest {
    private Validator<Student> studentValidator = new StudentValidator();
    private StudentRepository studentRepository = new StudentRepository(studentValidator);
    private Service service = new Service(studentRepository, null, null);

    @Test
    public void tc_1_validStudentWithGroup() {
        int response = service.saveStudent("30", "Robert Cojocariu", 212);
        assertEquals(1, response);
    }

    @Test
    public void tc_2_invalidStudentWithGroup() {
        int response = service.saveStudent("18", "Robert Cojocariu", 1234);
        assertEquals(1, response);

    }
}
