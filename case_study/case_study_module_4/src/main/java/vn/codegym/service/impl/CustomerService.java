package vn.codegym.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.dto.CustomerDto;
import vn.codegym.dto.ICustomerDto;
import vn.codegym.model.Customer;
import vn.codegym.repository.ICustomerRepository;
import vn.codegym.service.ICustomerService;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.iCustomerRepository.findAll(pageable);
    }

    @Override
    public void save(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        this.iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return this.iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Customer customer) {
        this.iCustomerRepository.delete(customer);
    }

    @Override
    public boolean checkExist(String randomCode) {
        return this.iCustomerRepository.existsCustomerByCode(randomCode);
    }

    @Override
    public Page<Customer> findByNameAndPhoneAndTypeCustomer(String nameQuery, String phoneQuery,String typeQuery, Pageable pageable) {
        if ("".equals(typeQuery)){
            return this.iCustomerRepository.findAllByNameContainingAndPhoneContaining(nameQuery,phoneQuery,pageable);
        }else{
            return this.iCustomerRepository.findAllByNameContainingAndPhoneContainingAndCustomerType_Id(nameQuery,phoneQuery,Integer.parseInt(typeQuery),pageable);
        }
    }

    @Override
    public List<Customer> findAllCustomer() {
        return this.iCustomerRepository.findAll();
    }




}
