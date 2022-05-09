package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;
import vn.codegym.util.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public String productList(Model model){
        List<Product> productList;
        productList = this.service.getAllProduct();
        model.addAttribute("productList",productList);
        return "/product/list";
    }

    @GetMapping("/create")
    public String createProductForm(Model model){
        model.addAttribute("product",new Product());
        return "/product/create";
    }


    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        this.service.save(product);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Integer id,Model model){
        Product product = this.service.findById(id);
        if(product == null){
            return "/product/error";
        }else{
            model.addAttribute("product",product);
            return "/product/edit";
        }
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("product") Product product,RedirectAttributes redirectAttributes){
            this.service.update(product.getId(),product);
            redirectAttributes.addFlashAttribute("message","Chỉnh sửa thành công");
            return "redirect:/products";

    }

    @GetMapping("/delete/")
    public String deleteProductConfirm(@RequestParam Integer id,Model model,RedirectAttributes redirectAttributes){
        Product product = this.service.findById(id);
        if(product==null){
            return "/product/error";
        }else{
            try {
                this.service.delete(product.getId());
            } catch (ProductNotFoundException e) {
                model.addAttribute("message",e.getMessage());
            }
            redirectAttributes.addFlashAttribute("message","Xóa sản phẩm thành công");
//            model.addAttribute("product",product);
            return "redirect:/products";
        }

    }

//    @GetMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable String id, Product product,RedirectAttributes redirectAttributes){
//        System.out.println(id);
//        redirectAttributes.addFlashAttribute("message","Xóa sản phẩm thành công");
//        return "redirect:/products";
//    }

    @GetMapping("/detail/{id}")
    public String detailProduct(@PathVariable Integer id,Model model){
        Product product = this.service.findById(id);
        if(product==null){
            return "/product/error";
        }
        model.addAttribute("product",product);
        return "/product/detail";
    }


    @GetMapping("/search")
    public String searchProduct(@RequestParam("query")String query,Model model,RedirectAttributes redirectAttributes){

        if("".equals(query)){
            return "redirect:/products";
        }

        List<Product> products = this.service.findProductByName(query);
        if(products == null){
//            redirectAttributes.addFlashAttribute("message","Không tìm thấy sản phẩm với tên này");
//            redirectAttributes.addAttribute("productList",products);
            model.addAttribute("productList",products);
            model.addAttribute("message","Không tìm thấy sản phẩm bạn muốn tìm");
        }else{
            model.addAttribute("productList",products);
            model.addAttribute("message","Đã tìm thấy sản phẩm bạn muốn tìm");
        }
        return "/product/list";
    }

}
