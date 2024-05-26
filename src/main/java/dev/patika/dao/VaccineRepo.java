package dev.patika.dao;

import dev.patika.entities.Animal;
import dev.patika.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Long> {

    //We extends the repository to be able to use Jpa features.
    Vaccine findByName(String name);

    Vaccine findByAnimalIdAndName(Long animal_id, String name);


    List<Vaccine> findAllByProtectionStartDateBetween(LocalDate startDate, LocalDate finishDate);

    List<Vaccine> findByAnimalId(Long animal_id);

}