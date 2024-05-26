package dev.patika.business.abstracts;

import dev.patika.entities.Doctor;
import dev.patika.entities.Vaccine;

import java.util.List;

public interface IDoctorService {

    //Where crud processing takes place
    Doctor getByID(Long id);

    Doctor save(Doctor doctor);

    String delete(Long id);

    Doctor update(Doctor doctor);

    List<Doctor> findAll();

    Doctor getByName(String name);
}