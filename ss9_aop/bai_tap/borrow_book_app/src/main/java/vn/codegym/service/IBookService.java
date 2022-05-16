package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Books;

import java.util.List;

public interface IBookService {
    Page<Books> getAll(Pageable pageable);

    Books getOne(Integer id);

    void save(Books books);
}
