package dev.patika.dao;

import dev.patika.entities.AvailableDate;
import dev.patika.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate, Long> {

    //We extends the repository to be able to use Jpa features.
    List<AvailableDate> findByAvailableDateAndDoctorId(LocalDate availableDate, Long doctorId);


}