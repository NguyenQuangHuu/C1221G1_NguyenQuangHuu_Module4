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
import vn.codegym.dto.EmployeeDto;
import vn.codegym.model.Division;
import vn.codegym.model.Education;
import vn.codegym.model.Employee;
import vn.codegym.model.Position;
import vn.codegym.service.IDivisionService;
import vn.codegym.service.IEducationService;
import vn.codegym.service.IEmployeeService;
import vn.codegym.service.IPositionService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IEducationService iEducationService;
    @Autowired
    private IPositionService iPositionService;

    @ModelAttribute("educations")
    public List<Education> listEducation(){
        return this.iEducationService.findAll();
    }

    @ModelAttribute("positions")
    public List<Position> listPosition(){
        return this.iPositionService.findAll();
    }

    @ModelAttribute("divisions")
    public List<Division> listDivision(){
        return this.iDivisionService.findAll();
    }


    @GetMapping("")
    public String getListEmployees(@PageableDefault(value=8) Pageable pageable, Model model,
                                   @RequestParam Optional<String> nameQuery,
                                   @RequestParam Optional<String> phoneQuery,
                                   @RequestParam Optional<String> divisionQuery
                                   ){
        if(nameQuery.isPresent()||phoneQuery.isPresent()||divisionQuery.isPresent()){
            String name = nameQuery.orElse("");
            String phone = phoneQuery.orElse("");
            String division = divisionQuery.orElse("");
            model.addAttribute("name",name);
            model.addAttribute("phone",phone);
            model.addAttribute("division",division);
            Page<Employee> employeePage = this.iEmployeeService.findAllByNameAndPhoneAndDivision(name,phone,division,pageable);
            model.addAttribute("employeeList",employeePage);
        }else{
            Page<Employee> employeePage = this.iEmployeeService.findAll(pageable);
            model.addAttribute("employeeList",employeePage);
        }

        return "/employees/list";
    }

    @GetMapping("/create")
    public String newEmployeeForm(Model model){
        model.addAttribute("employeeDto",new EmployeeDto());
        return "/employees/new";
    }

    @PostMapping("/create")
    public String newEmployee(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/employees/new";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        this.iEmployeeService.save(employee);
        return "redirect:/employees/";
    }

    @GetMapping("/detail/{id}")
    public String detailEmployee(@PathVariable Integer id,Model model){
        Employee employee = this.iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        model.addAttribute("employeeDto",employeeDto);
        return "/employees/details";
    }


    @GetMapping("/update/{id}")
    public String editEmployeeForm(@PathVariable Integer id, Model model){
        Employee employee = this.iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        model.addAttribute("employeeDto",employeeDto);
        return "/employees/edit";
    }

    @PostMapping("/update")
    public String editEmployee(@ModelAttribute @Validated  EmployeeDto employeeDto,BindingResult bindingResult){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/employees/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        this.iEmployeeService.save(employee);
        return "redirect:/employees/";
    }

    @GetMapping("/delete")
    public String forwardDelete(@RequestParam Integer id){
        return "redirect:/employees/delete/"+id;
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        Employee employee = this.iEmployeeService.findById(id);
        if(employee==null){
            return "redirect:/employees/";
        }
        this.iEmployeeService.remove(employee);
        return "redirect:/employees/";
    }

    @ExceptionHandler(Exception.class)
    public String error(){
        return "404-page";
    }
}
