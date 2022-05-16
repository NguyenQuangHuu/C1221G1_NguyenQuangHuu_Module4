package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Books;
import vn.codegym.model.BorrowBookCode;
import vn.codegym.repository.IBorrowBookCodeRepository;
import vn.codegym.service.IBorrowBookCodeService;

import java.time.LocalDate;

@Service
public class BorrowBookCodeService implements IBorrowBookCodeService {
    @Autowired
    private IBorrowBookCodeRepository bookCodeRepository;

    @Override
    public void save(BorrowBookCode borrowBookCode) {
        boolean check;

        long code = 0;
        do{
            code = (long)( Math.random()*89999 + 10000);
            check = this.bookCodeRepository.existsByCode(Long.toString(code));
        }while (check);
        borrowBookCode.setCode(Long.toString(code));
        borrowBookCode.setBorrowStartDate(LocalDate.now().toString());
        this.bookCodeRepository.save(borrowBookCode);
    }

    @Override
    public boolean checkCode(String code) {
        return this.bookCodeRepository.existsByCode(code);
    }

    @Override
    public BorrowBookCode checkGiveBack(String code) {
        return this.bookCodeRepository.findByCode(code);
    }

}
