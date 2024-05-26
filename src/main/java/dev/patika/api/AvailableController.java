package dev.patika.api;

import dev.patika.business.abstracts.IAvailableDateService;
import dev.patika.entities.AvailableDate;
import dev.patika.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/date")
public class AvailableController {

    //Is where we do our mapping and customize it

    private final IAvailableDateService availableDateService;

    public AvailableController(IAvailableDateService availableDateService) {
        this.availableDateService = availableDateService;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<AvailableDate> findAll() {
        return this.availableDateService.findAll();
    }

    @GetMapping("/getByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDate getByID(@PathVariable("id") Long id) {

        return this.availableDateService.getByID(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AvailableDate save(@RequestBody AvailableDate availableDate) {
        return this.availableDateService.save(availableDate);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDate update(@RequestBody AvailableDate availableDate) {
        return this.availableDateService.update(availableDate);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") Long id) {
        return this.availableDateService.delete(id);
    }


}