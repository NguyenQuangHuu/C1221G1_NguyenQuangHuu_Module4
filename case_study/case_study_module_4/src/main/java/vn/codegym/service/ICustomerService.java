package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.dto.CustomerDto;
import vn.codegym.model.Customer;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(CustomerDto customerDto);

    Customer findById(Integer id);

    void delete(Customer customer);

    boolean checkExist(String randomCode);

    Page<Customer> findByNameAndPhoneAndTypeCustomer(String nameValue, String phoneValue,String typeValue, Pageable pageable);
}
