package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.CustomerType;
import vn.codegym.repository.ICustomerRepository;
import vn.codegym.repository.ICustomerTypeRepository;
import vn.codegym.service.ICustomerService;
import vn.codegym.service.ICustomerTypeService;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return this.iCustomerTypeRepository.findAll();
    }
}
