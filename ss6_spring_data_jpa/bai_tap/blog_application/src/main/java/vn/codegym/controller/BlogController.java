package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Blog;
import vn.codegym.service.IBlogService;
import vn.codegym.service.ICategoryService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService service;

    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("/")
    public String homepage(Model model, @PageableDefault(value = 5) Pageable pageable, Sort sort){
        Page<Blog> blogList = this.service.findAll(pageable);
        model.addAttribute("blogList",blogList);
        return "list";
    }

    @GetMapping("/add-blog")
    public String addBlogForm(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList",this.iCategoryService.listCategory());
        return "add-blog";
    }

    @PostMapping("/add-blog")
    public String addBlog(Blog blog, RedirectAttributes redirectAttributes){
        blog.setDateCreate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        this.service.addOne(blog);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id,Model model){
        Blog blog =  this.service.findOne(id);
        model.addAttribute("blog",blog);
        model.addAttribute("categoryList",this.iCategoryService.listCategory());
        return "edit";
    }

    @PostMapping("/edit")
    public String editSubmit(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        this.service.updateOne(blog);
        redirectAttributes.addFlashAttribute("message","Chỉnh sửa thành công");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteOne(@RequestParam Integer id, RedirectAttributes redirectAttributes){

        Blog blog =  this.service.findOne(id);
        if(blog==null){
            return "error111";
        }
        this.service.removeOne(blog);
        redirectAttributes.addFlashAttribute("message","Xóa thành công");

        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String viewOne(@PathVariable Integer id,Model model){
        Blog blog =  this.service.findOne(id);
        if(blog==null){
            return "error111";
        }
        model.addAttribute("blog",blog);
        return "view";
    }

    @GetMapping("/search")
    public String searchBlog(@RequestParam("name") String name,Model model,RedirectAttributes redirectAttributes){
        if("".equals(name)){
            return "redirect:/";
        }
        List<Blog> blogs;
        blogs = this.service.findByName(name);
        if(blogs.size()==0){
            model.addAttribute("message","Không tồn tại blog này");
            return "list";
        }
        model.addAttribute("blogList",blogs);
        model.addAttribute("message","Tìm kiếm thành công");
        return "list";
    }
}
