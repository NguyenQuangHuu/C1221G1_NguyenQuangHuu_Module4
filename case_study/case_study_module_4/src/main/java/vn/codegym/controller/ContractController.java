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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.dto.ContractDto;
import vn.codegym.model.Contract;
import vn.codegym.model.Customer;
import vn.codegym.model.Employee;
import vn.codegym.model.Facility;
import vn.codegym.service.IContractService;
import vn.codegym.service.ICustomerService;
import vn.codegym.service.IEmployeeService;
import vn.codegym.service.IFacilityService;

import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IFacilityService iFacilityService;

    @ModelAttribute("employees")
    public List<Employee> findAllEmployee(){
        return this.iEmployeeService.findAllEmployee();
    }

    @ModelAttribute("customers")
    public List<Customer> findAllCustomer(){
        return this.iCustomerService.findAllCustomer();
    }

    @ModelAttribute("facilities")
    public List<Facility> findAllFacility(){
        return this.iFacilityService.findAllFacility();
    }

    @GetMapping("")
    public String listContract(Model model,@PageableDefault(value=4) Pageable pageable){
        Page<Contract> contractPage = this.iContractService.findAll(pageable);
        model.addAttribute("contracts",contractPage);
        return "/contracts/list";
    }

    @GetMapping("/new")
    public String newContractForm(Model model){
        model.addAttribute("contractDto",new ContractDto());
        return "/contracts/new";
    }

    @PostMapping("/new")
    public String newContract(@ModelAttribute @Validated ContractDto contractDto, BindingResult bindingResult){
        new ContractDto().validate(contractDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "contracts/new";
        }
        this.iContractService.add(contractDto);
        return "redirect:/contracts/";
    }
}
