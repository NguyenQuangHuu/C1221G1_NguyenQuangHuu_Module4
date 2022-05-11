package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Category;
import vn.codegym.repository.ICategoryRepository;
import vn.codegym.service.ICategoryService;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    public List<Category>  listCategory(){
        return this.iCategoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        this.iCategoryRepository.save(category);
    }

    @Override
    public Category findOne(Integer id) {
        return this.iCategoryRepository.findById(id).get();
    }

    @Override
    public void removeOne(Category category) {
        this.iCategoryRepository.delete(category);
    }
}
