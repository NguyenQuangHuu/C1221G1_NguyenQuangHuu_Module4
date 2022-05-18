package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Category;

import java.util.List;

public interface ICategoryService {
    Page<Category> listCategory(Pageable pageable);

    void addCategory(Category category);

    Category findOne(Integer id);

    void removeOne(Category category);
}
