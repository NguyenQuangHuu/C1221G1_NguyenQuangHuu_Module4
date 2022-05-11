package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Product;
import vn.codegym.model.TypeProduct;
import vn.codegym.service.IProductService;
import vn.codegym.service.ITypeProductService;
import vn.codegym.util.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {



    @Autowired
    private IProductService service;

    @Autowired
    private ITypeProductService typeProductService;

    @ModelAttribute("type_product")
    public List<TypeProduct> getType(){
        return this.typeProductService.findAll();
    }

    @GetMapping("/products")
    public String productList(Model model,@PageableDefault(value=5) Pageable pageable,
                              @RequestParam Optional<String> query){
        if(query.isPresent()){
            String queryValue = query.orElse("");
            model.addAttribute("query",queryValue);
            Page<Product> products = this.service.findProductByName(queryValue,pageable);
            model.addAttribute("productList",products);
        }else{
            Page<Product> productList = this.service.getAllProduct(pageable);
            model.addAttribute("productList",productList);
        }

        return "list";
    }

    @GetMapping("/create")
    public String createProductForm(Model model){
        try{
            model.addAttribute("product",new Product());

        }catch (NumberFormatException e){
            e.getMessage();
        }
        return "create";
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
            return "error";
        }else{
            model.addAttribute("product",product);
            return "edit";
        }
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("product") Product product,RedirectAttributes redirectAttributes){
            this.service.save(product);
            redirectAttributes.addFlashAttribute("message","Chỉnh sửa thành công");
            return "redirect:/products";
    }

    @GetMapping("/delete/")
    public String deleteProductConfirm(@RequestParam Integer id,Model model,RedirectAttributes redirectAttributes){
        Product product = this.service.findById(id);
        if(product==null){
            return "error";
        }else{
            try {
                this.service.delete(product);
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
            return "/error";
        }
        model.addAttribute("product",product);
        return "detail";
    }


    @GetMapping("/products/search")
    public String searchProduct(@RequestParam("query")String query,Model model,@PageableDefault(value=4) Pageable pageable){

        if("".equals(query)){
            return "redirect:/products";
        }

        Page<Product> products = this.service.findProductByName(query,pageable);
        if(products.isEmpty()){
//            redirectAttributes.addFlashAttribute("message","Không tìm thấy sản phẩm với tên này");
//            redirectAttributes.addAttribute("productList",products);
            model.addAttribute("productList",products);
            model.addAttribute("message","Không tìm thấy sản phẩm bạn muốn tìm");
        }else{
            model.addAttribute("productList",products);
            model.addAttribute("query",query);
            model.addAttribute("message","Đã tìm thấy sản phẩm bạn muốn tìm");
        }
        return "list";
    }

}
