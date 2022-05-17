package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductService{
    Page<Product> findAll(Pageable pageable);

    Product findById(Integer id);
}
