package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Employee;



public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee findById(Integer id);

    void save(Employee employee);

    void remove(Employee employee);

    Page<Employee> findAllByNameAndPhoneAndDivision(String name, String phone, String division, Pageable pageable);
}
