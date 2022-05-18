package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;

import java.util.List;

public interface IBlogService {

    void addOne(Blog blog);

    Blog findOne(Integer id);

    void updateOne(Blog blog);

    void removeOne(Blog blog);

    Page<Blog> findByName(String name,Pageable pageable);
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByCategory(Category category, Pageable pageable);
}
