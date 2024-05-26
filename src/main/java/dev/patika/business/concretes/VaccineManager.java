package dev.patika.business.concretes;

import dev.patika.business.abstracts.IVaccineService;
import dev.patika.dao.VaccineRepo;
import dev.patika.entities.Customer;
import dev.patika.entities.Vaccine;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class VaccineManager implements IVaccineService {

    //Is where we override and customize our methods
    private final VaccineRepo vaccineRepo;

    public VaccineManager(VaccineRepo vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }


    @Override
    public Vaccine getByID(Long id) {
        return this.vaccineRepo.findById(id).orElseThrow();
    }

    @Override
    public Vaccine save(Vaccine vaccine) {
        Long animal_id = vaccine.getAnimal().getId();
        String name = vaccine.getName();
        Vaccine animalLastVaccine = vaccineRepo.findByAnimalIdAndName(animal_id, name);
        if (animalLastVaccine == null) {
            return this.vaccineRepo.save(vaccine);
        } else {
            if (animalLastVaccine.getProtectionFinishDate().isBefore(vaccine.getProtectionStartDate())) {
                return this.vaccineRepo.save(vaccine);
            } else {
                throw new ResponseStatusException(HttpStatus.CONFLICT);
            }
        }
    }


    @Override
    public String delete(Long id) {
        this.vaccineRepo.delete(this.getByID(id));
        return "vaccine deleted with this id" + id;
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        Vaccine existDate = vaccineRepo.findById(vaccine.getId()).orElseThrow();
        existDate.setCode(vaccine.getCode());
        existDate.setName(vaccine.getName());
        existDate.setProtectionStartDate(vaccine.getProtectionStartDate());
        existDate.setProtectionFinishDate(vaccine.getProtectionFinishDate());
        return this.vaccineRepo.save(existDate);
    }

    @Override
    public List<Vaccine> findAll() {
        return this.vaccineRepo.findAll();
    }

    @Override
    public Vaccine getByName(String name) {
        return this.vaccineRepo.findByName(name);
    }

    @Override
    public List<Vaccine> findAllByProtectionStartDateBetween(LocalDate startDate, LocalDate finishDate) {
        return this.vaccineRepo.findAllByProtectionStartDateBetween(startDate, finishDate);
    }

    @Override
    public List<Vaccine> findByAnimalId(Long animal_id) {
        return this.vaccineRepo.findByAnimalId(animal_id);
    }


}