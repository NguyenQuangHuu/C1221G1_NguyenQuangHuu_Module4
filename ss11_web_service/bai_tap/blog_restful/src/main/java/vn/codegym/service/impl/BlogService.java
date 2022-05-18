package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;
import vn.codegym.repository.IBlogRepository;
import vn.codegym.service.IBlogService;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository repository;


    @Override
    public void addOne(Blog blog) {
        this.repository.save(blog);
    }

    @Override
    public Blog findOne(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void updateOne(Blog blog) {
        this.repository.save(blog);
    }

    @Override
    public void removeOne(Blog blog) {
        this.repository.delete(blog);
    }

    @Override
    public Page<Blog> findByName(String name,Pageable pageable) {
        return this.repository.findBlogByTitleContaining('%'+name+'%',pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByCategory(Category category, Pageable pageable) {
        return this.repository.findBlogByCategory(category,pageable);
    }
}
