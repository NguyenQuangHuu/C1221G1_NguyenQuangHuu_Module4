package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.CustomerDto;
import vn.codegym.dto.ICustomerDto;
import vn.codegym.model.Customer;
import vn.codegym.model.CustomerType;
import vn.codegym.service.ICustomerService;
import vn.codegym.service.ICustomerTypeService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute("types")
    public List<CustomerType> customerTypes(){
        return this.customerTypeService.findAll();
    }

    @GetMapping("")
    public String listCustomer(@PageableDefault(value=5) Pageable pageable, Model model,
                               @RequestParam Optional<String> nameQuery,
                               @RequestParam Optional<String> phoneQuery,
                               @RequestParam Optional<String> typeQuery
                               ){
        if(nameQuery.isPresent() || phoneQuery.isPresent() || typeQuery.isPresent()){
            String nameValue = nameQuery.orElse("");
            String phoneValue =phoneQuery.orElse("");
            String typeValue =typeQuery.orElse("");
            model.addAttribute("nameSearch",nameValue);
            model.addAttribute("phoneSearch",phoneValue);
            model.addAttribute("typeSearch",typeValue);
            Page<Customer> customerPage = this.customerService.findByNameAndPhoneAndTypeCustomer(
                    nameValue,phoneValue,typeValue,pageable);
            model.addAttribute("customers",customerPage);
        }else{
            Page<Customer> customers = this.customerService.findAll(pageable);
            model.addAttribute("customers",customers);
        }

        return "/customers/list";
    }

    @GetMapping("/new")
    public String newCustomerForm(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        return "/customers/new";
    }

    @PostMapping("/new")
    public String newCustomer(@ModelAttribute @Validated CustomerDto customerDto,
                                                        BindingResult bindingResult){
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/customers/new";
        }
        this.customerService.save(customerDto);
        return "redirect:/customers/";
    }

    @GetMapping("/detail/{id}")
    public String detailCustomer(@PathVariable Integer id, Model model){
        Customer customer = this.customerService.findById(id);
        if(customer == null){
            return "/customers/list";
        }
        model.addAttribute("customer",customer);
        return "/customers/details";
    }


    @GetMapping("/delete")
    public String forwardDelete(@RequestParam Integer id){
        return "redirect:/customers/delete/"+id;
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomerById(@PathVariable Integer id){
        Customer  customer = this.customerService.findById(id);
        if(customer==null){
            return "/customers/list";
        }
        this.customerService.delete(customer);
        return "redirect:/customers/";
    }


    @GetMapping("/update/{id}")
    public String updateCustomerForm(@PathVariable Integer id,Model model){
        Customer customer = this.customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto",customerDto);
        return "/customers/edit";
    }

    @PostMapping("/update/")
    public String updateCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult){
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/customers/edit";
        }
        this.customerService.save(customerDto);
        return "redirect:/customers/";
    }




}
