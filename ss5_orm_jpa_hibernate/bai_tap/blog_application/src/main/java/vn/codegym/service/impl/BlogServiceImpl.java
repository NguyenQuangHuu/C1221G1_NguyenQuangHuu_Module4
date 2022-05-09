package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Blog;
import vn.codegym.repository.IBlogRepository;
import vn.codegym.service.IBlogService;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void addOne(Blog blog) {
        this.repository.addOneOrUpdate(blog);
    }

    @Override
    public Blog findOne(Integer id) {
        return this.repository.findOne(id);
    }

    @Override
    public void updateOne(Blog blog) {
        this.repository.addOneOrUpdate(blog);
    }

    @Override
    public void removeOne(Blog blog) {
        this.repository.removeOne(blog);
    }
}
