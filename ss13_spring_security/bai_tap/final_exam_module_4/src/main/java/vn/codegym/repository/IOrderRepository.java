package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Orders;

public interface IOrderRepository extends JpaRepository<Orders,Integer> {
}
