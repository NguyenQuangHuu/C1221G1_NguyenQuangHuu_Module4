package vn.codegym.service;

import vn.codegym.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
