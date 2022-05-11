package vn.codegym.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Blog;
import vn.codegym.repository.IBlogRepository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {
    @Autowired
    private BaseRepository baseRepository;
    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> blogs = this.baseRepository.entityManager.createQuery("select b from Blog b",Blog.class);
        return blogs.getResultList();
    }

    public void addOneOrUpdate(Blog blog) {
        EntityTransaction entityTransaction = baseRepository.entityManager.getTransaction();
        if(blog.getId()==null){
            entityTransaction.begin();
            baseRepository.entityManager.persist(blog);
            entityTransaction.commit();
        }else{
            entityTransaction.begin();
            baseRepository.entityManager.merge(blog);
            entityTransaction.commit();
        }

    }

    @Override
    public Blog findOne(Integer id) {
        return this.baseRepository.entityManager.find(Blog.class,id);
    }

    @Override
    public void removeOne(Blog blog) {
        EntityTransaction entityTransaction = baseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        baseRepository.entityManager.remove(blog);
        entityTransaction.commit();
    }
}
