package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
