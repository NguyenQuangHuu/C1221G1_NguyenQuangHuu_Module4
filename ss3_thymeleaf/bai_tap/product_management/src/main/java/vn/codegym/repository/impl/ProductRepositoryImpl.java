package vn.codegym.repository.impl;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;
import vn.codegym.repository.ProductRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    static  Map<Integer,Product> products = new LinkedHashMap<>();
    static{
        products.put(1,new Product(1,"Bánh Xe",10000.0,"Bánh này có thể ăn được","Công ty lốp xe"));
        products.put(2,new Product(2,"Kẹo ke",10000.0,"Kẹo này hít vui lắm","Công ty trách nhiệm"));
        products.put(3,new Product(3,"Bánh phồng mồm",10000.0,"Hơi nóng nhưng đớp vô tư","Công ty một thành viên"));
        products.put(4,new Product(4,"Kẹo bánh xe ",10000.0,"Kẹo dành cho người răng sắt","Công ty"));
        products.put(5,new Product(5,"Thạch rau canabis",10000.0,"Kẹo này high lắm","Công ty hữu hạn"));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(Integer id) {
        if(products.containsKey(id)){
            return products.get(id);
        }
        return null;
    }

    @Override
    public void update(Integer id, Product product) {
        products.replace(id,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findProductByName(String query) {
        List<Product> product = new ArrayList<>();
        for(Map.Entry<Integer,Product> key : products.entrySet()){
            if(key.getValue().getName().toLowerCase().contains(query.toLowerCase())){
                product.add(key.getValue());
            }
        }
        return product;
    }
}
