package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.CustomerDto;
import vn.codegym.model.Customer;
import vn.codegym.service.ICustomerService;
import vn.codegym.service.ICustomerTypeService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/")
    public ResponseEntity<Page<Customer>> getAll(Pageable pageable){
        Page<Customer> customers = this.iCustomerService.findAll(pageable);
        if(customers.getSize() == 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getOneById(@PathVariable Integer id){
        return new ResponseEntity<>(this.iCustomerService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> create(@RequestBody CustomerDto customerDto){
        this.iCustomerService.save(customerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Customer> editForm(@PathVariable Integer id){
        return new ResponseEntity<>(this.iCustomerService.findById(id),HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Void> editSubmit(@RequestBody CustomerDto customerDto){
        this.iCustomerService.save(customerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id){
        Customer customer = this.iCustomerService.findById(id);
        this.iCustomerService.delete(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
