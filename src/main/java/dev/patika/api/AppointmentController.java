package dev.patika.api;

import dev.patika.business.abstracts.IAppointmentService;
import dev.patika.entities.Animal;
import dev.patika.entities.Appointment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    //Is where we do our mapping and customize it

    private final IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> findAll() {
        return this.appointmentService.findAll();
    }

    @GetMapping("/getByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment getByID(@PathVariable("id") Long id) {

        return this.appointmentService.getByID(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment save(@RequestBody Appointment appointment) {
        return this.appointmentService.save(appointment);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Appointment update(@RequestBody Appointment appointment) {
        return this.appointmentService.update(appointment);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") Long id) {
        return this.appointmentService.delete(id);
    }

    @GetMapping("/getByAnimalIdBetween")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> listApoByAnimalIdBetween(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
            @RequestParam("animalId") long id) {

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);
        return appointmentService.findByAnimalIdBetweenDates(startDateTime, endDateTime, id);
    }

    @GetMapping("/getByDoctorIdBetween")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> listApoByDoctorIdBetween(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
            @RequestParam("doctorId") long id) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);
        return appointmentService.findByDoctorIdBetweenDates(startDateTime, endDateTime, id);
    }

}