package dev.patika.api;

import dev.patika.business.abstracts.ICustomerService;
import dev.patika.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    //Is where we do our mapping and customize it
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findAll() {
        return this.customerService.findAll();
    }

    @GetMapping("/getByID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getByID(@PathVariable("id") Long id) {

        return this.customerService.getByID(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody Customer customer) {
        return this.customerService.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") Long id) {
        return this.customerService.delete(id);
    }

    @GetMapping("/getByCustomerName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getByName(@PathVariable("name") String name) {

        return this.customerService.getByName(name);
    }


}