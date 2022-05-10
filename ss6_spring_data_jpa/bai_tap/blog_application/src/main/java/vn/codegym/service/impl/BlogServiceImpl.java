package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        Page<Blog> blog = (Page<Blog>) this.repository.findAll();
        return this.repository.findAll();
    }

    @Override
    public void addOne(Blog blog) {
        this.repository.save(blog);
    }

    @Override
    public Blog findOne(Integer id) {
        return this.repository.findById(id).get();
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
    public List<Blog> findByName(String name) {
        return this.repository.getAllList('%'+name+'%');
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}
