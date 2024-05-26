package dev.patika.business.abstracts;

import dev.patika.entities.Animal;
import dev.patika.entities.Customer;

import java.util.List;

public interface IAnimalService {

    //Where crud processing takes place
    Animal getByID(Long id);

    Animal save(Animal animal);

    String delete(Long id);

    Animal update(Animal animal);

    List<Animal> findAll();

    Animal getByName(String name);

    List<Animal> findByCustomerId(Long customer_id);

    List<Animal> findByAnimalId(Long animal_id);
}