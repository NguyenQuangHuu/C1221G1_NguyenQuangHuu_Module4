package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Books;
import vn.codegym.repository.IBookRepository;
import vn.codegym.service.IBookService;


import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Books> getAll(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Books getOne(Integer id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Books books) {
        this.bookRepository.save(books);
    }
}
