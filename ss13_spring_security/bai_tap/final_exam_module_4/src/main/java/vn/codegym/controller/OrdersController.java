package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.dto.OrdersDto;
import vn.codegym.model.Orders;
import vn.codegym.model.Product;
import vn.codegym.service.IOrderService;
import vn.codegym.service.IProductService;

import java.util.List;

@Controller
public class OrdersController {
    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("products")
    public List<Product> productList(){
        return  this.iProductService.findAllProduct();
    }

    @GetMapping("orders/edit/{id}")
    public String editOrder(@PathVariable Integer id, Model model){
        Orders orders = this.iOrderService.findOne(id);
        model.addAttribute("order",orders);
        return "edit";
    }

    @PostMapping("orders/edit")
    public String editOrderSubmit(@ModelAttribute("order") Orders order){
        this.iOrderService.edit(order);
        return "redirect:/list";
    }
}
