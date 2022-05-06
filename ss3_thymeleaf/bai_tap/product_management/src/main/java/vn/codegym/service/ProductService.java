package vn.codegym.service;

import vn.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    void save(Product product);

    Product findById(Integer id);


    void update(Integer id, Product product);


    void delete(int id);

    List<Product> findProductByName(String query);
}
