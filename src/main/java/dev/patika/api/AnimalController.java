package dev.patika.api;

import dev.patika.business.abstracts.IAnimalService;
import dev.patika.entities.Animal;
import dev.patika.entities.AvailableDate;
import dev.patika.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    //Is where we do our mapping and customize it
    private final IAnimalService animalService;

    public AnimalController(IAnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> findAll() {
        return this.animalService.findAll();
    }

    @GetMapping("/getByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getByID(@PathVariable("id") Long id) {
        return this.animalService.getByID(id);
    }

    @GetMapping("/getByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getByName(@PathVariable("name") String name) {
        return this.animalService.getByName(name);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Animal save(@RequestBody Animal animal) {
        return this.animalService.save(animal);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Animal update(@RequestBody Animal animal) {
        return this.animalService.update(animal);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") Long id) {
        return this.animalService.delete(id);
    }

    @GetMapping("/getByCustomerId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getByCustomerId(@PathVariable("id") Long customer_id) {

        return this.animalService.findByCustomerId(customer_id);
    }

    @GetMapping("/getByAnimalId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getByAnimalId(@PathVariable("id") Long animal_id) {

        return this.animalService.findByAnimalId(animal_id);
    }
}