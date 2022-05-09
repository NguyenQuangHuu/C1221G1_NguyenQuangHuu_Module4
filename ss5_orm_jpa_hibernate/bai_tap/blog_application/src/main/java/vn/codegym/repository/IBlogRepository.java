package vn.codegym.repository;

import vn.codegym.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();

    void addOneOrUpdate(Blog blog);

    Blog findOne(Integer id);

    void removeOne(Blog blog);
}
