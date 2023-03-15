package ssvv.example.src.repository;

import ssvv.example.src.domain.Tema;
import ssvv.example.src.validation.*;

public class TemaRepository extends AbstractCRUDRepository<String, Tema> {
    public TemaRepository(Validator<Tema> validator) {
        super(validator);
    }
}

