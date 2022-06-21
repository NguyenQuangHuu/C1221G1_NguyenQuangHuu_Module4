package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.IOrdersDetail;
import vn.codegym.model.Product;
import vn.codegym.repository.IProductRepository;
import vn.codegym.service.IProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<IOrdersDetail> findAll(Pageable pageable) {
        return this.iProductRepository.listOrder(pageable);
    }

    @Override
    public Page<IOrdersDetail> searchDate(String startDate, String endDate, Pageable pageable) {
        return this.iProductRepository.searchOrder(startDate,endDate,pageable);
    }

    @Override
    public List<Product> findAllProduct() {
        return this.iProductRepository.findAll();
    }
}
