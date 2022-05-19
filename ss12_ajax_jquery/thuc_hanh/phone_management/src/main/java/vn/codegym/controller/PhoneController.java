package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Phone;
import vn.codegym.service.IPhoneService;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private IPhoneService iPhoneService;

    @PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone){
        return new ResponseEntity<>(this.iPhoneService.save(phone),HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", iPhoneService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Phone> editForm(@PathVariable Long id){
        return new ResponseEntity<>(this.iPhoneService.findById(id).get(),HttpStatus.OK);
    }

    @PatchMapping("/edit/")
    public ResponseEntity<Void> editSubmit(@RequestBody Phone phone){
        this.iPhoneService.save(phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Phone>> allPhones() {
        return new ResponseEntity<>(iPhoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> deleteSmartphone(@PathVariable Long id) {
        Optional<Phone> smartphoneOptional = iPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iPhoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }



}
