package com.example.controller;

import com.example.dto.CartDto;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SessionAttributes("cart")
@Controller
public class ShoppingController {

    @Autowired
    private IProductService productService;


    @ModelAttribute("cart")
    public CartDto cartDto(){
        return new CartDto();
    }

    @GetMapping("/")
    public String listProduct(@PageableDefault(value = 10) Pageable pageable, Model model){
        Page<Product> products = this.productService.findAll(pageable);
        model.addAttribute("products",products);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id,Model model){
        Product product = this.productService.findById(id);
        model.addAttribute("product",product);
        return "detail";
    }

    @GetMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable Integer id,
                            @SessionAttribute("cart") CartDto cart){
        Product product=this.productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        cart.addProduct(productDto);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/shopping-cart")
    public String cartList(@SessionAttribute("cart")CartDto cartDto,Model model){
        model.addAttribute("cart",cartDto);
        return "cart";
    }

    @GetMapping("remove-from-cart/{id}")
    public String removeFormCart(@PathVariable Integer id,@SessionAttribute("cart") CartDto cartDto){
        Product product = this.productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        cartDto.removeProduct(productDto);
        return "redirect:/shopping-cart";
    }

    @GetMapping("payment")
    public String payment(@RequestParam String payment,Model model,@SessionAttribute("cart") CartDto cartDto){
        model.addAttribute("money",payment);
        model.addAttribute("cart",cartDto);
        return "payment";
    }
}
