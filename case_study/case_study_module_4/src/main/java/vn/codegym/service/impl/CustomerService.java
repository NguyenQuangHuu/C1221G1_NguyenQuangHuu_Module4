package vn.codegym.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.dto.CustomerDto;
import vn.codegym.model.Customer;
import vn.codegym.repository.ICustomerRepository;
import vn.codegym.service.ICustomerService;
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
        String randomCode = null;
        boolean checkCode = true;
        do{
            randomCode = "KH-" + (int) (Math.random()*8999+1000);
            checkCode = this.iCustomerRepository.existsCustomerByCode(randomCode);
        }while (checkCode);
        customerDto.setCode(randomCode);
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


}
