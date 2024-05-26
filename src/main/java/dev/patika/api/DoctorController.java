package dev.patika.api;

import dev.patika.business.abstracts.IDoctorService;
import dev.patika.entities.Animal;
import dev.patika.entities.Doctor;
import dev.patika.entities.Vaccine;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    //Is where we do our mapping and customize it
    private final IDoctorService doctorService;

    public DoctorController(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> findAll() {
        return this.doctorService.findAll();
    }

    @GetMapping("/getByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getByID(@PathVariable("id") Long id) {

        return this.doctorService.getByID(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor doctor) {
        return this.doctorService.save(doctor);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Doctor update(@RequestBody Doctor doctor) {
        return this.doctorService.update(doctor);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") Long id) {
        return this.doctorService.delete(id);
    }

    @GetMapping("/getByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getByName(@PathVariable("name") String name) {
        return this.doctorService.getByName(name);
    }
}