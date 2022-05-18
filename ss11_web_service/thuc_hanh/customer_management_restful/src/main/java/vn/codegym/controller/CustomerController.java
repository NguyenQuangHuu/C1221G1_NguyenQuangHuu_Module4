package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Customer;
import vn.codegym.service.ICustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("/customers")
    public ResponseEntity<Page<Customer>> getList(@PageableDefault(value = 6) Pageable pageable){
        Page<Customer> customers = this.iCustomerService.findAll(pageable);
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getOne(@PathVariable Long id){
        Customer customer = this.iCustomerService.findById(id);
        if(customer==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @PostMapping("/customers/create")
    public ResponseEntity<Void> addNew(@RequestBody Customer customer){
        this.iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/customers/delete/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable Long id){
        Customer customer = this.iCustomerService.findById(id);
        if(customer==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iCustomerService.delete(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
