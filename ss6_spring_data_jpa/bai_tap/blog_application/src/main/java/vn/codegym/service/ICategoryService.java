package vn.codegym.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> listCategory();

    void addCategory(Category category);

    Category findOne(Integer id);

    void removeOne(Category category);
}
