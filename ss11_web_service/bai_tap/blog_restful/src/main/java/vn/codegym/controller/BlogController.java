package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService service;

    @GetMapping("/")
    public ResponseEntity<Page<Blog>> homepage(@PageableDefault(value = 2) Pageable pageable){
            Page<Blog> blogList = this.service.findAll(pageable);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }


    @PostMapping("/add-blog")
    public ResponseEntity<Void> addBlog(@RequestBody Blog blog){
        blog.setDateCreate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        this.service.addOne(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("edit/{id}")
    public ResponseEntity<Blog> editBlogForm(@PathVariable Integer id){
        Blog resultBlog = this.service.findOne(id);
        if(resultBlog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(resultBlog,HttpStatus.OK);
    }
    @PatchMapping("/edit/")
    public ResponseEntity<Void> editSubmit(@RequestBody Blog blog){
        this.service.updateOne(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable Integer id){

        Blog blog =  this.service.findOne(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.service.removeOne(blog);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> viewOne(@PathVariable Integer id){
        Blog blog =  this.service.findOne(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }





    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> searchBlog(@RequestParam("name") Optional<String> name,@PageableDefault(value = 2) Pageable pageable){
        if(!name.isPresent()){
            Page<Blog> blogs = this.service.findAll(pageable);
            return new ResponseEntity<>(blogs,HttpStatus.OK);
        }
        Page<Blog> blogSearch = this.service.findByName(name.get(),pageable);

        return new ResponseEntity<>(blogSearch,HttpStatus.OK);
    }
}
