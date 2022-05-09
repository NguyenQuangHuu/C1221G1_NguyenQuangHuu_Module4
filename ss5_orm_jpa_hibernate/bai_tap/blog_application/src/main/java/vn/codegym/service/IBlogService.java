package vn.codegym.service;

import vn.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void addOne(Blog blog);

    Blog findOne(Integer id);

    void updateOne(Blog blog);

    void removeOne(Blog blog);
}
