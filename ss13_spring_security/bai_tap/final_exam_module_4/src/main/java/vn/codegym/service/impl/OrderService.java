package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Orders;
import vn.codegym.repository.IOrderRepository;
import vn.codegym.service.IOrderService;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public List<Orders> findAll() {
        return this.iOrderRepository.findAll();
    }

    @Override
    public Orders findOne(Integer id) {
        return this.iOrderRepository.findById(id).orElse(null);
    }

    @Override
    public void edit(Orders order) {
        this.iOrderRepository.save(order);
    }
}
