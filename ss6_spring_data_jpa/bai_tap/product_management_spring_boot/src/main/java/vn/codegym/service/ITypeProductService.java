package vn.codegym.service;

import vn.codegym.model.TypeProduct;
import vn.codegym.repository.ITypeProductRepository;

import java.util.List;

public interface ITypeProductService{
    List<TypeProduct> findAll();
}
