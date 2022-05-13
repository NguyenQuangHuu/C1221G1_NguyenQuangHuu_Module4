package vn.codegym.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.dto.ProductDto;
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
                              @RequestParam Optional<String> nameQuery,
                              @RequestParam Optional<String> typeQuery,
                              @RequestParam Optional<String> manufacturerQuery){
        if(nameQuery.isPresent() || typeQuery.isPresent() || manufacturerQuery.isPresent()){
            String nameValue = nameQuery.orElse("");
            String typeValue = typeQuery.orElse("");
            String manufacturerValue = manufacturerQuery.orElse("");
            model.addAttribute("nameQuery",nameValue);
            model.addAttribute("typeQuery",typeValue);
            model.addAttribute("manufacturerQuery",manufacturerValue);
            Page<Product> products = this.service.findProductByName(nameValue,manufacturerValue,typeValue,pageable);
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
            model.addAttribute("productDto",new ProductDto());
        }catch (NumberFormatException e){
            e.getMessage();
        }
        return "create";
    }


    @PostMapping("/create")
    public String createProduct(@ModelAttribute("productDto") @Validated ProductDto productDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        if(productDto.getPrice() == null){
//            productDto.setPrice(-1.0);
//        }
        new ProductDto().validate(productDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/create";
        }else{
            Product product = this.service.getLastProduct();
            productDto.setCode("product-"+product.getId());
            Product productCopy = new Product();
            BeanUtils.copyProperties(productDto,productCopy);
            this.service.save(productCopy);
            redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
            return "redirect:/products";
        }
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Integer id,Model model){
        Product product = this.service.findById(id);

        if(product == null){
            return "error";
        }else{
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            model.addAttribute("productDto",productDto);
            return "edit";
        }
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("productDto") @Validated ProductDto productDto,BindingResult bindingResult,RedirectAttributes redirectAttributes){
            new ProductDto().validate(productDto,bindingResult);
            if(bindingResult.hasErrors()){
                return "/edit";
            }else{
                Product product = new Product();
                BeanUtils.copyProperties(productDto,product);
                this.service.save(product);
                redirectAttributes.addFlashAttribute("message","Chỉnh sửa thành công");
                return "redirect:/products";
            }

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


//    @GetMapping("/products/search")
//    public String searchProduct(@RequestParam("query")String query,Model model,@PageableDefault(value=4) Pageable pageable){
//
//        if("".equals(query)){
//            return "redirect:/products";
//        }
//
//        Page<Product> products = this.service.findProductByName(query,pageable);
//        if(products.isEmpty()){
////            redirectAttributes.addFlashAttribute("message","Không tìm thấy sản phẩm với tên này");
////            redirectAttributes.addAttribute("productList",products);
//            model.addAttribute("productList",products);
//            model.addAttribute("message","Không tìm thấy sản phẩm bạn muốn tìm");
//        }else{
//            model.addAttribute("productList",products);
//            model.addAttribute("query",query);
//            model.addAttribute("message","Đã tìm thấy sản phẩm bạn muốn tìm");
//        }
//        return "list";
//    }

}
