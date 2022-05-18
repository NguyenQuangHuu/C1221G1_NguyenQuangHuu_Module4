package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {


    Page<Blog> findBlogByTitleContaining(@Param("name")String name, Pageable pageable);

    Page<Blog> findBlogByCategory(Category category,Pageable pageable);
}
