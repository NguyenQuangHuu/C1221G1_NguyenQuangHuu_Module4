package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void addOne(Blog blog);

    Blog findOne(Integer id);

    void updateOne(Blog blog);

    void removeOne(Blog blog);

    List<Blog> findByName(String name);
    Page<Blog> findAll(Pageable pageable);
}
