package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Product;
import vn.codegym.util.ProductNotFoundException;

import java.util.List;

public interface IProductService {
    Page<Product> getAllProduct(Pageable pageable);

    void save(Product product);

    Product findById(Integer id);



    void delete(Product product) throws ProductNotFoundException;

    Page<Product> findProductByName(String query,String manufacturerQuery,String type,Pageable pageable);
}
