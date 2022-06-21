package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.model.IOrdersDetail;
import vn.codegym.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Page<IOrdersDetail> findAll(Pageable pageable);


    Page<IOrdersDetail> searchDate(String startDate, String endDate, Pageable pageable);

    List<Product> findAllProduct();
}
