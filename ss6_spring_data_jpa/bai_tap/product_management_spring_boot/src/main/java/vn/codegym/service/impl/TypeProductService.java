package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.TypeProduct;
import vn.codegym.repository.ITypeProductRepository;
import vn.codegym.service.ITypeProductService;

import java.util.List;

@Service
public class TypeProductService implements ITypeProductService {
    @Autowired
    private ITypeProductRepository iTypeProductRepository;

    @Override
    public List<TypeProduct> findAll() {
        return this.iTypeProductRepository.findAll();
    }
}
