package dev.patika.business.abstracts;


import dev.patika.entities.Customer;

import java.util.List;

public interface ICustomerService {

    //Where crud processing takes place
    Customer getByID(Long id);

    Customer save(Customer customer);

    String delete(Long id);

    Customer update(Customer customer);

    List<Customer> findAll();

    Customer getByName(String name);


}