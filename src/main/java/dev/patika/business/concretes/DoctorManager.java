package dev.patika.business.concretes;

import dev.patika.business.abstracts.IDoctorService;
import dev.patika.dao.DoctorRepo;
import dev.patika.entities.Animal;
import dev.patika.entities.Doctor;
import dev.patika.entities.Vaccine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorManager implements IDoctorService {

    //Is where we override and customize our methods

    private final DoctorRepo doctorRepo;

    public DoctorManager(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor getByID(Long id) {
        return this.doctorRepo.findById(id).orElseThrow();
    }

    @Override
    public Doctor save(Doctor doctor) {
        return this.doctorRepo.save(doctor);
    }

    @Override
    public String delete(Long id) {
        this.doctorRepo.delete(this.getByID(id));
        return "doctor deleted with this id" + id;
    }

    @Override
    public Doctor update(Doctor doctor) {
        Doctor existDoctor = doctorRepo.findById(doctor.getId()).orElseThrow();
        existDoctor.setName(doctor.getName());
        existDoctor.setCity(doctor.getCity());
        existDoctor.setMail(doctor.getMail());
        existDoctor.setPhone(doctor.getPhone());
        existDoctor.setAddress(doctor.getAddress());
        return this.doctorRepo.save(existDoctor);
    }

    @Override
    public List<Doctor> findAll() {
        return this.doctorRepo.findAll();
    }

    @Override
    public Doctor getByName(String name) {
        return this.doctorRepo.findByName(name);
    }


}