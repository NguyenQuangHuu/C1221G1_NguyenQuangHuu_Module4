package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.model.IOrdersDetail;
import vn.codegym.model.Orders;
import vn.codegym.model.TypeProduct;
import vn.codegym.service.IOrderService;
import vn.codegym.service.IProductService;
import vn.codegym.service.ITypeProductService;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private ITypeProductService iTypeProductService;

    @Autowired
    private IOrderService iOrderService;


    @ModelAttribute("typeProducts")
    public List<TypeProduct> typeProducts(){
        return this.iTypeProductService.findAll();
    }

    @ModelAttribute("orders")
    public List<Orders> orders(){
        return this.iOrderService.findAll();
    }


    @GetMapping("/list")
    public String list(@PageableDefault(value = 5) Pageable pageable, Model model,
                       @RequestParam Optional<String> startDate,
                       @RequestParam Optional<String> endDate,
                       @RequestParam Optional<String> top){


        if(startDate.isPresent() || endDate.isPresent()){
            String startValue = startDate.orElse("");
            String endValue = endDate.orElse("");
            model.addAttribute("startDate",startValue);
            model.addAttribute("endDate",endValue);
            Page<IOrdersDetail> products = this.iProductService.searchDate(startValue,endValue,pageable);
            model.addAttribute("products",products);
        }else{
            Page<IOrdersDetail> products = this.iProductService.findAll(pageable);
            model.addAttribute("products",products);
        }
        return "/list";
    }

}
