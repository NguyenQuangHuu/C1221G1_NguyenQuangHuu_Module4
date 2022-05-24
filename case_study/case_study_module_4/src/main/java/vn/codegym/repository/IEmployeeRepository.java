package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAllByNameContainingAndPhoneContaining(String name, String phone, Pageable pageable);

    Page<Employee> findAllByNameContainingAndPhoneContainingAndDivision_Id(String name,String phone,Integer id,Pageable pageable);
}
