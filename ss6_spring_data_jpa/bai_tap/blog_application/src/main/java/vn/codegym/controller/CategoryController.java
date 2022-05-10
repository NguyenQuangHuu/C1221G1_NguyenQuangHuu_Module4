package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Category;
import vn.codegym.service.ICategoryService;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/category")
    public String categoryList(Model model){
        model.addAttribute("categoryList",this.iCategoryService.listCategory());
        return "/category/list";
    }

    @GetMapping("/category/add")
    public String addCategoryForm(Model model){
        model.addAttribute("category",new Category());
        return "category/add";
    }

    @PostMapping("/category/add")
    public String addCategory(@ModelAttribute("category") Category category){
        this.iCategoryService.addCategory(category);
        return "category/add";
    }

    @GetMapping("/category/edit/{id}")
    public String editCategoryForm(@PathVariable Integer id,Model model){
        Category category = this.iCategoryService.findOne(id);
        model.addAttribute("category",category);
        return "category/edit";
    }

    @PostMapping("/category/edit")
    public String editCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        this.iCategoryService.addCategory(category);
        redirectAttributes.addFlashAttribute("message","Chỉnh sửa thành công");
        return "redirect:/category";
    }

    @GetMapping("/category/delete/")
    public String deleteCategory(@RequestParam Integer id){
        Category category = this.iCategoryService.findOne(id);
        this.iCategoryService.removeOne(category);
        return "redirect:/category";
    }
}
