package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Product;
import vn.codegym.util.ProductNotFoundException;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAllByNameContainingAndManufacturerContainingAndProduct_Id(String name,String manufacturer,Integer type, Pageable pageable);
    Page<Product> findAllByNameContainingAndManufacturerContaining(String name,String manufacturer, Pageable pageable);

    Product getTopByOrderByIdDesc();
}
