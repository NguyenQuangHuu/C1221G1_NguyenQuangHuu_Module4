package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Employee;
import vn.codegym.repository.IEmployeeRepository;
import vn.codegym.service.IEmployeeService;



@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Integer id) {
        return this.iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(Employee employee) {
        this.iEmployeeRepository.delete(employee);
    }

    @Override
    public Page<Employee> findAllByNameAndPhoneAndDivision(String name, String phone, String division, Pageable pageable) {
        if(division.equals("")){
            return this.iEmployeeRepository.findAllByNameContainingAndPhoneContaining(name,phone,pageable);
        }else{
            return this.iEmployeeRepository.findAllByNameContainingAndPhoneContainingAndDivision_Id(name,phone,Integer.parseInt(division),pageable);
        }
    }
}
