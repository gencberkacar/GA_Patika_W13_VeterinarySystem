package dev.patika.business.abstracts;

import dev.patika.entities.Customer;
import dev.patika.entities.Vaccine;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {

    //Where crud processing takes place
    Vaccine getByID(Long id);

    Vaccine save(Vaccine vaccine);

    String delete(Long id);

    Vaccine update(Vaccine vaccine);

    List<Vaccine> findAll();

    Vaccine getByName(String name);


    List<Vaccine> findAllByProtectionStartDateBetween(LocalDate startDate, LocalDate finishDate);

    List<Vaccine> findByAnimalId(Long animal_id);
}