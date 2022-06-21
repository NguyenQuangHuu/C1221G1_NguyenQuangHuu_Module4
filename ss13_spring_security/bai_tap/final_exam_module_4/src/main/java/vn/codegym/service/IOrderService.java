package vn.codegym.service;

import vn.codegym.model.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders> findAll();

    Orders findOne(Integer id);

    void edit(Orders order);
}
