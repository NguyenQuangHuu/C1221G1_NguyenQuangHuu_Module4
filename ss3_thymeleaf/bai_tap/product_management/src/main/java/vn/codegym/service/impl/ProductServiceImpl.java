package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Product;
import vn.codegym.repository.ProductRepository;
import vn.codegym.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> getAllProduct() {
        return this.repository.getAll();
    }

    @Override
    public void save(Product product) {
        product.setId((int) (Math.random()*1000));
        this.repository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public void update(Integer id,Product product) {
        this.repository.update(id,product);
    }

    @Override
    public void delete(int id) {
        this.repository.delete(id);
    }

    @Override
    public List<Product> findProductByName(String query) {
            List<Product> products = this.repository.findProductByName(query);
            if(products.size()>0){
                return products;
            }
        return null;
    }
}
