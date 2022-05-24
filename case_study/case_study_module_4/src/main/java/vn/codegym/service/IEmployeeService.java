package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Employee;



public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
}
