package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    boolean existsCustomerByCode(String code);

    Page<Customer> findAllByNameContainingAndPhoneContaining(String name, String phone, Pageable pageable);


    Page<Customer> findAllByNameContainingAndPhoneContainingAndCustomerType_Id(String name, String phone,Integer type, Pageable pageable);


}
