package dev.patika.dao;

import dev.patika.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    //We extends the repository to be able to use Jpa features.
    Customer findByName(String name);


}