package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Blog;
import vn.codegym.service.IBlogService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Controller
public class BlogController {
    @Autowired
    private IBlogService service;
    @GetMapping("/")
    public String homepage(Model model){
        List<Blog> blogList = this.service.findAll();
        model.addAttribute("blogList",blogList);
        return "list";
    }

    @GetMapping("/add-blog")
    public String addBlogForm(Model model){
        model.addAttribute("blog",new Blog());
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
        return "edit";
    }

    @PostMapping("/edit")
    public String editSubmit(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
        this.service.updateOne(blog);
        redirectAttributes.addFlashAttribute("message","Chỉnh sửa thành công");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteOne(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        Blog blog =  this.service.findOne(id);
        if(blog==null){
            return "error";
        }
        this.service.removeOne(blog);
        redirectAttributes.addFlashAttribute("message","Xóa thành công");

        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String viewOne(@PathVariable Integer id,Model model){
        Blog blog =  this.service.findOne(id);
        if(blog==null){
            return "error";
        }
        model.addAttribute("blog",blog);
        return "view";
    }
}
