package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.Division;
import vn.codegym.model.Education;
import vn.codegym.model.Employee;
import vn.codegym.model.Position;
import vn.codegym.service.IDivisionService;
import vn.codegym.service.IEducationService;
import vn.codegym.service.IEmployeeService;
import vn.codegym.service.IPositionService;

import java.util.List;

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

    @ModelAttribute("education")
    public List<Education> listEducation(){
        return this.iEducationService.findAll();
    }

    @ModelAttribute("position")
    public List<Position> listPosition(){
        return this.iPositionService.findAll();
    }

    @ModelAttribute("education")
    public List<Division> listDivision(){
        return this.iDivisionService.findAll();
    }


    @GetMapping("")
    public String getListEmployees(Pageable pageable, Model model){
        Page<Employee> employeePage = this.iEmployeeService.findAll(pageable);
        model.addAttribute("employeeList",employeePage);
        return "/employees/list";
    }

}
