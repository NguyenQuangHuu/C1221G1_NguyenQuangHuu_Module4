package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Blog;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    @Query(value="select * from blog where title like :name", nativeQuery=true)
    List<Blog> getAllList(@Param("name")String name);
}
