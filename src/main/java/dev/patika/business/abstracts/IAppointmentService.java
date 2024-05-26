ackage dev.patika.business.abstracts;

import dev.patika.entities.Appointment;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IAppointmentService {

    //Where crud processing takes place
    Appointment getByID(Long id);

    Appointment save(Appointment appointment);

    String delete(Long id);

    Appointment update(Appointment appointment);

    List<Appointment> findAll();

    List<Appointment> findByAnimalIdBetweenDates(LocalDateTime startDate, LocalDateTime endDate, Long animal_id);

    List<Appointment> findByDoctorIdBetweenDates(LocalDateTime startDate, LocalDateTime endDate, Long doctor_id);


}