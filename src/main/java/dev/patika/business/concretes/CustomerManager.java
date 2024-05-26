package dev.patika.business.concretes;

import dev.patika.business.abstracts.ICustomerService;
import dev.patika.dao.CustomerRepo;
import dev.patika.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements ICustomerService {

    //Is where we override and customize our methods
    private final CustomerRepo customerRepo;

    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    @Override
    public Customer getByID(Long id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public String delete(Long id) {
        this.customerRepo.delete(this.getByID(id));
        return "customer deleted with this id" + id;
    }

    @Override
    public Customer update(Customer customer) {
        Customer existCustomer = customerRepo.findById(customer.getId()).orElseThrow();
        existCustomer.setAddress(customer.getAddress());
        existCustomer.setCity(customer.getCity());
        existCustomer.setName(customer.getName());
        existCustomer.setPhone(customer.getPhone());
        existCustomer.setMail(customer.getMail());

        return this.customerRepo.save(existCustomer);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }

    @Override
    public Customer getByName(String name) {
        return this.customerRepo.findByName(name);
    }


}