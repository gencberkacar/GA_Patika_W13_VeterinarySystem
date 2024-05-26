package dev.patika.business.concretes;

import dev.patika.business.abstracts.IAvailableDateService;
import dev.patika.dao.AvailableDateRepo;
import dev.patika.entities.AvailableDate;
import dev.patika.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableDateManager implements IAvailableDateService {

    //Is where we override and customize our methods

    private final AvailableDateRepo availableDateRepo;

    public AvailableDateManager(AvailableDateRepo availableDateRepo) {
        this.availableDateRepo = availableDateRepo;
    }


    @Override
    public AvailableDate getByID(Long id) {
        return this.availableDateRepo.findById(id).orElseThrow();
    }

    @Override
    public AvailableDate save(AvailableDate availableDate) {
        return this.availableDateRepo.save(availableDate);
    }

    @Override
    public String delete(Long id) {
        this.availableDateRepo.delete(this.getByID(id));
        return "Date deleted with this id" + id;
    }

    @Override
    public AvailableDate update(AvailableDate availableDate) {

        AvailableDate existDate = availableDateRepo.findById(availableDate.getId()).orElseThrow();
        existDate.setAvailableDate(availableDate.getAvailableDate());
        return this.availableDateRepo.save(existDate);
    }

    @Override
    public List<AvailableDate> findAll() {
        return this.availableDateRepo.findAll();
    }


}