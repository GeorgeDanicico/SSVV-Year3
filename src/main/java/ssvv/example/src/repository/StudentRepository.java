package ssvv.example.src.repository;

import ssvv.example.src.domain.Student;
import ssvv.example.src.validation.*;

public class StudentRepository extends AbstractCRUDRepository<String, Student> {
    public StudentRepository(Validator<Student> validator) {
        super(validator);
    }
}

