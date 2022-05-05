package vn.codegym.controller;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.form.ProductForm;
import vn.codegym.model.Product;
import vn.codegym.service.IProductService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService service;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("/products")
    public ModelAndView homepage(){
        List<Product> productList =  this.service.findAll();
        return new ModelAndView("index","products",productList);
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create","productForm",new ProductForm());
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute ProductForm productForm){
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = new Product(productForm.getId(),productForm.getName(),productForm.getDescription(),fileName);
        this.service.save(product);
        ModelAndView modelAndView =  new ModelAndView("create");
        modelAndView.addObject("productForm",productForm);
        modelAndView.addObject("message","Create Product is Successfully");
        return modelAndView;
    }
}
