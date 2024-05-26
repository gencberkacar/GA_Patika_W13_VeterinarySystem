package dev.patika.business.concretes;

import dev.patika.business.abstracts.IAppointmentService;

import dev.patika.dao.AppointmentRepo;
import dev.patika.dao.AvailableDateRepo;
import dev.patika.entities.Appointment;
import dev.patika.entities.AvailableDate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentManager implements IAppointmentService {

    //Is where we override and customize our methods
    private final AvailableDateRepo availableDateRepo;
    private final AppointmentRepo appointmentRepo;

    public AppointmentManager(AvailableDateRepo availableDateRepo, AppointmentRepo appointmentRepo) {
        this.availableDateRepo = availableDateRepo;
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public Appointment getByID(Long id) {
        return this.appointmentRepo.findById(id).orElseThrow();
    }

    @Override
    public Appointment save(Appointment appointment) {
        LocalDateTime appointmentTime = appointment.getAppointmentDate();
        Long doctorID = appointment.getDoctor().getId();
        List<AvailableDate> availableDateList = availableDateRepo.findByAvailableDateAndDoctorId(appointmentTime.toLocalDate(), doctorID);
        Appointment appointmentList = appointmentRepo.findByAppointmentDateAndDoctorId(appointmentTime, doctorID);
        if (availableDateList != null && appointmentList == null) {
            return this.appointmentRepo.save(appointment);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @Override
    public String delete(Long id) {
        this.appointmentRepo.delete(this.getByID(id));
        return "appointment deleted with this id" + id;
    }

    @Override
    public Appointment update(Appointment appointment) {
        Appointment existAppointment = appointmentRepo.findById(appointment.getId()).orElseThrow();
        existAppointment.setAppointmentDate(appointment.getAppointmentDate());

        return this.appointmentRepo.save(existAppointment);
    }

    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepo.findAll();
    }

    @Override
    public List<Appointment> findByAnimalIdBetweenDates(LocalDateTime startDate, LocalDateTime endDate, Long animal_id) {
        return this.appointmentRepo.findByAppointmentDateBetweenAndAnimalId(startDate, endDate, animal_id);
    }

    @Override
    public List<Appointment> findByDoctorIdBetweenDates(LocalDateTime startDate, LocalDateTime endDate, Long doctor_id) {
        return this.appointmentRepo.findByAppointmentDateBetweenAndDoctorId(startDate, endDate, doctor_id);
    }


}