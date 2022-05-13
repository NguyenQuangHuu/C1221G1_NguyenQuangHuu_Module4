package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Product;
import vn.codegym.repository.IProductRepository;
import vn.codegym.service.IProductService;
import vn.codegym.util.ProductNotFoundException;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository repository;

    public Page<Product> getAllProduct(Pageable pageable) {
        return this.repository.findAll(pageable);
    }




    public void save(Product product) {
        this.repository.save(product);
    }


    public Product findById(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    public void delete(Product product) throws ProductNotFoundException {
        this.repository.delete(product);
    }

    @Override
    public Page<Product> findProductByName(String nameQuery,String manufacturerQuery,String typeQuery, Pageable pageable) {
        if(typeQuery.equals("")) return this.repository.findAllByNameContainingAndManufacturerContaining(nameQuery,manufacturerQuery,pageable);
        else return this.repository.findAllByNameContainingAndManufacturerContainingAndProduct_Id(nameQuery,manufacturerQuery,Integer.parseInt(typeQuery),pageable);
    }

    @Override
    public Product getLastProduct() {
        return this.repository.getTopByOrderByIdDesc();
    }


}
