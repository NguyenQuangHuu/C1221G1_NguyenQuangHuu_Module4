package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Product;
import vn.codegym.util.ProductNotFoundException;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> getAllByNameContaining(String name, Pageable pageable);
}
