package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;
import vn.codegym.service.IBlogService;
import vn.codegym.service.ICategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/")
    public ResponseEntity<Page<Category>> categoryList(Pageable pageable){
        Page<Category> categoryPage = this.iCategoryService.listCategory(pageable);
        if(categoryPage.getSize()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Void> addCategory(@RequestBody Category category){
        this.iCategoryService.addCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Category> editCategoryForm(@PathVariable Integer id){
        Category category = this.iCategoryService.findOne(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @PatchMapping("/edit")
    public ResponseEntity<Void> editCategory(@RequestBody Category category){
        this.iCategoryService.addCategory(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id){
        Category category = this.iCategoryService.findOne(id);
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iCategoryService.removeOne(category);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Page<Blog>> detailCategory(@PathVariable Integer id,@PageableDefault(value = 1) Pageable pageable){
        Category category = this.iCategoryService.findOne(id);
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Page<Blog> blogs = this.iBlogService.findByCategory(category,pageable);

        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
}
