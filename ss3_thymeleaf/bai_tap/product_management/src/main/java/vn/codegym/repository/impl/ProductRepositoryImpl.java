package vn.codegym.repository.impl;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;
import vn.codegym.repository.ProductRepository;
import vn.codegym.util.ProductNotFoundException;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from Product p",Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void saveOrUpdate(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        if(product.getId() == null){
            entityTransaction.begin();
            BaseRepository.entityManager.persist(product);
            entityTransaction.commit();
        }else{
            entityTransaction.begin();
            BaseRepository.entityManager.merge(product);
            entityTransaction.commit();
        }
    }

    @Override
    public Product findById(Integer id) {
        return BaseRepository.entityManager.find(Product.class,id);
    }


    @Override
    public void delete(int id) throws ProductNotFoundException {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        Product product = findById(id);
        if(product == null){
            throw new ProductNotFoundException("Không tồn tại sản phẩm này");
        }else{
            entityTransaction.begin();
            BaseRepository.entityManager.remove(product);
            entityTransaction.commit();
        }
    }

    @Override
    public List<Product> findProductByName(String query) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from Product p where p.name like :name",Product.class);
        typedQuery.setParameter("name",'%'+query+'%');
        return typedQuery.getResultList();
    }
}
