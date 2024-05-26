package dev.patika.api;

import dev.patika.business.abstracts.IVaccineService;
import dev.patika.entities.Appointment;
import dev.patika.entities.Customer;
import dev.patika.entities.Vaccine;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

    //Is where we do our mapping and customize it

    private final IVaccineService vaccineService;

    public VaccineController(IVaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaccine> findAll() {
        return this.vaccineService.findAll();
    }

    @GetMapping("/getByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine getByID(@PathVariable("id") Long id) {

        return this.vaccineService.getByID(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Vaccine save(@RequestBody Vaccine vaccine) {
        return this.vaccineService.save(vaccine);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine update(@RequestBody Vaccine vaccine) {
        return this.vaccineService.update(vaccine);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") Long id) {
        return this.vaccineService.delete(id);
    }

    @GetMapping("/getBetween") //http://localhost:7171/vaccine/getBetween?startDate=2023-01-01&endDate=2024-01-01
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Vaccine>> getAnimalVaccinesBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Vaccine> vaccines = vaccineService.findAllByProtectionStartDateBetween(startDate, endDate);
        if (vaccines.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(vaccines);
    }


    @GetMapping("/getAnimalVaccine/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaccine> getByAnimalId(@PathVariable("id") Long anima_id) {

        return this.vaccineService.findByAnimalId(anima_id);
    }
}