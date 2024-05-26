package dev.patika.business.concretes;

import dev.patika.business.abstracts.IAnimalService;
import dev.patika.dao.AnimalRepo;
import dev.patika.entities.Animal;
import dev.patika.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalManager implements IAnimalService {

    //Is where we override and customize our methods
    private final AnimalRepo animalRepo;

    public AnimalManager(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @Override
    public Animal getByID(Long id) {
        return this.animalRepo.findById(id).orElseThrow();
    }

    @Override
    public Animal save(Animal animal) {
        return this.animalRepo.save(animal);
    }

    @Override
    public String delete(Long id) {
        this.animalRepo.delete(this.getByID(id));
        return "animal deleted with this id" + id;
    }

    @Override
    public Animal update(Animal animal) {
        Animal existAnimal = animalRepo.findById(animal.getId()).orElseThrow();
        existAnimal.setName(animal.getName());
        existAnimal.setBreed(animal.getBreed());
        existAnimal.setDate(animal.getDate());
        existAnimal.setGender(animal.getGender());
        existAnimal.setColour(animal.getColour());
        existAnimal.setSpecies(animal.getSpecies());
        return this.animalRepo.save(existAnimal);
    }

    @Override
    public List<Animal> findAll() {
        return this.animalRepo.findAll();
    }

    @Override
    public Animal getByName(String name) {
        return this.animalRepo.findByName(name);
    }

    @Override
    public List<Animal> findByCustomerId(Long customer_id) {
        return this.animalRepo.findByCustomerId(customer_id);
    }

    @Override
    public List<Animal> findByAnimalId(Long animal_id) {
        return this.animalRepo.findByAnimalId(animal_id);
    }
}