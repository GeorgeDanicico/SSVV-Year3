package ssvv.example;

import ssvv.example.src.domain.Student;
import ssvv.example.src.repository.StudentXMLRepository;
import ssvv.example.src.service.Service;
import ssvv.example.src.validation.StudentValidator;
import ssvv.example.src.validation.Validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StudentTest {
    private Validator<Student> studentValidator = new StudentValidator();
    private StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "students.xml");
    private Service service = new Service(studentXMLRepository, null, null);

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
