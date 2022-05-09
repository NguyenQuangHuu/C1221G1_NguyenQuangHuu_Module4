package vn.codegym.repository;

import vn.codegym.model.Product;
import vn.codegym.util.ProductNotFoundException;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();

    void saveOrUpdate(Product product);

    Product findById(Integer id);


    void delete(int id) throws ProductNotFoundException;

    List<Product> findProductByName(String query);
}
