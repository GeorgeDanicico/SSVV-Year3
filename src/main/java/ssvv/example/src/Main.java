package ssvv.example.src;

import ssvv.example.src.console.*;
import ssvv.example.src.domain.*;
import ssvv.example.src.repository.*;
import ssvv.example.src.service.*;
import ssvv.example.src.validation.*;

public class Main {
    public static void main(String[] args) {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentRepository fileRepository1 = new StudentRepository(studentValidator);
        TemaRepository fileRepository2 = new TemaRepository(temaValidator);
        NotaRepository fileRepository3 = new NotaRepository(notaValidator);

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        UI consola = new UI(service);
        consola.run();

        //PENTRU GUI
        // de avut un check: daca profesorul introduce sau nu saptamana la timp
        // daca se introduce nota la timp, se preia saptamana din sistem
        // altfel, se introduce de la tastatura
    }
}
