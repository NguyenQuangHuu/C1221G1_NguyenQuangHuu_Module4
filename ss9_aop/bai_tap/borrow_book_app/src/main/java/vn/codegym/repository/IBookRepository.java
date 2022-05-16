package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Books;

public interface IBookRepository extends JpaRepository<Books,Integer> {

}
