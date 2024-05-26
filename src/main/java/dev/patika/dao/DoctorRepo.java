package dev.patika.dao;

import dev.patika.entities.Customer;
import dev.patika.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    //We extends the repository to be able to use Jpa features.
    Doctor findByName(String name);


}