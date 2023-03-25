package ssvv.example.src.validation;
import ssvv.example.src.domain.Student;

import java.util.regex.Pattern;

public class StudentValidator implements Validator<Student> {
    private Pattern pattern = Pattern.compile("\\d+");

    public boolean isNumeric(String strNum) {
        return pattern.matcher(strNum).matches();
    }

    public void validate(Student student) throws ValidationException {
        if (student.getID() == null || student.getID().equals("") || !isNumeric(student.getID())) {
            throw new ValidationException("ID invalid! \n");
        }
        if (student.getNume() == null || student.getNume().equals("")) {
            throw new ValidationException("Nume invalid! \n");
        }
        if (student.getGrupa() <= 110 || student.getGrupa() >= 938) {
            throw new ValidationException("Grupa invalida! \n");
        }
    }
}

